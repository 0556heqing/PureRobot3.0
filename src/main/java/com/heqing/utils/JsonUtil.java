package com.heqing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	private static final Logger log = Logger.getLogger(JsonUtil.class);
	
	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new JsonUtil().new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	
	//输出JSON字符串，并打印日志
    public static void outputJsonMessage(Logger logger,String methodName,HttpServletResponse response,Map<String,Object> jsonMap){

    	logger.info("------"+methodName+"----");
    	//输出json字符串
		PrintWriter out=null;
        //"Access-Control-Allow-Origin: *"
        response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json; charset=UTF-8");
		JSONObject jsonObject=new JSONObject();
		for(String key:jsonMap.keySet()){
			jsonObject.put(key,jsonMap.get(key));
		}
		try {
			out = response.getWriter();
			out.write(jsonObject.toString());
			logger.info("返回JSON结果："+jsonObject.toString());
		} catch (IOException e) {
			logger.error("流输出异常：",e);
		}finally{
			out.close();
		}
    }
    
    /**
     * 证书信任管理器（用于https请求）
     */
    public class MyX509TrustManager implements X509TrustManager {

    	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    	}

    	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    	}

    	public X509Certificate[] getAcceptedIssuers() {
    		return null;
    	}
    }
    
    public static String getResp(String url, String requestMethod, String parameter){
    	com.alibaba.fastjson.JSONObject jsonObject = JsonUtil.httpRequest(url, requestMethod, parameter);
    	String respMessage = null;
		if (null != jsonObject) respMessage = jsonObject.toJSONString();
		else respMessage = "请求失败";
		return respMessage;
    }
}
