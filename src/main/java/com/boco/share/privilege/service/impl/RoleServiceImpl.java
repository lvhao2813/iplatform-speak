package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.privilege.bean.Role;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.dao.RoleMapper;
import com.boco.share.privilege.service.inter.RoleService;
/**
 * @author li970
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	

	@Override
	public List<Role> loadRoles(Map<String, String> formMap) {
		return roleMapper.loadRoles(formMap);
	}

	@Override
	public Role getRoleById(Map<String, String> formMap) {
		return roleMapper.getRoleById(formMap);
	}

	@Override
	public int insert(Role role) {
		role.setStatus("Y"); // 默认是可用
		return roleMapper.insert(role);
	}

	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public void deleteRole(String deleteId) {
		roleMapper.deleteRole(deleteId);
	}

	@Override
	public void batchDeleteRoles(String[] ids) {
		roleMapper.batchDeleteRoles(ids);
	}

	@Override
	public List<String> queryOrg() {
		return roleMapper.queryOrg();
	}
	
	@Override
	public List<User> queryUserWithOutRoleId(Map<String, String> formMap){
		return roleMapper.queryUserWithOutRoleId(formMap);
	}
	
	@Override
	public List<User> querySelectUserWithRoleId(Map<String, String> formMap){
		return roleMapper.querySelectUserWithRoleId(formMap);
	}
	
	@Override
	public void updateUserRole(String roleId, String[] checkedIds) {
		
		roleMapper.deleteUserWithRoleId(roleId);
		if (checkedIds != null) {
			for (String mgrId : checkedIds) {
				Map<String, String> formMap = CollectionUtil.getHashMap(4);
				formMap.put("USER_ROLE_ID", UniqueIDGenerator.getUUID());
				formMap.put("MGR_ID", mgrId);
				formMap.put("ROLE_ID", roleId);
				roleMapper.updateUserRole(formMap);
			}
		}
	}
	
	
}
