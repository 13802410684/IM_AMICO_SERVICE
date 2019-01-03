package io.jboot.admin.controller.auth;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.amico.service.api.AuthAppService;
import com.amico.service.api.AuthLogService;
import com.amico.service.api.AuthRedirectConfigService;
import com.amico.service.api.AuthTokenService;
import com.amico.service.api.AuthUserService;
import com.amico.service.entity.model.AuthApp;
import com.amico.service.entity.model.AuthToken;
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


@RequestMapping("/auth/api")
public class AuthController extends JbootController{

	private static final String AUTH_CACHE = "auth_cache";
	private static final String AUTH_CACHE_UUID = "auth_cache_uuid";
	
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
	
	
	public String getVerifyTokenHttpURI(String token) {
		String [] params = new String[] {"token"};
		StringBuffer strBuff = new StringBuffer();
		String httpURI = PropKit.get("amico.auth.web.verify");
		strBuff.append(httpURI).append("?");
		for (String param : params) {
			strBuff.append(param).append("=").append(token);
		}
		return strBuff.toString();
	}

	
	/**
	 * 生成二维码
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@EnableCORS
	public void generateQrImage() {
		String appId = getPara("appId");  
		String sessionId = getPara("sessionId");  
		String redirectType = getPara("redirectType");
		AuthApp app = authAppService.findBySecretAndRectType(appId, redirectType);
		if(app==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_APP_NOT_EXISTS));
			return;
		}
		String token = TokenUtil.sign(app);
		if(StrUtils.isNotEmpty(token)==false) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_APP_NOT_EXISTS));
			return;
		}
		if(sessionId==null) {
			sessionId = StrUtils.uuid();
		}
		//保存TOKEN
		AuthToken authToken = new AuthToken();
		authToken.setSessionId(sessionId);
		authToken.setStatus("0");
		authToken.setCreateDate(new Date());
		authToken.setUpdateDate(new Date());
		authToken.setDelFlag("0");
		authToken.setUserToken(token);
		
		if(authTokenService.save(authToken)) {
			app.put("status", "0");
			app.put("sessionId", sessionId);
			Jboot.me().getCache().put(AUTH_CACHE, token, app,60*1000*60);
			String httpURI = getVerifyTokenHttpURI(token);
			//renderHtml(httpURI);
			String responseStr= TokenUtil.sign(httpURI);
			renderQrCode(responseStr, 200, 200);
			//renderJson(AjaxRespose.toSuccess(httpURI));
		}else {
			renderJson(AjaxRespose.toError(ErrorConstant.SYSTEM_EXCEPTION));
		}		
	}
	
	
	public String generateThirdPartyHttp(AuthApp authApp,String thirdPartyHttp) {
		String token = TokenUtil.sign(authApp);
		Jboot.me().getCache().put(AUTH_CACHE_UUID, token,authApp,60*1000*60);
		return "";
	}
	/**
	 * 
	 */
	public void redirectTokenUrl() {
		String sessionId = getPara("sessionId");
		if(sessionId==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_SESSION_NOT_EXISTS));
			return;
		}
		AuthToken authToken = authTokenService.findBySessionId(sessionId);
		if(authToken==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_TOKEN_NOT_EXISTS));
			return;
		}
		if(authToken.getUid()==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_UID_NOT_EXISTS));
			return;	
		}
		AuthApp authApp = Jboot.me().getCache().get(AUTH_CACHE_UUID, authToken.getUid());
		if(authApp==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_CACHE_APP_NOT_EXISTS));
			return;
		}	
		if(authApp.getStr("status").equals("1")) {
			StringBuffer strbuff = new StringBuffer(PropKit.get("amico.auth.web.redirect"));
			strbuff.append("?").append("uid=").append(authToken.getUid());
			renderJson(AjaxRespose.toSuccess(strbuff.toString()));
		}else {
			renderJson(AjaxRespose.toError(ErrorConstant.SYSTEM_EXCEPTION));
		}
	}
	
	/**
	 * 扫描二位获取token,跳转
	 */
	public void verifyToken() {
		String token = getPara("token");
		AuthApp authApp = Jboot.me().getCache().get(AUTH_CACHE, token);
		if(authApp==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_CACHE_APP_NOT_EXISTS));
			return;
		}
		AuthToken authToken = authTokenService.findBySessionId(authApp.getStr("sessionId"));
		if(authToken==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_TOKEN_INVALID));
			return;
		}
		boolean status = TokenUtil.verifyToken(token, authApp);
		if(status==true) {
			String redirectType = authApp.getStr("redirect_type");
			String isAutoCommit = authApp.getStr("is_auto_commit");
			//1是PC端 2 是手机端
			String uuid = StrUtils.uuid();
			authToken.setUid(uuid);
			if(authTokenService.update(authToken)==false) {
				renderJson(AjaxRespose.toError(ErrorConstant.SYSTEM_EXCEPTION));
				return;
			}
			Jboot.me().getCache().remove(AUTH_CACHE, token);
			Jboot.me().getCache().put(AUTH_CACHE_UUID, uuid,authApp,60*1000*60);
			if(redirectType.equals("1")) {
				Map<String,String> result = new HashMap<String,String>();
				result.put("redirectType", "1");
				if("1".equals(isAutoCommit)) {
					//自动提交
					result.put("autoCommit", "1");
				}else {
					//手动提交
					result.put("autoCommit", "0");
				}	
				result.put("uid", uuid);
				result.put("commitUrl", PropKit.get("amico.auth.web.commit"));
				renderJson(AjaxRespose.toSuccess(result));
			}else {
				Map<String,String> result = new HashMap<String,String>();
				result.put("redirectType", "2");
				result.put("uid", uuid);
				result.put("commitUrl", PropKit.get("amico.auth.web.redirect"));
				renderJson(AjaxRespose.toSuccess(result));
			}
		}else {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_TOKEN_INVALID));
		}
	}
	

	public void commitToken() {
		String uuid = getPara("uid");
		String isCommit = getPara("isCommit");
		String userInfo = getPara("userInfo");
		if(uuid==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_CACHE_APP_NOT_EXISTS));
			return;
		}
		AuthApp authApp = Jboot.me().getCache().get(AUTH_CACHE_UUID, uuid);
		if(authApp==null) {
			renderJson(AjaxRespose.toError(ErrorConstant.BIZ_EXCEPTION_CACHE_APP_NOT_EXISTS));
			return;
		}
		if(authApp.getStr("is_auto_commit").equals("0")) {
			if("1".equals(isCommit)) {		
				authApp.put("status", "1");
				authApp.put("userInfo",userInfo);
				Jboot.me().getCache().put(AUTH_CACHE_UUID, uuid,authApp,60*1000*60);
				renderJson(AjaxRespose.toSuccess(null));
				return ;
			}else {
				authApp.put("status", "2");
				authApp.put("userInfo",userInfo);
				Jboot.me().getCache().put(AUTH_CACHE_UUID, uuid,authApp,60*1000*60);
				renderJson(AjaxRespose.toSuccess(null));
				return ;
			}
		}else {
			authApp.put("status", "1");
			authApp.put("userInfo",userInfo);
			Jboot.me().getCache().put(AUTH_CACHE_UUID, uuid,authApp,60*1000*60);
			renderJson(AjaxRespose.toSuccess(null));
			return ;
		}
	}
	
	public void redirectToken() {
		String uuid = getPara("uid");
		AuthApp authApp = Jboot.me().getCache().get(AUTH_CACHE_UUID, uuid);
		if(authApp==null) {
			renderError(500);
			return;
		}
		String userInfo = authApp.get("userInfo");
		if(userInfo==null) {
			renderError(500);
			return;
		}
		String token = TokenUtil.signUserInfo(userInfo);
		Jboot.me().getCache().remove(AUTH_CACHE_UUID, uuid);
		Jboot.me().getCache().put(AUTH_CACHE, token,authApp,60*1000*60);
		String http = authApp.getStr("third_party_http");
		http+="?token="+token;
		redirect(http);
	}
	
	
	public static void main(String[] args) {
		String userInfo="{'userId':10000,'userName':'123'}";
		String i = URLEncoder.encode(userInfo);		
		System.out.println(i);
	}
	
}
