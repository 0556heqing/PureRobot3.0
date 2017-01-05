package com.heqing.base;

public class WeChatEntitiesType {

	public static final String REQ_MESSAGE_TYPE_TEXT 		= "text";			//请求消息类型：文本
	public static final String REQ_MESSAGE_TYPE_IMAGE 		= "image";			//请求消息类型：图片
	public static final String REQ_MESSAGE_TYPE_VOICE 		= "voice";			//请求消息类型：语音
	public static final String REQ_MESSAGE_TYPE_VIDEO 		= "video";			//请求消息类型：视频
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO 	= "shortvideo";		//请求消息类型：小视频
	public static final String REQ_MESSAGE_TYPE_LINK 		= "link";			//请求消息类型：链接
	public static final String REQ_MESSAGE_TYPE_LOCATION 	= "location";		//请求消息类型：地理位置
	public static final String REQ_MESSAGE_TYPE_EVENT 		= "event";			//请求消息类型：推送
	
	public static final String RESP_MESSAGE_TYPE_TEXT 		= "text";			//返回消息类型：文本
	public static final String RESP_MESSAGE_TYPE_IMAGE 		= "image";			//返回消息类型：图片
	public static final String RESP_MESSAGE_TYPE_VOICE 		= "voice";			//返回消息类型：语音
	public static final String RESP_MESSAGE_TYPE_VIDEO 		= "video";			//返回消息类型：视频
	public static final String RESP_MESSAGE_TYPE_MUSIC 		= "music";			//返回消息类型：音乐
	public static final String RESP_MESSAGE_TYPE_NEWS		= "news";			//返回消息类型：图文
	
	public static final String EVENT_TYPE_SUBSCRIBE			= "subscribe";		//事件类型：subscribe(订阅)
	public static final String EVENT_TYPE_UNSUBSCRIBE 		= "unsubscribe";	//事件类型：unsubscribe(取消订阅)
	public static final String EVENT_TYPE_SCAN 				= "SCAN";			//事件类型：扫码->用户已关注时的事件推送
	public static final String EVENT_TYPE_LOCATION 			= "LOCATION";		//事件类型：上报地理位置事件
	public static final String EVENT_TYPE_CLICK 			= "CLICK";			//事件类型：点击菜单拉取消息时的事件推送
	public static final String EVENT_TYPE_VIEW 				= "VIEW";			//事件类型：点击菜单跳转链接时的事件推送
	
	/*
	 * 点击推事件用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event的结构给开发者
	 * （参考消息接口指南）， 并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互；
	 */
	public static final String CLICK = "click" ;
	
	/*
	 * 跳转URL用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，
	 * 可与网页授权获取用户基本信息接口结合，获得用户基本信息。
	 */
	public static final String VIEW = "view" ;
	
	/*
	 * 扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），
	 * 且会将扫码的结果传给开发者，开发者可以下发消息。
	 */
	public static final String SCANCODE_PUSH = "scancode_push" ;
	
	/*
	 * 扫码推事件且弹出“消息接收中”提示框用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，
	 * 将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
	 */
	public static final String SCANCODE_WAITMSG = "scancode_waitmsg" ;
	
	/*
	 * 弹出系统拍照发图用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，
	 * 并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
	 */
	public static final String PIC_SYSPHOTO = "pic_sysphoto" ;
	
	/*
	 * 弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。
	 * 用户选择后即走其他两种流程。
	 */
	public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	
	/*
	 * 弹出微信相册发图器用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，
	 * 并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
	 */
	public static final String PIC_WEIXIN = "pic_weixin";
	
	/*
	 * 弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，
	 * 将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
	 */
	public static final String LOCATION_SELECT = "location_select";
	
	/*
	 * 下发消息（除文本消息）用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，
	 * 永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
	 */
	public static final String MEDIA_ID = "media_id";
	
	/*
	 * 跳转图文消息URL用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，
	 * 永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
	 */
	public static final String VIEW_LIMITED = "view_limited";
}
