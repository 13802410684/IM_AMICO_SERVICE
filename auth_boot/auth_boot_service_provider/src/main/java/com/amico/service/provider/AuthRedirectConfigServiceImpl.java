package com.amico.service.provider;

import java.util.List;

import javax.inject.Singleton;

import com.amico.service.api.AuthRedirectConfigService;
import com.amico.service.entity.model.AuthApp;
import com.amico.service.entity.model.AuthRedirectConfig;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;

@Bean
@Singleton
@JbootrpcService
public class AuthRedirectConfigServiceImpl extends JbootServiceBase<AuthRedirectConfig> implements AuthRedirectConfigService {

	
	public Page<AuthRedirectConfig> findPage(AuthRedirectConfig authRedirectConfig, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Columns columns = Columns.create();
	    if (StrKit.notBlank(authRedirectConfig.getAppId())) {
	         columns.eq("app_id", authRedirectConfig.getAppId());
	    }
	    if (StrKit.notBlank(authRedirectConfig.getThirdPartyName())) {
	         columns.eq("third_party_name", authRedirectConfig.getThirdPartyName());
	    }
	    return DAO.paginateByColumns(pageNumber, pageSize, columns.getList(), "create_date desc");
	}
}