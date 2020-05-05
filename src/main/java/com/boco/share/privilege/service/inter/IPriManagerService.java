package com.boco.share.privilege.service.inter;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.bean.User;

/**
* <p>Title: IPriManagerService</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
public interface IPriManagerService {

	/**
	 * <p>Title: checkManager</p>  
	 * <p>Description: 验证登录，通过用户密码获取对应用户信息</p>  
	 * @param priManager
	 * @return
	 */
	PriManagerBean checkManager(PriManagerBean priManager);

	/**
	 * <p>Title: queryUserRole</p>  
	 * <p>Description: 通过用户管理员ID获取用户角色</p>  
	 * @param mgrId
	 * @return
	 */
	Map<String, String> getUserRole(String mgrId);

	/**
	 * <p>Title: queryAllMenu</p>  
	 * <p>Description: 如果是超级管理员，则获取所有菜单</p>  
	 * @return
	 */
	List<PriMenuBean> queryAllMenu();

	/**
	 * Title: queryMenuAndOptByUser
	 * Description: 查询当前角色的操作和菜单信息
	 * @param priManager
	 * @return
	 */
	List<Map<String, String>> queryMenuAndOptByUser(PriManagerBean priManager);

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
	 * Title: insert
	 * Description: 新增管理员
	 * @param priManager
	 * @return
	 */
	int insert(User user);

	/**
	 * Title: update
	 * Description:  修改管理员信息
	 * @param priManager
	 * @return
	 */
	int update(User user);

	/**
	 * Title: deleteManager
	 * Description: 
	 * @param mgrId
	 */
	void deleteManager(String deleteId);

	/**
	 * Title: batchDeleteManager
	 * Description: 
	 * @param ids
	 */
	void batchDeleteManager(String[] ids);

	/**
	 * Title: setStopOrActive
	 * Description: 
	 * @param mgrId
	 */
	void setStopOrActive(String mgrId);

	/**
	 * Title: queryHomeUrl
	 * Description: 
	 * @param mgrId
	 * @return
	 */
	String queryHomeUrl(String mgrId);
	
	/**
	 * Title: setDateAuthoParams
	 * Description: 
	 * @param priManager
	 * @param request
	 * @return
	 */
	void setDateAuthoParams(PriManagerBean priManager, ServletRequest request);


}
