package com.heqing.entities.message.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.VideoReqMsg;

/*
 * MsgType--->
 * video：视频消息
 */
public class VideoRespMsg extends BaseRespMsg {

	private List<Video> Video = new ArrayList<Video>();
	
	public List<Video> getVideo() {
		return Video;
	}
	public void setImage(List<Video> video) {
		Video = video;
	}
	
	public class Video {
		private String MediaId;		//是	通过素材管理中的接口上传多媒体文件，得到的id
		private String Title;		//否	视频消息的标题
		private String Description;	//否	视频消息的描述
		
		public String getMediaId() {
			return MediaId;
		}
		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
		
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
	}

	/*
	 * 返回的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>12345678</CreateTime>
	 * 	 <MsgType><![CDATA[video]]></MsgType>
	 * 	 <Video>
	 * 	 	<MediaId><![CDATA[media_id]]></MediaId>
	 * 	 	<Title><![CDATA[title]]></Title>
	 * 	 	<Description><![CDATA[description]]></Description>
	 * 	 </Video> 
	 * </xml>
	 */
	public static String responseMessage(VideoRespMsg videoMessage) {
		videoMessage.setCreateTime(new Date().getTime());
		videoMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_VIDEO);
		
		xstream.alias("xml", videoMessage.getClass());	
	    xstream.addImplicitCollection(videoMessage.getClass(), "Video");  
		xstream.alias("Video", videoMessage.new Video().getClass());
		return xstream.toXML(videoMessage);
	}
	
	public static String test(String xmlStr) {
		String response = "VideoRespMsg-->error";
		try {
			VideoReqMsg videoReqMsg = VideoReqMsg.requestMessage(xmlStr);
			VideoRespMsg videoRespMsg = new VideoRespMsg();
			videoRespMsg.setToUserName(videoReqMsg.getFromUserName());
			videoRespMsg.setFromUserName(videoReqMsg.getToUserName());
			int videos = 1;
			for(int i=0; i<videos; i++) {
				VideoRespMsg.Video video = videoRespMsg.new Video();
				video.setMediaId(videoReqMsg.getMediaId());
				video.setTitle("title");
				video.setDescription("description");
				videoRespMsg.getVideo().add(video);
			}
			response = responseMessage(videoRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
