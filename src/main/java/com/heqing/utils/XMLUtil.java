package com.heqing.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XMLUtil {

	/**
	 * 解析微信发来的请求（XML）
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		return XMLUtil.parseXmlByInputStream(request.getInputStream());
	}
	
	public static Map<String, String> parseXml(String xmlString) throws Exception {
		return XMLUtil.parseXmlByInputStream(new ByteArrayInputStream(xmlString.getBytes()));
	}
	
	public static Map<String, String> parseXmlByInputStream(InputStream inputStream) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		XMLUtil.elementToMap(map, root);
		map.put("wechatXML", root.asXML());
		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	// 解析XML元素生成Map
	public static void elementToMap(Map<String, String> map, Element root){
		int i = 0;
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList) {
			if(e.elements().size() > 0) {
				elementToMap(map, e);
			} else {
				map.put(e.getName(), e.getText());
			}
		}
	}
	
	/**
	 * 扩展xstream，使其支持CDATA块
	 */
	public static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
