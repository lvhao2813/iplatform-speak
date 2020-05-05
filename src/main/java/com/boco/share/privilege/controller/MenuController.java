package com.boco.share.privilege.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.function.transport.bean.TransportHttpBean;
import com.boco.share.privilege.service.inter.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * Title: PriMenuController
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@RestController
@RequestMapping("/privilege/menu")
public class MenuController extends BaseController {

	@Autowired
	public MenuService menuService;
	
	@ApiOperation(value = "获取菜单列表")
	@ResponseBody
	@RequestMapping(value = "/queryMenuList", method = RequestMethod.POST)
	public String queryMenuList() {
		return menuService.queryAllMenuList().toString();
	}

}
