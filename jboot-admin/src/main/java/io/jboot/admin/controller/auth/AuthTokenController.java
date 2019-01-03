package io.jboot.admin.controller.auth;

import com.amico.service.api.AuthLogService;
import com.amico.service.api.AuthTokenService;
import com.amico.service.entity.model.AuthLog;
import com.amico.service.entity.model.AuthToken;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.admin.base.common.RestResult;
import io.jboot.admin.base.exception.BusinessException;
import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.admin.base.rest.datatable.DataTable;
import io.jboot.admin.base.web.base.BaseController;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.web.controller.annotation.RequestMapping;

@RequestMapping("/auth/token")
public class AuthTokenController extends BaseController{

    @JbootrpcService
    private AuthTokenService authTokenService;
    
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
        AuthToken authToken = new AuthToken();
        Page<AuthToken> dataPage = authTokenService.findPage(authToken, pageNumber, pageSize);
        renderJson(new DataTable<AuthToken>(dataPage));
    }

    /**
     * 删除
     */
    @NotNullPara({"id"})
    public void delete() {
        String id = getPara("id");
        if (!authTokenService.deleteById(id)) {
            throw new BusinessException("删除失败");
        }

        renderJson(RestResult.buildSuccess());
    }
}
