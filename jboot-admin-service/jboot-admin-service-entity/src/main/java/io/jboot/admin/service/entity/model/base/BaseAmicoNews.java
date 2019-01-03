package io.jboot.admin.service.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAmicoNews<M extends BaseAmicoNews<M>> extends JbootModel<M> implements IBean {

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

	public void setCategoryId(java.lang.String categoryId) {
		set("category_id", categoryId);
	}
	
	public java.lang.String getCategoryId() {
		return getStr("category_id");
	}

	public void setNewsTitle(java.lang.String newsTitle) {
		set("news_title", newsTitle);
	}
	
	public java.lang.String getNewsTitle() {
		return getStr("news_title");
	}

	public void setNewsContent(java.lang.String newsContent) {
		set("news_content", newsContent);
	}
	
	public java.lang.String getNewsContent() {
		return getStr("news_content");
	}

	public void setDelFlag(java.lang.String delFlag) {
		set("del_flag", delFlag);
	}
	
	public java.lang.String getDelFlag() {
		return getStr("del_flag");
	}

	public void setRemarks(java.lang.String remarks) {
		set("remarks", remarks);
	}
	
	public java.lang.String getRemarks() {
		return getStr("remarks");
	}

	public void setReadingNum(java.lang.Integer readingNum) {
		set("reading_num", readingNum);
	}
	
	public java.lang.Integer getReadingNum() {
		return getInt("reading_num");
	}

	public void setThumbsUpNum(java.lang.Integer thumbsUpNum) {
		set("thumbs_up_num", thumbsUpNum);
	}
	
	public java.lang.Integer getThumbsUpNum() {
		return getInt("thumbs_up_num");
	}

	public void setHttpUrl(java.lang.String httpUrl) {
		set("http_url", httpUrl);
	}
	
	public java.lang.String getHttpUrl() {
		return getStr("http_url");
	}

	public void setNewsType(java.lang.String newsType) {
		set("news_type", newsType);
	}
	
	public java.lang.String getNewsType() {
		return getStr("news_type");
	}

}
