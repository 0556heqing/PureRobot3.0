package com.heqing.entities.message.request.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 点击菜单拉取消息时的事件推送
 * Event	事件类型，CLICK
 * EventKey	事件KEY值，与自定义菜单接口中KEY值对应
 * 
 * 点击菜单跳转链接时的事件推送
 * Event	事件类型，VIEW
 * EventKey	事件KEY值，设置的跳转URL
 */
@XmlRootElement
public class MsgMenuEvent extends MsgBaseEvent {

	@XmlElement(name = "EventKey") 
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	/*
	 * 接收到的文本示例
     * <xml>
     * 	<ToUserName><![CDATA[toUser]]></ToUserName>
     * 	<FromUserName><![CDATA[FromUser]]></FromUserName>
     * 	<CreateTime>123456789</CreateTime>
     * 	<MsgType><![CDATA[event]]></MsgType>
     * 	<Event><![CDATA[CLICK|VIEW]]></Event>
     * 	<EventKey><![CDATA[EVENTKEY|www.qq.com]]></EventKey>
     * </xml>
	 */
	public static MsgMenuEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "msgMenuEvent");
		JAXBContext context = JAXBContext.newInstance(MsgMenuEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MsgMenuEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
