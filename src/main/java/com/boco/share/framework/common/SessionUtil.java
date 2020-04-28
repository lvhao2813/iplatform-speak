package com.boco.share.framework.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.util.PrivilageConstants;

/**
 * Title: SessionUtil Description:
 * 
 * @author RayLLi
 * @date 2018年8月28日
 */
public class SessionUtil {

	/**
	 * Title: getLoginMgrId Description: 登录管理员ID
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginMgrId(HttpSession session) {
		if (getManager(session) == null) {
			return null;
		} else {
			return getManager(session).getMgrId();
		}
	}

	/**
	 * Title: getLoginUserCode Description: 获取登录用户名
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginUserCode(HttpSession session) {
		if (getManager(session) == null) {
			return null;
		} else {
			return getManager(session).getUserCode();
		}
	}

	/**
	 * Title: getLoginMgrType Description: 管理员类型
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginMgrType(HttpSession session) {
		if (getManager(session) == null) {
			return null;
		} else {
			return getManager(session).getMgrType();
		}
	}

	/**
	 * Title: getOrgCode Description: 管理员单位编码
	 * 
	 * @param session
	 * @return
	 */
	public static String getOrgCode(HttpSession session) {
		PriManagerBean priManagerBean = getManager(session);
		if (priManagerBean == null) {
			return null;
		} else {
			return priManagerBean.getOrgId();
		}
	}

	private static final int DEFAULT_ORGID_LENTH = 6;

	/**
	 * Title: getAreaCode Description: 管理员区域编码
	 * 
	 * @param session
	 * @return
	 */
	public static String getAreaCode(HttpSession session) {
		String orgId = getOrgCode(session);
		if (orgId == null) {
			return null;
		}
		if (orgId.length() >= DEFAULT_ORGID_LENTH) {
			return orgId.substring(0, DEFAULT_ORGID_LENTH);
		}
		return null;
	}

	/**
	 * Title: getLoginRealName Description: 获取登录姓名
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginRealName(HttpSession session) {
		if (getManager(session) == null) {
			return null;
		} else {
			return getManager(session).getMgrName();
		}
	}

	/**
	 * Title: getLoginRoleName Description: 获取登录角色明
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginRoleName(HttpSession session) {
		if (getManager(session) == null) {
			return null;
		} else {
			return getManager(session).getRoleName();
		}
	}

	// 是否超级管理员

	public static boolean isSuper(HttpSession session) {
		if (getManager(session) == null) {
			return false;
		} else {
			if (getManager(session).getIsSuper() == null) {
				return false;
			}
			return "1".equals(String.valueOf(getManager(session).getIsSuper()));
		}
	}

	/**
	 * Title: getManager Description: 获取登录vo 信息
	 * 
	 * @param session
	 * @return
	 */
	public static PriManagerBean getManager(HttpSession session) {
		PriManagerBean priManagerTO = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		return priManagerTO;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getLoginInfo(HttpSession session) {
		List<HashMap<String, String>> list = (List<HashMap<String, String>>) session
				.getAttribute(PrivilageConstants.LOGIN_INFO);
		if (list != null && list.size() > 0) {
			return (Map<String, String>) list.get(0);
		} else {
			return null;
		}
	}

	public static String getOrgId(HttpSession session) {
		if (getLoginInfo(session) == null) {
			return null;
		} else {
			return "" + getLoginInfo(session).get("ORG_ID");
		}
	}

	/**
	 * 
	 * Title: getOrgName Description:
	 * 
	 * @param session
	 * @return
	 */
	public static String getOrgName(HttpSession session) {
		if (getLoginInfo(session) == null) {
			return null;
		} else {
			return "" + getLoginInfo(session).get("ORG_NAME");
		}
	}

	/**
	 * Title: getAreaName
	 * Description: 区域名称
	 * @param session
	 * @return
	 */
	public static String getAreaName(HttpSession session) {
		if (getLoginInfo(session) == null) {
			return null;
		} else {
			return "" + getLoginInfo(session).get("AREA_NAME");
		}
	}

	/**
	 * Title: getMenuOptInfo
	 * Description: 获取登录菜单 功能操作信息
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<PriMenuBean> getMenuOptInfo(HttpSession session) {
		return (List<PriMenuBean>) session.getAttribute(PrivilageConstants.PRI_MENU_OPT);
	}

	@SuppressWarnings("unchecked")
	public static List<Map<String, String>> getMenueAndOptInfo(HttpSession session) {
		return (List<Map<String, String>>) session.getAttribute(PrivilageConstants.PRI_MENUE_MENU_OPT);
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> queryOrgByuserCode(HttpSession session) {
		return (HashMap<String, String>) session.getAttribute(PrivilageConstants.PRI_LEARNCENTER);
	}

	/**
	 * Title: sessionInvalid Description: 让登录信息失效
	 * 
	 * @param session
	 */
	public static void sessionInvalid(HttpSession session) {
		// 清除session
		Enumeration<String> em = session.getAttributeNames();
		while (em.hasMoreElements()) {
			session.removeAttribute(em.nextElement().toString());
		}
		session.invalidate();
	}
}
