package com.amico.service.im.net.manager;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.tio.core.ChannelContext;

import com.amico.service.im.api.MissuFriendreqService;
import com.amico.service.im.api.MissuRosterService;
import com.amico.service.im.api.MissuUsersService;
import com.amico.service.im.chat.common.dto.LoginUser;
import com.amico.service.im.chat.common.dto.cnst.ServiceCnst;
import com.amico.service.im.entity.model.MissuFriendreq;
import com.amico.service.im.entity.model.MissuRoster;
import com.amico.service.im.entity.model.MissuUsers;
import com.amico.service.im.net.config.NetConfig;
import com.amico.service.im.net.container.ImContainer;
import com.amico.service.im.net.req.dto.AddFriendDto;
import com.amico.service.im.net.req.dto.LoginDto;
import com.amico.service.im.net.rps.dto.LoginRpsDto;
import com.amico.service.im.net.service.dto.ImUser;
import com.amico.service.im.net.utils.CacheUtils;
import com.amico.service.im.net.utils.ImResponseUtils;
import com.jfinal.log.Log;

import io.jboot.Jboot;

public class BaseBizManager implements ImManager{

	private ExecutorService pool ;
	private ExecutorService servicePool ;
	
	public BaseBizManager() {
		 pool = Executors.newFixedThreadPool(10);
		 servicePool = Executors.newFixedThreadPool(10);
	}
	
	
	/***
	 * 用户登录
	 * @param req
	 * @param channelContext
	 */
	public void userLogin(Object req,ChannelContext channelContext) {
		LoginDto loginDto = (LoginDto)req;
		String token = loginDto.getToken();
		String userId = loginDto.getUserId();
		LoginUser loginUser = Jboot.me().getCache().get(ServiceCnst.IM_USERS_SESSION_CACHE, token);
		//缓存找不到对应信息,无法登录
		if(loginUser==null) {
			ImResponseUtils.sendFail(channelContext,"2000001","user is not login system !");
			return ;
		}
		//如果发现缓存对象和对应userId不一致 表示用户伪造登录信息
		if(loginUser.getUser().getUserUid().toString().equals(userId)==false) {
			ImResponseUtils.sendFail(channelContext,"2000002","user is not login auth !");
			return ;
		}
//		if(CacheUtils.getImUser(loginUser.getUser().getUserUid()+"")!=null) {
//			ImUser _imUser = CacheUtils.getImUser(loginUser.getUser().getUserUid()+"");
//			if(_imUser.isOnline()) {
//				//踢掉在綫用戶
//				
//			}
//		}
		//如果上线是否通知其他好友
		ImUser imUser = new ImUser();
		imUser.setUserId(loginUser.getUser().getUserUid()+"");
		imUser.setOnline(true);
		imUser.setServiceName(NetConfig.myImService.getServiceName());
		imUser.setServiceUrl(NetConfig.myImService.getServiceUrl());
		imUser.setToken(token);
		imUser.setLoginTime(new Date());
		imUser.setIp(channelContext.getClientNode().getIp());
		//缓存用户信息
		CacheUtils.putImUser(imUser.getUserId(), imUser);
		//注册通道
		ImContainer.regiterUserChannel(loginDto.getUserId(), channelContext);
		//创建返回对象
		LoginRpsDto loginRpsDto = new LoginRpsDto();
		loginRpsDto.setServiceUrl(imUser.getServiceUrl());
		loginRpsDto.setLoginTime(imUser.getLoginTime());
		loginRpsDto.setToken(imUser.getToken());
		loginRpsDto.setUserId(imUser.getUserId());
		loginRpsDto.setServiceName(imUser.getServiceName());
		//登录成功
		ImResponseUtils.sendLoginRpsDto(channelContext, loginRpsDto);
	}
	
	public void addFriends(Object req,ChannelContext channelContext) {
		AddFriendDto addFriendDto = (AddFriendDto)req;
		//保存好友加朋友请求信息
		MissuFriendreq missuFriendreq = new MissuFriendreq();
		missuFriendreq.setUserUid(Integer.valueOf(addFriendDto.getUserId()));
		missuFriendreq.setBeUserUid(Integer.valueOf(addFriendDto.getFriendUserId()));
		missuFriendreq.setBeDesc(addFriendDto.getDesc());
		missuFriendreq.setBeTime(new Date());
		missuFriendreq.setBtIp(channelContext.getClientNode().getIp());
		MissuFriendreqService service = Jboot.me().service(MissuFriendreqService.class);
		service.save(missuFriendreq);
		//通知在线用户
		//ImResponseUtils.sendLoginRpsDto(channelContext, loginRpsDto);
		
		
	}
	
	/***
	 * 退出
	 * @param req
	 * @param channelContext
	 */
	public void userLoginOut(Object req,ChannelContext channelContext) {
		
	}
	
	
	@Override
	public void process(Object req, ChannelContext channelContext) {
		// TODO Auto-generated method stub
		pool.execute(new ChatProcessRun(req, channelContext));
	}

	private class ChatProcessRun implements Runnable{
		
		private Object req;
		private ChannelContext channelContext;
				
		public ChatProcessRun(Object req, ChannelContext channelContext) {
			super();
			this.req = req;
			this.channelContext = channelContext;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//如果是单人聊天
			if(req==null) {
				Log.getLog(this.getClass()).error("req is null params is error !");
				return ;
			}
			//处理登陆请求
			if(req instanceof LoginDto) {
				//登录
				userLogin(req,channelContext);
			}
			if(req instanceof AddFriendDto) {
				addFriends(req,channelContext);
			}
			//用户加好友
			//用户删除好友
			//用户主动加群
			//用户被动加群
			//用户被踢出群
			//
			
		}
	}
}

















