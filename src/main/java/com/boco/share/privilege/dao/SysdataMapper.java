package com.boco.share.privilege.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
* Title: SysdataMapper 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
@Mapper
public interface SysdataMapper {

	/**
	 * Title: loadData
	 * Description: 获取数据字典列表
	 * @return
	 */
	public List<HashMap<String, String>> loadData();

	/**
	 * Title: querySysData
	 * Description: 查询数据字典
	 * @param formMap
	 * @return
	 */
	public List<HashMap<String, String>> querySysData(Map<String, String> formMap);

	/**
	 * Title: insertSysData
	 * Description: 添加数据字典
	 * @param formMap
	 * @return
	 */
	public int insertSysData(Map<String, String> formMap);

	/**
	 * Title: updateSysData
	 * Description: 更新数据字典
	 * @param formMap
	 * @return
	 */
	public int updateSysData(Map<String, String> formMap);

	/**
	 * Title: deleteSysData
	 * Description: 删除数据字典
	 * @param id
	 * @return
	 */
	public int deleteSysData(String id);

	/**
	 * Title: batchDeleteSysData
	 * Description: 批量删除数据字典
	 * @param deleteIds
	 */
	public void batchDeleteSysData(String[] deleteIds);

	/**
	 * Title: setReadOnlyStatus
	 * Description: 设置只读状态
	 * @param id
	 */
	public void setReadOnlyStatus(String id);

}
