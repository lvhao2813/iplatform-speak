package com.boco.share.privilege.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.dao.SysdataMapper;
import com.boco.share.privilege.service.inter.ISysDataService;

/**
* Title: SysDataServiceImpl 
* Description:   
* @author RayLLi  
* @date 2018年8月28日
 */
@Service
public class SysDataServiceImpl implements ISysDataService {

	@Autowired
	public SysdataMapper sysdataMapper;

	@Override
	public List<HashMap<String, String>> loadData() {
		return sysdataMapper.loadData();
	}

	@Override
	public List<HashMap<String, String>> querySysData(Map<String, String> formMap) {
		return sysdataMapper.querySysData(formMap);
	}

	@Override
	public int insertSysData(Map<String, String> formMap) {
		return sysdataMapper.insertSysData(formMap);
	}

	@Override
	public int updateSysData(Map<String, String> formMap) {
		return sysdataMapper.updateSysData(formMap);
	}

	@Override
	public void deleteSysData(String id) {
		sysdataMapper.deleteSysData(id);
	}

	@Override
	public void batchDeleteSysData(String[] deleteIds) {
		sysdataMapper.batchDeleteSysData(deleteIds);
	}

	@Override
	public void setReadOnlyStatus(String id) {
		sysdataMapper.setReadOnlyStatus(id);
	}
}
