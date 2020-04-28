package com.boco.share.function.release.service.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.function.release.bean.DataSetBean;
import com.boco.share.function.release.bean.ReleaseDataBean;
import com.boco.share.function.release.bean.ReleaseLog;
import com.boco.share.function.release.bean.ReleaseTempBean;

/**
 * <p>
 * Title: ReleaseService
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author xinxiaofei
 * @date 2020年4月22日
 */
public interface ReleaseService {
	/**
	 * 数据包发布url的列表
	 * 
	 * @return
	 */
	List<ReleaseDataBean> queryReleaseDataBeanList();

	/**
	 * 获取发布详情
	 */
	JSONObject queryReleaseDeatil(Map<String, String> formMap);

	/**
	 * 获取数据包列
	 * 
	 * @return
	 */
	List<DataSetBean> queryDataSetColumnList(Map<String, String> formMap);

	/**
	 * url发布接口
	 * 
	 * @param formMap
	 */
	ReleaseTempBean saveReleaseDataBean(ReleaseDataBean releaseDataBean);

	/**
	 * 查看日志
	 * 
	 * @param formMap
	 * @return
	 */
	List<ReleaseLog> queryReleaseLogs(Map<String, String> formMap);

}
