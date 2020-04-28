package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.dao.PriOptMapper;
import com.boco.share.privilege.service.inter.IPriOptService;

/**
* Title: PriOptServiceImpl 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Service
public class PriOptServiceImpl implements IPriOptService {

	@Autowired
	public PriOptMapper priOptMapper;

	@Override
	public List<Map<String, String>> queryOpt(Map<String, String> formMap) {
		return priOptMapper.queryOpt(formMap);
	}

	@Override
	public int insert(Map<String, String> formMap) {
		return priOptMapper.insert(formMap);
	}

	@Override
	public int update(Map<String, String> formMap) {
		return priOptMapper.update(formMap);
	}

	@Override
	public int delete(String deleteId) {
		return priOptMapper.delete(deleteId);
	}

	@Override
	public void batchDelete(String[] deleteIds) {
		priOptMapper.batchDelete(deleteIds);
	}

	@Override
	public void setIsStop(String optId) {
		priOptMapper.setIsStop(optId);
	}

}
