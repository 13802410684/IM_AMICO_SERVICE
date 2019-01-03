package com.amico.service.im.net.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.jboot.utils.StrUtils;

public class ImManagerProcess {

	private static final Map<String, ImManager> dictMap = new ConcurrentHashMap<String, ImManager>();

	static {
		dictMap.put("GroupChat", new GroupChatManager());
		dictMap.put("Chat", new ChatManager());
		dictMap.put("BaseBiz", new BaseBizManager());
	}

	public static ImManager getImProcessManager(String key) {
		if (StrUtils.isNotEmpty(key)) {
			return dictMap.get(key);
		} else {
			return null;
		}
	}

	
}
