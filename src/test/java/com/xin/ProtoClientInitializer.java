package com.xin;

import com.xin.core.ProtoDecoder;
import com.xin.core.ProtoEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ProtoClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ProtoDecoder());
        //Google Protocol Buffers编码器
        pipeline.addLast(new ProtoEncoder());

        pipeline.addLast(new ProtoClientHandler());
    }
}