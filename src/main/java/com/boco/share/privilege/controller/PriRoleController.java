package com.boco.share.privilege.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.bean.PriRoleBean;
import com.boco.share.privilege.service.inter.MenuService;
import com.boco.share.privilege.service.inter.IPriOrganizationService;
import com.boco.share.privilege.service.inter.IPriRoleService;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* Title: PriRoleController 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */


public class PriRoleController extends BaseController {

	@Autowired
	public IPriRoleService userRoleService;

	@Autowired
	public IPriOrganizationService priOrganizationService;

	@Autowired
	public MenuService priMenuService;

	@RequestMapping("query")
	public ModelAndView queryRoleList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<PriRoleBean> resultList = userRoleService.loadRole(formMap);

		PageInfo<PriRoleBean> pageInfo = new PageInfo<PriRoleBean>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView mav = new ModelAndView("privilege/role/list");
		mav.addObject("resultList", resultList);
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);

		return mav;
	}

	@RequestMapping("insertpage")
	public ModelAndView insertPage(@ModelAttribute(value = "priMenuBean") PriRoleBean priRoleBean) {
		ModelAndView mav = new ModelAndView("privilege/role/add");
		mav.addObject("priRoleBean", priRoleBean);
		return mav;
	}

	@RequestMapping("selectOrg")
	public ModelAndView selectOrg() {
		ModelAndView mav = new ModelAndView("privilege/role/select_org");

		Map<String, String> orgMap = CollectionUtil.getHashMap();
		orgMap.put("ORG_TYPE", "0");

		mav.addObject("orgList", priOrganizationService.queryOrganization(orgMap));
		return mav;
	}

	@RequestMapping("selectDepartment")
	public ModelAndView selectDepartment(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("privilege/role/select_department");

		formMap.put("ORG_TYPE", "0");

		mav.addObject("orgList", priOrganizationService.queryDepartmentByOrgId(formMap));
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public String addRole(@ModelAttribute(value = "PriRoleBean") PriRoleBean priRoleBean, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		priRoleBean.setRoleId(UniqueIDGenerator.getUUID());
		priRoleBean.setCreatedBy(priManager.getUserCode());

		userRoleService.insert(priRoleBean);

		return "success";
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "priMenuBean") PriRoleBean priRoleBean) {
		List<PriRoleBean> resultList = userRoleService.loadRole(formMap);

		ModelAndView mav = new ModelAndView("privilege/role/update");
		mav.addObject("priRoleBean", resultList.get(0));
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public String updateRole(@ModelAttribute(value = "PriRoleBean") PriRoleBean priRoleBean) {
		userRoleService.update(priRoleBean);

		return "success";
	}

	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String deleteRole(@RequestParam Map<String, String> formMap) {
		userRoleService.delete(formMap.get("deleteId"));
		return "success";
	}

	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	public String batchDelete(String[] deleteIds) {
		userRoleService.batchDelete(deleteIds);
		return "success";
	}

	@RequestMapping("setIsUse")
	@ResponseBody
	public String setIsUse(String roleId) {
		userRoleService.setIsUse(roleId);
		return "success";
	}

	@RequestMapping("gotoSelectMenuPage")
	public ModelAndView gotoSelectOptPage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("privilege/role/select_menu");

		List<PriMenuBean> resultList = null;//priMenuService.queryMenuListByLevel(formMap);

		List<Map<String, String>> optList = userRoleService.queryAllOptByMenuIds(formMap);

		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("optList", optList);
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("updateRoleMenuAndOpt")
	@ResponseBody
	public String updateRoleMenuAndOpt(HttpSession session, String roleId, String[] checkedMenuIds,
			String[] checkedOptIds) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		userRoleService.updateRoleMenuAndOpt(roleId, checkedMenuIds, checkedOptIds, priManager.getUserCode());
		return "success";
	}
	
	final String orgNameStr = "ORG_NAME";

	@RequestMapping("gotoSelectManagerPage")
	public ModelAndView gotoSelectManagerPage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		ModelAndView modelAndView = new ModelAndView("privilege/role/select_manager");

		List<String> queryOrg = userRoleService.queryOrg();
		modelAndView.addObject("orgGroup", queryOrg);

		if (StringUtils.isEmpty(formMap.get(orgNameStr))) {
			formMap.put(orgNameStr, "省公司");
		}

		Map<String, String> outRoleMap = CollectionUtil.getHashMap();
		outRoleMap.put("ROLE_ID", formMap.get("ROLE_ID"));
		outRoleMap.put("MGR_NAME", formMap.get("OUT_ROLE_NAME"));
		outRoleMap.put("ORG_NAME", formMap.get("ORG_NAME"));

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<PriManagerBean> resultList = userRoleService.querySelectManagerWithOutRoleId(outRoleMap);

		// 取分页信息
		PageInfo<PriManagerBean> pageInfo = new PageInfo<PriManagerBean>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("outRoleList", resultList);

		Map<String, String> inRoleMap = CollectionUtil.getHashMap();
		inRoleMap.put("ROLE_ID", formMap.get("ROLE_ID"));
		inRoleMap.put("MGR_NAME", formMap.get("IN_ROLE_NAME"));
		modelAndView.addObject("inRoleList", userRoleService.querySelectManagerWithRoleId(inRoleMap));
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("saveManagerRole")
	public ModelAndView saveManagerRole(HttpSession session, @RequestParam String roleId,
			@RequestParam(value="checkedIds", required = false) String[] checkedIds) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		userRoleService.updateManagerRole(roleId, checkedIds, priManager.getUserCode());
		Map<String, String> formMap = CollectionUtil.getHashMap();
		formMap.put("ROLE_ID", roleId);
		return gotoSelectManagerPage(formMap, new Pagination());
	}

	@RequestMapping("selectedMgr")
	@ResponseBody
	public String selectedMgr(HttpSession session, String roleId, String[] checkedIds) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		userRoleService.updateManagerRole(roleId, checkedIds, priManager.getUserCode());
		return "success";
	}

	@RequestMapping("gotoSelectTargetPage")
	public ModelAndView gotoSelectTargetPage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		ModelAndView mav = new ModelAndView("privilege/role/select_target");
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);
		return mav;
	}

	@RequestMapping("selectTarget")
	@ResponseBody
	public void selectTarget(String targetId, String roleId, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		userRoleService.selectTarget(targetId, roleId, priManager.getUserCode());
	}

}
