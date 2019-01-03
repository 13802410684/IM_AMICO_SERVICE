package com.amico.service.im.net.service.dto;

import java.io.Serializable;

public class ImService implements Serializable{
	//服务器别名
	private String serviceName;
	//ip地址
	private String ip;
	//端口號
	private String port;
	//服務器唯一鏈接
	private String serviceUrl;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
}
