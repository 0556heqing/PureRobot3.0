package com.heqing.service;

import com.heqing.entities.message.MessageModel;
import com.heqing.entities.message.sendMass.MessageSendMass;
import com.heqing.entities.message.sendMass.SendMassResponse;
import com.heqing.entities.message.service.CustomerService;
import com.heqing.entities.message.service.CustomerServiceResponse;

public interface MessageService {

	//设置客服帐号的头像
	public String uploadKFHeadImg(String file, String Kf_account);
	//增加客服人员
	public String addKFAccount(CustomerService customerService);
	//修改客服人员
	public String updateKFAccount(CustomerService customerService);
	//删除客服人员
	public String deleteKFAccount(CustomerService customerService);
	//获取所有客服账号
	public String getKFList();
	//客服人员回复
	public String kfSendMsg(CustomerServiceResponse serverResp);
	
	//设置所属行业
	public String setIndustry(MessageModel model);
	//获取设置的行业信息
	public String getIndustry();
	//添加模板
	public String addTemplate(MessageModel model);
	//删除模板
	public String deleteTemplate(MessageModel model);
	//获取模板列表	
	public String getAllTemplate();
	//发送模板消息	
	public String sendTemplate(MessageModel model);
	
	//获取公众号的自动回复规则
	public String getAutoreplyInfo();
	
	//上传图文消息内的图片获取URL
	public String uploadImg(String file);
	//上传图文消息素材	
	public String uploadNews(MessageSendMass massMsg);
	//上传图文消息素材	
	public String uploadVideo(MessageSendMass massMsg);
	//上传图文消息素材	
	public String sendAll(SendMassResponse massResp);
	//根据OpenID列表群发【订阅号不可用，服务号认证后可用】
	public String sendNumerousByID(SendMassResponse massResp);
	//删除群发【订阅号与服务号认证后均可用】
	public String deleteNumerous(MessageSendMass massMsg);
	//预览接口【订阅号与服务号认证后均可用】
	public String preview(SendMassResponse massResp);
	//查询群发消息发送状态【订阅号与服务号认证后均可用】
	public String getNumerous(MessageSendMass massMsg);
	
}
