package com.amico.service.im.net.req.dto.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.amico.service.im.net.req.dto.AddFriendDto;
import com.amico.service.im.net.req.dto.GroupChatDto;
import com.amico.service.im.net.req.dto.GuestChatDto;
import com.amico.service.im.net.req.dto.LoginDto;
import com.amico.service.im.net.req.dto.SingleChatDto;

import io.jboot.utils.StrUtils;

public class IMReqModelMap {

	private static final Map<String, Class> dictMap = new ConcurrentHashMap<String, Class>();

	static {
		dictMap.put("AddFriendDto", AddFriendDto.class);
		dictMap.put("GroupChatDto", GroupChatDto.class);
		dictMap.put("GuestChatDto", GuestChatDto.class);
		dictMap.put("SingleChatDto", SingleChatDto.class);
		dictMap.put("LoginDto", LoginDto.class);
	}

	public static Class getClassByName(String clsName) {
		if (StrUtils.isNotEmpty(clsName)) {
			return dictMap.get(clsName);
		} else {
			return null;
		}
	}

}
