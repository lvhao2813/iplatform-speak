package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.privilege.bean.PriOrganizationBean;

/**
* Title: IPriOrganizationService 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
public interface IPriOrganizationService {
	
	/**
	 * Title: queryOrganization
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<PriOrganizationBean> queryOrganization(Map<String, String> formMap);
	
	/**
	 * Title: queryDepartmentByOrgId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<PriOrganizationBean> queryDepartmentByOrgId(Map<String, String> formMap);
	
	/**
	 * Title: queryOrgById
	 * Description: 
	 * @param orgId
	 * @return
	 */
	PriOrganizationBean queryOrgById(String orgId);
	
	/**
	 * Title: insertOrganization
	 * Description: 
	 * @param priOrganizationBean
	 * @return
	 */
	int insertOrganization(PriOrganizationBean priOrganizationBean);

	/**
	 * Title: updateOrganization
	 * Description: 
	 * @param priOrganizationBean
	 * @return
	 */
	int updateOrganization(PriOrganizationBean priOrganizationBean);

	/**
	 * Title: delete
	 * Description: 
	 * @param orgId
	 * @return
	 */
	int delete(String orgId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param deleteIds
	 */
	void batchDelete(String[] deleteIds);

}
