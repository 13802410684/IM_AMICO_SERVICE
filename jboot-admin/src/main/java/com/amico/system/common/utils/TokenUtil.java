package com.amico.system.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.amico.service.entity.model.AuthApp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {

	private static int EXPIRE_TIME = 60 * 1000 * 15;

	public static String sign(AuthApp app) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(app.getAppTokenSecret());
			Map<String, Object> header = new HashMap<>();
			header.put("typ", "JWT");
			header.put("alg", "HS256");
			return JWT.create().withHeader(header).withClaim("appId",app.getId()).withClaim("secret", app.getAppTokenSecret()).withExpiresAt(date).sign(algorithm);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String sign(String url) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256("amico");
			Map<String, Object> header = new HashMap<>();
			header.put("typ", "JWT");
			header.put("alg", "HS256");
			return JWT.create().withHeader(header).withClaim("url", url).withExpiresAt(date).sign(algorithm);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String signUserInfo(String userInfo) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256("amico");
			Map<String, Object> header = new HashMap<>();
			header.put("typ", "JWT");
			header.put("alg", "HS256");
			return JWT.create().withHeader(header).withClaim("userInfo", userInfo).withExpiresAt(date).sign(algorithm);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static boolean verifyToken(String token,AuthApp app) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(app.getAppTokenSecret());
			JWTVerifier ver = JWT.require(algorithm).build();
			DecodedJWT decodedJWT = ver.verify(token);
			String id = decodedJWT.getClaim("appId").asString();
			String secret = decodedJWT.getClaim("secret").asString();
			if(app.getId().equals(id)&&app.getAppTokenSecret().equals(secret)) {
				long time = decodedJWT.getExpiresAt().getTime();
				long currentTime = new Date().getTime();
				if(currentTime-time>0) {
					return false;
				}else {
					return true;	
				}
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
