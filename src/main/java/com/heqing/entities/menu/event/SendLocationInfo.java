package com.heqing.entities.menu.event;

import javax.xml.bind.annotation.XmlElement;

public class SendLocationInfo {
	@XmlElement(name = "Location_X")
	private float Location_X ;			//X坐标信息
	
	@XmlElement(name = "Location_Y")
	private float Location_Y ;			//Y坐标信息
	
	@XmlElement(name = "Scale")
	private float Scale ;				//精度，可理解为精度或者比例尺、越精细的话 scale越高
	
	@XmlElement(name = "Label")
	private String Label ;				//地理位置的字符串信息
	
	@XmlElement(name = "Poiname")
	private String Poiname ;			//朋友圈POI的名字，可能为空
	
	public float getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(float location_X) {
		Location_X = location_X;
	}
	
	public float getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(float location_Y) {
		Location_Y = location_Y;
	}
	
	public float getScale() {
		return Scale;
	}
	public void setScale(float scale) {
		Scale = scale;
	}
	
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
}
