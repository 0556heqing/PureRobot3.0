package com.heqing.entities.menu.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * location_select：弹出地理位置选择器的事件推送
 */
@XmlRootElement
public class MenuLocationEvent extends MenuBaseEvent {

	@XmlElement(name = "SendLocationInfo") 
	private SendLocationInfo SendLocationInfo ;	//发送的位置信息

	public SendLocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}
	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
	 * 	<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
	 * 	<CreateTime>1408091189</CreateTime>
	 * 	<MsgType><![CDATA[event]]></MsgType>
	 * 	<Event><![CDATA[location_select]]></Event>
	 * 	<EventKey><![CDATA[6]]></EventKey>
	 * 	<SendLocationInfo>
	 * 		<Location_X><![CDATA[23]]></Location_X>
	 * 		<Location_Y><![CDATA[113]]></Location_Y>
	 * 		<Scale><![CDATA[15]]></Scale>
	 * 		<Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>
	 * 		<Poiname><![CDATA[]]></Poiname>
	 * 	</SendLocationInfo>
	 * </xml>
	 */
	public static MenuLocationEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "menuLocationEvent");
		JAXBContext context = JAXBContext.newInstance(MenuLocationEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MenuLocationEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}

}
