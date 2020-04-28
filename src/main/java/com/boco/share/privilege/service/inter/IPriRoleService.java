package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriRoleBean;

/**
* Title: IPriRoleService 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
public interface IPriRoleService {

	/**
	 * Title: findRoleByMrgId
	 * Description: 
	 * @param mgrId
	 * @return
	 */
	PriRoleBean findRoleByMrgId(String mgrId);

	/**
	 * Title: loadRole
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<PriRoleBean> loadRole(Map<String, String> formMap);

	/**
	 * Title: insert
	 * Description: 
	 * @param priRoleBean
	 * @return
	 */
	int insert(PriRoleBean priRoleBean);

	/**
	 * Title: update
	 * Description: 
	 * @param priRoleBean
	 * @return
	 */
	int update(PriRoleBean priRoleBean);

	/**
	 * Title: delete
	 * Description: 
	 * @param roleId
	 */
	void delete(String roleId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param roleIds
	 */
	void batchDelete(String[] roleIds);

	/**
	 * Title: setIsUse
	 * Description: 
	 * @param roleId
	 */
	void setIsUse(String roleId);

	/**
	 * Title: querySelectManagerWithRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<PriManagerBean> querySelectManagerWithRoleId(Map<String, String> formMap);

	/**
	 * Title: querySelectManagerWithOutRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<PriManagerBean> querySelectManagerWithOutRoleId(Map<String, String> formMap);

	/**
	 * Title: updateManagerRole
	 * Description: 
	 * @param roleId
	 * @param checkedIds
	 * @param createdBy
	 */
	void updateManagerRole(String roleId, String[] checkedIds, String createdBy);

	/**
	 * Title: updateRoleMenuAndOpt
	 * Description: 
	 * @param roleId
	 * @param checkedMenuIds
	 * @param checkedOptIds
	 * @param createdBy
	 */
	void updateRoleMenuAndOpt(String roleId, String[] checkedMenuIds, String[] checkedOptIds, String createdBy);
	
	/**
	 * Title: queryAllOptByMenuIds
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> queryAllOptByMenuIds(Map<String, String> formMap);
	
	/**
	 * Title: selectTarget
	 * Description: 
	 * @param targetId
	 * @param roleId
	 * @param createdBy
	 */
	void selectTarget(String targetId, String roleId, String createdBy);
	
	/**
	 * Title: queryOrg
	 * Description: 
	 * @return
	 */
	List<String> queryOrg();
}
