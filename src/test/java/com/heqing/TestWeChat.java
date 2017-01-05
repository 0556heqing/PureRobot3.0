package com.heqing;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.service.MessageService;
import com.heqing.utils.HttpUtil;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestWeChat {

	@Resource	
	private MessageService messageService;
	
//	@Test
	public void getCallbackIP() {
		String url = WeChatInterface.GETCALLBACKIP.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		System.out.println(">>>>>"+HttpUtil.getStringByGet(url));
	}
	
//	@Test
	public void getAutoreplyInfo() {
		System.out.println(">>>>>"+messageService.getAutoreplyInfo());
	}
}
