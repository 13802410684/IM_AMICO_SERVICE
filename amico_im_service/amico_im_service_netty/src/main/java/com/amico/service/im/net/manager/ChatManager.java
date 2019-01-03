package com.amico.service.im.net.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.tio.core.ChannelContext;

import com.amico.im.client.net.dto.SingleChatDto;
import com.amico.service.im.net.config.NetConfig;
import com.amico.service.im.net.service.dto.ImUser;
import com.amico.service.im.net.utils.CacheUtils;

public class ChatManager implements ImManager{

	private ExecutorService pool ;
	
	public ChatManager() {
		 pool = Executors.newFixedThreadPool(10);
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
			if(req instanceof SingleChatDto) {
				SingleChatDto singleChatDto = (SingleChatDto)req;
				String toUserId = singleChatDto.getToUserId();
				ImUser toUser = CacheUtils.getImUser(toUserId);
				//如果用户存在缓存
				if(toUser!=null) {
					//用户在线
					if(toUser.isOnline()) {
						//发送
						String serviceUrl = toUser.getServiceUrl();
						//如果是本地用户直接发送
						if(NetConfig.myImService.getServiceUrl().equals(serviceUrl)) {
							
						}
					}else {
						//不在线存入离线数据库
					}
				}else {
					//查询数据库是否有此人
					//有就存入离线数据库
				}
			}
		}
	}
}

















