package com.xin;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class ProtoDecoder extends LengthFieldBasedFrameDecoder {
    //  length (4)+ headerId(4) + content
    private int HEADER_SIZE = 4;

    //  1m，0,0,4,0,4
    public ProtoDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in == null) {
            return null;
        }
        if (in.readableBytes() < HEADER_SIZE) {
            throw new Exception("可读信息段比头部信息都小，你在逗我？");
        }

        //注意在读的过程中，readIndex的指针也在移动
        int headId =  in.readInt();
        ByteBuf buf = in.readBytes(in.readableBytes());
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);


        CustomMsg customMsg = new CustomMsg(type,flag,length,body);
    }
}
