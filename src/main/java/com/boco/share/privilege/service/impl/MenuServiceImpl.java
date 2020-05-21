package com.boco.share.privilege.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boco.share.privilege.bean.Menu;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.dao.MenuMapper;
import com.boco.share.privilege.service.inter.MenuService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * Title: PriMenuServiceImpl Description:
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	public MenuMapper menuMapper;

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

		JSONArray jtemp = getAllMenusJson("0");
		manage.put("child", jtemp); // 这里以后通过数据库读取

		currency.put("currency", manage);
		return currency;
	}

	/**
	 * 通过数据库读取菜单
	 * 
	 * @return
	 */
	private JSONArray getAllMenusJson(String parentId) {
		List<Menu> menuList = menuMapper.queryMenuByParentId(String.valueOf(parentId));
		if (menuList.size() == 0 || menuList == null) {
			return null;
		}
		JSONArray menus = new JSONArray();
		for (Menu menu : menuList) {
			JSONObject temp = new JSONObject();
			temp.put("title", menu.getTitle());
			temp.put("href", menu.getHref());
			temp.put("icon", menu.getIcon());
			temp.put("target", menu.getTarget());
			if (menu.getRightIcon() != null) {
				temp.put("rightIcon", menu.getRightIcon());
			}
			JSONArray tmenus = getAllMenusJson(menu.getId());
			if (tmenus != null) {
				temp.put("child", tmenus);
			}
			menus.add(temp);
		}
		return menus;
	}

	@Override
	public List<Menu> loadMenusFormat(Map<String, String> formMap) {
		List<Menu> formatMenusList = loadMenus(formMap);
		for (Menu menu : formatMenusList) {
			switch (menu.getLevel()) {
			case "1":
				String st = new String("&nbsp;<b>" + menu.getTitle() + "</b>");
				menu.setTitle(st);
				break;
			case "2":
				String st2 = new String("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + menu.getTitle());
				menu.setTitle(st2);
				break;
			case "3": // 万一有三级目录
				menu.setTitle("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + menu.getTitle());
				break;
			}
		}
		return formatMenusList;
	}

	@Override
	public List<Menu> loadMenus(Map<String, String> formMap) {
		if (formMap == null || StringUtils.isEmpty(formMap.get("MENU_NAME"))) { // 搜索全部 -- 就是加载
			return getAllMenusList("0");
		} else { // 有输入的搜索
			return menuMapper.loadMenus(formMap);
		}
	}

	private List<Menu> getAllMenusList(String parentId) {
		List<Menu> menuList = menuMapper.queryMenuByParentId(String.valueOf(parentId));
		if (menuList == null || menuList.isEmpty()) {
			return null;
		}
		List<Menu> menus = new ArrayList<>();
		for (Menu menu : menuList) {
			menus.add(menu);
			List<Menu> tmenus = getAllMenusList(menu.getId());
			if (tmenus != null) {
				menus.addAll(tmenus);
			}
		}
		return menus;
	}

	@Override
	public int insert(Menu menu) {
		Menu parentMenu = menuMapper.getMenuById(menu.getParentId());
		if (parentMenu ==null) {
			menu.setLevel("1");
		}else {
			menu.setLevel(String.valueOf( Integer.parseInt( parentMenu.getLevel()) +1));
		}
		return menuMapper.insert(menu);
	}

	@Override
	public void delete(String deleteId) {
		menuMapper.delete(deleteId);
	}

	@Override
	public void batchDeleteMenus(String[] ids) {
		menuMapper.batchDeleteMenus(ids);
	}

	@Override
	public Menu getMenuById(Map<String, String> formMap) {
		String menuId = formMap.get("MENU_ID");
		return menuMapper.getMenuById(menuId);
	}

	@Override
	public int update(Menu menu) {
		Menu parentMenu = menuMapper.getMenuById(menu.getParentId());
		if (parentMenu ==null) {
			menu.setLevel("1");
		}else {
			menu.setLevel(String.valueOf( Integer.parseInt( parentMenu.getLevel()) +1));
		}
		return menuMapper.update(menu);
	}

}
