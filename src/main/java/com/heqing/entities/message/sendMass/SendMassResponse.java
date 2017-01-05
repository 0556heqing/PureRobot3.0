package com.heqing.entities.message.sendMass;

import java.util.ArrayList;
import java.util.List;

/*
 * 根据标签进行群发【订阅号与服务号认证后均可用】
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140549&token=&lang=zh_CN
 */
public class SendMassResponse {

	private String  msgtype;	//群发的消息类型，
	private Filter  filter;		//用于设定图文消息的接收者
	private List<String> touser = new ArrayList<String>();	//填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	private MPNews  mpnews;		//图文消息（注意图文消息的media_id需要通过上述方法来得到）：
	private MPVideo mpvideo;	//此处视频的media_id需通过POST请求WeChatInterface.uploadVideo的返回结果获得
	private Text    text;
	private Voice   voice;		//语音（注意此处media_id需通过基础支持中的上传下载多媒体文件来得到）：
	private Image   image;		//图片（注意此处media_id需通过基础支持中的上传下载多媒体文件来得到）：
	private WXCard  wxcard;		//卡券消息（注意图文消息的media_id需要通过上述方法来得到）
	
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public MPNews getMpnews() {
		return mpnews;
	}
	public void setMpnews(MPNews mpnews) {
		this.mpnews = mpnews;
	}

	public MPVideo getMpvideo() {
		return mpvideo;
	}
	public void setMpvideo(MPVideo mpvideo) {
		this.mpvideo = mpvideo;
	}

	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	
	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	public WXCard getWxcard() {
		return wxcard;
	}
	public void setWxcard(WXCard wxcard) {
		this.wxcard = wxcard;
	}
	
	public List<String> getTouser() {
		return touser;
	}
	public void setTouser(List<String> touser) {
		this.touser = touser;
	}

	public class Filter{
		private boolean is_to_all;	//用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
		private int tag_id;			//群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
		
		public boolean getIs_to_all() {
			return is_to_all;
		}
		public void setIs_to_all(boolean is_to_all) {
			this.is_to_all = is_to_all;
		}
		
		public int getTag_id() {
			return tag_id;
		}
		public void setTag_id(int tag_id) {
			this.tag_id = tag_id;
		}
	}

	public class MPNews{
		private String media_id;	//用于群发的消息的media_id

		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class MPVideo{
		private String media_id;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class Text{
		private String content;
		
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
	
	public class Voice{
		private String media_id;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class Image{
		private String media_id;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
	
	public class WXCard{
		private String media_id;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
	}
}
