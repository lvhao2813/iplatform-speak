package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.privilege.bean.Menu;

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
	public JSONObject queryAllMenuList();

	/**
	 * Title：loadManagers
	 * Description: 读取目录信息
	 * @return 目录的列表
	 */
	public List<Menu> loadMenus(Map<String, String> formMap);
}
