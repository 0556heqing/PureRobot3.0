package com.heqing.message;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.entities.message.MessageModel;
import com.heqing.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestMessageModel {

	@Resource	
	private MessageService messageService;
	
//	@Test
	public void setIndustry() {
		MessageModel industry = new MessageModel();
		industry.setIndustry_id1("2");
		industry.setIndustry_id2("31");
		System.out.println(">>>"+messageService.setIndustry(industry));
	}
	
//	@Test
	public void getIndustry() {
		System.out.println(">>>"+messageService.getIndustry());
	}
	
//	@Test
	public void addTemplate() {
		MessageModel model = new MessageModel();
		model.setTemplate_id_short("TM00015");
		System.out.println(">>>"+messageService.addTemplate(model));
	}
	
//	@Test
	public void getAllTemplate() {
		System.out.println(">>>"+messageService.getAllTemplate());
	}
	
//	@Test
	public void deleteTemplate() {
		MessageModel model = new MessageModel();
		model.setTemplate_id("mGlkai6ObsibaPT28MyYc6MYk-c4UfKyX_GPLL4iDCo");
		System.out.println(">>>"+messageService.deleteTemplate(model));
	}
	
//	@Test
	public void sendTemplate() {
		MessageModel model = new MessageModel();
		model.setTouser("o0xVxt1HBqcN1zsXswCXFrpVfiWA");
		model.setTemplate_id("mGlkai6ObsibaPT28MyYc6MYk-c4UfKyX_GPLL4iDCo");
		model.setUrl("http://www.baidu.com");
		System.out.println(">>>"+messageService.sendTemplate(model));
	}
}
