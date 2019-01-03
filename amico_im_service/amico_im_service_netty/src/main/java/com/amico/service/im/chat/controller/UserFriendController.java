package com.amico.service.im.chat.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.amico.service.im.api.MissuUsersService;
import com.amico.service.im.chat.common.dto.AjaxResult;
import com.amico.service.im.chat.common.dto.cnst.ServiceErrorCode;
import com.amico.service.im.entity.model.MissuUsers;

import io.jboot.admin.base.interceptor.NotNullPara;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;



@RequestMapping("/amico/friend")
public class UserFriendController extends JbootController{

	@JbootrpcService
    private  MissuUsersService missuUsersService;
	
	
	@NotNullPara({"userName"})
	public void searchFriend() {
		//用户名
		String userName = getPara("userName");
		MissuUsers users = new MissuUsers();
		users.setNickname(userName);
		List<MissuUsers> missuUsers = missuUsersService.findFriends(users);
		if(missuUsers!=null&&missuUsers.size()>0) {
			renderJson(AjaxResult.toSuccess(missuUsers));
		}else {
			renderJson(AjaxResult.toError(ServiceErrorCode.SEARCH_USER_NOT_EXISTS));
		}
	}
	
}
