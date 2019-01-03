package com.amico.im.client.net.listener;

import org.smartboot.socket.transport.AioSession;

import com.amico.im.client.net.process.req.ClientPacket;

public interface ConnectListener {
	
	public void onConnected(AioSession<ClientPacket> session);
	
	public void onClose(AioSession<ClientPacket> session);
	
	public void onSuccess(AioSession<ClientPacket> session,Object result);
	
	public void onError(AioSession<ClientPacket> session,String errorNo,String errorInfo);
	
}
