package com.heqing.entities.menu;

import com.heqing.entities.BaseConfigInfo;

/*
 * 获取自定义菜单配置接口
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1434698695&token=&lang=zh_CN
 * type -- 菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用API设置的则有8种，详见《自定义菜单创建接口》
 */
public class CustomMenuConfigInfo extends BaseConfigInfo {

	private int is_menu_open ;		//菜单是否开启，0代表未开启，1代表开启
	private String selfmenu_info ; 	//菜单信息
	private String button ;			//菜单按钮
	private String name ;			//菜单名称
	private String value ; 			/*value、url、key等字段	对于不同的菜单类型，value的值意义不同。官网上设置的自定义菜单：
										Text:保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； 
										News：保存图文消息到news_info，同时保存mediaID到value； View：保存链接到url。
										使用API设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、
										pic_photo_or_album、 pic_weixin、location_select：保存值到key；view：保存链接到url*/
	
	public String getIs_menu_open() {
		if(is_menu_open == CLOSE) return "未开启";
		return "开启";
	}
	public void setIs_menu_open(int is_menu_open) {
		this.is_menu_open = is_menu_open;
	}
	
	public String getSelfmenu_info() {
		return selfmenu_info;
	}
	public void setSelfmenu_info(String selfmenu_info) {
		this.selfmenu_info = selfmenu_info;
	}
	
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
