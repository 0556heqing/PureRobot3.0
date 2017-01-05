package com.heqing.service;

public interface UserService {

	// 获取公众号已创建的标签
	public String getTags();
	// 获取用户基本信息(UnionID机制)
	public String getUserInfo(String openid);
	
}
