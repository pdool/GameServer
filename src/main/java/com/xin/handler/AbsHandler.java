package com.xin.handler;

import com.google.protobuf.MessageLite;

public abstract class AbsHandler<Msg_IN extends MessageLite,Msg_OUT extends MessageLite> {
    public abstract  Object handle(Msg_IN in,Msg_OUT out);
}
