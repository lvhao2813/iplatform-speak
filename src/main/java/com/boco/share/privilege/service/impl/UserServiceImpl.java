/**
 * 
 */
package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.dao.UserMapper;
import com.boco.share.privilege.service.inter.UserService;
import com.boco.share.privilege.util.Md5Util;
import com.boco.share.privilege.util.PrivilageConstants;

/**
 * @author lv
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByCode(String code) {
		return userMapper.getUserByCode(code);
	}

	@Override
	public boolean checkLoginUser(String code, String passWord) {
		User user = userMapper.getUserByCode(code);
		if (user == null) {
			return false;
		} else {
			if (passWord.equals(user.getPassWord())) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public List<User> loadUsers(Map<String, String> formMap) {
		return userMapper.loadUsers(formMap);
	}

	@Override
	public User getUserById(Map<String, String> formMap) {
		return userMapper.getUserById(formMap);
	}

	@Override
	public int insert(User user) {
		user.setPassWord((Md5Util.encode(PrivilageConstants.DEFAULT_PWD)));
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public void deleteManager(String deleteId) {
		userMapper.deleteManager(deleteId);
	}

	@Override
	public void batchDeleteManager(String[] mgrIds) {
		userMapper.batchDeleteManager(mgrIds);
	}

}
