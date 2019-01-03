package io.jboot.admin.controller.auth;

import java.util.Date;
import java.util.List;

import com.amico.service.api.AuthAppService;
import com.amico.service.api.AuthRedirectConfigService;
import com.amico.service.entity.model.AuthApp;
import com.amico.service.entity.model.AuthRedirectConfig;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.admin.base.common.RestResult;
import io.jboot.admin.base.exception.BusinessException;
import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.admin.base.rest.datatable.DataTable;
import io.jboot.admin.base.web.base.BaseController;
import io.jboot.admin.service.api.DataService;
import io.jboot.admin.service.entity.model.Data;
import io.jboot.admin.service.entity.status.system.DataStatus;
import io.jboot.admin.support.auth.AuthUtils;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.annotation.RequestMapping;

@RequestMapping("/auth/app")
public class AuthAppController extends BaseController{

    @JbootrpcService
    private AuthAppService authAppService;
    
    @JbootrpcService
    private AuthRedirectConfigService authRedirectConfigService;

    /**
     * index
     */
    public void index() {
        render("main.html");
    }

    /**
     * 表格数据
     */
    public void tableData() {
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 30);
        AuthApp authApp = new AuthApp();
        authApp.setAppName(getPara("appName"));
        Page<AuthApp> dataPage = authAppService.findPage(authApp, pageNumber, pageSize);
        renderJson(new DataTable<AuthApp>(dataPage));
    }

    /**
     * add
     */
    public void add() {
        render("add.html");
    }

    /**
     * 保存提交
     */
    public void postAdd() {
    	AuthApp authApp = getBean(AuthApp.class, "authApp");
    	authApp.setId(StrUtils.uuid());
    	authApp.setAppTokenSecret(StrUtils.uuid());
    	authApp.setCreateDate(new Date());
    	authApp.setDelFlag("0");
        if (!authAppService.save(authApp)) {
            throw new BusinessException("保存失败");
        }
        renderJson(RestResult.buildSuccess());
    }

    /**
     * update
     */
    @NotNullPara({"id"})
    public void update() {
        String id = getPara("id");
        AuthApp authApp = authAppService.findById(id);
        setAttr("authApp", authApp).render("update.html");
    }

    /**
     * 修改提交
     */
    public void postUpdate() {
    	AuthApp authApp = getBean(AuthApp.class, "authApp");

        if (authAppService.findById(authApp.getId()) == null) {
            throw new BusinessException("数据不存在");
        }
        
        authApp.setUpdateDate(new Date());
      
        if (!authAppService.update(authApp)) {
            throw new BusinessException("修改失败");
        }

        renderJson(RestResult.buildSuccess());
    }

    /**
     * 删除
     */
    @NotNullPara({"id"})
    public void delete() {
        String id = getPara("id");
        if (!authAppService.deleteById(id)) {
            throw new BusinessException("删除失败");
        }

        renderJson(RestResult.buildSuccess());
    }

    public void redirectList() {
    	setAttr("appId", getPara("appId"));
    	render("redirectList.html");
    }

    @NotNullPara({"appId"})
    public void redirectListData() {
        int pageNumber = getParaToInt("pageNumber", 1);
        int pageSize = getParaToInt("pageSize", 30);
        String appId = getPara("appId");
        AuthRedirectConfig authRedirectConfig = new AuthRedirectConfig();
        authRedirectConfig.setAppId(appId);
        Page<AuthRedirectConfig> dataPage = authRedirectConfigService.findPage(authRedirectConfig, pageNumber, pageSize);
        renderJson(new DataTable<AuthRedirectConfig>(dataPage));
    }
    
    
    public void addQr() {
    	setAttr("appId", getPara("appId"));
        render("add_qr.html");
    }

    /**
     * 保存提交
     */
    public void postAddQr() {
    	AuthRedirectConfig authRedirectConfig = getBean(AuthRedirectConfig.class, "authRedirectConfig");
    	authRedirectConfig.setId(StrUtils.uuid());
    	authRedirectConfig.setIsOff("1");
    	authRedirectConfig.setCreateDate(new Date());
    	authRedirectConfig.setDelFlag("0");
        if (!authRedirectConfigService.save(authRedirectConfig)) {
            throw new BusinessException("保存失败");
        }
        renderJson(RestResult.buildSuccess());
    }

    /**
     * update
     */
    @NotNullPara({"id"})
    public void updateQr() {
        String id = getPara("id");
        AuthRedirectConfig authRedirectConfig = authRedirectConfigService.findById(id);
        setAttr("authRedirectConfig", authRedirectConfig).render("update_qr.html");
    }

    /**
     * 修改提交
     */
    public void postUpdateQr() {
    	AuthRedirectConfig authRedirectConfig = getBean(AuthRedirectConfig.class, "authRedirectConfig");

        if (authRedirectConfigService.findById(authRedirectConfig.getId()) == null) {
            throw new BusinessException("数据不存在");
        }
        
        authRedirectConfig.setUpdateDate(new Date());
      
        if (!authRedirectConfigService.update(authRedirectConfig)) {
            throw new BusinessException("修改失败");
        }

        renderJson(RestResult.buildSuccess());
    }

    /**
     * 删除
     */
    @NotNullPara({"id"})
    public void deleteQr() {
        String id = getPara("id");
        if (!authRedirectConfigService.deleteById(id)) {
            throw new BusinessException("删除失败");
        }

        renderJson(RestResult.buildSuccess());
    }
}
