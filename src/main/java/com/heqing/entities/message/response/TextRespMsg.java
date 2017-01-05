package com.heqing.entities.message.response;

import java.util.Date;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.TextReqMsg;

/*
 * MsgType--->
 * text：文本消息
 */
public class TextRespMsg extends BaseRespMsg {

	private String Content;		//文本消息内容

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

	/*
	 * 返回的文本示例
	 * 	<xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>12345678</CreateTime>
	 * 	 <MsgType><![CDATA[text]]></MsgType>
	 * 	 <Content><![CDATA[你好]]></Content>
	 * 	</xml>
	 */
	public static String responseMessage(TextRespMsg textMessage) {
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_TEXT);
		
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String test(String xmlStr) {
		String response = "TextRespMsg-->error";
		try {
			TextReqMsg textReqMsg = TextReqMsg.requestMessage(xmlStr);
			TextRespMsg textRespMsg = new TextRespMsg();
			textRespMsg.setToUserName(textReqMsg.getFromUserName());
			textRespMsg.setFromUserName(textReqMsg.getToUserName());
			textRespMsg.setContent(textReqMsg.getMsgType());
			response = responseMessage(textRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
