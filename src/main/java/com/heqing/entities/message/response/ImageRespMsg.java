package com.heqing.entities.message.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.base.WeChatEntitiesType;
import com.heqing.entities.message.request.ImageReqMsg;

/*
 * MsgType--->
 * image：图片消息
 */
public class ImageRespMsg extends BaseRespMsg {

	private List<Image> Image = new ArrayList<Image>();
	
	public List<Image> getImage() {
		return Image;
	}
	public void setImage(List<Image> images) {
		Image = images;
	}

	public class Image {
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
	 * 	 <MsgType><![CDATA[image]]></MsgType>
	 * 	 <Image>
	 * 	  	 <MediaId><![CDATA[media_id]]></MediaId>
	 * 	 </Image>
	 * </xml>
	 */
	public static String responseMessage(ImageRespMsg imageMessage) {
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setMsgType(WeChatEntitiesType.RESP_MESSAGE_TYPE_IMAGE);
		
		xstream.alias("xml", imageMessage.getClass());	
	    xstream.addImplicitCollection(imageMessage.getClass(), "Image");  
		xstream.alias("Image", imageMessage.new Image().getClass());
		return xstream.toXML(imageMessage);
	}
	
	public static String test(String xmlStr) {
		String response = "ImageRespMsg-->error";
		try {
			ImageReqMsg imageReqMsg = ImageReqMsg.requestMessage(xmlStr);
			ImageRespMsg imageRespMsg = new ImageRespMsg();
			imageRespMsg.setToUserName(imageReqMsg.getFromUserName());
			imageRespMsg.setFromUserName(imageReqMsg.getToUserName());
			int images = 1;
			for(int i=0; i<images; i++) {
				ImageRespMsg.Image image = imageRespMsg.new Image();
				image.setMediaId(imageReqMsg.getMediaId());
				imageRespMsg.getImage().add(image);
			}
			response = responseMessage(imageRespMsg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
