package com.heqing.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.entities.message.MessageModel;
import com.heqing.entities.message.sendMass.MessageSendMass;
import com.heqing.entities.message.sendMass.SendMassResponse;
import com.heqing.entities.message.service.CustomerService;
import com.heqing.entities.message.service.CustomerServiceResponse;
import com.heqing.service.MessageService;
import com.heqing.utils.HttpUtil;
import com.heqing.utils.JsonUtil;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	private static final Logger logger = Logger.getLogger(MessageService.class);
	
	@Override
	public String addKFAccount(CustomerService customerService) {
		logger.info("==========addKFAccount===========");
		String url = WeChatInterface.addCustomService.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(customerService));
	}
	
	@Override
	public String updateKFAccount(CustomerService customerService) {
		logger.info("==========addKFAccount===========");
		String url = WeChatInterface.updateCustomService.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(customerService));
	}
	
	@Override
	public String deleteKFAccount(CustomerService customerService) {
		logger.info("==========addKFAccount===========");
		String url = WeChatInterface.deleteCustomService.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(customerService));
	}

	@Override
	public String getKFList() {
		logger.info("==========getKFList===========");
		String url = WeChatInterface.getKFList.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String kfSendMsg(CustomerServiceResponse serverResp) {
		logger.info("==========kfSendMsg===========");
		String url = WeChatInterface.customServiceSend.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(serverResp));
	}

	@Override
	public String getAutoreplyInfo() {
		logger.info("==========getAutoreplyInfo===========");
		String url = WeChatInterface.getCurrentAutoreplyInfo.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String setIndustry(MessageModel model) {
		logger.info("==========setIndustry===========");
		String url = WeChatInterface.setIndustry.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(model));
	}

	@Override
	public String getIndustry() {
		logger.info("==========getIndustry===========");
		String url = WeChatInterface.getIndustry.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}
	
	@Override
	public String getAllTemplate() {
		logger.info("==========getIndustry===========");
		String url = WeChatInterface.getAllTemplate.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String addTemplate(MessageModel model) {
		logger.info("==========setIndustry===========");
		String url = WeChatInterface.addTemplate.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(model));
	}
	
	@Override
	public String deleteTemplate(MessageModel model) {
		logger.info("==========setIndustry===========");
		String url = WeChatInterface.deleteTemplate.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(model));
	}

	@Override
	public String sendTemplate(MessageModel model) {
		logger.info("==========sendTemplate===========");
		String url = WeChatInterface.sendTemplate.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(model));
	}

	@Override
	public String uploadNews(MessageSendMass massMsg) {
		logger.info("==========uploadnews===========");
		String url = WeChatInterface.uploadNews.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massMsg));
	}
	
	@Override
	public String uploadVideo(MessageSendMass massMsg) {
		logger.info("==========uploadnews===========");
		String url = WeChatInterface.uploadVideo.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massMsg));
	}

	@Override
	public String sendAll(SendMassResponse massResp) {
		logger.info("==========sendAll===========");
		String url = WeChatInterface.sendAll.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massResp));
	}
	
	@Override
	public String sendNumerousByID(SendMassResponse massResp) {
		logger.info("==========sendNumerousByID===========");
		String url = WeChatInterface.sendNumerousByID.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massResp));
	}

	@Override
	public String deleteNumerous(MessageSendMass massMsg) {
		logger.info("==========deleteNumerous===========");
		String url = WeChatInterface.deleteNumerous.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massMsg));
	}

	@Override
	public String preview(SendMassResponse massResp) {
		logger.info("==========preview===========");
		String url = WeChatInterface.preview.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massResp));
	}

	@Override
	public String getNumerous(MessageSendMass massMsg) {
		logger.info("==========getNumerous===========");
		String url = WeChatInterface.getNumerous.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(massMsg));
	}

	@Override
	public String uploadKFHeadImg(String file, String Kf_account) {
		logger.info("==========uploadKFHeadImg===========");
		String url = WeChatInterface.uploadKFHeadImg.replace("ACCESS_TOKEN", WeChatCertificate.access_token).replace("KFACCOUNT", Kf_account);
		String cmd ="curl -F filename=@"+file+" \""+url+"\"";
		return HttpUtil.getStringByCurl(cmd);
	}

	@Override
	public String uploadImg(String file) {
		logger.info("==========uploadImg===========");
		String url = WeChatInterface.uploadImg.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		String cmd ="curl -F filename=@"+file+" \""+url+"\"";
		return HttpUtil.getStringByCurl(cmd);
	}

}
