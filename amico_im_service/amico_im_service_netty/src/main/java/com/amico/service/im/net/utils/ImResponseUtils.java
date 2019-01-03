package com.amico.service.im.net.utils;

import org.tio.core.ChannelContext;
import org.tio.core.Tio;

import com.alibaba.dubbo.config.spring.context.annotation.DubboConfigConfiguration.Single;
import com.alibaba.fastjson.JSON;
import com.amico.service.im.net.packet.ImPacket;
import com.amico.service.im.net.req.protobuf.ResponseProto;
import com.amico.service.im.net.req.protobuf.ResponseProto.ResponseMessageProto.Builder;
import com.amico.service.im.net.rps.dto.LoginRpsDto;
import com.amico.service.im.net.rps.dto.SingleChatRpsDto;
import com.google.protobuf.ByteString;

public class ImResponseUtils {
	/**
	 * 发送消息
	 */
	public static boolean sendMessage(ChannelContext channelContext, ImPacket respacket) {
		return Tio.send(channelContext, respacket);
	}
		
	/**
	 * 对其他用户发送聊天信息
	 */
	public static boolean sendSingleChatRpsDto(ChannelContext channelContext,SingleChatRpsDto singleChatRpsDto) {
		ImPacket respacket = new ImPacket();
		Builder rewMessage = ResponseProto.ResponseMessageProto.newBuilder();
		rewMessage.setErrorNo("0");
		rewMessage.setClassName("SingleChatRpsDto");
		rewMessage.setErrorInfo("");
		rewMessage.setData(ByteString.copyFrom(JSON.toJSONString(singleChatRpsDto).getBytes()));
		respacket.setBody(rewMessage.build().toByteArray());
		return Tio.send(channelContext, respacket);
	}
	
	/**
	 * 发送登录成功后消息
	 * @param channelContext
	 * @param loginRpsDto
	 * @return
	 */
	public static boolean sendLoginRpsDto(ChannelContext channelContext,LoginRpsDto loginRpsDto) {
		ImPacket respacket = new ImPacket();
		Builder rewMessage = ResponseProto.ResponseMessageProto.newBuilder();
		rewMessage.setErrorNo("0");
		rewMessage.setClassName("LoginRpsDto");
		rewMessage.setErrorInfo("");
		rewMessage.setData(ByteString.copyFrom(JSON.toJSONString(loginRpsDto).getBytes()));
		respacket.setBody(rewMessage.build().toByteArray());
		return Tio.send(channelContext, respacket);
	}
	/***
	 * 请求成功
	 * @param channelContext
	 * @param respacket
	 * @return
	 */
	public static boolean sendSucess(ChannelContext channelContext,Object data) {
		ImPacket respacket = new ImPacket();
		Builder rewMessage = ResponseProto.ResponseMessageProto.newBuilder();
		rewMessage.setErrorNo("0");
		rewMessage.setErrorInfo("");
		rewMessage.setClassName("");
		rewMessage.setData(ByteString.copyFrom(JSON.toJSONString(data).getBytes()));
		respacket.setBody(rewMessage.build().toByteArray());
		return Tio.send(channelContext, respacket);
	}
	/***
	 * 请求失败
	 * @param channelContext
	 * @param respacket
	 * @return
	 */
	public static boolean sendFail(ChannelContext channelContext,String erorrNo,String errorInfo) {
		ImPacket respacket = new ImPacket();
		Builder rewMessage = ResponseProto.ResponseMessageProto.newBuilder();
		rewMessage.setErrorNo(erorrNo);
		rewMessage.setErrorInfo(errorInfo);
		rewMessage.setClassName("");
		rewMessage.setData(ByteString.copyFrom(JSON.toJSONString(new Object()).getBytes()));
		respacket.setBody(rewMessage.build().toByteArray());
		return Tio.send(channelContext, respacket);
	}
}
