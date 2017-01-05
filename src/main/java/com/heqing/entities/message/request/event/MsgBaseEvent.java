package com.heqing.entities.message.request.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 接收事件推送消息
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454&token=&lang=zh_CN
 */
@XmlRootElement
public class MsgBaseEvent {

	@XmlElement(name = "ToUserName")  
	private String ToUserName;		//开发者微信号
	
	@XmlElement(name = "FromUserName")  
	private String FromUserName;	//发送方帐号（一个OpenID）
	
	@XmlElement(name = "CreateTime")  
	private long CreateTime;		//消息创建时间 （整型）
	
	@XmlElement(name = "MsgType")  
	private String MsgType;			//消息类型，event
	
	@XmlElement(name = "Event")  
	private String Event;			//事件类型
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	
}
