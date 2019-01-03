package com.amico.service.im.net.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.tio.core.ChannelContext;

public class ImContainer {

	
	//用戶集合
	private static final Map<String, ChannelContext> userMap = new ConcurrentHashMap<String, ChannelContext>();

	
	public static void regiterUserChannel(String userId,ChannelContext channelContext) {
		userMap.put(userId, channelContext);
	}
	
	public static ChannelContext getUserChannel(String userId) {
		return userMap.get(userId);
	}
}
