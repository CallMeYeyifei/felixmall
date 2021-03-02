package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName NioClientTest
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/12/10 12:39 AM
 * @Version 1.0
 **/
public class NioClientTest {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //非阻塞的
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",7000);

        if (!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("客户端连接需要时间，非阻塞的 可以做其他事情");
            }
        }

        String str = "我是客户端，我要发送数据了！！！";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            socketChannel.write(byteBuffer);
        }

        System.in.read();

    }
}
