package com.xin;

import com.google.protobuf.Parser;
import com.xin.msg.login.SimpleMessage;

import java.util.HashMap;
import java.util.Map;

public class MsgMgr {
    public static Map<Integer, Parser> msgMap = new HashMap<>();
    static {
        msgMap.put(1, SimpleMessage.parser());
    }
}
