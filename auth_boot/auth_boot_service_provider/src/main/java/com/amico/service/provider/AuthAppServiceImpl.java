package com.amico.service.provider;

import javax.inject.Singleton;

import com.amico.service.api.AuthAppService;
import com.amico.service.entity.model.AuthApp;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;

@Bean
@Singleton
@JbootrpcService
public class AuthAppServiceImpl extends JbootServiceBase<AuthApp> implements AuthAppService {

	public AuthApp findBySecretAndRectType(String appId, String redirectType) {
		return DAO.findFirst(
				"select app.*,config.redirect_type as redirect_type,config.is_auto_commit as is_auto_commit,config.third_party_http as third_party_http,config.third_party_param as third_party_param from auth_app app join auth_redirect_config config on app.id = config.app_id where app.id = ? and redirect_type = ?",
				appId, redirectType);
	}

	public Page<AuthApp> findPage(AuthApp authApp, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Columns columns = Columns.create();
	    if (StrKit.notBlank(authApp.getAppName())) {
	         columns.like("app_name", "%"+authApp.getAppName()+"%");
	    }
	    return DAO.paginateByColumns(pageNumber, pageSize, columns.getList(), "create_date  desc");
	}

	
	
	

	

}