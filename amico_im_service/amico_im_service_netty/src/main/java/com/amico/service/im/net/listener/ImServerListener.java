package com.amico.service.im.net.listener;

import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioListener;

import com.amico.service.im.net.app.ImServerStarter;
import com.amico.service.im.net.config.NetConfig;
import com.amico.service.im.net.service.dto.ImService;
import com.amico.service.im.net.utils.CacheUtils;

import io.jboot.Jboot;
import io.jboot.utils.StrUtils;

public class ImServerListener implements ServerAioListener{
	
	private ImServerStarter imServerStarter;
	
	public ImServerListener(ImServerStarter imServerStarter) {
		this.imServerStarter = imServerStarter;
	}

	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect)
			throws Exception {
		// TODO Auto-generated method stub
		//鏈接成功后
		//註冊IM服務器 
		ImService imservice = new ImService();
    	imservice.setIp(imServerStarter.serverIp);
    	imservice.setPort(imServerStarter.serverPort+"");
    	imservice.setServiceName(StrUtils.uuid());
    	imservice.setServiceUrl("/amico/im/servers/"+imServerStarter.serverIp+"/"+imServerStarter.serverPort);
    	NetConfig.myImService = imservice;
    	CacheUtils.putIMservice(imservice.getServiceUrl(), imservice);
	}

	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
