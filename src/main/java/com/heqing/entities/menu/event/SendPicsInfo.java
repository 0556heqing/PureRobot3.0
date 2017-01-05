package com.heqing.entities.menu.event;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class SendPicsInfo {
	
	@XmlElement(name = "Count") 
	private int Count ;				//发送的图片数量
	
	@XmlElementWrapper(name = "PicList")  
	@XmlElement(name = "PicMd5Sum")			//图片的MD5值，开发者若需要，可用于验证接收到图片
	private List<String> PicList = new ArrayList<String>();			//图片列表

	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	
	public List<String> getPicList() {
		return PicList;
	}
	public void setPicList(List<String> picList) {
		PicList = picList;
	}

}
