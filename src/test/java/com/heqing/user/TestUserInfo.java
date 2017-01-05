package com.heqing.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUserInfo {

	@Resource	
	private UserService userService;
	
//	@Test
	public void getTags() {
		System.out.println(">>>"+userService.getTags());
	}
	
	@Test
	public void getAllUserInfo() {
		String openid = "o0xVxt22mSUy_WP-AGTm3iGmJA30";
		System.out.println(">>>"+userService.getUserInfo(openid));
		}
}
