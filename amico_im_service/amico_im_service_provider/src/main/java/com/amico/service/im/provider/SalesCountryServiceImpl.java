package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.SalesCountryService;
import com.amico.service.im.entity.model.SalesCountry;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class SalesCountryServiceImpl extends JbootServiceBase<SalesCountry> implements SalesCountryService {

}