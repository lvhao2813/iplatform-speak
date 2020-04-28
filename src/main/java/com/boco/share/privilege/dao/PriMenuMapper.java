package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.privilege.bean.PriMenuBean;

/**
* <p>Title: PriMenuMapper</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
@Mapper
public interface PriMenuMapper {

	/**
	 * <p>Title: queryMenu</p>  
	 * <p>Description: 查询所有菜单信息 </p>  
	 * @param formMap
	 * @return
	 */
	List<PriMenuBean> queryMenu(Map<String, String> formMap);

	/**
	 * <p>Title: queryMenuListByLevel</p>  
	 * <p>Description: 查询所有菜单--采用树形结构</p>  
	 * @param formMap
	 * @return
	 */
	List<PriMenuBean> queryMenuListByLevel(Map<String, String> formMap);

	/**
	 * <p>Title: insertMenu</p>  
	 * <p>Description: 新增菜单</p>  
	 * @param priMenuBean
	 * @return
	 */
	int insertMenu(PriMenuBean priMenuBean);

	/**
	 * <p>Title: updateMenu</p>  
	 * <p>Description: 修改菜单信息</p>  
	 * @param priMenuBean
	 * @return
	 */
	int updateMenu(PriMenuBean priMenuBean);

	/**
	 * <p>Title: deleteMenu</p>  
	 * <p>Description: 删除菜单信息</p>  
	 * @param deleteId
	 * @return
	 */
	int deleteMenu(String deleteId);

	/**
	 * <p>Title: batchDelete</p>  
	 * <p>Description: 批量删除菜单信息</p>  
	 * @param deleteIds
	 */
	void batchDeleteMenu(String[] deleteIds);

	/**
	 * <p>Title: querySelectOptByMenuId</p>  
	 * <p>Description: 查询指定菜单的操作列表</p>  
	 * @param menuId
	 * @return
	 */
	List<Map<String, String>> querySelectOptByMenuId(String menuId);

	/**
	 * <p>Title: menuSelectedOpt</p>  
	 * <p>Description: 菜单新增操作</p>  
	 * @param formMap
	 */
	void insertSelectedOpt(Map<String, String> formMap);

	/**
	 * <p>Title: deleteSelectedOpt</p>  
	 * <p>Description: 菜单删除已选的操作</p>  
	 * @param menuId
	 */
	void deleteSelectedOpt(String menuId);

	/**
	 * <p>Title: getMaxMenuOrder</p>  
	 * <p>Description: 获取上级菜单的获取最大menu order值</p>  
	 * @param parentId
	 * @return
	 */
	int getParentMenuMaxOrder(String parentId);

	/**
	 * <p>Title: getMenuIdByLink</p>  
	 * <p>Description: 通过URL地址来获取对应菜单的ID</p>  
	 * @param menuLink
	 * @return
	 */
	String getMenuIdByLink(String menuLink);
	
	/**
	 * <p>Title: setupOrCancelHomePageByMenuId</p>  
	 * <p>Description: 根据菜单ID设置或取消首页设置</p>  
	 * @param menuId
	 */
	@Deprecated
	void setupOrCancelHomePageByMenuId(String menuId);
	
	/**
	 * <p>Title: cancelAllHomePage</p>  
	 * <p>Description: 取消掉所有首页设置</p>
	 */
	@Deprecated
	void cancelAllHomePage();
	
	/**
	 * <p>Title: querySelectWithOutRole</p>  
	 * <p>Description: 分配账号角色页面---没选择当前角色的列表信息</p>  
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> listSelectWithOutRole(Map<String, String> formMap);
	
	/**
	 * Title: listSelectWithInRole
	 * Description: 分配账号角色页面---选择了当前角色的列表信息
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> listSelectWithInRole(Map<String, String> formMap);
	
	/**
	 * Title: deleteHomeWithRoleId
	 * Description: 当前角色移除首页信息
	 * @param menuId
	 */
	void deleteHomeWithRoleId(String menuId);
	
	/**
	 * Title: updateHomeRole
	 * Description: 更新角色首页信息
	 * @param formMap
	 */
	void updateHomeRole(Map<String, String> formMap);

}
