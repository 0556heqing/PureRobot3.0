package com.heqing.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.entities.Material;
import com.heqing.service.MaterialService;
import com.heqing.utils.HttpUtil;
import com.heqing.utils.JsonUtil;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

	private static final Logger logger = Logger.getLogger(MaterialServiceImpl.class);
	
	@Override
	public String addTempMaterial(String filenPath, String type) {
		logger.info("==========addTempMaterial===========");
		String url = WeChatInterface.addTempMaterial.replace("ACCESS_TOKEN", WeChatCertificate.access_token).replace("TYPE", type);
		String cmd ="curl -F filename=@"+filenPath+" \""+url+"\"";
		return HttpUtil.getStringByCurl(cmd);
	}

	@Override
	public String getTempMaterial(String media_id) {
		logger.info("==========getTempMaterial===========");
		String url = WeChatInterface.getTempMaterial.replace("ACCESS_TOKEN", WeChatCertificate.access_token).replace("MEDIA_ID", media_id);
		String cmd ="curl -I -G \""+url+"\"";
		return HttpUtil.getStringByCurl(cmd);
	}

	@Override
	public String addMaterial(Material material) {
		logger.info("==========addMaterial===========");
    	String url = WeChatInterface.addMaterial.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(material));
	}
	
	@Override
	public String getMaterialList(Material material) {
		logger.info("==========getMaterialList===========");
    	String url = WeChatInterface.getMaterialList.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(material));
	}
	
	public String getMaterialCount() {
		logger.info("==========getMaterialCount===========");
		String url = WeChatInterface.getMaterialCount.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}
	
	public String delMaterial(Material material) {
		logger.info("==========delMaterial===========");
		String url = WeChatInterface.delMaterial.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(material));
	}
}
