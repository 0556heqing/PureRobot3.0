package com.heqing.entities.message;

import com.heqing.entities.BaseConfigInfo;

/*
 * 获取公众号的自动回复规则
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751299&token=&lang=zh_CN
 * type -- 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news）
 */
public class CurrentAutoreplyInfo extends BaseConfigInfo {

	private int is_add_friend_reply_open;			//关注后自动回复是否开启，0代表未开启，1代表开启
	private int is_autoreply_open;					//消息自动回复是否开启，0代表未开启，1代表开启
	private String add_friend_autoreply_info;		//关注后自动回复的信息
	private String content;							//对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	private String message_default_autoreply_info;	//消息自动回复的信息
	private String keyword_autoreply_info;			//关键词自动回复的信息
	private String rule_name;						//规则名称
	private String create_time;						//创建时间
	private String reply_mode;						//回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
	private String keyword_list_info;				//匹配的关键词列表
	private String match_mode;						//匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
	
	public String getIs_add_friend_reply_open() {
		if(is_add_friend_reply_open == CLOSE) return "未开启";
		return "开启";
	}
	public void setIs_add_friend_reply_open(int is_add_friend_reply_open) {
		this.is_add_friend_reply_open = is_add_friend_reply_open;
	}
	
	public String getIs_autoreply_open() {
		if(is_autoreply_open == CLOSE) return "未开启";
		return "开启";
	}
	public void setIs_autoreply_open(int is_autoreply_open) {
		this.is_autoreply_open = is_autoreply_open;
	}
	
	public String getAdd_friend_autoreply_info() {
		return add_friend_autoreply_info;
	}
	public void setAdd_friend_autoreply_info(String add_friend_autoreply_info) {
		this.add_friend_autoreply_info = add_friend_autoreply_info;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getMessage_default_autoreply_info() {
		return message_default_autoreply_info;
	}
	public void setMessage_default_autoreply_info(
			String message_default_autoreply_info) {
		this.message_default_autoreply_info = message_default_autoreply_info;
	}
	
	public String getKeyword_autoreply_info() {
		return keyword_autoreply_info;
	}
	public void setKeyword_autoreply_info(String keyword_autoreply_info) {
		this.keyword_autoreply_info = keyword_autoreply_info;
	}
	
	public String getRule_name() {
		return rule_name;
	}
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	public String getReply_mode() {
		return reply_mode;
	}
	public void setReply_mode(String reply_mode) {
		this.reply_mode = reply_mode;
	}
	
	public String getKeyword_list_info() {
		return keyword_list_info;
	}
	public void setKeyword_list_info(String keyword_list_info) {
		this.keyword_list_info = keyword_list_info;
	}
	
	public String getMatch_mode() {
		return match_mode;
	}
	public void setMatch_mode(String match_mode) {
		this.match_mode = match_mode;
	}

}
