package com.boco.share.privilege.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boco.share.privilege.bean.Menu;
import com.boco.share.privilege.dao.MenuMapper;
import com.boco.share.privilege.service.inter.MenuService;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
	public JSONObject queryAllMenuList() {
		JSONObject result = new JSONObject();

		// 清空缓存的链接
		result.put("clearInfo", getClearCacheUrl());
		// 构造首页链接
		result.put("homeInfo", getHomeUrl());
		// 构造logo
		result.put("logoInfo", getLogoUrl());
		// 构造菜单
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
		
		JSONArray jtemp = getAllMenus("0");
		manage.put("child", jtemp); // 这里以后通过数据库读取

		currency.put("currency", manage);
		return currency;
	}
	
	/**
	 * 通过数据库读取菜单
	 * 
	 * @return
	 */
	private JSONArray getAllMenus(String parentId) {
		List<Menu> menuList = priMenuMapper.queryMenuByParentID(String.valueOf(parentId));	
		if (menuList.size() == 0) {
			return null;
		}
		JSONArray menus = new JSONArray();
		JSONObject temp = new JSONObject();
		for (Menu menu : menuList) {
			System.out.println(menu);
			temp.put("title", menu.getTitle());
			temp.put("href", menu.getHref());
			temp.put("icon", menu.getIcon());
			if (menu.getRightIcon() != null) {
				temp.put("rightIcon", menu.getRightIcon());
			}
			temp.put("target", menu.getTarget());
			
			List<Menu> childList = priMenuMapper.queryMenuByParentID(menu.getId());
			if(childList.size()!=0) {
				temp.put("child", getAllMenus(menu.getId()));
			}
			menus.add(temp);
		}
		return menus;

	}

}
