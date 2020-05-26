/**
 * 
 */
package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.bean.UserAvailable;

/**
 * @author lv
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * 查询用户通过 账号
	 * 
	 * @param code
	 * @return
	 */
	User getUserByCode(String code);

	/**
	 * Title: loadManagers Description: 读取管理员信息
	 * 
	 * @param formMap
	 * @return
	 */
	List<User> loadUsers(Map<String, String> formMap);

	/**
	 * 获取用户，通过id
	 * 
	 * @param formMap
	 * @return
	 */
	User getUserById(Map<String, String> formMap);

	/**
	 * 新增管理员
	 * 
	 * @param user
	 * @return
	 */
	int insert(User user);

	/**
	 * 修改管理员信息
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);

	/**
	 * 删除用户
	 * 
	 * @param user ID
	 */
	public void deleteUser(String deleteId);

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 */
	public void batchDeleteUsers(String[] ids);
	
	/**
	 * 查询用户可用权益
	 * 
	 * @param code
	 * @return
	 */
	public UserAvailable queryUserAvailableByUserId(@Param("userId")String userId);
	
	/**
	 * 删除用户可用权益
	 * 
	 * @param userAvailable
	 * @return
	 */
	void deleteUserAvailable(String userAvailableId);

	/**
	 * 保存用户可用权益
	 * 
	 * @param userAvailable
	 * @return
	 */
	void saveUserAvailable(UserAvailable userAvailable);

}
