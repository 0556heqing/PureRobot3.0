package com.heqing.entities.message.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.TextReqMsg;

/*
 * MsgType--->
 * music：音乐消息
 */
public class MusicRespMsg extends BaseRespMsg {
	
	private List<Music> Music = new ArrayList<Music>();
	
	public List<Music> getMusic() {
		return Music;
	}
	public void setMusic(List<Music> music) {
		Music = music;
	}
	
	public class Music {
		private String Title;			//否	音乐标题
		private String Description;		//否	音乐描述
		private String MusicUrl;		//否	音乐链接
		private String HQMusicUrl;		//否	高质量音乐链接，WIFI环境优先使用该链接播放音乐
		private String ThumbMediaId;	//是	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
		
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
		
		public String getMusicUrl() {
			return MusicUrl;
		}
		public void setMusicUrl(String musicURL) {
			MusicUrl = musicURL;
		}
		
		public String getHQMusicUrl() {
			return HQMusicUrl;
		}
		public void setHQMusicUrl(String hQMusicUrl) {
			HQMusicUrl = hQMusicUrl;
		}
		
		public String getThumbMediaId() {
			return ThumbMediaId;
		}
		public void setThumbMediaId(String thumbMediaId) {
			ThumbMediaId = thumbMediaId;
		}
	}

	/*
	 * 返回的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>12345678</CreateTime>
	 * 	 <MsgType><![CDATA[music]]></MsgType>
	 * 	 <Music>
	 * 	 	<Title><![CDATA[TITLE]]></Title>
	 * 	 	<Description><![CDATA[DESCRIPTION]]></Description>
	 * 	 	<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
	 * 	 	<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
	 * 	 	<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
	 * 	 </Music>
	 * </xml>
	 */
	public static String responseMessage(MusicRespMsg musicMessage) {
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_MUSIC);
		
		xstream.alias("xml", musicMessage.getClass());
		xstream.addImplicitCollection(musicMessage.getClass(), "Music");  
		xstream.alias("Music", musicMessage.new Music().getClass());
		return xstream.toXML(musicMessage);
	}
	
	public static String test(String xmlStr) {
		String response = "MusicRespMsg-->error";
		try {
			TextReqMsg textReqMsg = TextReqMsg.requestMessage(xmlStr);
			MusicRespMsg musicRespMsg = new MusicRespMsg();
			musicRespMsg.setToUserName(textReqMsg.getFromUserName());
			musicRespMsg.setFromUserName(textReqMsg.getToUserName());
			int musics = 1;
			for(int i=0; i<musics; i++) {
				MusicRespMsg.Music music = musicRespMsg.new Music();
				music.setTitle("残酷月光");
				music.setDescription(" 林宥嘉 词:向月娥 曲:陈小霞");
				music.setMusicUrl("http://wma.5282.cc/2008-11//20140226/1.mp3");
				music.setHQMusicUrl("http://wma.5282.cc/2008-11//20140226/1.mp3");
				musicRespMsg.getMusic().add(music);
			}
			response = responseMessage(musicRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
