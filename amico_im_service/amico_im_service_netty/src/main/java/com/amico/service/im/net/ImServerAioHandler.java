package com.amico.service.im.net;

import java.nio.ByteBuffer;

import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import com.alibaba.fastjson.JSON;
import com.amico.service.im.net.manager.ImManager;
import com.amico.service.im.net.manager.ImManagerProcess;
import com.amico.service.im.net.packet.ImPacket;
import com.amico.service.im.net.req.dto.map.IMReqModelMap;
import com.amico.service.im.net.req.protobuf.RequestProto;
import com.amico.service.im.net.req.protobuf.RequestProto.RequestMessageProto;
import com.google.protobuf.ByteString;
import com.jfinal.log.Log;

import io.jboot.utils.StrUtils;

/***
 * 处理聊天信息
 * 
 * @author 黄琦
 *
 */
public class ImServerAioHandler implements ServerAioHandler {
	
	@Override
	public Packet decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext)
			throws AioDecodeException {
		// 提醒：buffer的开始位置并不一定是0，应用需要从buffer.position()开始读取数据
		// 收到的数据组不了业务包，则返回null以告诉框架数据不够
		if (readableLength < ImPacket.HEADER_LENGHT) {
			return null;
		}
		// 读取消息体的长度
		int bodyLength = buffer.getInt();
		// 数据不正确，则抛出AioDecodeException异常
		if (bodyLength < 0) {
			Log.getLog(getClass()).error("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
			return null;
		}
		// 计算本次需要的数据长度
		int neededLength = ImPacket.HEADER_LENGHT + bodyLength;
		// 收到的数据是否足够组包
		int isDataEnough = readableLength - neededLength;
		// 不够消息体长度(剩下的buffe组不了消息体)
		if (isDataEnough < 0) {
			return null;
		} else // 组包成功
		{
			ImPacket imPacket = new ImPacket();
			if (bodyLength > 0) {
				byte[] dst = new byte[bodyLength];
				buffer.get(dst);
				imPacket.setBody(dst);
			}
			return imPacket;
		}
	}

	@Override
	public ByteBuffer encode(Packet packet, GroupContext groupContext, ChannelContext channelContext) {
		// TODO Auto-generated method stub
		ImPacket imPacket = (ImPacket) packet;
        byte[] body = imPacket.getBody();
        int bodyLen = 0;
        if (body != null) {
            bodyLen = body.length;
        }
        //bytebuffer的总长度是 = 消息头的长度 + 消息体的长度
        int allLen = ImPacket.HEADER_LENGHT + bodyLen;
        //创建一个新的bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(allLen);
        //设置字节序
        buffer.order(groupContext.getByteOrder());
        //写入消息头----消息头的内容就是消息体的长度
        buffer.putInt(bodyLen);
        //写入消息体
        if (body != null) {
            buffer.put(body);
        }
        return buffer;
	}

	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		// TODO Auto-generated method stub
		ImPacket helloPacket = (ImPacket) packet;
		byte[] body = helloPacket.getBody();
		RequestMessageProto rewMessage = RequestProto.RequestMessageProto.parseFrom(body);
		String event = rewMessage.getEvent();
		String className = rewMessage.getClassName();
		ByteString byteStr = rewMessage.getData();
		byte [] contentByte = byteStr.toByteArray();
		Class<?> clsMap = IMReqModelMap.getClassByName(className);
		if(clsMap!=null) {
			Object t = JSON.parseObject(contentByte, clsMap);
			System.out.println(JSON.toJSONString(t));
			ImManager manager = ImManagerProcess.getImProcessManager(event);
			manager.process(t, channelContext);
		}else {
			Log.getLog(this.getClass()).info("ImPacket is fail check socket" +channelContext.getClientNode() );
		}
	     return;
	}

}
