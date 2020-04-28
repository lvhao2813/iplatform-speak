package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.privilege.bean.PriMenuBean;

/**
* <p>Title: IPriMenuService</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
public interface IPriMenuService {

	/**
	 * <p>Title: queryMenu</p>  
	 * <p>Description: 查询菜单信息</p>  
	 * @param formMap
	 * @return
	 */
	List<PriMenuBean> queryMenu(Map<String, String> formMap);

	/**
	 * <p>Title: queryMenuListByLevel</p>  
	 * <p>Description: 已树形结构查询菜单信息</p>  
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
	void batchDelete(String[] deleteIds);

	/**
	 * <p>Title: menuSelectedOpt</p>  
	 * <p>Description: 菜单绑定操作</p>  
	 * @param menuId
	 * @param optId
	 * @param createdBy
	 */
	void menuSelectedOpt(String menuId, String[] optId, String createdBy);

	/**
	 * <p>Title: querySelectOptByMenuId</p>  
	 * <p>Description: 获取菜单绑定的操作列表</p>  
	 * @param menuId
	 * @return
	 */
	List<Map<String, String>> querySelectOptByMenuId(String menuId);
	
	/**
	 * <p>Title: setIsHome</p>  
	 * <p>Description: 过时首页方法</p>  
	 * @param menuId
	 */
	@Deprecated
	void setIsHome(String menuId);
	
	/**
	 * <p>Title: querySelectWithOutRole</p>  
	 * <p>Description: 获取没有选取当前角色的管理员列表</p>  
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> listSelectWithOutRole(Map<String, String> formMap);
	
	/**
	 * <p>Title: querySelectWithInRole</p>  
	 * <p>Description: 获取已选中的角色</p>  
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> listSelectWithInRole(Map<String, String> formMap);
	
	/**
	 * <p>Title: updateHomeRole</p>  
	 * <p>Description:指定角色绑定菜单首页 </p>  
	 * @param menuId
	 * @param checkedIds
	 */
	void updateHomeRole(String menuId, String[] checkedIds);

}
