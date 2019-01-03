package io.jboot.admin.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.admin.service.api.AmicoNewsCategoryService;
import io.jboot.admin.service.entity.model.AmicoNewsCategory;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class AmicoNewsCategoryServiceImpl extends JbootServiceBase<AmicoNewsCategory> implements AmicoNewsCategoryService {

}