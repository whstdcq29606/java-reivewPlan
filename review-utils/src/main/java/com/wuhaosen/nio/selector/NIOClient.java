package com.wuhaosen.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.selector
 * @ClassName:NIOClient
 * @Description
 * @Date 2025/9/28 11:41
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        String sendValue = "吴昊森，你好";
        //    生成socketChannel，设置为非阻塞
        SocketChannel clientSocket = SocketChannel.open();
        clientSocket.configureBlocking(false);
//    绑定服务器端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8000);
//    写入数据，发送请求
        if (!clientSocket.connect(inetSocketAddress)) {
//            如果没有完成连接，就到这里做别的事情，不会阻塞
            while (!clientSocket.finishConnect()) {
                System.out.println("客户端正在连接服务器，这需要一定的时间，客户端不会阻塞，可以先干别的时间。");
            }
        }

//     连接完成,发送数据。
        ByteBuffer byteBuffer = ByteBuffer.wrap(sendValue.getBytes());
        clientSocket.write(byteBuffer);
//        代码先停在这里
        System.in.read();

    }

}
