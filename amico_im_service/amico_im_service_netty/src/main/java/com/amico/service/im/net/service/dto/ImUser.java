package com.amico.service.im.net.service.dto;

import java.io.Serializable;
import java.util.Date;

import org.tio.core.ChannelContext;

public class ImUser implements Serializable{

	//用户ID
	private String userId;
	//登录时间
	private Date loginTime;
	//所在服务器别名
	private String serviceName;
	//服务器URI地址 表示唯一
	private String serviceUrl;
	//ip地址
	private String ip;
	//是否在线
	private boolean online;


	private String token;
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
