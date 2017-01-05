package com.heqing.entities.menu.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.heqing.utils.TimeUtil;

/*
 * 基本的事件推送
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016&token=&lang=zh_CN
 */
@XmlRootElement
public class MenuBaseEvent {

	@XmlElement(name = "ToUserName")  
	private String ToUserName ;		//开发者微信号
	
	@XmlElement(name = "FromUserName")  
	private String FromUserName ;	//发送方帐号（一个OpenID）
	
	@XmlElement(name = "CreateTime")  
	private long   CreateTime ;		//消息创建时间 （整型）
	
	@XmlElement(name = "MsgType")  
	private String MsgType ;		//消息类型，event
	
	@XmlElement(name = "Event")  
	private String Event ;			//事件类型，CLICK
	
	@XmlElement(name = "EventKey")  
	private String EventKey ;		//事件KEY值，与自定义菜单接口中KEY值对应
	
	public MenuBaseEvent(){
		super();
	}
	
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
	
	public String getCreateTime() {
		return TimeUtil.getTime(CreateTime);
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
	
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
