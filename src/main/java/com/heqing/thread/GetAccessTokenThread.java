package com.heqing.thread;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.heqing.base.WeChatCertificate;
import com.heqing.base.WeChatInterface;
import com.heqing.utils.HttpUtil;

@Service("getAccessTokenThread")
public class GetAccessTokenThread implements Runnable {
	
	@Override
	public void run() {
		while(true){
			try {
//				//获取access_token(每日最多获取100000次，每次获取的有效期为7200秒)
				if(null != getAccess_token()){
					System.out.println("Get AccessToken Success："+ WeChatCertificate.access_token);
					//7000秒之后重新进行获取
					Thread.sleep(7000*1000);
				}else{
					//获取失败时，30秒之后尝试重新获取
					Thread.sleep(30*1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
    * 获得ACCESS_TOKEN
    * @Title: getAccess_token
    * @Description: 获得ACCESS_TOKEN
    * @param appID		微信公众号凭证
    * @param appScret	微信公众号凭证秘钥
    * @return access_token
    */
    public static String getAccess_token() {
        String url = WeChatInterface.GETACCESSTOKEN.replace("APPID", WeChatCertificate.APPID).replace("APPSECRET", WeChatCertificate.APPSCRET);
        JSONObject demoJson = HttpUtil.getJSONObjectByGet(url);
        if(demoJson == null) return null;
        else {
        	WeChatCertificate.access_token = demoJson.getString("access_token");
        }
    	return WeChatCertificate.access_token;
    }

}
