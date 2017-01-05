package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * shortvideo：小视频消息
 * video：视频消息
 */
@XmlRootElement
public class VideoReqMsg extends BaseReqMsg {

	@XmlElement(name = "MediaId") 
	private String MediaId;		//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	
	@XmlElement(name = "ThumbMediaId") 
	private String ThumbMediaId;//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	<CreateTime>1357290913</CreateTime>
	 * 	<MsgType><![CDATA[video|shortvideo ]]></MsgType>
	 * 	<MediaId><![CDATA[media_id]]></MediaId>
	 * 	<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
	 * 	<MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static VideoReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "videoReqMsg");
		JAXBContext context = JAXBContext.newInstance(VideoReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (VideoReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
