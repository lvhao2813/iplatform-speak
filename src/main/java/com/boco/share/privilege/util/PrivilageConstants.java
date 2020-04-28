package com.boco.share.privilege.util;

/**
 * Title: PrivilageConstants Description:
 * 
 * @author RayLLi
 * @date 2018年9月6日
 */
public interface PrivilageConstants {

	// ==========================登录加载数据字典表===========================

	/**
	 * 登入当天时间
	 */
	public final static String FORMAT_TODAY = "FORMAT_TODAY";

	/**
	 * 登入用户信息
	 */
	public final static String PRI_MANAGER = "PRI_MANAGER";

	public final static String LOGIN_INFO = "LOGIN_INFO";

	/**
	 * 默认密码
	 */
	public final static String DEFAULT_PWD = "111111";

	/**
	 * 菜单信息
	 */
	public final static String PRI_MENU_OPT = "PRI_MENU_OPT";

	/**
	 * 菜单和功能操作信息
	 */
	public final static String PRI_MENUE_MENU_OPT = "PRI_MENUE_MENU_OPT";

	/**
	 * 用户角色
	 */
	public final static String PRI_USER_ROLE = "PRI_USER_ROLE";

	public final static String PRI_ROLE = "PRI_ROLE";

	/**
	 * 是否超级管理员
	 */
	public final static String SUPERMAN_YES = "1";

	/**
	 * 如果在用户登录时，在session中设置该变量为true或其他任意值，则认为当前用户只具有查看权限，没有任何其他权限
	 */
	public final static String NO_PERMISSION = "NO_PERMISSION";

	/**
	 * 账号停用
	 */
	public final static String PRI_MANAGER_STOP = "0";

	/**
	 * 系统管理员
	 */
	public final static String SYS_MGR_TYPE = "0";

	public final static String PRI_USER_ID = "userid";

	public final static String PRI_USER_LEVEL = "lv";

	/**
	 * 添加管理员赋予默认角色备注
	 */
	public final static String REMARK_MGR_ROLE = "系统默认赋予角色";

	public final static String PRI_LEARNCENTER = "PRI_LEARNCENTER";

	/**
	 * 默认管理员1
	 */
	public final static String DEFAULT_COMMON_MGR_ROLE = "default_common_mgr_role"; 

	/**
	 * 默认普通用户2
	 */
	public final static String DEFAULT_COMMON_USER_ROLE = "default_common_user_role"; 

	public final static String HOME_URL = "homeUrl";
	// ==========================登录加载数据字典表===========================
	
	/**
	 * 项目状态
	 */
	public final static String PRO_STATUS = "PRO_STATUS"; 

	// ==========================单位相关===========================
	
	/**
	 * 顶级单位默认代码,从0开始查找下属列表信息
	 */
	public final static String TOP_PARENT_ORG = "0";

	// ==========================地图相关===========================
	
	/**
	 * 默认1级地图等级
	 */
	public final static int TOP_MENU_LEVEL = 1;

}
