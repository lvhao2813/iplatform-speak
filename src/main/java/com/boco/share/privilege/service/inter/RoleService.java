package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.privilege.bean.Role;
import com.boco.share.privilege.bean.User;

/**
 * @author li970
 *
 */
public interface RoleService {
	
	
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
	
	/**
	 * queryOrg
	 * @return
	 */
	public List<String> queryOrg();
	
	/**
	 * Title: querySelectManagerWithOutRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<User> querySelectUserWithOutRoleId(Map<String, String> formMap);
	
	/**
	 * Title: querySelectManagerWithRoleId
	 * Description: 
	 * @param formMap
	 * @return
	 */
	public List<User> querySelectUserWithRoleId(Map<String, String> formMap);
	
}
