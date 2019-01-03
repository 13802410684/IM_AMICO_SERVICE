package com.amico.service.im.chat.controller;

import java.util.Date;

import com.amico.service.im.api.MissuUsersService;
import com.amico.service.im.chat.common.dto.AjaxResult;
import com.amico.service.im.chat.common.dto.LoginUser;
import com.amico.service.im.chat.common.dto.cnst.ServiceCnst;
import com.amico.service.im.chat.common.dto.cnst.ServiceErrorCode;
import com.amico.service.im.entity.model.MissuUsers;

import io.jboot.Jboot;
import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;

@RequestMapping("/amico/chat")
public class UserController extends JbootController{
	
	@JbootrpcService
    private  MissuUsersService missuUsersService;

	
	/****
	 * im登录
	 */
	@EnableCORS
	@NotNullPara({"pwd","devType","userPhone"})
	public void imLoginService() {
		String pwd = getPara("pwd");
		String devType = getPara("devType");
		String deviceToken = getPara("deviceToken");
		String userPhone = getPara("userPhone");
		String ip = getIPAddress();
		MissuUsers missuUser = missuUsersService.iMloginService(devType, deviceToken, ip, userPhone, pwd);
		if(missuUser==null) {
			//账号错误,无法登录
			renderJson(AjaxResult.toError(ServiceErrorCode.SERVICE_ERROR_LOGIN_FAIL));
		}else {
			String sessionId = StrUtils.uuid();		
			long timeOut = new Date().getTime() + ServiceCnst.CACHHE_TIME_OUT;
			LoginUser loginUser = new LoginUser();
			loginUser.setSessionId(sessionId);
			loginUser.setTimeOut(timeOut);
			loginUser.setUser(missuUser);
			Jboot.me().getCache().put(ServiceCnst.IM_USERS_SESSION_CACHE, sessionId, loginUser, ServiceCnst.CACHHE_TIME_OUT);
			renderJson(AjaxResult.toSuccess(loginUser));
		}
	}
	
	/***
	 * 用戶詳細信息
	 */
	@NotNullPara({"userId"})
	public void userDeatil(){
		String userId = getPara("userId");
		MissuUsers missuUser =missuUsersService.findById(userId);
		if(missuUser!=null) {
			renderJson(AjaxResult.toSuccess(missuUser));
		}else {
			renderJson(AjaxResult.toError(ServiceErrorCode.SEARCH_USER_NOT_EXISTS));
		}
	}
	
	/**
	 * 版本验证
	 */
	
	
	/***
	 * 注册
	 */
	public void reg() {
		
		
	}

	/***
	 * 获取好友列表
	 */
	
	
	
	
}
