package com.heqing.entities.message.request.event;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*
 * Event--->
 * LOCATION
 */
@XmlRootElement
public class MsgLocationEvent {

	@XmlElement(name = "Latitude") 
	private float Latitude;		//地理位置纬度
	
	@XmlElement(name = "Longitude") 
	private float Longitude;	//地理位置经度
	
	@XmlElement(name = "Precision") 
	private float Precision;	//地理位置精度
	
	public float getLatitude() {
		return Latitude;
	}
	public void setLatitude(float latitude) {
		Latitude = latitude;
	}
	
	public float getLongitude() {
		return Longitude;
	}
	public void setLongitude(float longitude) {
		Longitude = longitude;
	}
	
	public float getPrecision() {
		return Precision;
	}
	public void setPrecision(float precision) {
		Precision = precision;
	}
	
	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>1348831860</CreateTime>
	 * 	 <MsgType><![CDATA[event]]></MsgType>
	 * 	 <Event><![CDATA[LOCATION]]></Event>
	 * 	 <Latitude>23.137466</Latitude>
	 * 	 <Longitude>113.352425</Longitude>
	 * 	 <Precision>119.385040</Precision>
	 * </xml>
	 */
	public static MsgLocationEvent requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "msgLocationEvent");
		JAXBContext context = JAXBContext.newInstance(MsgLocationEvent.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (MsgLocationEvent)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
