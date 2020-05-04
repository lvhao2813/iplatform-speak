package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.privilege.bean.Role;

/**
 * @author li970
 *
 */
public interface RoleService {
	
	/**
	 * 查询角色通过等级
	 * @param grade
	 * @return
	 */
	public Role getUserByGrade(String grade);
	
	
	/**
	 * Title: loadManagers
	 * Description: 读取角色信息
	 * @param formMap
	 * @return
	 */
	List<Role> loadRoles(Map<String, String> formMap);
	
	/**
	 * 获取角色，通过id
	 * @param formMap
	 * @return
	 */
	Role getRoleById(Map<String, String> formMap);

	/**
	 *  	新增管理员
	 * @param role
	 * @return
	 */
	int insert(Role role);

	/**
	 * 修改管理员信息
	 * @param role
	 * @return
	 */
	int update(Role role);

	/**
	 * 删除角色
	 * @param role ID
	 */
	void deleteRole(String deleteId);

	/**
	 * 批量删除角色
	 * @param ids
	 */
	void batchDeleteRoles(String[] ids);
}