package com.heqing.entities.message.service;

import java.util.ArrayList;
import java.util.List;

/*
 * 客服接口-发消息
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140547&token=&lang=zh_CN
 */
public class CustomerServiceResponse {

	private String access_token;	//是	调用接口凭证
	private String touser;			//是	普通用户openid
	private String msgtype;			//是	消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	private Text   text  ;
	private Image  image ;
	private Voice  voice ;
	private Video  video ;
	private Music  music ;
	private News   news  ;
	private MPNews mpNews;
	private WXCard wxCard;
	private CustomService customservice;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
	public MPNews getMpNews() {
		return mpNews;
	}
	public void setMpNews(MPNews mpNews) {
		this.mpNews = mpNews;
	}
	
	public WXCard getWxCard() {
		return wxCard;
	}
	public void setWxCard(WXCard wxCard) {
		this.wxCard = wxCard;
	}
	
	public CustomService getCustomservice() {
		return customservice;
	}
	public void setCustomservice(CustomService customservice) {
		this.customservice = customservice;
	}

	public class Text {
		private String content;			//是	文本消息内容

		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
	
	public class Image {
		private String media_id;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class Voice {
		private String media_id;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class Video {
		private String media_id;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		private String thumb_media_id;	//是	缩略图的媒体ID
		private String title;			//否	图文消息/视频消息/音乐消息的标题
		private String description;		//否	图文消息/视频消息/音乐消息的描述
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
		public String getThumb_media_id() {
			return thumb_media_id;
		}
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
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
	}
	
	public class Music {
		private String title;			//否	图文消息/视频消息/音乐消息的标题
		private String description;		//否	图文消息/视频消息/音乐消息的描述
		private String musicurl;		//是	音乐链接
		private String hqmusicurl;		//是	高品质音乐链接，wifi环境优先使用该链接播放音乐
		private String thumb_media_id;	//是	缩略图的媒体ID
	
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
		
		public String getMusicurl() {
			return musicurl;
		}
		public void setMusicurl(String musicurl) {
			this.musicurl = musicurl;
		}
		
		public String getHqmusicurl() {
			return hqmusicurl;
		}
		public void setHqmusicurl(String hqmusicurl) {
			this.hqmusicurl = hqmusicurl;
		}
		
		public String getThumb_media_id() {
			return thumb_media_id;
		}
		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}
	}
	
	public class News {
		private List<Article> articles = new ArrayList<Article>(); //是	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
	
		public class Article{
			private String title;			//否	图文消息/视频消息/音乐消息的标题
			private String description;		//否	图文消息/视频消息/音乐消息的描述
			private String url;				//否	图文消息被点击后跳转的链接
			private String picurl;			//否	图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80

			public String getPicurl() {
				return picurl;
			}
			public void setPicurl(String picurl) {
				this.picurl = picurl;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
		}

		public List<Article> getArticles() {
			return articles;
		}
		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}
	}
	
	public class MPNews {
		private String media_id;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class WXCard {
		private String card_id;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		
		public String getCard_id() {
			return card_id;
		}
		public void setCard_id(String card_id) {
			this.card_id = card_id;
		}
	}

	public class CustomService {
		private String kf_account;		//是	发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
		
		public String getKF_Account() {
			return kf_account;
		}
		public void setKF_Account(String kf_account) {
			this.kf_account = kf_account;
		}
	}
}
