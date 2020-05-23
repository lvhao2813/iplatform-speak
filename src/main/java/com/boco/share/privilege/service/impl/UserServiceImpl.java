/**
 * 
 */
package com.boco.share.privilege.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.framework.common.DateUtils;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.bean.UserAvailable;
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
		User user = userMapper.getUserByCode(code);
		UserAvailable userAvailable = userMapper.queryUserAvailableByUserId(user.getId());
		//检测会员是否过期,过期则更新状态
		if(isVip(userAvailable) && DateUtils.isVipOverTime(userAvailable.getExecTime())) {
			userAvailable.setVip("0");
			userMapper.deleteUserAvailable(userAvailable.getId());
			userMapper.saveUserAvailable(userAvailable);
		}
		user.setUserAvaliable(userAvailable);
		return user;
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
	public void deleteUser(String deleteId) {
		userMapper.deleteUser(deleteId);
	}

	@Override
	public void batchDeleteUsers(String[] mgrIds) {
		userMapper.batchDeleteUsers(mgrIds);
	}

	private boolean isVip(UserAvailable available) {
		//如果是空的则为未充值对象
		if(available == null) {
			return false;
		}else {
			if("0".equals(available.getVip())) {
				return false;
			}else {
				return true;
			}
		}
	}
	
}
