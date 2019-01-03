package com.amico.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;

import com.amico.service.api.AuthTokenService;
import com.amico.service.entity.model.AuthLog;
import com.amico.service.entity.model.AuthToken;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class AuthTokenServiceImpl extends JbootServiceBase<AuthToken> implements AuthTokenService {

	
	public AuthToken findBySessionId(String sessionId) {
		return DAO.findFirst("select * from auth_token where session_id = ?", sessionId);
	}
	
	
	public Page<AuthToken> findPage(AuthToken authToken, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Columns columns = Columns.create();
	    return DAO.paginateByColumns(pageNumber, pageSize, columns.getList(), "create_date  desc");
	}
}