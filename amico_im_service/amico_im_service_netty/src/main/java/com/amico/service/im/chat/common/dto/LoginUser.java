package com.amico.service.im.chat.common.dto;

import java.io.Serializable;

import com.amico.service.im.entity.model.MissuUsers;

public class LoginUser implements Serializable{
	private String sessionId;
	private long timeOut;
	private MissuUsers user;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public long getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}
	public MissuUsers getUser() {
		return user;
	}
	public void setUser(MissuUsers user) {
		this.user = user;
	}
	
}
