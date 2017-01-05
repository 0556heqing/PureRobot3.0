package com.heqing.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heqing.service.TestService;

/**
 * 参数传递，最简单的DEMO
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private TestService testService;
	
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request,Model model) {
		return "measure";
	}

}
