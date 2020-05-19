package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.privilege.bean.Menu;
import com.boco.share.privilege.bean.User;

/**
 * 
 * @author lv
 */
@Mapper
public interface MenuMapper {
	
	/**
	 * 通过父结点查找菜单
	 * @param formMap
	 * @return
	 */
	List<Menu> queryMenuByParentId(@Param("PARENT_ID")String parentId);
	
	/**
	 * 加载菜单
	 * @param formMap
	 * @return
	 */
	List<Menu> loadMenus(Map<String, String> formMap);
	
	/**
	 * 增加菜单
	 * @param menu
	 * @return
	 */
	int insert(Menu menu);
	
	/**
	 * 删除菜单
	 * @param deleteId
	 */
	public void delete(String deleteId);
	
	/**
	 * 批量删除菜单
	 * @param deleteId
	 */
	public void batchDeleteMenus(String[] ids);
	
	/**
	 * 修改目录
	 * @param menu
	 * @return
	 */
	public int update(Menu menu);
	
	/**
	 * 	 通过id获取菜单
	 */
	public Menu getMenuById(@Param("MENU_ID")String id);
}
