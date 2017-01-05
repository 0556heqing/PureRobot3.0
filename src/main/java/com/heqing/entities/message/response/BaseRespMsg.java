package com.heqing.entities.message.response;

import com.heqing.utils.XMLUtil;
import com.thoughtworks.xstream.XStream;

/*
 * 回复消息
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140543&token=&lang=zh_CN
 */
public class BaseRespMsg {

	public static XStream xstream = XMLUtil.xstream;
	
	private String ToUserName;			// 开发者微信号
	private String FromUserName;		// 发送方帐号（一个OpenID）
	private long   CreateTime;			// 消息创建时间 （整型）
	private String MsgType;				// 消息类型（text/image/location/link）
	
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
	
}
