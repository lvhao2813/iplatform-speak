/**
 * 
 */
package com.boco.share.privilege.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.constants.ConfigContants;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.Role;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.service.inter.RoleService;
import com.boco.share.privilege.util.LoginConstants;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author li970
 *
 */
@Controller
@RequestMapping("/privilege/role")
public class RoleController extends BaseController implements LoginConstants, PrivilageConstants, ConfigContants{
	
	@Autowired
	private RoleService roleService;

	
	@RequestMapping("gotoSelectManagerPage")
	public ModelAndView gotoSelectManagerPage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		ModelAndView modelAndView = new ModelAndView("privilege/role/select_manager");

		//查询左侧,未绑定用户列表
		Map<String, String> outRoleMap = CollectionUtil.getHashMap();
		outRoleMap.put("ROLE_ID", formMap.get("ROLE_ID"));
		outRoleMap.put("MGR_NAME", formMap.get("OUT_ROLE_NAME"));

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<User> resultList = roleService.queryUserWithOutRoleId(outRoleMap);

		// 取分页信息
		PageInfo<User> pageInfo = new PageInfo<User>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("outRoleList", resultList);

		Map<String, String> inRoleMap = CollectionUtil.getHashMap();
		inRoleMap.put("ROLE_ID", formMap.get("ROLE_ID"));
		inRoleMap.put("MGR_NAME", formMap.get("IN_ROLE_NAME"));
		List<User> resultListRight = roleService.querySelectUserWithRoleId(inRoleMap);
		modelAndView.addObject("inRoleList", resultListRight);
		modelAndView.addObject("formMap", formMap);
		
		return modelAndView;
	}
	
	@RequestMapping("saveManagerRole")
	public ModelAndView saveManagerRole(HttpSession session, @RequestParam String roleId,
			@RequestParam(value="checkedIds", required = false) String[] checkedIds) {
		
		roleService.updateUserRole(roleId, checkedIds);
		
		Map<String, String> formMap = CollectionUtil.getHashMap();
		formMap.put("ROLE_ID", roleId);
		return gotoSelectManagerPage(formMap, new Pagination());
	}

	
	@RequestMapping("query")
	public ModelAndView queryRoleList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<Role> resultList = roleService.loadRoles(formMap);

		PageInfo<Role> pageInfo = new PageInfo<Role>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("privilege/role/list");
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);

		return modelAndView;
	}
	
	@RequestMapping("insertpage")
	public ModelAndView insertPage(@ModelAttribute(value = "Role") Role role) {
		ModelAndView mav = new ModelAndView("privilege/role/add");
		mav.addObject("Role", role);
		return mav;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public void insert(@ModelAttribute(value = "Role") Role role, HttpSession session) {
		roleService.insert(role);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "Role") Role role) {
		Role result = roleService.getRoleById(formMap);
		ModelAndView mav = new ModelAndView("privilege/role/update");
		mav.addObject("Role", result);
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void update(Role role) {
		roleService.update(role);
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
		roleService.deleteRole(formMap.get("deleteId"));
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
		roleService.batchDeleteRoles(deleteIds);
	}
}
