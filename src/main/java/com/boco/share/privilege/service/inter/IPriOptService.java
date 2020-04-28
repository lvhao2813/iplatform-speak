package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

/**
* Title: IPriOptService 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
public interface IPriOptService {

	/**
	 * Title: queryOpt
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<Map<String, String>> queryOpt(Map<String, String> formMap);

	/**
	 * Title: insert
	 * Description: 
	 * @param formMap
	 * @return
	 */
	int insert(Map<String, String> formMap);

	/**
	 * Title: update
	 * Description: 
	 * @param formMap
	 * @return
	 */
	int update(Map<String, String> formMap);

	/**
	 * Title: delete
	 * Description: 
	 * @param deleteId
	 * @return
	 */
	int delete(String deleteId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param deleteIds
	 */
	void batchDelete(String[] deleteIds);
	
	/**
	 * Title: setIsStop
	 * Description: 
	 * @param optId
	 */
	void setIsStop(String optId);

}
