package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSalesSoDetail<M extends BaseSalesSoDetail<M>> extends JbootModel<M> implements IBean {

	public void setSoDetailId(java.lang.String soDetailId) {
		set("so_detail_id", soDetailId);
	}
	
	public java.lang.String getSoDetailId() {
		return getStr("so_detail_id");
	}

	public void setOrderId(java.lang.String orderId) {
		set("order_id", orderId);
	}
	
	public java.lang.String getOrderId() {
		return getStr("order_id");
	}

	public void setDeviceId(java.lang.String deviceId) {
		set("device_id", deviceId);
	}
	
	public java.lang.String getDeviceId() {
		return getStr("device_id");
	}

	public void setColorId(java.lang.String colorId) {
		set("color_id", colorId);
	}
	
	public java.lang.String getColorId() {
		return getStr("color_id");
	}

	public void setPurchaseQuantity(java.lang.Integer purchaseQuantity) {
		set("purchase_quantity", purchaseQuantity);
	}
	
	public java.lang.Integer getPurchaseQuantity() {
		return getInt("purchase_quantity");
	}

	public void setPurchasePrice(java.math.BigDecimal purchasePrice) {
		set("purchase_price", purchasePrice);
	}
	
	public java.math.BigDecimal getPurchasePrice() {
		return get("purchase_price");
	}

	public void setPurchaseAmount(java.math.BigDecimal purchaseAmount) {
		set("purchase_amount", purchaseAmount);
	}
	
	public java.math.BigDecimal getPurchaseAmount() {
		return get("purchase_amount");
	}

	public void setAppender(java.lang.String appender) {
		set("appender", appender);
	}
	
	public java.lang.String getAppender() {
		return getStr("appender");
	}

	public void setIsEvaluate(java.lang.Integer isEvaluate) {
		set("is_evaluate", isEvaluate);
	}
	
	public java.lang.Integer getIsEvaluate() {
		return getInt("is_evaluate");
	}

}