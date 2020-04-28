package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.privilege.bean.PriOrganizationBean;

/**
* Title: PriOrganizationMapper 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Mapper
public interface PriOrganizationMapper {

	/**
	 * Title: queryOrganization1
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<PriOrganizationBean> queryOrganization(Map<String, String> formMap);

	/**
	 * Title: queryDepartmentByOrgId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<PriOrganizationBean> queryDepartmentByOrgId(Map<String, String> formMap);

	/**
	 * Title: queryOrgById
	 * Description: 
	 * @param orgId
	 * @return
	 */
	public PriOrganizationBean queryOrgById(String orgId);

	/**
	 * Title: queryMaxOrder
	 * Description: 
	 * @param parentId
	 * @return
	 */
	public int queryMaxOrder(String parentId);

	/**
	 * Title: insertOrg
	 * Description: 
	 * @param priOrganizationBean
	 * @return
	 */
	public int insertOrg(PriOrganizationBean priOrganizationBean);

	/**
	 * Title: updateOrg
	 * Description: 
	 * @param priOrganizationBean
	 * @return
	 */
	public int updateOrg(PriOrganizationBean priOrganizationBean);

	/**
	 * Title: delete
	 * Description: 
	 * @param orgId
	 * @return
	 */
	public int delete(String orgId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param deleteIds
	 */
	public void batchDelete(String[] deleteIds);

}
