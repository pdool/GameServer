package com.xin;

import com.google.protobuf.MessageLite;
import com.xin.msg.login.SimpleMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoClientHandler extends SimpleChannelInboundHandler<MessageLite> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageLite msg) throws Exception {
        System.out.println("read");
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SimpleMessage chongxin = SimpleMessage.newBuilder().setIsSimple(true).setId(88).setName("chongxin").build();
        byte[] bytes = chongxin.toByteArray();

        ByteBuf buf = Unpooled.copiedBuffer(intToBytes(1),bytes);
        ctx.channel().writeAndFlush(buf);
    }
    /**
     * 将整形转化成字节
     * @param num
     * @return
     */
    public static byte[] intToBytes(int num) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            b[i] = (byte) (num >>> (24 - i * 8));
        }
        return b;
    }

}