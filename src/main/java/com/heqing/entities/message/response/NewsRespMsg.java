package com.heqing.entities.message.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.TextReqMsg;

/*
 * MsgType--->
 * news：图文消息
 */
public class NewsRespMsg extends BaseRespMsg {

	private int ArticleCount;		//是	图文消息个数，限制为10条以内
	private List<Article> Articles = new ArrayList<Article>(); //是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
	public class Article{
		private String Title;				//否	图文消息标题
		private String Description;			//否	图文消息描述
		private String PicUrl;				//否	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		private String Url;					//否	点击图文消息跳转链接
		
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		
		public String getPicUrl() {
			return PicUrl;
		}
		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}
		
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
	}

	/*
	 * 返回的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>12345678</CreateTime>
	 * 	 <MsgType><![CDATA[news]]></MsgType>
	 * 	 <ArticleCount>2</ArticleCount>
	 * 	 <Articles>
	 * 	 	<item>
	 * 	 		<Title><![CDATA[title1]]></Title> 
	 * 	 		<Description><![CDATA[description1]]></Description>
	 * 	 		<PicUrl><![CDATA[picurl]]></PicUrl>
	 * 	 		<Url><![CDATA[url]]></Url>
	 * 		</item>
	 * 	 	<item>
	 * 	 		<Title><![CDATA[title]]></Title>
	 * 	 		<Description><![CDATA[description]]></Description>
	 * 	 		<PicUrl><![CDATA[picurl]]></PicUrl>
	 * 			<Url><![CDATA[url]]></Url>
	 * 		</item>
	 * 	 </Articles>
	 * </xml>
	 */
	public static String responseMessage(NewsRespMsg newsMessage) {
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_NEWS);
		
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", newsMessage.new Article().getClass());
		return xstream.toXML(newsMessage);
	}
	
	public static String test(String xmlStr) {
		String response = "NewsRespMsg-->error";
		try {
			TextReqMsg textReqMsg = TextReqMsg.requestMessage(xmlStr);
			NewsRespMsg newsRespMsg = new NewsRespMsg();
			newsRespMsg.setToUserName(textReqMsg.getFromUserName());
			newsRespMsg.setFromUserName(textReqMsg.getToUserName());
			int articleCount = 3;
			newsRespMsg.setArticleCount(articleCount);
			for(int i=0; i<articleCount; i++) {
				NewsRespMsg.Article articla = newsRespMsg.new Article();
				articla.setTitle("title"+i);
				articla.setDescription("description"+i);
				articla.setPicUrl("http://img5.imgtn.bdimg.com/it/u=1938623644,625001929&fm=11&gp=0.jpg");
				articla.setUrl("http://www.baidu.com");
				newsRespMsg.getArticles().add(articla);
			}
			response = responseMessage(newsRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
