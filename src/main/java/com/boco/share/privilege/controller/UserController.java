/**
 * 
 */
package com.boco.share.privilege.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author lv
 *
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/privilege/user")
public class UserController extends BaseController implements LoginConstants, PrivilageConstants, ConfigContants {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "后台,查询用户列表")
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

	@ApiOperation(value = "后台,新增用户中转页")
	@RequestMapping("insertpage")
	public ModelAndView insertPage(@ModelAttribute(value = "User") User user) {
		ModelAndView mav = new ModelAndView("privilege/manager/add");
		mav.addObject("User", user);
		return mav;
	}

	@ApiOperation(value = "后台,新增用户")
	@RequestMapping("add")
	@ResponseBody
	public void insert(@ModelAttribute(value = "User") User user, HttpSession session) {
		userService.insert(user);
	}

	@ApiOperation(value = "后台,更新用户中转页")
	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "User") User user) {
		User result = userService.getUserById(formMap);
		ModelAndView mav = new ModelAndView("privilege/manager/update");
		mav.addObject("User", result);
		return mav;
	}

	@ApiOperation(value = "1前端and后端,更新用户")
	@RequestMapping("update")
	@ResponseBody
	public void update(@ApiParam(name = "user", value = "用户对象对象") User user) {
		userService.update(user);
	}

	@ApiOperation(value = "后台,删除用户中转页")
	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@ApiOperation(value = "后台,删除用户")
	@RequestMapping("delete")
	@ResponseBody
	public void delete(@RequestParam Map<String, String> formMap) {
		userService.deleteUser(formMap.get("deleteId"));
	}

	@ApiOperation(value = "后台,批量删除中专页")
	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@ApiOperation(value = "后台,批量删除用户")
	@RequestMapping("batchDelete")
	@ResponseBody
	public void batchDelete(String[] deleteIds) {
		userService.batchDeleteUsers(deleteIds);
	}

	@ApiOperation(value = "前台打开个人中心")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "id", value = "用户id", required = false) })
	@RequestMapping(value = "/personalpage", method = RequestMethod.GET)
	public ModelAndView personalpage(@RequestParam Map<String, String> formMap) {
		User user = userService.getUserById(formMap);
		ModelAndView mav = new ModelAndView("privilege/manager/personalpage");
		mav.addObject("user", user);
		return mav;
	}
	
	@ApiOperation(value = "上传/更改头像")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "userId", value = "用户id", required = true) })
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public void uploadImg(HttpServletRequest request, @RequestParam Map<String, String> formMap) throws Exception {
		MultipartFile file = null;
		if(request instanceof StandardMultipartHttpServletRequest) {
			file = ((StandardMultipartHttpServletRequest) request).getFile("file");
		}	
		userService.uploadImg(formMap, file);
		 
	}

}
