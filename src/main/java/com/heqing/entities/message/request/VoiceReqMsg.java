package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * voice：语音消息
 */
@XmlRootElement
public class VoiceReqMsg extends BaseReqMsg {

	@XmlElement(name = "MediaId")
	private String MediaId;		//语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
	
	@XmlElement(name = "Format")
	private String Format;		//	语音格式：amr
	
	@XmlElement(name = "Recognition")
	private String Recognition;	//	语音识别结果，UTF8编码.需开通开通语音识别
	
	public String getMediaID() {
		return MediaId;
	}
	public void setMediaID(String mediaID) {
		MediaId = mediaID;
	}
	
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 *	<CreateTime>1357290913</CreateTime>
	 * 	<MsgType><![CDATA[voice]]></MsgType>
	 * 	<MediaId><![CDATA[media_id]]></MediaId>
	 * 	<Format><![CDATA[Format]]></Format>
	 *  <Recognition><![CDATA[腾讯微信团队]]></Recognition>
	 * 	<MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static VoiceReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "voiceReqMsg");
		JAXBContext context = JAXBContext.newInstance(VoiceReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (VoiceReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
