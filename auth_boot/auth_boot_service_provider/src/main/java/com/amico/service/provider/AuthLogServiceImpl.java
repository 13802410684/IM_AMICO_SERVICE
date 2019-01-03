package com.amico.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;

import com.amico.service.api.AuthLogService;
import com.amico.service.entity.model.AuthLog;
import com.amico.service.entity.model.AuthUser;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class AuthLogServiceImpl extends JbootServiceBase<AuthLog> implements AuthLogService {

	
	
	

	public Page<AuthLog> findPage(AuthLog authLog, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Columns columns = Columns.create();
	    return DAO.paginateByColumns(pageNumber, pageSize, columns.getList(), "create_date  desc");
	}
}