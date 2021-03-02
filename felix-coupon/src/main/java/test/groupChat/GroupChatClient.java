package test.groupChat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName GroupChatClient
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/12/12 1:30 AM
 * @Version 1.0
 **/
public class GroupChatClient {
    private SocketChannel socketChannel;
    private Selector selector;
    private static final String IP = "127.0.0.1";
    private static final int PORT = 7000;
    private String username;

    public GroupChatClient(){
        try {
            selector = Selector.open();
            //连接服务器
            socketChannel = SocketChannel.open(new InetSocketAddress(IP,PORT));
            //socketChannel.connect(new InetSocketAddress(IP,PORT));
            //设置非阻塞
            socketChannel.configureBlocking(false);
            socketChannel.register(selector,SelectionKey.OP_READ);
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println("客户端"+username+"  is OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器发送消息
    public void sendInfo(String msg){
        msg = username + "说：" + msg;

        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取从服务器端过来的消息
    public void readInfo(){
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int select = selector.select();
            if(select>0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isReadable()){
                        SocketChannel channel = (SocketChannel)key.channel();
                        channel.read(buffer);
                        System.out.println("from 服务器："+new String (buffer.array()));
                    }
                    iterator.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        File file= new File("/c/name");
//        FileChannel fileChannel = new FileInputStream(file).getChannel();
//        fileChannel.transferTo()

        GroupChatClient groupChatClient = new GroupChatClient();
        new Thread(new inner(groupChatClient)).start();

        //发送消息给服务器
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            groupChatClient.sendInfo(s);
        }
    }


    static class inner implements Runnable{
        private GroupChatClient groupChatClient;
        @Override
        public void run() {
            while (true){
                groupChatClient.readInfo();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        inner(GroupChatClient groupChatClient){
            this.groupChatClient = groupChatClient;
        }
    }
}
