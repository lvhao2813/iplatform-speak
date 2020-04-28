package com.boco.share.privilege.service.inter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Title: ISysDataService 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
public interface ISysDataService {

	/**
	 * Title: loadData
	 * Description: 
	 * @return
	 */
	List<HashMap<String, String>> loadData();

	/**
	 * Title: querySysData
	 * Description: 
	 * @param formMap
	 * @return
	 */
	List<HashMap<String, String>> querySysData(Map<String, String> formMap);

	/**
	 * Title: insertSysData
	 * Description: 
	 * @param formMap
	 * @return
	 */
	int insertSysData(Map<String, String> formMap);

	/**
	 * Title: updateSysData
	 * Description: 
	 * @param formMap
	 * @return
	 */
	int updateSysData(Map<String, String> formMap);

	/**
	 * Title: deleteSysData
	 * Description: 
	 * @param id
	 */
	void deleteSysData(String id);

	/**
	 * Title: batchDeleteSysData
	 * Description: 
	 * @param deleteIds
	 */
	void batchDeleteSysData(String[] deleteIds);
	
	/**
	 * Title: setReadOnlyStatus
	 * Description: 
	 * @param id
	 */
	void setReadOnlyStatus(String id);
}
