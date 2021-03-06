package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMissuGiftsMine<M extends BaseMissuGiftsMine<M>> extends JbootModel<M> implements IBean {

	public void setMyGiftRecId(java.lang.Integer myGiftRecId) {
		set("my_gift_rec_id", myGiftRecId);
	}
	
	public java.lang.Integer getMyGiftRecId() {
		return getInt("my_gift_rec_id");
	}

	public void setUserUid(java.lang.Integer userUid) {
		set("user_uid", userUid);
	}
	
	public java.lang.Integer getUserUid() {
		return getInt("user_uid");
	}

	public void setFromUserUid(java.lang.Integer fromUserUid) {
		set("from_user_uid", fromUserUid);
	}
	
	public java.lang.Integer getFromUserUid() {
		return getInt("from_user_uid");
	}

	public void setGetTime(java.util.Date getTime) {
		set("get_time", getTime);
	}
	
	public java.util.Date getGetTime() {
		return get("get_time");
	}

	public void setGetTime2(java.lang.String getTime2) {
		set("get_time2", getTime2);
	}
	
	public java.lang.String getGetTime2() {
		return getStr("get_time2");
	}

	public void setSrcConsumeId(java.lang.String srcConsumeId) {
		set("src_consume_id", srcConsumeId);
	}
	
	public java.lang.String getSrcConsumeId() {
		return getStr("src_consume_id");
	}

	public void setGiftIdent(java.lang.String giftIdent) {
		set("gift_ident", giftIdent);
	}
	
	public java.lang.String getGiftIdent() {
		return getStr("gift_ident");
	}

}
