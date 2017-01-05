package com.heqing.entities.message;

public class MessageModel {

	public String industry_id1;			//公众号模板消息所属行业编号
	public String industry_id2;			//公众号模板消息所属行业编号
	
	public String template_id_short;	//模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
	
	public String template_id;			//公众帐号下模板消息ID
	
	public String touser;				//是	接收者openid
	public String url;					//否	模板跳转链接
	public String data;					//是	模板数据
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
	public String getTemplate_id_short() {
		return template_id_short;
	}
	public void setTemplate_id_short(String template_id_short) {
		this.template_id_short = template_id_short;
	}
	public String getIndustry_id1() {
		return industry_id1;
	}
	public void setIndustry_id1(String industry_id1) {
		this.industry_id1 = industry_id1;
	}
	
	public String getIndustry_id2() {
		return industry_id2;
	}
	public void setIndustry_id2(String industry_id2) {
		this.industry_id2 = industry_id2;
	}
	
}
