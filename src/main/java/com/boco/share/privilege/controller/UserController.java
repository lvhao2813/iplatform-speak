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

import com.boco.share.framework.constants.ConfigContants;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.service.inter.UserService;
import com.boco.share.privilege.util.LoginConstants;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author lv
 *
 */
@Controller
@RequestMapping("/privilege/user")
public class UserController extends BaseController implements LoginConstants, PrivilageConstants, ConfigContants {

	@Autowired
	private UserService userService;

	@RequestMapping("query")
	public ModelAndView queryManagerList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<User> resultList = userService.loadUsers(formMap);

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

	@RequestMapping("add")
	@ResponseBody
	public void insert(@ModelAttribute(value = "User") User user, HttpSession session) {
		userService.insert(user);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "User") User user) {
		User result = userService.getUserById(formMap);
		ModelAndView mav = new ModelAndView("privilege/manager/update");
		mav.addObject("User", result);
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void update(User user) {
		userService.update(user);
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
		userService.deleteUser(formMap.get("deleteId"));
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
		userService.batchDeleteUsers(deleteIds);
	}

}
