package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.MissuUserMsgsCollectService;
import com.amico.service.im.entity.model.MissuUserMsgsCollect;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class MissuUserMsgsCollectServiceImpl extends JbootServiceBase<MissuUserMsgsCollect> implements MissuUserMsgsCollectService {

}