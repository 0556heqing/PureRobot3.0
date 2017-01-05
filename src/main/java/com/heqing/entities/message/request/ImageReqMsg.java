package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * image：图片消息
 */
@XmlRootElement
public class ImageReqMsg extends BaseReqMsg {
	
	@XmlElement(name = "PicUrl")  
	private String PicUrl ;		//图片链接（由系统生成）
	
	@XmlElement(name = "MediaId")  
	private String MediaId ;	//	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>1348831860</CreateTime>
	 * 	 <MsgType><![CDATA[image]]></MsgType>
	 * 	 <PicUrl><![CDATA[this is a url]]></PicUrl>
	 * 	 <MediaId><![CDATA[media_id]]></MediaId>
	 * 	 <MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static ImageReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "imageReqMsg");
		JAXBContext context = JAXBContext.newInstance(ImageReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (ImageReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
