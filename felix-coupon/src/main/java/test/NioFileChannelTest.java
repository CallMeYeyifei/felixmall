package test;

import lombok.val;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioFileChannelTest
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/12/7 11:21 PM
 * @Version 1.0
 **/
public class NioFileChannelTest {
    public static void main(String[] args) {
        read();
    }

    public static void write(){
        try {
            String str = "hello,我是叶艺菲";
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/yeyifei/yyf/test.txt");
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(str.getBytes());
            //buffer读写反转
            byteBuffer.flip();
            channel.write(byteBuffer);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(){
        try {
            File file = new File("/Users/yeyifei/yyf/test.txt");
            FileInputStream fileInputStream = new FileInputStream(file);

            FileChannel fileChannel = fileInputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
            fileChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
