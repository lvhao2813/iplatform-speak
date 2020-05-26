package com.boco.share.privilege.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.service.inter.UserService;
import com.boco.share.privilege.util.PrivilageConstants;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController implements PrivilageConstants {

	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String login2(Map<String, Object> map, String loginMessage) {
		return "login";
	}

	/**
	 * 登陆
	 * 
	 * @param map
	 * @param loginMessage
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login(@RequestParam Map<String, String> formMap) {
		boolean isCheck = userService.checkLoginUser(formMap.get("username"), formMap.get("password"));
		ModelAndView mav = null;
		boolean error = false;
		if (isCheck) {
			mav = new ModelAndView("index");
			mav.addObject("user", userService.getUserByCode(formMap.get("username")));
		} else {
			mav = new ModelAndView("login");
			error = true;
		}
		mav.addObject("isCheck", error);
		return mav;
	}

	@RequestMapping("demo")
	public String demo() {
		return "demo";
	}

	@RequestMapping("outIndex")
	public String outIndex(Map<String, Object> map, HttpServletRequest request,
			@RequestParam Map<String, String> formMap) {
		HttpSession session = request.getSession();
		return "forward:" + (String) session.getAttribute(HOME_URL);
	}

	@RequestMapping("index")
	public ModelAndView index(Map<String, Object> map, HttpServletRequest request,
			@RequestParam Map<String, String> formMap) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("formMap", formMap);

		return mv;
	}

	@RequestMapping("home")
	public ModelAndView home(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

}
