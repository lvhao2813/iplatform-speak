package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.bean.Role;
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
	public Role getUserByGrade(String grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> loadRoles(Map<String, String> formMap) {
		return roleMapper.loadRoles(formMap);
	}

	@Override
	public Role getRoleById(Map<String, String> formMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Role role) {
		role.setStatus("Y"); // 默认是可用
		role.setCode("这个怎么写");
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

}
