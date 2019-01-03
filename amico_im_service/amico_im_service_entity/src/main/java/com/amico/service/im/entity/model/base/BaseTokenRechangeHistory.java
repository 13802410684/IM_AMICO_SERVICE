package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTokenRechangeHistory<M extends BaseTokenRechangeHistory<M>> extends JbootModel<M> implements IBean {

	public void setRecordId(java.lang.Integer recordId) {
		set("record_id", recordId);
	}
	
	public java.lang.Integer getRecordId() {
		return getInt("record_id");
	}

	public void setUserUid(java.lang.Integer userUid) {
		set("user_uid", userUid);
	}
	
	public java.lang.Integer getUserUid() {
		return getInt("user_uid");
	}

	public void setHistoryDate(java.lang.String historyDate) {
		set("history_date", historyDate);
	}
	
	public java.lang.String getHistoryDate() {
		return getStr("history_date");
	}

	public void setPayType(java.lang.Integer payType) {
		set("pay_type", payType);
	}
	
	public java.lang.Integer getPayType() {
		return getInt("pay_type");
	}

	public void setHistoryCurrency(java.lang.Integer historyCurrency) {
		set("history_currency", historyCurrency);
	}
	
	public java.lang.Integer getHistoryCurrency() {
		return getInt("history_currency");
	}

	public void setHistoryAmount(java.math.BigDecimal historyAmount) {
		set("history_amount", historyAmount);
	}
	
	public java.math.BigDecimal getHistoryAmount() {
		return get("history_amount");
	}

	public void setHistoryToken(java.lang.Integer historyToken) {
		set("history_token", historyToken);
	}
	
	public java.lang.Integer getHistoryToken() {
		return getInt("history_token");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setPayKey(java.lang.String payKey) {
		set("pay_key", payKey);
	}
	
	public java.lang.String getPayKey() {
		return getStr("pay_key");
	}

	public void setAppender(java.lang.String appender) {
		set("appender", appender);
	}
	
	public java.lang.String getAppender() {
		return getStr("appender");
	}

}