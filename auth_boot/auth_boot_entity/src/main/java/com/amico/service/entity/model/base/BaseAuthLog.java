package com.amico.service.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAuthLog<M extends BaseAuthLog<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setCreateBy(java.lang.String createBy) {
		set("create_by", createBy);
	}
	
	public java.lang.String getCreateBy() {
		return getStr("create_by");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}
	
	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public void setUpdateBy(java.lang.String updateBy) {
		set("update_by", updateBy);
	}
	
	public java.lang.String getUpdateBy() {
		return getStr("update_by");
	}

	public void setUpdateDate(java.util.Date updateDate) {
		set("update_date", updateDate);
	}
	
	public java.util.Date getUpdateDate() {
		return get("update_date");
	}

	public void setRemarks(java.lang.String remarks) {
		set("remarks", remarks);
	}
	
	public java.lang.String getRemarks() {
		return getStr("remarks");
	}

	public void setDelFlag(java.lang.String delFlag) {
		set("del_flag", delFlag);
	}
	
	public java.lang.String getDelFlag() {
		return getStr("del_flag");
	}

	public void setEvent(java.lang.String event) {
		set("event", event);
	}
	
	public java.lang.String getEvent() {
		return getStr("event");
	}

	public void setIp(java.lang.String ip) {
		set("ip", ip);
	}
	
	public java.lang.String getIp() {
		return getStr("ip");
	}

	public void setUserId(java.lang.String userId) {
		set("user_id", userId);
	}
	
	public java.lang.String getUserId() {
		return getStr("user_id");
	}

	public void setUserName(java.lang.String userName) {
		set("user_name", userName);
	}
	
	public java.lang.String getUserName() {
		return getStr("user_name");
	}

	public void setMac(java.lang.String mac) {
		set("mac", mac);
	}
	
	public java.lang.String getMac() {
		return getStr("mac");
	}

	public void setAction(java.lang.String action) {
		set("action", action);
	}
	
	public java.lang.String getAction() {
		return getStr("action");
	}

	public void setUri(java.lang.String uri) {
		set("uri", uri);
	}
	
	public java.lang.String getUri() {
		return getStr("uri");
	}

	public void setReqParams(java.lang.String reqParams) {
		set("req_params", reqParams);
	}
	
	public java.lang.String getReqParams() {
		return getStr("req_params");
	}

}
