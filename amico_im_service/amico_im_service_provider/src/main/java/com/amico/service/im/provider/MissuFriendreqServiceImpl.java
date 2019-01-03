package com.amico.service.im.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;

import com.amico.service.im.api.MissuFriendreqService;
import com.amico.service.im.entity.model.MissuFriendreq;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class MissuFriendreqServiceImpl extends JbootServiceBase<MissuFriendreq> implements MissuFriendreqService {

}