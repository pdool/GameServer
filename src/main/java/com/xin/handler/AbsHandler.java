package com.xin.handler;

import com.google.protobuf.AbstractMessage;

public abstract class AbsHandler<Msg_IN extends AbstractMessage,Msg_OUT extends AbstractMessage>  {
    public abstract  Msg_OUT handle(Msg_IN in);
}
