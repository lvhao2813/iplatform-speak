/**
 * 
 */
package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.privilege.bean.Role;

/**
 * @author li970
 *
 */

@Mapper
public interface RoleMapper {

	/**
	 * 获取角色，通过id
	 * 
	 * @param formMap
	 * @return
	 */
	Role getRoleById(Map<String, String> formMap);

	/**
	 * 读取角色信息
	 * 
	 * @param formMap
	 * @return
	 */
	public List<Role> loadRoles(Map<String, String> formMap);

	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	int insert(Role role);

	/**
	 * 修改管理员信息
	 * 
	 * @param role
	 * @return
	 */
	int update(Role role);

	/**
	 * 删除用户
	 * 
	 * @param user ID
	 */
	void deleteRole(String deleteId);

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	void batchDeleteRoles(String[] ids);

}
