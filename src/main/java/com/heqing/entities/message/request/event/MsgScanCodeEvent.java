package com.heqing.entities.message.request.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 用户未关注时，进行关注后的事件推送
 * Event	事件类型，subscribe
 * EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值
 * 
 * 用户已关注时的事件推送
 * Event	事件类型，SCAN
 * EventKey	事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
 */
@XmlRootElement
public class MsgScanCodeEvent extends MsgBaseEvent {

	@XmlElement(name = "EventKey")
	private String EventKey;	//事件KEY值，qrscene_为前缀，后面为二维码的参数值 
	
	@XmlElement(name = "Ticket")
	private String Ticket;		//二维码的ticket，可用来换取二维码图片
	
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	/*
	 * 接收到的文本示例
     * <xml>
     * 	<ToUserName><![CDATA[toUser]]></ToUserName>
     * 	<FromUserName><![CDATA[FromUser]]></FromUserName>
     * 	<CreateTime>123456789</CreateTime>
     * 	<MsgType><![CDATA[event]]></MsgType>
     * 	<Event><![CDATA[subscribe|SCAN]]></Event>
     * 	<EventKey><![CDATA[qrscene_123123|SCENE_VALUE]]></EventKey>
     * 	<Ticket><![CDATA[TICKET]]></Ticket>
     * </xml>
	 */
	public static MsgScanCodeEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "msgScanCodeEvent");
		JAXBContext context = JAXBContext.newInstance(MsgScanCodeEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MsgScanCodeEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
