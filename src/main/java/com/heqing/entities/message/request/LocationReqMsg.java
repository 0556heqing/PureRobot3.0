package com.heqing.entities.message.request;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * MsgType--->
 * location：地理位置消息
 */
@XmlRootElement
public class LocationReqMsg extends BaseReqMsg {

	@XmlElement(name = "Location_X") 
	private float Location_X;		//地理位置维度
	
	@XmlElement(name = "Location_Y") 
	private float Location_Y;		//地理位置经度
	
	@XmlElement(name = "Scale") 
	private float Scale;			//地图缩放大小
	
	@XmlElement(name = "Label") 
	private String Label;			//地理位置信息
	
	public float getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(float location_X) {
		Location_X = location_X;
	}
	
	public float getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(float location_Y) {
		Location_Y = location_Y;
	}
	
	public float getScale() {
		return Scale;
	}
	public void setScale(float scale) {
		Scale = scale;
	}
	
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}

	/*
	 * 接收到的文本示例
	 * <xml>
	 * 	<ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	<FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	<CreateTime>1351776360</CreateTime>
	 * 	<MsgType><![CDATA[location]]></MsgType>
	 * 	<Location_X>23.134521</Location_X>
	 * 	<Location_Y>113.358803</Location_Y>
	 * 	<Scale>20</Scale>
	 * 	<Label><![CDATA[位置信息]]></Label>
	 * 	<MsgId>1234567890123456</MsgId>
	 * </xml>
	 */
	public static LocationReqMsg requestMessage(String xmlStr) throws JAXBException {
		xmlStr = xmlStr.replace("xml", "locationReqMsg");
		JAXBContext context = JAXBContext.newInstance(LocationReqMsg.class);  
        Unmarshaller unmarshaller = context.createUnmarshaller();  
        return (LocationReqMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
	}
}
