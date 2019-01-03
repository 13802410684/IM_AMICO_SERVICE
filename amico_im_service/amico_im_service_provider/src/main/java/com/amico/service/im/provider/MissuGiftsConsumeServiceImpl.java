package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.MissuGiftsConsumeService;
import com.amico.service.im.entity.model.MissuGiftsConsume;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class MissuGiftsConsumeServiceImpl extends JbootServiceBase<MissuGiftsConsume> implements MissuGiftsConsumeService {

}