package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * link：链接消息
 */
@XmlRootElement
public class LinkReqMsg extends BaseReqMsg {

	@XmlElement(name = "Title") 
	private String Title;		//消息标题
	
	@XmlElement(name = "Description") 
	private String Description;	//消息描述
	
	@XmlElement(name = "Url") 
	private String Url;			//消息链接
	
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
	
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	<CreateTime>1351776360</CreateTime>
	 * 	<MsgType><![CDATA[link]]></MsgType>
	 * 	<Title><![CDATA[公众平台官网链接]]></Title>
	 * 	<Description><![CDATA[公众平台官网链接]]></Description>
	 * 	<Url><![CDATA[url]]></Url>
	 * 	<MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static LinkReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "linkReqMsg");
		JAXBContext context = JAXBContext.newInstance(LinkReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (LinkReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
