package com.heqing.message;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.entities.message.service.CustomerService;
import com.heqing.entities.message.service.CustomerServiceResponse;
import com.heqing.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestCustomerService {

	@Resource	
	private MessageService messageService;
	
	/*
	 *   客服帐号管理.增删改查。调用失败。返回65400.没能理解具体含义
	 */
	
//	@Test
	public void addKFAccount() {
		CustomerService customerService = new CustomerService();
		customerService.setKf_account("975656343@qq.com");
		customerService.setNickname("客服一");
		customerService.setPassword("hq246512");
		System.out.println(">>>"+messageService.addKFAccount(customerService));
	}
	
//	@Test
	public void updateKFAccount() {
		CustomerService customerService = new CustomerService();
		customerService.setKf_account("975656343@qq.com");
		customerService.setNickname("客服二");
		customerService.setPassword("hq246512");
		System.out.println(">>>"+messageService.updateKFAccount(customerService));
	}
	
//	@Test
	public void deleteFAccount() {
		CustomerService customerService = new CustomerService();
		customerService.setKf_account("975656343@qq.com");
		customerService.setNickname("客服二");
		customerService.setPassword("hq246512");
		System.out.println(">>>"+messageService.deleteKFAccount(customerService));
	}
	
//	@Test
	public void uploadHeadImg() {
		messageService.uploadKFHeadImg("D:/test/test.jpg", "975656343@qq.com");
	}
	
//	@Test
	public void getKFList() {
		System.out.println(">>>"+messageService.getKFList());
	}
	
	@Test
	public void kfSendMsg() {
		CustomerServiceResponse serverResp = new CustomerServiceResponse();
		serverResp.setTouser("o0xVxt22mSUy_WP-AGTm3iGmJA30");
		serverResp.setMsgtype("text");
		CustomerServiceResponse.Text text = serverResp.new Text();
		text.setContent("hello");
		serverResp.setText(text);
//		CustomerServiceResponse.News news = serverResp.new News();
//		for(int i=0; i<3; i++) {
//			CustomerServiceResponse.News.Article article = news.new Article();
//			article.setTitle("title"+i);
//			article.setDescription("description"+i);
//			article.setPicurl("picurl"+i);
//			article.setUrl("url"+i);
//			news.getArticles().add(article);
//		}
//		serverResp.setNews(news);
//		//某个客服帐号来发消息
//		CustomerServiceResponse.CustomService customservice = serverResp.new CustomService();
//		customservice.setKF_Account("975656343@qq.com");
//		serverResp.setCustomservice(customservice);
		System.out.println(">>>"+messageService.kfSendMsg(serverResp));
	}
	
//	@Test
	public void getAutoreplyInfo() {
		System.out.println(">>>"+messageService.getAutoreplyInfo());
	}
}
