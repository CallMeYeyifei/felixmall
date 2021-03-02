package test.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName GroupChatServer
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/12/12 12:21 AM
 * @Version 1.0
 **/
public class GroupChatServer {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private static final int PORT = 7000;

    public GroupChatServer() throws IOException {

        try {
            //得到选择器
            selector = Selector.open();
            //服务通道
            serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            //非阻塞的
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {

        while (true){
            //获取选择器上可操作的selectionkey数
            int select = selector.select();

            if(select>0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while(selectionKeyIterator.hasNext()){
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    //有客户端的通道连接请求
                    if(selectionKey.isAcceptable()){
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        System.out.println("客户端"+socketChannel.getRemoteAddress()+"上线了");

                    }

                    //读事件
                    if(selectionKey.isReadable()){
                        readMessage(selectionKey);
                    }

                    //删除当前可操作的事件key
                    selectionKeyIterator.remove();
                }
            }

        }
    }

    //读取客户端消息
    public void readMessage(SelectionKey selectionKey){
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            //说明有数据 从管道 读到 buffer里去
            if(read>0){
                //bytebuffer 转为 字符串
                String msg = new String(byteBuffer.array());
                System.out.println("from 客户端的消息："+msg);


                //转发消息给其他客户端
                sendMsgToOtherClient(msg, channel);
            }
        } catch (Exception e) {
            try {
                System.out.println("客户端"+channel.getRemoteAddress()+"断开连接");
                //取消注册
                selectionKey.cancel();
                //关闭通道
                channel.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    //发送消息给其他服务器
    private void sendMsgToOtherClient(String msg, SocketChannel channel) {
        System.out.println("服务器转发消息中。。。");
        try {

            Iterator<SelectionKey> iterator = selector.keys().iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                SelectableChannel eachChannel = key.channel();
                if((eachChannel instanceof SocketChannel) && eachChannel != channel){
                    ((SocketChannel) eachChannel).write(
                            ByteBuffer.wrap(msg.getBytes())
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            GroupChatServer groupChatServer = new GroupChatServer();
            groupChatServer.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
