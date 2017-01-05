package com.heqing.message;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heqing.entities.message.sendMass.MessageSendMass;
import com.heqing.entities.message.sendMass.SendMassResponse;
import com.heqing.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSendMass {

	@Resource	
	private MessageService messageService;
	
	/*
	 * bug
	 * curl: (60) SSL certificate problem: unable to get local issuer certificate
	 * 	More details here: http://curl.haxx.se/docs/sslcerts.html
	 */
	@Test
	public void uploadImg() {
//		curl -F filename=@D:/test/test.jpg "http://115.28.174.212:8080/SSM/test/upload"
		System.out.println(">>>"+messageService.uploadImg("D:/test/test.jpg"));
	}
	
//	@Test
	public void uploadnews() {
		MessageSendMass mass = new MessageSendMass();
		for(int i=0; i<1; i++) {
			MessageSendMass.Article article = mass.new Article();
			article.setThumb_media_id("Thumb_media_id"+i);
			article.setAuthor("Author"+i);
			article.setTitle("Title"+i);
			article.setContent_source_url("Content_source_url"+i);
			article.setContent("Content"+i);
			article.setDigest("Digest"+i);
			article.setShow_cover_pic(article.SHOW);
			mass.getArticles().add(article);
		}
		System.out.println(">>>"+messageService.uploadNews(mass));
	}
	
//	@Test
	public void uploadVideo() {
		MessageSendMass mass = new MessageSendMass();
		mass.setMedia_id("rF4UdIMfYK3efUfyoddYRMU50zMiRmmt_l0kszupYh_SzrcW5Gaheq05p_lHuOTQ");
		mass.setTitle("TITLE");
		mass.setDescription("Description");
		System.out.println(">>>"+messageService.uploadVideo(mass));
	}
	
//	@Test
	public void sendAll() {
		SendMassResponse mass = new SendMassResponse();
		mass.setMsgtype("mpnews");
		SendMassResponse.Filter filter = mass.new Filter();
		filter.setIs_to_all(false);
		filter.setTag_id(0);
		mass.setFilter(filter);
		SendMassResponse.MPNews mpnews = mass.new MPNews();
		mpnews.setMedia_id("123dsdajkasd231jhksad");
		mass.setMpnews(mpnews);
		System.out.println(">>>"+messageService.sendAll(mass));
	}
	
//	@Test
	public void sendNumerousByID() {
		SendMassResponse mass = new SendMassResponse();
		mass.setMsgtype("mpnews");
		mass.getTouser().add("OPENID1");mass.getTouser().add("OPENID2");
		SendMassResponse.MPNews mpnews = mass.new MPNews();
		mpnews.setMedia_id("123dsdajkasd231jhksad");
		mass.setMpnews(mpnews);
		System.out.println(">>>"+messageService.sendNumerousByID(mass));
	}
	
//	@Test
	public void deleteNumerous() {
		MessageSendMass mass = new MessageSendMass();
		mass.setMsg_id(30124);
		System.out.println(">>>"+messageService.deleteNumerous(mass));
	}
	
//	@Test
	public void preview() {
		SendMassResponse mass = new SendMassResponse(); 
		mass.setMsgtype("mpnews");
		mass.getTouser().add("OPENID1");				//bug  Touser是String，不是数组
		SendMassResponse.MPNews mpnews = mass.new MPNews();
		mpnews.setMedia_id("123dsdajkasd231jhksad");
		mass.setMpnews(mpnews);
		System.out.println(">>>"+messageService.preview(mass));
	}
	
//	@Test
	public void getNumerous() {
		MessageSendMass mass = new MessageSendMass();
		mass.setMsg_id(201053012);
		System.out.println(">>>"+messageService.getNumerous(mass));
	}
	
}
