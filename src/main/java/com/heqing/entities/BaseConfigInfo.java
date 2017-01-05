package com.heqing.entities;

public class BaseConfigInfo {

	public static final int OPEN = 0;
	public static final int CLOSE = 1;
	
	public static final int NOSHOW = 0;
	public static final int SHOW = 1;
	
	private String type ;			//类型
	private String news_info ;	    //图文消息的信息
	private String title ;			//图文消息的标题
	private String digest ;			//摘要
	private String author ;			//作者
	private int show_cover ;		//是否显示封面，0为不显示，1为显示
	private String cover_url ;		//封面图片的URL
	private String content_url ;	//正文的URL
	private String source_url ;		//原文的URL，若置空则无查看原文入口
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNews_info() {
		return news_info;
	}
	public void setNews_info(String news_info) {
		this.news_info = news_info;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getShow_cover() {
		if(show_cover == NOSHOW) return "不显示";
		return "显示";
	}
	public void setShow_cover(int show_cover) {
		this.show_cover = show_cover;
	}
	
	public String getCover_url() {
		return cover_url;
	}
	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
	
	public String getContent_url() {
		return content_url;
	}
	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}
	
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
}
