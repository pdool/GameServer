package com.xin.core;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldPrepender;

import java.util.Arrays;
import java.util.List;

public class ProtoEncoder extends LengthFieldPrepender {


    public ProtoEncoder() {
        super(4);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        super.encode(ctx, msg, out);
        System.out.println();
    }
}

