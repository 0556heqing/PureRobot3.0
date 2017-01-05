package com.heqing.entities.message.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.VoiceReqMsg;;

/*
 * MsgType--->
 * voice：语音消息
 */
public class VoiceRespMsg extends BaseRespMsg {

	private List<Voice> Voice = new ArrayList<Voice>();
	
	public List<Voice> getVoice() {
		return Voice;
	}
	public void setVoice(List<Voice> voice) {
		Voice = voice;
	}
	
	public class Voice {
		private String MediaId;		//是	通过素材管理中的接口上传多媒体文件，得到的id

		public String getMediaId() {
			return MediaId;
		}
		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
	}

	/*
	 * 返回的文本示例
	 * <xml>
	 * 	 <ToUserName><![CDATA[toUser]]></ToUserName>
	 * 	 <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * 	 <CreateTime>12345678</CreateTime>
	 * 	 <MsgType><![CDATA[voice]]></MsgType>
	 * 	 <Voice>
	 * 	  	 <MediaId><![CDATA[media_id]]></MediaId>
	 * 	 </Voice>
	 * </xml>
	 */
	public static String responseMessage(VoiceRespMsg voiceMessage) {
		voiceMessage.setCreateTime(new Date().getTime());
		voiceMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_VOICE);
		
		xstream.alias("xml", voiceMessage.getClass());
	    xstream.addImplicitCollection(voiceMessage.getClass(), "Voice");  
		xstream.alias("Voice", voiceMessage.new Voice().getClass());
		return xstream.toXML(voiceMessage);
	}

	public static String test(String xmlStr) {
		String response = "VoiceRespMsg-->error";
		try {
			VoiceReqMsg voiceReqMsg = VoiceReqMsg.requestMessage(xmlStr);
			VoiceRespMsg voiceRespMsg = new VoiceRespMsg();
			voiceRespMsg.setToUserName(voiceReqMsg.getFromUserName());
			voiceRespMsg.setFromUserName(voiceReqMsg.getToUserName());
			int voices = 1;
			for(int i=0; i<voices; i++) {
				VoiceRespMsg.Voice voice = voiceRespMsg.new Voice();
				voice.setMediaId(voiceReqMsg.getMediaID());
				voiceRespMsg.getVoice().add(voice);
			}
			response = responseMessage(voiceRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
