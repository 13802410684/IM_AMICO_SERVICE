package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSalesTrsferForCountry<M extends BaseSalesTrsferForCountry<M>> extends JbootModel<M> implements IBean {

	public void setTrsferForCountryId(java.lang.Integer trsferForCountryId) {
		set("trsfer_for_country_id", trsferForCountryId);
	}
	
	public java.lang.Integer getTrsferForCountryId() {
		return getInt("trsfer_for_country_id");
	}

	public void setTransferId(java.lang.Integer transferId) {
		set("transfer_id", transferId);
	}
	
	public java.lang.Integer getTransferId() {
		return getInt("transfer_id");
	}

	public void setCountryId(java.lang.Integer countryId) {
		set("country_id", countryId);
	}
	
	public java.lang.Integer getCountryId() {
		return getInt("country_id");
	}

	public void setTransferFare(java.math.BigDecimal transferFare) {
		set("transfer_fare", transferFare);
	}
	
	public java.math.BigDecimal getTransferFare() {
		return get("transfer_fare");
	}

}
