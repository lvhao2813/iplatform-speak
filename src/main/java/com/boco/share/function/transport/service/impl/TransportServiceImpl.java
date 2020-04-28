/**
 * 
 */
package com.boco.share.function.transport.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.framework.common.UuidUtil;
import com.boco.share.function.release.bean.ReleaseDataBean;
import com.boco.share.function.release.bean.ReleaseDetailBean;
import com.boco.share.function.release.bean.ReleaseLog;
import com.boco.share.function.release.dao.ReleaseMapper;
import com.boco.share.function.transport.bean.TransportHttpBean;
import com.boco.share.function.transport.dao.TransportMapper;
import com.boco.share.function.transport.service.inter.TransportService;

/**
 * @author lv
 *
 */
@Service
public class TransportServiceImpl implements TransportService {

	@Autowired
	private ReleaseMapper releaseMapper;
	@Autowired
	private TransportMapper transportMapper;

	@Override
	@Transactional
	public String getHttpDatas(TransportHttpBean transportHttpBean) {
		if (StringUtils.isEmpty(transportHttpBean.getReleaseId()))
			return "releaseId(接口id)不能为空！";

		ReleaseDataBean release = releaseMapper.queryReleaseById(transportHttpBean.getReleaseId());
		if (!release.getToken().equals(transportHttpBean.getToken())) {
			return "密钥错误！";
		}
		// 查询数据条数
		List<Map> countMap = transportMapper.queryDataBySql(genCountDataSql(release, transportHttpBean));
		BigDecimal count = (BigDecimal) countMap.get(0).get("COUNT");
		// 查询数据
		List<Map> datas = transportMapper.queryDataBySql(genDataSql(release, transportHttpBean));

		// 保存日志
		saveLog(release.getId(), count.toString(), release.getOperator());

		JSONObject ret = new JSONObject();
		ret.put("totalCount", count);
		ret.put("data", datas);
		return ret.toString();
	}

	/**
	 * 保存查询数据日志
	 * 
	 * @param releaseId 接口对象
	 * @param count     条数
	 * @param operator  操作人
	 */
	private void saveLog(String releaseId, String count, String operator) {
		ReleaseLog log = new ReleaseLog();
		log.setId(UuidUtil.genUUID());
		log.setReleaseId(releaseId);
		log.setOperDate(new Date());
		log.setCount(count);
		log.setOperator(operator);
		transportMapper.saveReleaseLog(log);
	}

	/**
	 * 生成查询接口数据sql
	 * 
	 * @param release 接口对象
	 * @return
	 */
	private String genDataSql(ReleaseDataBean release, TransportHttpBean transportHttpBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ").append(release.getDataSetTableName()).append(" where 1=1  ")
				.append(genCondition(transportHttpBean));
		return sb.toString();
	}

	/**
	 * 生成查询接口数据 条数 sql
	 * 
	 * @param release 接口对象
	 * @return
	 */
	private String genCountDataSql(ReleaseDataBean release, TransportHttpBean transportHttpBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) COUNT from ").append(release.getDataSetTableName()).append("  ")
				.append(genCondition(transportHttpBean));
		return sb.toString();
	}

	/**
	 * 生成查询接口条件sql
	 * 
	 * @param transportHttpBean
	 * @return
	 */
	private String genCondition(TransportHttpBean transportHttpBean) {
		List<ReleaseDetailBean> conditions = transportHttpBean.getCondition();
		if (conditions.isEmpty())
			return "";
		StringBuffer sb = new StringBuffer();
		for (ReleaseDetailBean detail : conditions) {
			sb.append(" and ").append(detail.getCode()).append(detail.getCondition()).append(detail.getValue());
		}
		return sb.toString();
	}
}
