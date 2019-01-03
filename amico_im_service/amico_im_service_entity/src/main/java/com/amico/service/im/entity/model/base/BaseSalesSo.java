package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSalesSo<M extends BaseSalesSo<M>> extends JbootModel<M> implements IBean {

	public void setOrderId(java.lang.String orderId) {
		set("order_id", orderId);
	}
	
	public java.lang.String getOrderId() {
		return getStr("order_id");
	}

	public void setOrderType(java.lang.Integer orderType) {
		set("order_type", orderType);
	}
	
	public java.lang.Integer getOrderType() {
		return getInt("order_type");
	}

	public void setForUserUid(java.lang.Integer forUserUid) {
		set("for_user_uid", forUserUid);
	}
	
	public java.lang.Integer getForUserUid() {
		return getInt("for_user_uid");
	}

	public void setOrderDate(java.lang.String orderDate) {
		set("order_date", orderDate);
	}
	
	public java.lang.String getOrderDate() {
		return getStr("order_date");
	}

	public void setOrderStatus(java.lang.Integer orderStatus) {
		set("order_status", orderStatus);
	}
	
	public java.lang.Integer getOrderStatus() {
		return getInt("order_status");
	}

	public void setPayType(java.lang.Integer payType) {
		set("pay_type", payType);
	}
	
	public java.lang.Integer getPayType() {
		return getInt("pay_type");
	}

	public void setOrderCurrency(java.lang.Integer orderCurrency) {
		set("order_currency", orderCurrency);
	}
	
	public java.lang.Integer getOrderCurrency() {
		return getInt("order_currency");
	}

	public void setOrderAmount(java.math.BigDecimal orderAmount) {
		set("order_amount", orderAmount);
	}
	
	public java.math.BigDecimal getOrderAmount() {
		return get("order_amount");
	}

	public void setTransferId(java.lang.Integer transferId) {
		set("transfer_id", transferId);
	}
	
	public java.lang.Integer getTransferId() {
		return getInt("transfer_id");
	}

	public void setFareAmount(java.math.BigDecimal fareAmount) {
		set("fare_amount", fareAmount);
	}
	
	public java.math.BigDecimal getFareAmount() {
		return get("fare_amount");
	}

	public void setOrderTotal(java.math.BigDecimal orderTotal) {
		set("order_total", orderTotal);
	}
	
	public java.math.BigDecimal getOrderTotal() {
		return get("order_total");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setPayTime(java.util.Date payTime) {
		set("pay_time", payTime);
	}
	
	public java.util.Date getPayTime() {
		return get("pay_time");
	}

	public void setAppender(java.lang.String appender) {
		set("appender", appender);
	}
	
	public java.lang.String getAppender() {
		return getStr("appender");
	}

	public void setPayKey(java.lang.String payKey) {
		set("pay_key", payKey);
	}
	
	public java.lang.String getPayKey() {
		return getStr("pay_key");
	}

	public void setTransferOrderId(java.lang.String transferOrderId) {
		set("transfer_order_id", transferOrderId);
	}
	
	public java.lang.String getTransferOrderId() {
		return getStr("transfer_order_id");
	}

	public void setSign(java.lang.String sign) {
		set("sign", sign);
	}
	
	public java.lang.String getSign() {
		return getStr("sign");
	}

	public void setTransferName(java.lang.String transferName) {
		set("transfer_name", transferName);
	}
	
	public java.lang.String getTransferName() {
		return getStr("transfer_name");
	}

	public void setSoSrc(java.lang.Integer soSrc) {
		set("so_src", soSrc);
	}
	
	public java.lang.Integer getSoSrc() {
		return getInt("so_src");
	}

}
