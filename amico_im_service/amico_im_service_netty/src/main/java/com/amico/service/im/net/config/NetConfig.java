package com.amico.service.im.net.config;

import com.amico.service.im.net.service.dto.ImService;

public class NetConfig {
	/**
	 * 服务器地址
	 */
	public static final String SERVER = "192.168.3.13";
	/**
	 * 监听端口
	 */
	public static final int PORT = 6789;
	/**
	 * 心跳超时时间
	 */
	public static final int TIMEOUT = 5000;
	
	public static ImService myImService;
}
