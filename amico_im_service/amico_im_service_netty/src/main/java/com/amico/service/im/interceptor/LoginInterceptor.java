package com.amico.service.im.interceptor;



import com.amico.service.im.chat.common.dto.AjaxResult;
import com.amico.service.im.chat.common.dto.LoginUser;
import com.amico.service.im.chat.common.dto.cnst.ServiceCnst;
import com.amico.service.im.chat.common.dto.cnst.ServiceErrorCode;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import io.jboot.Jboot;

/**
 * 前台登录拦截
 * 
 * @author
 *
 */
public class LoginInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		String token =inv.getController().getPara("token");
		if(token==null) {
			inv.getController().renderJson(AjaxResult.toError(ServiceErrorCode.LOGIN_TOKEN_NOT_EXISTS));
			return;
		}else {
			LoginUser agent = Jboot.me().getCache().get(ServiceCnst.IM_USERS_SESSION_CACHE,token);
			if(agent==null) {
				inv.getController().renderJson(AjaxResult.toError(ServiceErrorCode.LOGIN_TIME_OUT));
				return;
			}
		}
		inv.invoke();
	}

}
