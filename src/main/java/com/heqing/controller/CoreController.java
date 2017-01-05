package com.heqing.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heqing.service.WeChatCoreService;

@Controller
@RequestMapping("/core")
public class CoreController {

	private static final Logger logger = Logger.getLogger(CoreController.class);
	
	@Resource	
	private WeChatCoreService weChatCoreService;
	
	@RequestMapping("/start")
	public void start(HttpServletRequest request, HttpServletResponse response) {
		logger.info("===========startWeChat============");
		
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			String method = request.getMethod();
	        if(method.equals("GET")) {
	        	String signature = request.getParameter("signature");			// 微信加密签名
				String timestamp = request.getParameter("timestamp");			// 时间戳
				String nonce = request.getParameter("nonce");					// 随机数
				String echostr = request.getParameter("echostr");				// 随机字符串
				System.out.println(">>>signature="+signature+",timestamp="+timestamp+",nonce="+nonce);
				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (weChatCoreService.checkSignature(signature, timestamp, nonce)) {
					out.print(echostr);
				}
	        } else if(method.equals("POST")) {
	        	String respMessage = weChatCoreService.processRequest(request);
	        	out.print(respMessage);
	        }
	        out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
