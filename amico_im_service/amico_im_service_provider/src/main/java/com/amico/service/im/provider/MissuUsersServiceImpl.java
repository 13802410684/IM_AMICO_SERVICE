package com.amico.service.im.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;

import com.amico.service.im.api.MissuUsersService;
import com.amico.service.im.entity.model.MissuUsers;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;

import io.jboot.service.JbootServiceBase;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

@Bean
@Singleton
@JbootrpcService
public class MissuUsersServiceImpl extends JbootServiceBase<MissuUsers> implements MissuUsersService {

	
	
	/*****
	 * 用户登录
	 */
	@Override
	public MissuUsers iMloginService(String devType,String deviceToken,String ip,String userPhone,String pwd) {		
		MissuUsers missuUser = DAO.findFirst("select * from missu_users where user_status = 1 and user_phone = ? and user_psw = ?", userPhone,pwd);
		if (missuUser != null) {
			if("IOS".equals(devType)) {
				List<MissuUsers> lastUsersUseThisIOSDeviceToken = DAO.find(
						"select user_uid from missu_users where ios_device_token=? and user_uid <> ?",deviceToken,missuUser.getUserUid());
				if(lastUsersUseThisIOSDeviceToken.size()>0) {
					Db.update("update missu_users set ios_device_token=null where ios_device_token=?",deviceToken);
				}
				for (MissuUsers _missuUser : lastUsersUseThisIOSDeviceToken) {
					_missuUser.setIosDeviceToken(null);
					Jboot.me().getRedis().set(_missuUser.getUserUid(), _missuUser);
				}
				missuUser.setIosDeviceToken(deviceToken);
			}else if("ANDROID".equals(devType)) {
				List<MissuUsers> lastUsersUseThisAndroidDeviceToken = DAO.find("select user_uid from missu_users where android_device_token=? and user_uid <> ?",deviceToken,missuUser.getUserUid());
				if(lastUsersUseThisAndroidDeviceToken.size()>0) {
					Db.update("update missu_users set android_device_token=null where android_device_token=?",deviceToken);
				}
				for (MissuUsers _missuUser : lastUsersUseThisAndroidDeviceToken) {
					_missuUser.setAndroidDeviceToken(null);
					Jboot.me().getRedis().set(_missuUser.getUserUid(), _missuUser);
				}
				missuUser.setAndroidDeviceToken(deviceToken);
			}	
			//在线
			missuUser.setIsOnline(1);
			missuUser.setLatestLoginIp(ip);
			missuUser.setLatestLoginTime(new Date());
			missuUser.update();
			Jboot.me().getRedis().set(missuUser.getUserUid(), missuUser);
			return missuUser;
		}else {
			return null;
		}
	}
	
	@Override
	public List<MissuUsers> findFriends(MissuUsers user){
		Columns columns = Columns.create();
	    if (StrKit.notBlank(user.getNickname())) {
	         columns.like("nickname", "%"+user.getNickname()+"%");
	    }
	    return DAO.findListByColumns(columns, "latest_login_time desc");
	}
		
}