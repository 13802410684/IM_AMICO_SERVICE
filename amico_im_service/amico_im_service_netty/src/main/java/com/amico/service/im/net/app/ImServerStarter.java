package com.amico.service.im.net.app;

import java.io.IOException;

import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.server.ServerGroupContext;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioListener;

import com.amico.service.im.net.ImServerAioHandler;
import com.amico.service.im.net.config.NetConfig;
import com.amico.service.im.net.listener.ImServerListener;
import com.amico.service.im.net.service.dto.ImService;

public class ImServerStarter implements Runnable{

	private static String AMICO_IM_SERVICE = "amico-im-server";	
	
	public  ImServerAioHandler aioHandler = new ImServerAioHandler();	
	//事件监听器，可以为null，但建议自己实现该接口，可以参考showcase了解些接口
    public  ServerAioListener aioListener = new ImServerListener(this);
    //一组连接共用的上下文对象
    public  ServerGroupContext serverGroupContext = new ServerGroupContext(AMICO_IM_SERVICE, aioHandler, aioListener);
    //tioServer对象
    public  TioServer tioServer = new TioServer(serverGroupContext);
    //有时候需要绑定ip，不需要则null
    public  String serverIp = NetConfig.SERVER;
    //监听的端口
    public  int serverPort = NetConfig.PORT;
  
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//serverGroupContext.setHeartbeatTimeout(NetConfig.TIMEOUT);
		//serverGroupContext.setShortConnection(false);
        try {
			tioServer.start(serverIp, serverPort);
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		new Thread(new ImServerStarter()).start();
	}
}
