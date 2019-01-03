package com.amico.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;

import com.amico.service.api.AuthUserService;
import com.amico.service.entity.model.AuthApp;
import com.amico.service.entity.model.AuthUser;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class AuthUserServiceImpl extends JbootServiceBase<AuthUser> implements AuthUserService {

	
	
	public Page<AuthUser> findPage(AuthUser authApp, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Columns columns = Columns.create();
	    if (StrKit.notBlank(authApp.getUserName())) {
	         columns.like("user_name", "%"+authApp.getUserName()+"%");
	    }
	    return DAO.paginateByColumns(pageNumber, pageSize, columns.getList(), "create_date  desc");
	}
}