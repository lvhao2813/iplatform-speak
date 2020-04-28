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
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User getUserByName(String name) {
		return loginMapper.getUserByName(name);
	}

}
