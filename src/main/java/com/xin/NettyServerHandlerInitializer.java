package com.xin;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new ProtoDecoder(1024 * 1024,0,4,0,4))
                .addLast(new ProtoEncoder())
                .addLast(new NettyServerHandler());
    }
}