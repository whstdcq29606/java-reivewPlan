package com.wuhaosen.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:PACKAGE_NAME
 * @ClassName:NioServer
 * @Description
 * @Date 2025/9/26 17:01
 */

public class NioServer {
    List<SocketChannel> channelList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//        创建NIO的 serverSocketChannel 类似BIO（阻塞IO）serverSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        监听9000端口
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
//        配置channel为非阻塞
        serverSocketChannel.configureBlocking(false);

        Selector open = Selector.open();


        while(true){
//            非阻塞的accept方法不会阻塞，否则会阻塞。
//            NIO非阻塞的是由操作系统实现的，linux内核调用accept方法
            SocketChannel accept = serverSocketChannel.accept();
//            如果有客户端连接
            if (accept != null) {
                System.out.println("连接成功");
                serverSocketChannel.configureBlocking(false);
            }
        }
    }
}
