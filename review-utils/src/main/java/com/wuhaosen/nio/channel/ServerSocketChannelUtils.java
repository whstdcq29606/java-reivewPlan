package com.wuhaosen.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.channel
 * @ClassName:ServerSocketChannelUtils
 * @Description
 * @Date 2025/9/27 22:27
 */
public class ServerSocketChannelUtils {
    public static void main(String[] args) throws IOException {
        //    创建ServerSocketChannel (对应BIO中的ServerSocket)  //    绑定监听端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(8000));
        //    创建ByteBuffer数组，并初始化
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        serverSocketChannel.configureBlocking(true);
        SocketChannel accept = serverSocketChannel.accept();
        System.out.println("看看是不是锁住了？");

        //    循环监听数据
        int messageLength = byteBuffers[0].capacity() + byteBuffers[1].capacity();
        while (true) {
            int readByte = 0;
            while (readByte < messageLength) {
                readByte += accept.read(byteBuffers);
                System.out.println("本次读取了: " + readByte + "个字节");

                Arrays.stream(byteBuffers).
                        map(byteBuffer -> "position: "
                                + byteBuffer.position() + "    limit:   "
                                + byteBuffer.limit() + "    capacity: " +
                                byteBuffer.capacity())
                        .forEach(System.out::println);
            }



            Arrays.stream(byteBuffers).forEach(ByteBuffer::clear);

            int writeByte = 0;
            while(writeByte < messageLength) {
                writeByte += accept.write(byteBuffers);
            }


            //    clear ByteBuffer,为下一次数据传输做准备
            Arrays.stream(byteBuffers).forEach(ByteBuffer::clear);


        }



    }
}
