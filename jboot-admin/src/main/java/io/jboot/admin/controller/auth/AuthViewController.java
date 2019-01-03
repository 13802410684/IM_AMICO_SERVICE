package io.jboot.admin.controller.auth;

import java.util.HashMap;
import java.util.Map;

import com.amico.service.api.AuthAppService;
import com.amico.service.api.AuthLogService;
import com.amico.service.api.AuthRedirectConfigService;
import com.amico.service.api.AuthTokenService;
import com.amico.service.api.AuthUserService;
import com.amico.service.entity.model.AuthApp;
import com.amico.system.common.constant.ErrorConstant;
import com.amico.system.common.utils.TokenUtil;
import com.amico.system.common.view.model.AjaxRespose;
import com.jfinal.kit.PropKit;

import io.jboot.Jboot;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;


@RequestMapping("/auth/view")
public class AuthViewController extends JbootController{

	
	@JbootrpcService
	private AuthLogService authLogService;
	@JbootrpcService
	private AuthUserService authUserService;
	@JbootrpcService
	private AuthRedirectConfigService authRedirectConfigService;
	@JbootrpcService
	private AuthTokenService authTokenService;
	@JbootrpcService
	private AuthAppService authAppService;
	
	public void index() {
		String sessionId= StrUtils.uuid();
		setAttr("sessionId", sessionId);
		render("main.html");
	}
	
	
}
