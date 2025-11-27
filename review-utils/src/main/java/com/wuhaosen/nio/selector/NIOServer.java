package com.wuhaosen.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.selector
 * @ClassName:NIOServer
 * @Description
 * @Date 2025/9/28 11:41
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //    生成selector
        Selector sel = Selector.open();
//    生成ServerSocketChannel,并设置为非阻塞
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
//        绑定监听端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8000));
//    将ServerSocketChannel注册到selector，并设置为监听连接事件
        serverSocketChannel.register(sel, SelectionKey.OP_ACCEPT);
//    监听
        while (true) {
            if (sel.select(2000) == 0) {
                System.out.println("服务器等待了4s钟，目前没有客户端连接");
                continue;
            }
            //  过了监听循环，说明有事件进来了  监听事件，获取SelectorKeys，并遍历
            Set<SelectionKey> keys = sel.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                //    监听到连接事件，生成对应的socketChannel，设置为非阻塞的，注册到selector，监听读事件,并给该channel一个buffer
                if (next.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(sel, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接成功： 生成了一个socketChannel： " + socketChannel.hashCode());
                }
                //    监听到写事件，注意，监听到写/读事件的时候，已经有socketChannel了，所以不需要再生成socketChannel了。
                if (next.isReadable()) {
//                    通过Selector获取到相应的发生写事件的channel
                    SocketChannel channel = (SocketChannel) next.channel();
//                    获取对应的buffer
                    ByteBuffer byteBuffer = (ByteBuffer) next.attachment();
                    channel.read(byteBuffer);
//                  将数据打印到控制台
                    String test = new String(byteBuffer.array());
                    System.out.println("从客户端获取到的数据为： " + new String(byteBuffer.array()));
                }
//                处理完事件后，从SelectorKeys集合中扔掉（这里扔掉不是说不管channel了，
//                而是还在Selector里，只不过扔掉的channel没有事件了，等待下一次它有事件后再次进去SelectorKey集合中
                it.remove();
            }


        }

    }


}
