package com.heqing.entities.menu.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * pic_sysphoto：弹出系统拍照发图的事件推送
 * pic_photo_or_album：弹出拍照或者相册发图的事件推送
 * pic_weixin：弹出微信相册发图器的事件推送
 */
@XmlRootElement
public class MenuPicEvent extends MenuBaseEvent {

	@XmlElement(name = "SendPicsInfo") 
	private SendPicsInfo SendPicsInfo ;	//发送的图片信息
	
	public SendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}
	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		this.SendPicsInfo = sendPicsInfo;
	}
	
	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
	 *  <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
	 * 	<CreateTime>1408090651</CreateTime>
	 * 	<MsgType><![CDATA[event]]></MsgType>
	 * 	<Event><![CDATA[pic_sysphoto|pic_photo_or_album|pic_weixin]]></Event>
	 * 	<EventKey><![CDATA[6]]></EventKey>
	 * 	<SendPicsInfo>
	 * 		<Count>1</Count>
	 * 		<PicList>
	 * 			<item>
	 * 				<PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum>
	 * 			</item>
	 * 		</PicList>
	 * 	</SendPicsInfo>
	 * </xml>
	 */
	public static MenuPicEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "menuPicEvent").replace("<item>", "").replace("</item>", "");
		JAXBContext context = JAXBContext.newInstance(MenuPicEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MenuPicEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
