package com.heqing.entities.message.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 接收普通消息
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453&token=&lang=zh_CN
 */
@XmlRootElement
public class BaseReqMsg {
	
	@XmlElement(name = "ToUserName")  
	private String ToUserName;			// 开发者微信号
	
	@XmlElement(name = "FromUserName")  
	private String FromUserName;		// 发送方帐号（一个OpenID）
	
	@XmlElement(name = "CreateTime")  
	private long CreateTime;			// 消息创建时间 （整型）
	
	@XmlElement(name = "MsgType")  
	private String MsgType;				// 消息类型（text/image/location/link）
	
	@XmlElement(name = "MsgId")  
	private long MsgId;					// 消息id，64位整型
	
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
	
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}
