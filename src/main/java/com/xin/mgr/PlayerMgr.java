package com.xin.mgr;

import com.xin.Player;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;

public class PlayerMgr {
    public static ConcurrentHashMap<ChannelHandlerContext, Player> playerMap = new ConcurrentHashMap<>();
}
