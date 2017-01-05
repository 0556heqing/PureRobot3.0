package com.heqing.entities.message.request.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * subscribe(订阅)
 * unsubscribe(取消订阅)
 */
@XmlRootElement
public class MsgSubscribeEvent extends MsgBaseEvent {

	/*
	 * 接收到的文本示例
     * <xml>
     * 	<ToUserName><![CDATA[toUser]]></ToUserName>
     * 	<FromUserName><![CDATA[FromUser]]></FromUserName>
     * 	<CreateTime>123456789</CreateTime>
     * 	<MsgType><![CDATA[event]]></MsgType>
     * 	<Event><![CDATA[subscribe|unsubscribe]]></Event>
     * </xml>
	 */
	public static MsgSubscribeEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "msgSubscribeEvent");
		JAXBContext context = JAXBContext.newInstance(MsgSubscribeEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MsgSubscribeEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
