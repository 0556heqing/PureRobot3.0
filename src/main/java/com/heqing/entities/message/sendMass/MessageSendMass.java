package com.heqing.entities.message.sendMass;

import java.util.ArrayList;
import java.util.List;

/*
 * 高级群发接口
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140549&token=&lang=zh_CN
 */
public class MessageSendMass {

	private int msg_id;
	private String media_id;
	private String title;
	private String description;
	private List<Article> articles = new ArrayList<Article>(); //是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应

	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public class Article{

		public static final int SHOW = 1;
		public static final int NOShOW = 0;

		private String thumb_media_id;		//是	图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
		private String author;				//否	图文消息的作者
		private String title;				//是	图文消息的标题
		private String content_source_url;	//否	在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
		private String content;				//是	图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用
		private String digest;				//否	图文消息的描述
		private int    show_cover_pic;		//否	是否显示封面，1为显示，0为不显示
		private String media_id;
		
		
		public String getThumb_media_id() {
			return thumb_media_id;
		}
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}
		
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getContent_source_url() {
			return content_source_url;
		}
		public void setContent_source_url(String content_source_url) {
			this.content_source_url = content_source_url;
		}
		
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public String getDigest() {
			return digest;
		}
		public void setDigest(String digest) {
			this.digest = digest;
		}
		
		public int getShow_cover_pic() {
			return show_cover_pic;
		}
		public void setShow_cover_pic(int show_cover_pic) {
			this.show_cover_pic = show_cover_pic;
		}
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}

}
