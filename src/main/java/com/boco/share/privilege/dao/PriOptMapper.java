package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
* Title: PriOptMapper 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Mapper
public interface PriOptMapper {

	/**
	 * Title: queryOpt
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<Map<String, String>> queryOpt(Map<String, String> formMap);

	/**
	 * Title: insert
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public int insert(Map<String, String> formMap);

	/**
	 * Title: update
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public int update(Map<String, String> formMap);

	/**
	 * Title: delete
	 * Description: 
	 * @param deleteId
	 * @return
	 */
	public int delete(String deleteId);

	/**
	 * Title: batchDelete
	 * Description: 
	 * @param deleteIds
	 */
	public void batchDelete(String[] deleteIds);
	
	/**
	 * Title: setIsStop
	 * Description: 
	 * @param optId
	 */
	public void setIsStop(String optId) ;

}
