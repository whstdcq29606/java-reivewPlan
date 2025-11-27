package com.wuhaosen.nio.netty.discard;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author 吴昊森 - utf-8
 * @PackageName:com.wuhaosen.nio.netty.discard
 * @ClassName:DiscardServier
 * @Description
 * @Date 2025/9/28 16:13
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    //    写一个discardServer
    void run() throws Exception{
//        建立boss和worker循环事件组
            NioEventLoopGroup boss = new NioEventLoopGroup();
            NioEventLoopGroup worker = new NioEventLoopGroup();
//        建议netty server启动helper
            ServerBootstrap bs = new ServerBootstrap();
//        对helper进行设置
        try {
            bs.group(boss,worker)  //服务配置需要把boss和worker配置上
                    .channel(NioServerSocketChannel.class) // 配置Server的channel的类型，用于接受client的连接
                    .childHandler(new ChannelInitializer<SocketChannel>() { //配置子Selector的handler，用于处理client的事件
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128) //配置
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
//        服务启动
            ChannelFuture f = bs.bind(port).sync();
//        关闭服务
            f.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 9999;
        new DiscardServer(port).run();
    }
}
