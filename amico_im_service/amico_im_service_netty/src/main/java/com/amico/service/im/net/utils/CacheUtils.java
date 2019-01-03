package com.amico.service.im.net.utils;

import com.amico.service.im.net.req.dto.LoginDto;
import com.amico.service.im.net.service.dto.ImService;
import com.amico.service.im.net.service.dto.ImUser;

import io.jboot.Jboot;

public class CacheUtils {

	
	
	/***
	 * 設置loginDto
	 * @param userId
	 */
	public static void putImUser(String userId,ImUser imUser) {
		Jboot.me().getRedis().set(userId, imUser);
	}
	
	/**
	 * 獲取DTO
	 * @param userId
	 * @return
	 */
	public static ImUser getImUser(String userId) {
		return Jboot.me().getRedis().get(userId);
	}
	
	public static void putIMservice(String serviceUri,ImService imService) {
		Jboot.me().getRedis().set(serviceUri, imService);
	}
	/**
	 * 獲取DTO
	 * @param userId
	 * @return
	 */
	public static ImService gutIMservice(String serviceUri) {
		return Jboot.me().getRedis().get(serviceUri);
	}
}
