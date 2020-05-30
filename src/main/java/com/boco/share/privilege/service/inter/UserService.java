package com.boco.share.privilege.service.inter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.boco.share.privilege.bean.User;

/**
 * 
 * @author lv
 *
 */

public interface UserService {
	/**
	 * 查询用户通过 账号
	 * @param code
	 * @return
	 */
	User getUserByCode(String code);
	
	/**
	 * 校验用户密码是否正确
	 * 
	 * @param code
	 * @param passWord
	 * @return
	 */
	boolean checkLoginUser(String code, String passWord);
	
	/**
	 * Title: loadManagers
	 * Description: 读取管理员信息
	 * @param formMap
	 * @return
	 */
	List<User> loadUsers(Map<String, String> formMap);
	
	/**
	 * 获取用户，通过id
	 * @param formMap
	 * @return
	 */
	User getUserById(Map<String, String> formMap);

	/**
	 *  新增管理员
	 * @param user
	 * @return
	 */
	int insert(User user);

	/**
	 * 修改管理员信息
	 * @param user
	 * @return
	 */
	int update(User user);

	/**
	 * 删除用户
	 * @param user ID
	 */
	void deleteUser(String deleteId);

	/**
	 * 批量删除用户
	 * @param ids
	 */
	void batchDeleteUsers(String[] ids);
	
	/**
	 * 	根据传来的ID 和图片文件，更新头像
	 * @param formMap
	 * @param file
	 */
	void uploadImg(Map<String, String> formMap,MultipartFile file) throws IOException ;

}
