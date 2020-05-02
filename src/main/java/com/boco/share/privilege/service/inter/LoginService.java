/**
 * 
 */
package com.boco.share.privilege.service.inter;

import com.boco.share.privilege.bean.User;

/**
 * @author LOVE
 *
 */
public interface LoginService {

	public User getUserByCode(String code);
	
	public boolean checkLoginUser(String code, String passWord);
}
