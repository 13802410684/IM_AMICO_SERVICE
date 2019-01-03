package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseEsysSn<M extends BaseEsysSn<M>> extends JbootModel<M> implements IBean {

	public void setSnName(java.lang.String snName) {
		set("sn_name", snName);
	}
	
	public java.lang.String getSnName() {
		return getStr("sn_name");
	}

	public void setCurrentVal(java.math.BigDecimal currentVal) {
		set("current_val", currentVal);
	}
	
	public java.math.BigDecimal getCurrentVal() {
		return get("current_val");
	}

	public void setMinVal(java.math.BigDecimal minVal) {
		set("min_val", minVal);
	}
	
	public java.math.BigDecimal getMinVal() {
		return get("min_val");
	}

	public void setMaxVal(java.math.BigDecimal maxVal) {
		set("max_val", maxVal);
	}
	
	public java.math.BigDecimal getMaxVal() {
		return get("max_val");
	}

	public void setDigit(java.math.BigDecimal digit) {
		set("digit", digit);
	}
	
	public java.math.BigDecimal getDigit() {
		return get("digit");
	}

	public void setHeadStr(java.lang.String headStr) {
		set("head_str", headStr);
	}
	
	public java.lang.String getHeadStr() {
		return getStr("head_str");
	}

	public void setBz(java.lang.String bz) {
		set("bz", bz);
	}
	
	public java.lang.String getBz() {
		return getStr("bz");
	}

	public void setGenTime(java.util.Date genTime) {
		set("gen_time", genTime);
	}
	
	public java.util.Date getGenTime() {
		return get("gen_time");
	}

}
