package com.heqing.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.entities.menu.CustomMenu;
import com.heqing.entities.menu.PersonaliseMenu;
import com.heqing.service.MenuService;
import com.heqing.utils.HttpUtil;
import com.heqing.utils.JsonUtil;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Override
	public String createCustomMenu(CustomMenu customMenu) {
		logger.info("==========createCustomMenu===========");
    	String url = WeChatInterface.createCustomMenu.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(customMenu));
	}

	@Override
	public String getCustomMenu() {
		logger.info("==========getCustomMenu===========");
		String url = WeChatInterface.getCustomMenu.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String deleteCustomMenu() {
		logger.info("==========deleteCustomMenu===========");
		String url = WeChatInterface.deleteCustomMenu.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String getCustomMenuInfo() {
		logger.info("==========getCustomMenuInfo===========");
		String url = WeChatInterface.getCustomMenuInfo.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return HttpUtil.getStringByGet(url);
	}

	@Override
	public String addConditional(PersonaliseMenu personaliseMenu) {
		logger.info("==========addConditional===========");
    	String url = WeChatInterface.addConditional.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(personaliseMenu));
	}

	@Override
	public String delConditional(String menuid) {
		logger.info("==========delConditional===========");
		String url = WeChatInterface.delConditional.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(menuid));
	}

	@Override
	public String testConditional(String user_id) {
		logger.info("==========testConditional===========");
		String url = WeChatInterface.testConditional.replace("ACCESS_TOKEN", WeChatCertificate.access_token);
		return JsonUtil.getResp(url, "POST", new Gson().toJson(user_id));
	}
}
