package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.TokenRechangeHistoryService;
import com.amico.service.im.entity.model.TokenRechangeHistory;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class TokenRechangeHistoryServiceImpl extends JbootServiceBase<TokenRechangeHistory> implements TokenRechangeHistoryService {

}