package com.heqing;

import org.junit.Test;

import com.heqing.utils.HttpUtil;

public class TestCurl {

	@Test
	public void testUpload() {
		//curl -F filename=@D:/test/test.jpg "http://localhost:8080/SSM/test/upload"
		String cmd ="curl -F filename=@D:/test/test.jpg \"http://localhost:8080/SSM/test/upload\"";
		System.out.println(">>"+HttpUtil.getStringByCurl(cmd));
	}

}
