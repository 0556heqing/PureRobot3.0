package com.heqing.service;

import javax.servlet.http.HttpServletRequest;

/*
 * 微信核心服务类
 */
public interface WeChatCoreService {
	
	/**
	 * 验证签名
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return
	 */
	public boolean checkSignature(String signature, String timestamp, String nonce);
	
	/**
	 * 处理用户发送的消息
	 */
	public String processRequest(HttpServletRequest request);
   
}
