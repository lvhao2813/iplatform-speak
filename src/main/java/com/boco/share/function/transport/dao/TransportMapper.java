/**
 * 
 */
package com.boco.share.function.transport.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.function.release.bean.ReleaseLog;

/**
 * @author lv
 *
 */
@Mapper
public interface TransportMapper {

	/**
	 * 根据sql查询数据
	 * 
	 * 
	 * @return
	 */
	public List<Map> queryDataBySql(@Param("sql") String sql);

	/**
	 * 保存日志
	 * 
	 * 
	 * @return
	 */
	public void saveReleaseLog(ReleaseLog log);
}
