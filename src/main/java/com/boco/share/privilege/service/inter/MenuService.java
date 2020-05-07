package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.privilege.bean.Menu;
import com.boco.share.privilege.bean.User;

/**
 * <p>
 * Title: MenuService
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
public interface MenuService {

	/**
	 * 查询目录列表，
	 * @return JSONObject对象
	 */
	JSONObject queryAllMenuList();

	/**
	 * Title：loadManagers
	 * Description: 读取目录信息
	 * @return 目录的列表
	 */
	List<Menu> loadMenus(Map<String, String> formMap);
	
	/**
	 * Title:insert
	 * @param menu
	 * @return
	 */
	int insert(Menu menu);
	
	/**
	 * 根据ID删除目录
	 * @param string
	 */
	void delete(String deleteId);
	
	/**
	 * 批量删除目录
	 * @param ids
	 */
	void batchDeleteMenus(String[] ids);
	
	/**
	 * 获取目录，通过id
	 * @param formMap
	 * @return
	 */
	Menu getMenuById(Map<String, String> formMap);
	
	
	/**
	 * 修改目录信息
	 * @param menu
	 * @return
	 */
	int update(Menu menu);
	
	/**
	 * 按前台展示格式输出目录列表
	 * @param formMap
	 * @return
	 */
	List<Menu> loadMenusFormat(Map<String, String> formMap);
}
