package com.heqing.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.service.UserService;
import com.heqing.utils.HttpUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public String getUserInfo(String openid) {
		logger.info("==========getUserInfo===========");
		String url = WeChatInterface.getUserInfo.replace("ACCESS_TOKEN", WeChatCertificate.access_token).replace("OPENID", openid);
		System.out.println(">>>"+url);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String getTags() {
		logger.info("==========getTags===========");
		String url = WeChatInterface.getTags.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

}
