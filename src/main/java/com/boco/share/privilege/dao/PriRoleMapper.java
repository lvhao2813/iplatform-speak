package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriRoleBean;

/**
* Title: PriRoleMapper 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */

public interface PriRoleMapper {

	/**
	 * Title: findRoleIdByMrgId
	 * Description: 
	 * @param mgrId
	 * @return
	 */
	public String findRoleIdByMrgId(String mgrId);

	/**
	 * Title: queryRole
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public PriRoleBean queryRole(Map<String, String> formMap);

	/**
	 * Title: loadRole
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<PriRoleBean> loadRole(Map<String, String> formMap);

	/**
	 * Title: insert
	 * Description: 
	 * @param priRoleBean
	 * @return
	 */
	public int insert(PriRoleBean priRoleBean);

	/**
	 * Title: update
	 * Description: 
	 * @param priRoleBean
	 * @return
	 */
	public int update(PriRoleBean priRoleBean);

	/**
	 * Title: delete
	 * Description: 
	 * @param roleId
	 * @return
	 */
	public int delete(String roleId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param roleIds
	 */
	public void batchDelete(String[] roleIds);

	/**
	 * Title: setIsUse
	 * Description: 
	 * @param roleId
	 */
	public void setIsUse(String roleId);

	/**
	 * Title: querySelectManagerWithRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<PriManagerBean> querySelectManagerWithRoleId(Map<String, String> formMap);

	/**
	 * Title: querySelectManagerWithOutRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<PriManagerBean> querySelectManagerWithOutRoleId(Map<String, String> formMap);

	/**
	 * Title: deleteManagerWithRoleId
	 * Description: 
	 * @param roleId
	 */
	public void deleteManagerWithRoleId(@Param("roleId") String roleId);

	/**
	 * Title: updateManagerRole
	 * Description: 
	 * @param formMap
	 */
	public void updateManagerRole(Map<String, String> formMap);

	/**
	 * Title: roleSelectedMenu
	 * Description: 
	 * @param formMap
	 */
	public void roleSelectedMenu(Map<String, String> formMap);

	/**
	 * Title: roleSelectedOpt
	 * Description: 
	 * @param formMap
	 */
	public void roleSelectedOpt(Map<String, String> formMap);

	/**
	 * Title: deleteRoleMenu
	 * Description: 
	 * @param roleId
	 */
	public void deleteRoleMenu(@Param("roleId") String roleId);

	/**
	 * Title: deleteRoleOpt
	 * Description: 
	 * @param roleId
	 */
	public void deleteRoleOpt(@Param("roleId") String roleId);

	/**
	 * Title: queryAllOptByMenuIds
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<Map<String, String>> queryAllOptByMenuIds(Map<String, String> formMap);

	/**
	 * Title: deleteTarget
	 * Description: 
	 * @param roleId
	 * @param targetId
	 */
	public void deleteTarget(@Param("roleId") String roleId, @Param("targetId") String targetId);
	
	/**
	 * Title: isRoleSelectTarget
	 * Description: 
	 * @param roleId
	 * @param targetId
	 * @return
	 */
	public String isRoleSelectTarget(@Param("roleId") String roleId, @Param("targetId") String targetId);
	
	/**
	 * Title: selectTarget
	 * Description: 
	 * @param formMap
	 */
	public void selectTarget(Map<String, String> formMap);
	
	/**
	 * Title: queryOrg
	 * Description: 
	 * @return
	 */
	public List<String> queryOrg();
}
