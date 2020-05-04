package com.boco.share.privilege.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.application.LogConstants;
import com.boco.share.framework.application.Sysdata;
import com.boco.share.framework.common.LoginUtil;
import com.boco.share.framework.common.SessionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.framework.constants.ConfigContants;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.service.inter.IPriManagerService;
import com.boco.share.privilege.service.inter.MenuService;
import com.boco.share.privilege.service.inter.IPriOrganizationService;
import com.boco.share.privilege.service.inter.IPriRoleService;
import com.boco.share.privilege.util.LoginConstants;
import com.boco.share.privilege.util.Md5Util;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Title: PriManagerController
 * Description: 管理员类，负责登录，获取权限，增删改查等
 * @author RayLLi
 * @date 2018年8月27日
 */

public class PriManagerController extends BaseController implements LoginConstants,PrivilageConstants,ConfigContants {

	@Autowired
	private IPriManagerService userManagerService;

	@Autowired
	private IPriRoleService userRoleService;

	@Autowired
	public IPriOrganizationService priOrganizationService;

	@Autowired
	public MenuService priMenuService;
	
	/**
	 * 登录管理平台
	 *
	 * @param 用户名
	 * @param 密码
	 *            非MD5加密
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, Map<String, Object> resultMap, String username, String password,HttpServletRequest request, @RequestParam Map<String, String> formMap) {
		PriManagerBean priManager = new PriManagerBean();
		priManager.setUserCode(username);
		priManager.setPassword(password);
		System.out.println("into login");

		priManager = userManagerService.checkManager(priManager);

		// 判断账号是否存在，密码是否正确
		if (priManager == null) {
			resultMap.put(LOGIN_MESSAGE, Sysdata.getInstance().getProperty(LOGIN_MESSAGE, SYSDATA_MESSAGE_LOGINERROR));
			return new ModelAndView("login");
		}

		// 是否已账号停用
		if (priManager.getStop().equals(PRI_MANAGER_STOP)) {
			resultMap.put(LOGIN_MESSAGE, Sysdata.getInstance().getProperty(LOGIN_MESSAGE, SYSDATA_MESSAGE_MANAGER_STOP));
			return new ModelAndView("login");
		}

		session.setAttribute(PRI_MANAGER, priManager);

		setHomeUrl(session, priManager);
		setMenu(session, priManager);
		setUserRole(session, priManager);
		setRole(session, priManager);
		
		//initMenuId(request,formMap);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("formMap", formMap);

		return mv;
	}

	/**
	 * Title: setUserRole
	 * Description: 保存用户角色
	 * @param session
	 * @param priManager
	 */
	private void setUserRole(HttpSession session, PriManagerBean priManager) {
		session.setAttribute(PRI_USER_ID, priManager.getMgrId());
		session.setAttribute(PRI_USER_LEVEL, priManager.getIsSuper());
		session.setAttribute(PRI_USER_ROLE, userManagerService.getUserRole(priManager.getMgrId()));
	}

	private void setRole(HttpSession session, PriManagerBean priManager) {
		session.setAttribute(PRI_ROLE, userRoleService.findRoleByMrgId(priManager.getMgrId()));
	}

	private void setMenu(HttpSession session, PriManagerBean priManager) {
		List<PriMenuBean> menuList = null;
		List<Map<String, String>> menuOptList = null;

		if (SessionUtil.isSuper(session)) {
			log.info(LogConstants.LOG_INFO_APPLICATION_PRIVILEGE_QUERYALLMENU);
//			menuList = userManagerService.queryAllMenu(); ###
		} else {
			log.info(LogConstants.LOG_INFO_APPLICATION_PRIVILEGE_QUERYMENUOPTBYMANAGER);
			Map<String, String> formMap = new HashMap<String, String>(16);
			formMap.put("LOGIN_MGR_ID", priManager.getMgrId());

//			menuList = priMenuService.queryMenuListByLevel(formMap); ###
		}

		if (menuList != null) {
			menuOptList = userManagerService.queryMenuAndOptByUser(priManager);
		}

		session.setAttribute(PRI_MENU_OPT, menuList);
		session.setAttribute(PRI_MENUE_MENU_OPT, menuOptList);

		session.setAttribute(FORMAT_TODAY, LoginUtil.getTodayFormat());
	}

	private void setHomeUrl(HttpSession session, PriManagerBean priManager) {
		String queryHomeUrl = userManagerService.queryHomeUrl(priManager.getMgrId());
		session.setAttribute(HOME_URL, StringUtils.isEmpty(queryHomeUrl) ? "home" : queryHomeUrl);
	}

	@RequestMapping("logout")
	public String login(HttpSession session) {
		// 清除session
		Enumeration<String> em = session.getAttributeNames();
		while (em.hasMoreElements()) {
			session.removeAttribute(em.nextElement().toString());
		}

		session.invalidate();
		return "login";
	}

	@RequestMapping("query")
	public ModelAndView queryManagerList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<User> resultList = userManagerService.loadUsers(formMap);

		PageInfo<User> pageInfo = new PageInfo<User>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("privilege/manager/list");
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);

		return modelAndView;
	}

	@RequestMapping("insertpage")
	public ModelAndView insertPage(@ModelAttribute(value = "User") User user) {
		ModelAndView mav = new ModelAndView("privilege/manager/add");
		mav.addObject("User", user);
		return mav;
	}

	@RequestMapping("selectOrg")
	public ModelAndView selectOrg() {
		ModelAndView mav = new ModelAndView("privilege/role/select_org");

		Map<String, String> orgMap = new HashMap<String, String>(16);
		orgMap.put("ORG_TYPE", TOP_PARENT_ORG);

		mav.addObject("orgList", priOrganizationService.queryOrganization(orgMap));
		return mav;
	}

	@RequestMapping("selectDepartment")
	public ModelAndView selectDepartment(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("privilege/role/select_department");

		formMap.put("ORG_TYPE", TOP_PARENT_ORG);

		mav.addObject("orgList", priOrganizationService.queryDepartmentByOrgId(formMap));
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public void insert(@ModelAttribute(value = "User") User user, HttpSession session) {
		
		userManagerService.insert(user);
	}
	


	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "User") User user) {
		User result = userManagerService.getUserById(formMap);

		ModelAndView mav = new ModelAndView("privilege/manager/update");
		mav.addObject("User", result);
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void update(User user) {
		userManagerService.update(user);
	}

	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("delete")
	@ResponseBody
	public void delete(@RequestParam Map<String, String> formMap) {
		userManagerService.deleteManager(formMap.get("deleteId"));
	}

	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	public void batchDelete(String[] deleteIds) {
		userManagerService.batchDeleteManager(deleteIds);
	}

	@RequestMapping("setIsStop")
	@ResponseBody
	public String setStopOrActive(String mgrId) {
		userManagerService.setStopOrActive(mgrId);
		return "success";
	}
}
