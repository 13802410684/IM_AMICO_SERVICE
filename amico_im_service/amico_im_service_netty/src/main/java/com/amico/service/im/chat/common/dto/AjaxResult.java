package com.amico.service.im.chat.common.dto;

public class AjaxResult {
	private String errorNo = "0";
	private String errorInfo = "";
	private Object data;

	private AjaxResult() {

	}

	public String getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public static AjaxResult toError(String errorNo,String errorInfo,String data) {
		AjaxResult result = new AjaxResult();
		result.setData(data);
		result.setErrorNo(errorNo);
		result.setErrorInfo(errorInfo);
		return result;
	}

	public static AjaxResult toError(String errorNo,String errorInfo) {
		AjaxResult result = new AjaxResult();
		result.setErrorNo(errorNo);
		result.setErrorInfo(errorInfo);
		return result;
	}

	public static AjaxResult toError(String errorNo) {
		AjaxResult result = new AjaxResult();
		result.setErrorNo(errorNo);
		return result;
	}

	public static AjaxResult toSuccess(Object data) {
		AjaxResult result = new AjaxResult();
		result.setErrorNo("0");
		result.setErrorInfo("");
		result.setData(data);
		return result;
	}
}
