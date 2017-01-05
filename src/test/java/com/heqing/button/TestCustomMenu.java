package com.heqing.button;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.heqing.entities.menu.CustomMenu;
import com.heqing.entities.menu.PersonaliseMenu;
import com.heqing.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestCustomMenu {

	@Resource	
	private MenuService menuService;
	
	@Test
	public void createCustomMenu() {
		//click类型必须带Key。view类型必须带Url。
		CustomMenu customMenu = new CustomMenu();
		CustomMenu.Button button1 = customMenu.new Button();
		button1.setType("click");
		button1.setName("按钮1");
		button1.setKey("ID10010");
		CustomMenu.Button button2 = customMenu.new Button();
		button2.setType("click");
		button2.setName("按钮2");
		button2.setKey("ID10020");
		CustomMenu.Button button3 = customMenu.new Button();
		button3.setName("菜单");
		CustomMenu.Button.SubButton subButton1 = button3.new SubButton();
		subButton1.setType("view");
		subButton1.setName("百度");
		subButton1.setUrl("http://www.baidu.com/");
		CustomMenu.Button.SubButton subButton2 = button3.new SubButton();
		subButton2.setType("view");
		subButton2.setName("好123");
		subButton2.setUrl("http://www.hao123.com/");
		button3.getSub_button().add(subButton1);
		button3.getSub_button().add(subButton2);
		customMenu.getButton().add(button1);
		customMenu.getButton().add(button2);
		customMenu.getButton().add(button3);

		System.out.println(">>>"+menuService.createCustomMenu(customMenu));
	}
	
//	@Test
	public void getCustomMenu() {
		System.out.println(">>>"+menuService.getCustomMenu());
	}
	
//	@Test
	public void deleteCustomMenu() {
		System.out.println(">>>"+menuService.deleteCustomMenu());
	}
	
//	@Test
	public void getCustomMenuInfo() {
		System.out.println(">>>"+menuService.getCustomMenuInfo());
	}
	
//	@Test
	public void addConditional() {
		//click类型必须带Key。view类型必须带Url。
		PersonaliseMenu personaliseMenu = new PersonaliseMenu();
		PersonaliseMenu.Button button1 = personaliseMenu.new Button();
		button1.setType("click");
		button1.setName("点击按钮1");
		button1.setKey("ID10010");
		PersonaliseMenu.Button button2 = personaliseMenu.new Button();
		button2.setType("click");
		button2.setName("点击按钮2");
		button2.setKey("ID10020");
		PersonaliseMenu.Button button3 = personaliseMenu.new Button();
		button3.setName("菜单");
		PersonaliseMenu.Button.SubButton subButton1 = button3.new SubButton();
		subButton1.setType("view");
		subButton1.setName("百度");
		subButton1.setUrl("http://www.baidu.com/");
		PersonaliseMenu.Button.SubButton subButton2 = button3.new SubButton();
		subButton2.setType("view");
		subButton2.setName("好123");
		subButton2.setUrl("http://www.hao123.com/");
		button3.getSub_button().add(subButton1);
		button3.getSub_button().add(subButton2);
		personaliseMenu.getButton().add(button1);
		personaliseMenu.getButton().add(button2);
		personaliseMenu.getButton().add(button3);
		
		//以下信息由 用户标签管理接口获取
		PersonaliseMenu.MatchRule matchRule = personaliseMenu.new MatchRule(); 
		matchRule.setTag_id("2");
		matchRule.setSex(PersonaliseMenu.MAN);
		matchRule.setClient_platform_type(PersonaliseMenu.OTHERS);
		matchRule.setCountry("中国");
		matchRule.setProvince("广东");
		matchRule.setCity("广州");
		matchRule.setLanguage("zh_CN");
		personaliseMenu.setMatchRule(matchRule);

		System.out.println(">>>"+new Gson().toJson(personaliseMenu));
//		System.out.println(">>>"+menuService.createCustomMenu(personaliseMenu));
	}
	
//	@Test
	public void delConditional() {
		String menuid = "ID10010";	//menuid为菜单id，可以通过自定义菜单查询接口获取。
		System.out.println(">>>"+menuService.delConditional(menuid));
	}
	
//	@Test
	public void testConditional() {
		String user_id = "o0xVxt22mSUy_WP-AGTm3iGmJA30";	//user_id可以是粉丝的OpenID，也可以是粉丝的微信号。
		System.out.println(">>>"+menuService.testConditional(user_id));
	}
}
