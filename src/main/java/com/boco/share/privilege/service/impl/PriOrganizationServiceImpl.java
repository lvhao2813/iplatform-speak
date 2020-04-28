package com.boco.share.privilege.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.bean.PriOrganizationBean;
import com.boco.share.privilege.dao.PriOrganizationMapper;
import com.boco.share.privilege.service.inter.IPriOrganizationService;

/**
 * Title: PriOrganizationServiceImpl Description:
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@Service
public class PriOrganizationServiceImpl implements IPriOrganizationService {

	@Autowired
	PriOrganizationMapper priOrgMapper;


	@Override
	public List<PriOrganizationBean> queryOrganization(Map<String, String> formMap) {
//		String orgType = formMap.get("ORG_TYPE");
		List<PriOrganizationBean> resultList = new ArrayList<PriOrganizationBean>();
		// 因为当orgType等于1的时候 表中ORG_TYPE等于（0,1,2,3），START WITH TD.PARENT_ID = '0'所以只能分开写
		resultList = priOrgMapper.queryOrganization(formMap);

		initTree(resultList);

		return resultList;
	}

	private void initTree(List<PriOrganizationBean> resultList) {
		for (int i = 0; i < resultList.size(); i++) {
			PriOrganizationBean currentOrgBean = resultList.get(i);

			if ("0".equals(currentOrgBean.getParentId())) {
				currentOrgBean.setTreeParentsId("0");
				currentOrgBean.setTreeId(String.valueOf(currentOrgBean.getOrgOrder()).trim());
			} else {
				if (currentOrgBean.getAllParentsId() != null) {
					currentOrgBean.setTreeParentsId(currentOrgBean.getAllParentsId().trim());
					currentOrgBean
							.setTreeId((currentOrgBean.getAllParentsId() + "-" + currentOrgBean.getOrgOrder()).trim());
				}
			}

		}
	}

	@Override
	public List<PriOrganizationBean> queryDepartmentByOrgId(Map<String, String> formMap) {
		return priOrgMapper.queryDepartmentByOrgId(formMap);
	}

	@Override
	public PriOrganizationBean queryOrgById(String orgId) {
		return priOrgMapper.queryOrgById(orgId);
	}

	@Override
	public int insertOrganization(PriOrganizationBean priOrganizationBean) {
		Integer maxOrder = priOrgMapper.queryMaxOrder(priOrganizationBean.getParentId());
		priOrganizationBean.setOrgOrder(maxOrder + 1);
		return priOrgMapper.insertOrg(priOrganizationBean);
	}

	@Override
	public int updateOrganization(PriOrganizationBean priOrganizationBean) {
		return priOrgMapper.updateOrg(priOrganizationBean);
	}

	@Override
	public int delete(String orgId) {
		return priOrgMapper.delete(orgId);
	}

	@Override
	public void batchDelete(String[] deleteIds) {
		priOrgMapper.batchDelete(deleteIds);
	}

}
