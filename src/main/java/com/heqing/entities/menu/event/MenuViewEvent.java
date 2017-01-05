package com.heqing.entities.menu.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * view：点击菜单跳转链接时的事件推送
 */
@XmlRootElement
public class MenuViewEvent extends MenuBaseEvent {

	@XmlElement(name = "MenuId")  
	private String MenuId ;			//指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。

	public String getMenuId() {
		return MenuId;
	}
	public void setMenuId(String menuId) {
		MenuId = menuId;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[FromUser]]></FromUserName>
	 * 	<CreateTime>123456789</CreateTime>
	 * 	<MsgType><![CDATA[event]]></MsgType>
	 * 	<Event><![CDATA[VIEW]]></Event>
	 * 	<EventKey><![CDATA[www.qq.com]]></EventKey>
	 * 	<MenuId>MENUID</MenuId>
	 * </xml>
	 */
	public static MenuViewEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "menuViewEvent");
		JAXBContext context = JAXBContext.newInstance(MenuViewEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MenuViewEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
