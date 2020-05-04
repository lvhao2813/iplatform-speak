package com.boco.share.privilege.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boco.share.privilege.dao.MenuMapper;
import com.boco.share.privilege.service.inter.MenuService;

/**
 * Title: PriMenuServiceImpl Description:
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	public MenuMapper priMenuMapper;

	/**
	 * 查询菜单列表并展示
	 */
	@Override
	public JSONObject queryMenuList() {
		JSONObject result = new JSONObject();

		//清空缓存的链接
		result.put("clearInfo", getClearCacheUrl());
		//构造首页链接
		result.put("homeInfo", getHomeUrl());
		//构造logo
		result.put("logoInfo", getLogoUrl());
		//构造菜单
		result.put("menuInfo", getMenuUrl());
		
		return result;
	}

	/**
	 * 构造清空缓存链接
	 * 
	 * @return
	 */
	private JSONObject getClearCacheUrl() {
		JSONObject clear = new JSONObject();
//		clearInfo.put("clearUrl", "/clearCache");
		clear.put("clearUrl", "{'code': 1, 'msg': '服务端清理缓存成功'}");
		return clear;
	}
	
	/**
	 * 构造首页链接
	 * 
	 * @return
	 */
	private JSONObject getHomeUrl() {
		JSONObject home = new JSONObject();
		home.put("title", "首页");
		home.put("icon", "fa fa-home");
		home.put("href", "/api/v1/iplatformtools/query");
		return home;
	}
	
	/**
	 * 构造首页链接
	 * 
	 * @return
	 */
	private JSONObject getLogoUrl() {
		JSONObject logo = new JSONObject();
		logo.put("title", "计划管理");
		logo.put("image", "images/index_logo.png");
		logo.put("href", "");
		return logo;
	}
	/**
	 * 构造首页链接
	 * 
	 * @return
	 */
	private JSONObject getMenuUrl() {
		JSONObject currency = new JSONObject();
		
		JSONObject manage = new JSONObject();
		manage.put("title", "常规管理");
		manage.put("image", "fa fa-address-book");
		manage.put("child", genAllMenus());
		
		currency.put("currency", manage);
		return currency;
	}
	/**
	 * 构造首页链接
	 * 
	 * @return
	 */
	private JSONArray genAllMenus() {
		JSONArray menus = new JSONArray();
		
		JSONObject home = new JSONObject();
		home.put("title", "主页");
		home.put("href", "foldOut");
		home.put("icon", "fa fa-home");
		home.put("rightIcon", "fa fa-outdent");
		home.put("target", "_self");
		
		JSONObject home2 = new JSONObject();
		home2.put("title", "系统设置");
		home2.put("href", "page/setting.html");
		home2.put("icon", "fa fa-gears");
		home2.put("target", "_self");
		JSONArray setting = new JSONArray();
		
		JSONObject user = new JSONObject();
		user.put("title", "用户管理");
		user.put("href", "/privilege/user/query");
		user.put("icon", "fa fa-tachometer");
		user.put("target", "_self");
		setting.add(user);
		JSONObject role = new JSONObject();
		role.put("title", "角色管理");
		role.put("href", "/privilege/role/query");
		role.put("icon", "fa fa-tachometer");
		role.put("target", "_self");
		setting.add(role);
		home2.put("child", setting);
		
		
		menus.add(home);
		menus.add(home2);
		
		return menus;
	}

}
