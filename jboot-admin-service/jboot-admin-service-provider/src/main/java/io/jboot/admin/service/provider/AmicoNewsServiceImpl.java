package io.jboot.admin.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.admin.service.api.AmicoNewsService;
import io.jboot.admin.service.entity.model.AmicoNews;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class AmicoNewsServiceImpl extends JbootServiceBase<AmicoNews> implements AmicoNewsService {

}