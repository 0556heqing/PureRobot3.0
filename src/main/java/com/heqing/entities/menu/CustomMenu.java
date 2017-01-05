package com.heqing.entities.menu;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义菜单
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN
 */
public class CustomMenu {

	private List<Button> button = new ArrayList<Button>(); //一级菜单数组，个数应为1~3个

	public List<Button> getButton() {
		return button;
	}
	public void setButton(List<Button> button) {
		this.button = button;
	}
	
	public class Button {
		private String type ;			//必须。菜单的响应动作类型
		private String name ;			//必须。菜单标题，不超过16个字节，子菜单不超过60个字节
		private String key ;			//click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
		private String url ;			//view类型必须		网页链接，用户点击菜单可打开链接，不超过1024字节
		private String media_id ;		//media_id类型和view_limited类型必须		调用新增永久素材接口返回的合法media_id
		private List<SubButton> sub_button = new ArrayList<SubButton>(); //二级菜单数组，个数应为1~5个
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
		public List<SubButton> getSub_button() {
			return sub_button;
		}
		public void setSub_button(List<SubButton> sub_button) {
			this.sub_button = sub_button;
		}

		public class SubButton {
			private String type ;			//必须。菜单的响应动作类型
			private String name ;			//必须。菜单标题，不超过16个字节，子菜单不超过60个字节
			private String key ;			//click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
			private String url ;			//view类型必须		网页链接，用户点击菜单可打开链接，不超过1024字节
			private String media_id ;		//media_id类型和view_limited类型必须		调用新增永久素材接口返回的合法media_id
			
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			
			public String getKey() {
				return key;
			}
			public void setKey(String key) {
				this.key = key;
			}
			
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
			
			public String getMedia_id() {
				return media_id;
			}
			public void setMedia_id(String media_id) {
				this.media_id = media_id;
			}
		}
	}

}
