package com.heqing.Material;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.entities.Material;
import com.heqing.service.MaterialService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestMaterial {

	@Resource	
	private MaterialService materialService;
	
//	@Test
	public void addTempMaterial() {
		System.out.println(materialService.addTempMaterial("D:\\test\\test.jpg", "image"));
	}
	
//	@Test
	public void getTempMaterial() {
		System.out.println(materialService.getTempMaterial("Eki__KqMkoFSoyr3f_C61UhOuZqwSBP8RxOUF23Vt0d-0dmeAAijSQFTipNlxMzD"));
	}
	
//	@Test
	public void addMaterial() {
		Material material = new Material();
		Material.Article article = material.new Article();
		article.setTitle("标题");
		article.setThumb_media_id("Eki__KqMkoFSoyr3f_C61UhOuZqwSBP8RxOUF23Vt0d-0dmeAAijSQFTipNlxMzD");
		article.setAuthor("heqing");
		article.setDigest("摘要");
		article.setShow_cover_pic(true);
		article.setContent("图文消息的具体内容");
		article.setContent_source_url("http://www.baidu.com");
		material.getArticles().add(article);
		
		System.out.println(materialService.addMaterial(material));
	}
	
//	@Test
	public void getMaterialList() {
		Material material = new Material();
		material.setType("image");
		material.setOffset(0);
		material.setCount(10);
		
		System.out.println(materialService.getMaterialList(material));
	}
	
//	@Test
	public void getMaterialCount() {
		System.out.println(materialService.getMaterialCount());
	}
	
//	@Test
	public void delMaterial() {
		Material material = new Material();
		material.setMedia_id("ID00001");
		
		System.out.println(materialService.delMaterial(material));
	}
}
