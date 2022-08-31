package com.xin.core;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new ProtoDecoder())
                .addLast(new ProtoEncoder())
                .addLast(new NettyServerHandler());
    }
}