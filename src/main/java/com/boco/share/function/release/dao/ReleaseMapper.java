package com.boco.share.function.release.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.function.release.bean.DataSetBean;
import com.boco.share.function.release.bean.ReleaseDataBean;
import com.boco.share.function.release.bean.ReleaseDetailBean;
import com.boco.share.function.release.bean.ReleaseLog;

/**
 * Title: ReleaseMapper Description:
 * 
 * @author xinxiaofei
 * @date 2020年4月22日
 */
@Mapper
public interface ReleaseMapper {
	List<ReleaseDataBean> queryReleaseDataBeanList();

	List<DataSetBean> queryDataSetColumnList(Map<String, String> formMap);
	
	List<ReleaseDetailBean> queryDetail(Map<String, String> formMap);
	
	void saveReleaseDataBean(ReleaseDataBean releaseDataBean);
	
	void saveReleaseDataDetailBean(ReleaseDetailBean releaseDetailBean);

	ReleaseDataBean queryReleaseById(@Param(value = "id") String id);
	
	List<ReleaseLog> queryReleaseLogs(Map<String, String> formMap);

}
