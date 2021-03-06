package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.MissuOprlogService;
import com.amico.service.im.entity.model.MissuOprlog;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class MissuOprlogServiceImpl extends JbootServiceBase<MissuOprlog> implements MissuOprlogService {

}