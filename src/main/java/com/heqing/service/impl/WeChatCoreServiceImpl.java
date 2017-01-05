package com.heqing.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.event.MsgLocationEvent;
import com.heqing.entities.message.request.event.MsgMenuEvent;
import com.heqing.entities.message.request.event.MsgScanCodeEvent;
import com.heqing.entities.message.request.event.MsgSubscribeEvent;
import com.heqing.entities.message.response.ImageRespMsg;
import com.heqing.entities.message.response.MusicRespMsg;
import com.heqing.entities.message.response.NewsRespMsg;
import com.heqing.entities.message.response.TextRespMsg;
import com.heqing.entities.message.response.VideoRespMsg;
import com.heqing.entities.message.response.VoiceRespMsg;
import com.heqing.service.MessageService;
import com.heqing.service.WeChatCoreService;
import com.heqing.utils.StringUtil;
import com.heqing.utils.XMLUtil;
import com.heqing.wechat.aes.WXBizMsgCrypt;

@Service("weChatCoreService")
public class WeChatCoreServiceImpl implements WeChatCoreService {

	private static final Logger logger = Logger.getLogger(WeChatCoreService.class);
	
	@Resource	
	private MessageService messageService;

	public boolean checkSignature(String signature, String timestamp, String nonce) {
		logger.info("==========checkSignature==========");
		
		String[] arr = new String[] { WeChatCertificate.TOKEN, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = StringUtil.byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
	/**
	 * 处理用户发送的消息
	 */
	public String processRequest(HttpServletRequest request) {
		logger.info("==========processRequest==========");
		String respMessage = null;
		try {
			/* 
			 * 安全模式，消息包为纯密文，需要开发者加密和解密，安全系数高
			 * 
			 * 说明：异常java.security.InvalidKeyException:illegal Key Size的解决方案
			 * 	在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
			 *      http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
			 * 	下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt
			 * 	如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件
			 * 	如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件
			 * */
			WXBizMsgCrypt pc = new WXBizMsgCrypt(WeChatCertificate.TOKEN, WeChatCertificate.encodingAesKey, WeChatCertificate.APPID);
			Map<String, String> requestMap = new HashMap<String, String>();
			
			String encrypt_type =request.getParameter("encrypt_type");  
			if (encrypt_type == null || encrypt_type.equals("raw")) { //不用加密  
				requestMap = XMLUtil.parseXml(request);
			} else {	//需走加解密流程
				// 微信加密签名    
				String msgSignature = request.getParameter("msg_signature");  
				// 时间戳    
				String timeStamp = request.getParameter("timestamp");    
				// 随机数    
				String nonce = request.getParameter("nonce");  
				//密文  
			    String encryptMsg = StringUtil.inputStream2String(request.getInputStream());  
			    String data = pc.decryptMsg(msgSignature, timeStamp, nonce, encryptMsg); 
			    requestMap = XMLUtil.parseXml(data);
			}

			// xml请求解析
//			Map<String, String> requestMap = XMLUtil.parseXml(request);		
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 用户传来的xml
			String xmlStr = requestMap.get("wechatXML");
			System.out.println("Receive information>>>"+xmlStr);
			logger.info("Receive information：>>>"+xmlStr);
			
			switch(msgType) {
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_IMAGE 		: respMessage = ImageRespMsg.test(xmlStr); break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_VOICE 		: respMessage = VoiceRespMsg.test(xmlStr); break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_VIDEO 		: respMessage = VideoRespMsg.test(xmlStr); break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_SHORTVIDEO : respMessage = VideoRespMsg.test(xmlStr); break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_LINK 		: respMessage = TextRespMsg.test(xmlStr);  break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_LOCATION 	: respMessage = TextRespMsg.test(xmlStr);  break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_TEXT : {
					String content = requestMap.get("Content");
					switch(content) {
						case "news" : 
							respMessage = NewsRespMsg.test(xmlStr);
							break;
						case "music" : 
							respMessage = MusicRespMsg.test(xmlStr);
							break;
						default : respMessage = TextRespMsg.test(xmlStr);
					}
				}	break;
				case WeChatEntitiesType.REQ_MESSAGE_TYPE_EVENT 		: {
					String event = requestMap.get("Event");
					switch(event) {
						case WeChatEntitiesType.EVENT_TYPE_SCAN : 
							MsgScanCodeEvent.requestMessage(requestMap.get("wechatXML"));
							break;
						case WeChatEntitiesType.EVENT_TYPE_LOCATION :
							MsgLocationEvent.requestMessage(requestMap.get("wechatXML"));
							break;
						case WeChatEntitiesType.EVENT_TYPE_CLICK : 
							MsgMenuEvent.requestMessage(requestMap.get("wechatXML"));
							break;
						case WeChatEntitiesType.EVENT_TYPE_VIEW : 
							MsgMenuEvent.requestMessage(requestMap.get("wechatXML"));
							break;
						case WeChatEntitiesType.EVENT_TYPE_SUBSCRIBE : 
							MsgSubscribeEvent.requestMessage(requestMap.get("wechatXML"));
							break;
						case WeChatEntitiesType.EVENT_TYPE_UNSUBSCRIBE : 
							MsgSubscribeEvent.requestMessage(requestMap.get("wechatXML"));
							break;
					}
					respMessage = TextRespMsg.test(xmlStr); 
				}	break;
				default :  respMessage = TextRespMsg.test(xmlStr);
			}

			//对返回消息进行加密。
			respMessage = pc.encryptMsg(respMessage, System.currentTimeMillis()+"", "xxxxxx");
			
			System.out.println("returned messages>>>"+respMessage);
			logger.info("returned messages：>>>"+respMessage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
	
}
