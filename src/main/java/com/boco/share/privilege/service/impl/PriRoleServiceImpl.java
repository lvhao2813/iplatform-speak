package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriRoleBean;
import com.boco.share.privilege.dao.PriRoleMapper;
import com.boco.share.privilege.service.inter.IPriRoleService;

/**
* <p>Title: PriRoleServiceImpl</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月23日
 */

public class PriRoleServiceImpl implements IPriRoleService {

	@Autowired
	private PriRoleMapper userRoleMapper;

	@Override
	public PriRoleBean findRoleByMrgId(String mgrId) {
		PriRoleBean priRole = new PriRoleBean();
		Map<String, String> formMap = CollectionUtil.getHashMap(1);

		String roleId = userRoleMapper.findRoleIdByMrgId(mgrId);
		if (!StringUtils.isEmpty(roleId)) {
			formMap.put("ROLE_ID", roleId);
			priRole = userRoleMapper.queryRole(formMap);
		}

		return priRole;
	}

	@Override
	public List<PriRoleBean> loadRole(Map<String, String> formMap) {
		return userRoleMapper.loadRole(formMap);
	}

	@Override
	public int insert(PriRoleBean priRoleBean) {
		return userRoleMapper.insert(priRoleBean);
	}

	@Override
	public int update(PriRoleBean priRoleBean) {
		return userRoleMapper.update(priRoleBean);
	}

	@Override
	public void delete(String roleId) {
		userRoleMapper.delete(roleId);
	}

	@Override
	public void batchDelete(String[] roleIds) {
		userRoleMapper.batchDelete(roleIds);
	}

	@Override
	public void setIsUse(String roleId) {
		userRoleMapper.setIsUse(roleId);
	}

	@Override
	public List<PriManagerBean> querySelectManagerWithRoleId(Map<String, String> formMap) {
		return userRoleMapper.querySelectManagerWithRoleId(formMap);
	}

	@Override
	public List<PriManagerBean> querySelectManagerWithOutRoleId(Map<String, String> formMap) {
		return userRoleMapper.querySelectManagerWithOutRoleId(formMap);
	}

	@Override
	public void updateManagerRole(String roleId, String[] checkedIds, String createdBy) {

		userRoleMapper.deleteManagerWithRoleId(roleId);
		if (checkedIds != null) {
			for (String mgrId : checkedIds) {

				Map<String, String> formMap = CollectionUtil.getHashMap(4);
				formMap.put("USER_ROLE_ID", UniqueIDGenerator.getUUID());
				formMap.put("MGR_ID", mgrId);
				formMap.put("ROLE_ID", roleId);
				formMap.put("CREATED_BY", createdBy);

				userRoleMapper.updateManagerRole(formMap);
			}
		}

	}

	@Override
	public void updateRoleMenuAndOpt(String roleId, String[] checkedMenuIds, String[] checkedOptIds, String createdBy) {

		// 更新用户可用的菜单
		userRoleMapper.deleteRoleMenu(roleId);
		if (checkedMenuIds != null) {
			for (String menuId : checkedMenuIds) {
				Map<String, String> formMap = CollectionUtil.getHashMap(4);
				formMap.put("ROLE_MENU_ID", UniqueIDGenerator.getUUID());
				formMap.put("MENU_ID", menuId);
				formMap.put("ROLE_ID", roleId);
				formMap.put("CREATED_BY", createdBy);

				userRoleMapper.roleSelectedMenu(formMap);
			}
		}

		// 更新用户的可用操作
		userRoleMapper.deleteRoleOpt(roleId);
		if (checkedOptIds != null) {
			for (String optId : checkedOptIds) {
				Map<String, String> formMap = CollectionUtil.getHashMap(4);
				formMap.put("ROLE_OPT_ID", UniqueIDGenerator.getUUID());
				formMap.put("MENU_OPT_ID", optId);
				formMap.put("ROLE_ID", roleId);
				formMap.put("CREATED_BY", createdBy);

				userRoleMapper.roleSelectedOpt(formMap);
			}
		}

	}

	@Override
	public List<Map<String, String>> queryAllOptByMenuIds(Map<String, String> formMap) {
		return userRoleMapper.queryAllOptByMenuIds(formMap);
	}
	
	private final String roleSelectedTarget = "Y";
	@Override
	public void selectTarget(String targetId, String roleId, String createdBy) {
		String isRoleSelectTarget = userRoleMapper.isRoleSelectTarget(roleId, targetId);

		if (roleSelectedTarget.equals(isRoleSelectTarget)) {
			userRoleMapper.deleteTarget(roleId, targetId);
		} else {
			Map<String, String> roleTargetMap = CollectionUtil.getHashMap(4);
			roleTargetMap.put("ROLE_TARGET_ID", UniqueIDGenerator.getUUID());
			roleTargetMap.put("TARGET_ID", targetId);
			roleTargetMap.put("ROLE_ID", roleId);
			roleTargetMap.put("CREATED_BY", createdBy);

			userRoleMapper.selectTarget(roleTargetMap);
		}
	}

	public PriRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}

	public void setUserRoleMapper(PriRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	@Override
	public List<String> queryOrg() {
		return userRoleMapper.queryOrg();
	}
	
	
}
