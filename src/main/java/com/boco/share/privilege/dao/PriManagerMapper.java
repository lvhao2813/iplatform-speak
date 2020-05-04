package com.boco.share.privilege.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.bean.User;

/**
* Title: PriManagerMapper 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Mapper
public interface PriManagerMapper {

	/**
	 * Title: getManagerByCodeAndPassword
	 * Description: 根据用户账号密码获取用户信息
	 * @param priManager
	 * @return
	 */
	PriManagerBean getManagerByCodeAndPassword(PriManagerBean priManager);

	/**
	 * Title: queryUserRole
	 * Description:  获取用户角色
	 * @param mgrId
	 * @return
	 */
	Map<String, String> getUserRole(String mgrId);

	/**
	 * Title: loadAllMenuOpt
	 * Description: 获取所有菜单操作
	 * @return
	 */
	List<PriMenuBean> loadAllMenu();

	/**
	 * Title: queryMenuAndOptByUser
	 * Description: 查询所有操作
	 * @param priManager
	 * @return
	 */
	List<Map<String, String>> queryMenuAndOptByUser(PriManagerBean priManager);

	/**
	 * Title: loadUsers
	 * Description: 读取所有管理员信息
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
	 * Title: insertManager
	 * Description: 新增管理员
	 * @param priManagerBean
	 * @return
	 */
	int insertManager(User user);

	/**
	 * Title: updateManager
	 * Description: 修改管理员s
	 * @param priManagerBean
	 * @return
	 */
	int updateManager(User user);

	/**
	 * Title: deleteManager
	 * Description: 删除管理员
	 * @param mgrId
	 * @return
	 */
	int deleteManager(String deleteId);

	/**
	 * Title: batchDeleteManager
	 * Description: 批量删除管理员
	 * @param mgrIds
	 */
	void batchDeleteManager(String[] deleteIds);

	/**
	 * Title: setStopOrActive
	 * Description: 设置账号停用或启用
	 * @param mgrId
	 */
	void setStopOrActive(String mgrId);
	
	/**
	 * Title: queryHomeUrl
	 * Description: 查询首页信息
	 * @param mgrId
	 * @return
	 */
	String queryHomeUrl(String mgrId);
	
	/**
	 * Title: queryOrgAndChild
	 * Description: 查询子类组织机构
	 * @param parentId
	 * @return
	 */
	List<String> queryOrgAndChild(String parentId);

}
