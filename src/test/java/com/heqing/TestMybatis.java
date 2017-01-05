package com.heqing;

import org.junit.Test;
import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestMybatis {

	@Resource	
	private TestService testService;

	@Test
	public void testById() {
		com.heqing.entities.Test test = testService.getById(2l);
		System.out.println(">>>>"+test.getName());
	}
	
//	@Test
	public void testSave() {
		com.heqing.entities.Test test = new com.heqing.entities.Test();
		test.setName("第二次测试");
		testService.save(test);
	}

}
