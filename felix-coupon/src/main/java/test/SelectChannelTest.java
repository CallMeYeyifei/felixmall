package test;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @ClassName SelectChannelTest
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/12/9 11:00 PM
 * @Version 1.0
 **/
public class SelectChannelTest {
    public static void main(String[] args) throws IOException {
        //1 创建一个ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2 创建一个Selector
        Selector selector = Selector.open();

        //3 ServerSocketChannel绑定端口7000
        serverSocketChannel.bind(new InetSocketAddress(7000));
        //设为非阻塞
        serverSocketChannel.configureBlocking(false);

        //注册进selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待1秒，无客户端连接！");
                continue;
            }
            //如果返回的>0,就获取到相夫的 selectionkey集合
            //1,如果返回的0,表示已经获取到关注的事件
            //2. selector, selectedkeys()返回关注事件的集合
            // 通过 selectionkeys反向获取通道
            Iterator<SelectionKey> selectKey = selector.selectedKeys().iterator();
            while(selectKey.hasNext()){
                //通过selectKey 反向操作channel通道
                SelectionKey key = selectKey.next();
                if(key.isAcceptable()){//客户端连接事件
                    //获取一个socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功。。。生成一个socketChannelid="+socketChannel.hashCode());

                    //设为非阻塞
                    socketChannel.configureBlocking(false);
                    //socketeChannel也要注册到selector里去
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if(key.isReadable()){//可读事件
                    //反向获取通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取buffer
                    ByteBuffer attachment = (ByteBuffer) key.attachment();
                    //写入数据 从buffer --》 通道
                    channel.read(attachment);
                    System.out.println("from 客户端："+ new String(attachment.array()));
                }

                //手动从集台中移当前的 selectionkey,防上重复操作
                selectKey.remove();
            }
        }
    }
}
