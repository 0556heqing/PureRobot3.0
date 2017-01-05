package com.heqing.entities.menu.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * click：点击菜单拉取消息时的事件推送
 */
@XmlRootElement
public class MenuClickEvent extends MenuBaseEvent {

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[FromUser]]></FromUserName>
	 * 	<CreateTime>123456789</CreateTime>
	 * 	<MsgType><![CDATA[event]]></MsgType>
	 * 	<Event><![CDATA[CLICK]]></Event>
	 * 	<EventKey><![CDATA[EVENTKEY]]></EventKey>
	 * </xml>
	 */
	public static MenuClickEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "menuClickEvent");
		JAXBContext context = JAXBContext.newInstance(MenuClickEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MenuClickEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
