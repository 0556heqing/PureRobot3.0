package com.heqing.service;

import com.heqing.entities.menu.CustomMenu;
import com.heqing.entities.menu.PersonaliseMenu;

public interface MenuService {
	
	//创建自定义菜单
	public String createCustomMenu(CustomMenu customMenu);
	//查询自定义菜单
	public String getCustomMenu();
	//删除自定义菜单
	public String deleteCustomMenu();
	//获取自定义菜单配置
	public String getCustomMenuInfo();
	//创建个性化菜单
	public String addConditional(PersonaliseMenu personaliseMenu);
	//删除个性化菜单
	public String delConditional(String menuid);
	//测试个性化菜单匹配结果
	public String testConditional(String user_id);
}
