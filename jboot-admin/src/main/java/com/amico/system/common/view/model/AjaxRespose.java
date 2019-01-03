package com.amico.system.common.view.model;


public class AjaxRespose {
	private String errorNo = "0";
	private String errorInfo = "";
	private Object data;

	private AjaxRespose() {

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

	public static AjaxRespose toError(String errorNo,String errorInfo,String data) {
		AjaxRespose result = new AjaxRespose();
		result.setData(data);
		result.setErrorNo(errorNo);
		result.setErrorInfo(errorInfo);
		return result;
	}

	public static AjaxRespose toError(String errorNo,String errorInfo) {
		AjaxRespose result = new AjaxRespose();
		result.setErrorNo(errorNo);
		result.setErrorInfo(errorInfo);
		return result;
	}

	public static AjaxRespose toError(String errorNo) {
		AjaxRespose result = new AjaxRespose();
		result.setErrorNo(errorNo);
		return result;
	}

	public static AjaxRespose toSuccess(Object data) {
		AjaxRespose result = new AjaxRespose();
		result.setErrorNo("0");
		result.setErrorInfo("");
		result.setData(data);
		return result;
	}
}
