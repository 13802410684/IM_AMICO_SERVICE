package com.amico.service.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAuthApp<M extends BaseAuthApp<M>> extends JbootModel<M> implements IBean {

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

	
	public void setUid(java.lang.String uid) {
		set("uid", uid);
	}
	
	public java.lang.String getUid() {
		return getStr("uid");
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

	public void setAppName(java.lang.String appName) {
		set("app_name", appName);
	}
	
	public java.lang.String getAppName() {
		return getStr("app_name");
	}

	public void setAppIco(java.lang.String appIco) {
		set("app_ico", appIco);
	}
	
	public java.lang.String getAppIco() {
		return getStr("app_ico");
	}

	public void setAppCompany(java.lang.String appCompany) {
		set("app_company", appCompany);
	}
	
	public java.lang.String getAppCompany() {
		return getStr("app_company");
	}

	public void setAppVersion(java.lang.String appVersion) {
		set("app_version", appVersion);
	}
	
	public java.lang.String getAppVersion() {
		return getStr("app_version");
	}

	public void setAppTokenSecret(java.lang.String appTokenSecret) {
		set("app_token_secret", appTokenSecret);
	}
	
	public java.lang.String getAppTokenSecret() {
		return getStr("app_token_secret");
	}

}
