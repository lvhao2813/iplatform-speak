package com.boco.share.privilege.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.function.transport.bean.TransportHttpBean;
import com.boco.share.privilege.bean.Menu;
import com.boco.share.privilege.bean.User;
import com.boco.share.privilege.service.inter.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
	@ApiOperation(value = "查询菜单列表")
	@ResponseBody
	@RequestMapping("query")
	public ModelAndView queryMenuList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<Menu> resultList = menuService.loadMenusFormat(formMap);

		PageInfo<Menu> pageInfo = new PageInfo<Menu>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("privilege/menu/list");
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);

		return modelAndView;
	}
	
	@ApiOperation(value = "新增菜单列表")
	@ResponseBody
	@RequestMapping("insertpage")
	public ModelAndView insertPage(@ModelAttribute(value = "Menu") Menu menu) {
		ModelAndView mav = new ModelAndView("privilege/Menu/add");
		List<Menu> menuList = menuService.loadMenus(null);
		/*for(int i=0;i<menuList.size();++i) {
			if(menuList.get(i).getIsLeaf().equals("1")) {
				menuList.remove(i);
				--i;
			}
		}*/
		mav.addObject("Menu", menu);
		mav.addObject("menuList", menuList);	
		return mav;
	}
	
	
	@RequestMapping("add")
	@ResponseBody
	public void insert(@ModelAttribute(value = "Menu") Menu menu, HttpSession session) {
		menuService.insert(menu);
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
		menuService.delete(formMap.get("deleteId"));
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
		menuService.batchDeleteMenus(deleteIds);
	}
	
	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "Menu") Menu menu) {
		ModelAndView mav = new ModelAndView("privilege/menu/update");
		Menu result = menuService.getMenuById(formMap);
		List<Menu> menuList = menuService.loadMenus(formMap);
		mav.addObject("Menu", result);
		mav.addObject("menuList", menuList);	
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void update(Menu menu) {
		menuService.update(menu);
	}


}
