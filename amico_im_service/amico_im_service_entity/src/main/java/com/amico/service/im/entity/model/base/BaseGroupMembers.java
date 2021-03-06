package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGroupMembers<M extends BaseGroupMembers<M>> extends JbootModel<M> implements IBean {

	public void setUserRecordId(java.lang.Integer userRecordId) {
		set("user_record_id", userRecordId);
	}
	
	public java.lang.Integer getUserRecordId() {
		return getInt("user_record_id");
	}

	public void setUserUid(java.lang.Integer userUid) {
		set("user_uid", userUid);
	}
	
	public java.lang.Integer getUserUid() {
		return getInt("user_uid");
	}

	public void setGId(java.lang.String gId) {
		set("g_id", gId);
	}
	
	public java.lang.String getGId() {
		return getStr("g_id");
	}

	public void setJoinTime(java.util.Date joinTime) {
		set("join_time", joinTime);
	}
	
	public java.util.Date getJoinTime() {
		return get("join_time");
	}

	public void setBeInviteUserId(java.lang.Integer beInviteUserId) {
		set("be_invite_user_id", beInviteUserId);
	}
	
	public java.lang.Integer getBeInviteUserId() {
		return getInt("be_invite_user_id");
	}

	public void setBeOwnerTime(java.util.Date beOwnerTime) {
		set("be_owner_time", beOwnerTime);
	}
	
	public java.util.Date getBeOwnerTime() {
		return get("be_owner_time");
	}

	public void setNicknameIngroup(java.lang.String nicknameIngroup) {
		set("nickname_ingroup", nicknameIngroup);
	}
	
	public java.lang.String getNicknameIngroup() {
		return getStr("nickname_ingroup");
	}

}
