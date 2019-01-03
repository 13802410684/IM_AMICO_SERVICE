package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.DeviceEvaluateService;
import com.amico.service.im.entity.model.DeviceEvaluate;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class DeviceEvaluateServiceImpl extends JbootServiceBase<DeviceEvaluate> implements DeviceEvaluateService {

}