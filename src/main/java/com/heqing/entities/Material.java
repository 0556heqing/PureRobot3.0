package com.heqing.entities;

import java.util.ArrayList;
import java.util.List;

public class Material {

	private String media_id;	//要获取的素材的media_id 
	private String type;		//是 	素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	private int    offset; 		//是 	从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	private int		count; 		//是 	返回素材的数量，取值在1到20之间 
	private List<Article> articles = new ArrayList<Article>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}


	public class Article {
		public String title;				//标题
		public String thumb_media_id;		//图文消息的封面图片素材id（必须是永久mediaID）
		public String author;				//作者
		public String digest;				//图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
		public int 	  show_cover_pic;		//是否显示封面，0为false，即不显示，1为true，即显示
		public String content;				//图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
		public String content_source_url;	//图文消息的原文地址，即点击“阅读原文”后的URL 
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
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
		
		public String getDigest() {
			return digest;
		}
		public void setDigest(String digest) {
			this.digest = digest;
		}
		
		public int getShow_cover_pic() {
			return show_cover_pic;
		}
		public void setShow_cover_pic(boolean show_cover_pic) {
			if(show_cover_pic) this.show_cover_pic =1;
			else this.show_cover_pic = 2;
		}
		
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public String getContent_source_url() {
			return content_source_url;
		}
		public void setContent_source_url(String content_source_url) {
			this.content_source_url = content_source_url;
		}
	}
}
