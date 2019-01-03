package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMissuUsersBinary<M extends BaseMissuUsersBinary<M>> extends JbootModel<M> implements IBean {

	public void setResourceId(java.lang.Integer resourceId) {
		set("resource_id", resourceId);
	}
	
	public java.lang.Integer getResourceId() {
		return getInt("resource_id");
	}

	public void setUserUid(java.lang.Integer userUid) {
		set("user_uid", userUid);
	}
	
	public java.lang.Integer getUserUid() {
		return getInt("user_uid");
	}

	public void setResType(java.lang.Integer resType) {
		set("res_type", resType);
	}
	
	public java.lang.Integer getResType() {
		return getInt("res_type");
	}

	public void setResFileName(java.lang.String resFileName) {
		set("res_file_name", resFileName);
	}
	
	public java.lang.String getResFileName() {
		return getStr("res_file_name");
	}

	public void setResHumanSize(java.lang.String resHumanSize) {
		set("res_human_size", resHumanSize);
	}
	
	public java.lang.String getResHumanSize() {
		return getStr("res_human_size");
	}

	public void setResSize(java.math.BigDecimal resSize) {
		set("res_size", resSize);
	}
	
	public java.math.BigDecimal getResSize() {
		return get("res_size");
	}

	public void setViewCount(java.lang.Integer viewCount) {
		set("view_count", viewCount);
	}
	
	public java.lang.Integer getViewCount() {
		return getInt("view_count");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

}