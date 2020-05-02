/**
 * 
 */
package com.boco.share.privilege.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.dao.LoginMapper;
import com.boco.share.privilege.service.inter.LoginService;

/**
 * @author LOVE
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public User getUserByCode(String code) {
		return loginMapper.getUserByCode(code);
	}

	@Override
	public boolean checkLoginUser(String code, String passWord) {
		User user = loginMapper.getUserByCode(code);
		if (user == null) {
			return false;
		}else {
			if(passWord.equals(user.getPassWord())) {
				return true;
			}else {
				return false;
			}
		}
	}

}
