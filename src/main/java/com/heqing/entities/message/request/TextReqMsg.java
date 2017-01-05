package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * text：文本消息
 */
@XmlRootElement
public class TextReqMsg extends BaseReqMsg {

	@XmlElement(name = "Content") 
	private String Content;		//文本消息内容

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>1348831860</CreateTime>
	 *	 <MsgType><![CDATA[text]]></MsgType>
	 * 	 <Content><![CDATA[this is a test]]></Content>
	 * 	 <MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static TextReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "textReqMsg");
		JAXBContext context = JAXBContext.newInstance(TextReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (TextReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
