package com.xin;

import com.google.protobuf.Parser;
import com.xin.mgr.MsgMgr;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.util.ArrayList;
import java.util.List;

public class ProtoDecoder extends LengthFieldBasedFrameDecoder {


    public ProtoDecoder() {
        super(1024*1024, 0, 4,0,4);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        ByteBuf decode = (ByteBuf) super.decode(ctx, byteBuf);
        int headId = decode.readInt();
        Parser parser = MsgMgr.msgMap.get(headId);
        int canReadBytes = decode.readableBytes();
        byte[] data = new byte[canReadBytes];
        decode.readBytes(data);
        Object o = parser.parseFrom(data);
        List<Object> list = new ArrayList<>();
        list.add(headId);
        list.add(o);
        return list;
        //  不想用反射
    }
}
