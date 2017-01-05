package com.heqing.entities.menu.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Event--->
 * scancode_push：扫码推事件的事件推送
 * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送
 */
@XmlRootElement
public class MenuScanCodeEvent extends MenuBaseEvent {

	@XmlElement(name = "ScanCodeInfo") 
	private ScanCodeInfo ScanCodeInfo ;	//扫描信息
	
	public ScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}
	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}


	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
	 * 	<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
	 * 	<CreateTime>1408090502</CreateTime>
	 * 	<MsgType><![CDATA[event]]></MsgType>
	 * 	<Event><![CDATA[scancode_push|scancode_waitmsg]]></Event>
	 * 	<EventKey><![CDATA[6]]></EventKey>
	 * 	<ScanCodeInfo>
	 * 		<ScanType><![CDATA[qrcode]]></ScanType>
	 * 		<ScanResult><![CDATA[1]]></ScanResult>
	 * 	</ScanCodeInfo>
	 * </xml>
	 */
	public static MenuScanCodeEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "menuScanCodeEvent");
		JAXBContext context = JAXBContext.newInstance(MenuScanCodeEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MenuScanCodeEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
