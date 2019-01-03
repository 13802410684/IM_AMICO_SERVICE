package io.jboot.admin.controller.auth;

import com.amico.service.api.AuthUserService;
import com.amico.service.entity.model.AuthApp;
import com.amico.service.entity.model.AuthUser;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.admin.base.common.RestResult;
import io.jboot.admin.base.exception.BusinessException;
import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.admin.base.rest.datatable.DataTable;
import io.jboot.admin.base.web.base.BaseController;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.web.controller.annotation.RequestMapping;

@RequestMapping("/auth/user")
public class AuthUserController extends BaseController{

    @JbootrpcService
    private AuthUserService authUserService;
    
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
        AuthUser authApp = new AuthUser();
        authApp.setUserName(getPara("user_name"));
        Page<AuthUser> dataPage = authUserService.findPage(authApp, pageNumber, pageSize);
        renderJson(new DataTable<AuthUser>(dataPage));
    }

    /**
     * 删除
     */
    @NotNullPara({"id"})
    public void delete() {
        String id = getPara("id");
        if (!authUserService.deleteById(id)) {
            throw new BusinessException("删除失败");
        }

        renderJson(RestResult.buildSuccess());
    }
}
