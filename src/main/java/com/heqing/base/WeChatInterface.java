package com.heqing.base;

public class WeChatInterface {

	/*
	 * 特别说明：  微信挖了好大一个坑，纠结了一个星期。
	 * 微信官方API文档有多处错误，其中最重要的使用Crul工具的时候大多数调用一下 “WECHATFILEURL” 的地址。
	 * 如果报与Crul有关的错误，可用 “微信公众平台接口调试工具” 查看 “请求地址” 中给出的详细地址
	 */
	public static final String WECHATURL     = "https://api.weixin.qq.com/";
	public static final String WECHATFILEURL = "http://file.api.weixin.qq.com/";
	
	//获取access_token	GET
	public static final String GETACCESSTOKEN =  WECHATURL + "cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//获取微信服务器IP地址	GET
	public static final String GETCALLBACKIP  =  WECHATURL + "cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	
	//自定义菜单创建接口	POST
	public static final String createCustomMenu =  WECHATURL + "cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//自定义菜单查询接口	GET
	public static final String getCustomMenu    =  WECHATURL + "cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	//自定义菜单删除接口	GET
	public static final String deleteCustomMenu =  WECHATURL + "cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	//创建个性化菜单		POST
	public static final String addConditional   =  WECHATURL + "cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	//删除个性化菜单 		POST
	public static final String delConditional   =  WECHATURL + "cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	//测试个性化菜单匹配结果	POST
	public static final String testConditional  =  WECHATURL + "cgi-bin/trymatch?access_token=ACCESS_TOKEN";
	//获取自定义菜单配置接口	GET
	public static final String getCustomMenuInfo = WECHATURL + "cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

	//添加客服帐号接口	POST
	public static final String addCustomService        =  WECHATURL + "customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	//修改客服帐号接口	POST
	public static final String updateCustomService     =  WECHATURL + "customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	//删除客服帐号	POST
	public static final String deleteCustomService     =  WECHATURL + "customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	//设置客服帐号的头像接口	POST
	public static final String uploadKFHeadImg         =  WECHATURL + "customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	//获取所有客服账号接口	POST
	public static final String getKFList               =  WECHATURL + "cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	//客服接口-发消息	POST
	public static final String customServiceSend       =  WECHATURL + "cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	//上传图文消息内的图片获取URL  POST	  	订阅号与服务号认证后均可用
	public static final String uploadImg         =  WECHATFILEURL + "cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	//上传图文消息素材		   POST		订阅号与服务号认证后均可用
	public static final String uploadNews        =  WECHATURL + "cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	//上传图文消息素材		   POST		订阅号与服务号认证后均可用
	public static final String uploadVideo       =  WECHATURL + "cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN";
	//根据标签进行群发		   POST		订阅号与服务号认证后均可用
	public static final String sendAll 	         = 	WECHATURL + "cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	//根据OpenID列表群发	   POST		订阅号与服务号认证后均可用
	public static final String sendNumerousByID	 =  WECHATURL + "cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
	//删除群发				   POST		订阅号与服务号认证后均可用
	public static final String deleteNumerous    =  WECHATURL + "cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
	//预览接口				   POST		订阅号与服务号认证后均可用
	public static final String preview           =  WECHATURL + "cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	//查询群发消息发送状态		   POST		订阅号与服务号认证后均可用
	public static final String getNumerous       =  WECHATURL + "cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";

	//获取公众号的自动回复规则	POST
	public static final String getCurrentAutoreplyInfo =  WECHATURL + "cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";

	//设置所属行业		   POST		
	public static final String setIndustry       =  WECHATURL + "cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
	//设置所属行业		   POST		
	public static final String getIndustry       =  WECHATURL + "cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
	//添加模板   		   POST	
	public static final String addTemplate       =  WECHATURL + "cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	//获取模板列表		   POST	
	public static final String getAllTemplate    =  WECHATURL + "cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	//删除模板		       POST	
	public static final String deleteTemplate    =  WECHATURL + "cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
	//发送模板消息		   POST	
	public static final String sendTemplate	     =  WECHATURL + "cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	
	// 获取公众号已创建的标签
	public static final String getTags	         =  WECHATURL + "cgi-bin/tags/get?access_token=ACCESS_TOKEN";
	//获取用户基本信息(UnionID机制)
	public static final String getUserInfo	     =  WECHATURL + "cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	//批量获取用户基本信息
	public static final String getAllUserInfo	 =  WECHATURL + "cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

	//新增临时素材
	public static final String addTempMaterial   =  WECHATFILEURL + "cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//获取临时素材
	public static final String getTempMaterial   =  WECHATFILEURL + "cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	//新增临时素材
	public static final String addMaterial   	 =  WECHATURL + "cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	//获取素材列表
	public static final String getMaterialList   =  WECHATURL + "cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	//获取素材总数
	public static final String getMaterialCount  =  WECHATURL + "cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	//删除永久素材
	public static final String delMaterial		 =  WECHATURL + "cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
}

