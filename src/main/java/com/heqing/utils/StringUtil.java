package com.heqing.utils;

import java.io.InputStream;

public class StringUtil {

	/**
	 * 将字节数组转换为十六进制字符串
	 * @param byteArray
	 * @return
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	
	/**
	 * 将字节转换为十六进制字符串
	 * @param mByte
	 * @return
	 */
	public static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		String s = new String(tempArr);
		return s;
	}
	
	public static String inputStream2String(InputStream in) { 
		String str = "error";
		try {
	        StringBuffer out = new StringBuffer(); 
	        byte[] b = new byte[2048]; 
	        for(int n=0;(n=in.read(b))!=-1;)   { 
	            out.append(new String(b, 0, n)); 
	        } 
	        str = out.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
        return str; 
	} 

}
