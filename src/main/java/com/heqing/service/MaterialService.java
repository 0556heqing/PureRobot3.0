package com.heqing.service;

import com.heqing.entities.Material;

public interface MaterialService {

	/*
	 * 新增临时素材
	 * 图片（image）: 1M，支持JPG格式
	 * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	 * 视频（video）：10MB，支持MP4格式
	 * 缩略图（thumb）：64KB，支持JPG格式
	 */
	public String addTempMaterial(String filenPath, String type);
	
	//获取临时素材
	public String getTempMaterial(String media_id);
	
	//获取临时素材
	public String addMaterial(Material material);	
	
	//获取素材列表
	public String getMaterialList(Material material);
	
	//获取素材列表
	public String getMaterialCount();
	
	//删除永久素材
	public String delMaterial(Material material);
}
