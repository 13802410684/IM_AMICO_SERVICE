package com.amico.service.im.net.manager;

import org.tio.core.ChannelContext;

public interface ImManager {
	
	public void process(Object req,ChannelContext channelContext);
}
