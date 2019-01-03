package com.amico.im.client.net.test;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.smartboot.socket.transport.AioSession;

import com.amico.im.client.net.IMClientService;
import com.amico.im.client.net.dto.SingleChatDto;
import com.amico.im.client.net.listener.ConnectListener;
import com.amico.im.client.net.process.req.ClientPacket;
import com.amico.service.im.net.rps.dto.LoginRpsDto;

public class ClientTest {

	
	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
		final IMClientService imClient = new IMClientService(new ConnectListener() {
			
			@Override
			public void onConnected(AioSession<ClientPacket> session) {
				// TODO Auto-generated method stub
				IMClientService imClient = session.getAttachment();
				imClient.loginIMService("400069","5eabe2b4ae064860b048a0ce9f0000b0");
			}
			
			@Override
			public void onClose(AioSession<ClientPacket> session) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(AioSession<ClientPacket> session, Object result) {
				// TODO Auto-generated method stub
				if(result instanceof LoginRpsDto) {
					LoginRpsDto loginRpsDto =  (LoginRpsDto)result;
					System.out.println(loginRpsDto);
				}
			}

			@Override
			public void onError(AioSession<ClientPacket> session, String errorNo, String errorInfo) {
				// TODO Auto-generated method stub
				System.out.println(errorNo);
			}

			
		});
		imClient.connect("127.0.0.1", 6789);	
	
//		Socket socket= new Socket("127.0.0.1", 6789);
//		socket.getOutputStream().write("12312312".getBytes());
//		while(true) {
//			Thread.sleep(10000);
//		}
	}
}
