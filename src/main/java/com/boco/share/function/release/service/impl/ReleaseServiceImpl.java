package com.boco.share.function.release.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.function.release.bean.DataSetBean;
import com.boco.share.function.release.bean.ReleaseDataBean;
import com.boco.share.function.release.bean.ReleaseDetailBean;
import com.boco.share.function.release.bean.ReleaseLog;
import com.boco.share.function.release.bean.ReleaseTempBean;
import com.boco.share.function.release.dao.ReleaseMapper;
import com.boco.share.function.release.service.inter.ReleaseService;
/**
 * <p>Title: ReleaseServiceImpl</p>  
 * <p>Description: </p>  
 * @author xinxiaofei
 * @date 2020年4月22日
 */
@Service
public class ReleaseServiceImpl  implements ReleaseService {
	
	@Autowired
	private ReleaseMapper releaseMapper;

	@Override
	public List<ReleaseDataBean> queryReleaseDataBeanList() {
		return releaseMapper.queryReleaseDataBeanList();
	}

	@Override
	public List<DataSetBean> queryDataSetColumnList(Map<String, String> formMap) {
		return releaseMapper.queryDataSetColumnList(formMap);
	}

	@Override
	public JSONObject queryReleaseDeatil(Map<String, String> formMap) {
		ReleaseDataBean releaseDataBean = releaseMapper.queryReleaseById(formMap.get("id"));
		List<ReleaseDetailBean> detailList= releaseMapper.queryDetail(formMap);
		JSONObject result = new JSONObject();
		
		JSONObject param = new JSONObject();
		param.put("id",releaseDataBean.getId());
		param.put("token", releaseDataBean.getToken());
		
		if(!detailList.isEmpty()) {
			JSONArray array = new JSONArray();
			for(ReleaseDetailBean detail : detailList) {
				JSONObject d = new JSONObject();
				d.put("code", detail.getCode());
				d.put("condition", detail.getCondition());
				d.put("value", detail.getValue());
				array.add(d);
			}
			param.put("condition", array);
		}
		result.put("releaseDataBean", releaseDataBean);
		result.put("info", param);
		return result;
	}
	@Override
	public List<ReleaseLog> queryReleaseLogs(Map<String, String> formMap) {
		return releaseMapper.queryReleaseLogs(formMap);
	}

	@Override
	public ReleaseTempBean saveReleaseDataBean(ReleaseDataBean releaseDataBean) {
        ReleaseTempBean releaseTempBean = new ReleaseTempBean();
        try {
        	 if(releaseDataBean!=null) {
        		releaseDataBean.setId(UniqueIDGenerator.getUUID());
        		releaseDataBean.setToken(UniqueIDGenerator.getUUID());
        		releaseDataBean.setRequestType("POST");
        		releaseDataBean.setUrl("192.168.12.121:8802/iplatform-share/api/v1/transport/getHttpDatas");
             }
        	 releaseMapper.saveReleaseDataBean(releaseDataBean);
             //获取发布详情
             List<ReleaseDetailBean> list= releaseDataBean.getDetails();
             if(!list.isEmpty()) {
             	for(ReleaseDetailBean releaseDetailBean: list) {
             		releaseDetailBean.setId(UniqueIDGenerator.getUUID());
             		releaseDetailBean.setReleaseId(releaseDataBean.getId());
             		releaseDetailBean.setValue(releaseDetailBean.getValue()==null?"":releaseDetailBean.getValue());
             		releaseMapper.saveReleaseDataDetailBean(releaseDetailBean);
             	}
             }
             releaseTempBean.setId("200");
             releaseTempBean.setCode("发布成功");
        }catch (Exception e) {
        	releaseTempBean.setId("400");
            releaseTempBean.setCode("发布失败");
		}
		return releaseTempBean;
	}

	

}
