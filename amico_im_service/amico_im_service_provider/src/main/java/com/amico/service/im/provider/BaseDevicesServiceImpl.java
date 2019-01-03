package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.BaseDevicesService;
import com.amico.service.im.entity.model.BaseDevices;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class BaseDevicesServiceImpl extends JbootServiceBase<BaseDevices> implements BaseDevicesService {

}