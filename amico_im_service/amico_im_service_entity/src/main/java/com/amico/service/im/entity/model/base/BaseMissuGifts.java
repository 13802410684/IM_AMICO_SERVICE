package com.amico.service.im.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMissuGifts<M extends BaseMissuGifts<M>> extends JbootModel<M> implements IBean {

	public void setGiftIdent(java.lang.String giftIdent) {
		set("gift_ident", giftIdent);
	}
	
	public java.lang.String getGiftIdent() {
		return getStr("gift_ident");
	}

	public void setGiftName(java.lang.String giftName) {
		set("gift_name", giftName);
	}
	
	public java.lang.String getGiftName() {
		return getStr("gift_name");
	}

	public void setIsValid(java.lang.Integer isValid) {
		set("is_valid", isValid);
	}
	
	public java.lang.Integer getIsValid() {
		return getInt("is_valid");
	}

	public void setPrice(java.lang.Integer price) {
		set("price", price);
	}
	
	public java.lang.Integer getPrice() {
		return getInt("price");
	}

	public void setResDrawableId(java.lang.String resDrawableId) {
		set("res_drawable_id", resDrawableId);
	}
	
	public java.lang.String getResDrawableId() {
		return getStr("res_drawable_id");
	}

	public void setResDialogue(java.lang.String resDialogue) {
		set("res_dialogue", resDialogue);
	}
	
	public java.lang.String getResDialogue() {
		return getStr("res_dialogue");
	}

}
