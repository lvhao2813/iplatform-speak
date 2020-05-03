package com.boco.share.privilege.controller;

import java.util.HashMap;
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

import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriMenuBean;
import com.boco.share.privilege.service.inter.MenuService;
import com.boco.share.privilege.service.inter.IPriOptService;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* <p>Title: PriMenuController</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
@Controller
@RequestMapping("/privilege/menu")
public class MenuController extends BaseController {

	@Autowired
	public MenuService priMenuService;

	@Autowired
	public IPriOptService priOptService;

	@RequestMapping("query")
	public ModelAndView queryMenu(@RequestParam Map<String, String> formMap, @ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<PriMenuBean> resultList = priMenuService.queryMenuListByLevel(formMap);

		// 取分页信息
		PageInfo<PriMenuBean> pageInfo = new PageInfo<PriMenuBean>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView mav = new ModelAndView("privilege/menu/list");
		mav.addObject("resultList", resultList);
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);

		return mav;
	}

	@RequestMapping("insertpage")
	public ModelAndView insertPage(@RequestParam Map<String, String> formMap, @ModelAttribute(value = "priMenuBean") PriMenuBean priMenuBean) {
		List<PriMenuBean> menuList = priMenuService.queryMenuListByLevel(formMap);

		ModelAndView mav = new ModelAndView("privilege/menu/add");
		mav.addObject("priMenuBean", priMenuBean);
		mav.addObject("menuList", menuList);
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public void addMenu(@RequestParam Map<String, String> formMap, @ModelAttribute(value = "priMenuBean") PriMenuBean priMenuBean, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		formMap.put("MENU_ID", priMenuBean.getParentId());
		List<PriMenuBean> parentList = priMenuService.queryMenu(formMap);
		if (parentList != null && parentList.size() > 0) {
			priMenuBean.setMenuLevel(((PriMenuBean) parentList.get(0)).getMenuLevel() + 1);
		} else {
			priMenuBean.setMenuLevel(PrivilageConstants.TOP_MENU_LEVEL);
		}

		priMenuBean.setMenuId(UniqueIDGenerator.getUUID());
		priMenuBean.setCreatedBy(priManager.getUserCode());
		priMenuBean.setUpdatedBy(priManager.getUserCode());

		priMenuService.insertMenu(priMenuBean);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap) {
		List<PriMenuBean> currentMenuList = priMenuService.queryMenu(formMap);

		List<PriMenuBean> menuList = priMenuService.queryMenuListByLevel(null);

		ModelAndView mav = new ModelAndView("privilege/menu/update");
		if (currentMenuList != null && currentMenuList.size() > 0) {
			mav.addObject("priMenuBean", currentMenuList.get(0));
		}
		mav.addObject("menuList", menuList);
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void updateMenu(@ModelAttribute(value = "priMenuBean") PriMenuBean priMenuBean, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		priMenuBean.setUpdatedBy(priManager.getUserCode());

		Map<String, String> formMap = new HashMap<String, String>(16);
		formMap.put("MENU_ID", priMenuBean.getParentId());
		List<PriMenuBean> parentList = priMenuService.queryMenu(formMap);
		if (parentList != null && parentList.size() > 0) {
			priMenuBean.setMenuLevel(((PriMenuBean) parentList.get(0)).getMenuLevel() + 1);
		} else {
			priMenuBean.setMenuLevel(1);
		}

		priMenuService.updateMenu(priMenuBean);
	}

	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("delete")
	@ResponseBody
	public void deleteMenu(@RequestParam Map<String, String> formMap) {
		priMenuService.deleteMenu(formMap.get("deleteId"));
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
		priMenuService.batchDelete(deleteIds);
	}

	@RequestMapping("gotoSelectOptPage")
	public ModelAndView gotoSelectOptPage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("privilege/menu/select_opt");

		List<Map<String, String>> resultList = priMenuService.querySelectOptByMenuId(formMap.get("MENU_ID"));

		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("menuSelectedOpt")
	@ResponseBody
	public void menuSelectedOpt(HttpSession session, String menuId, String[] checkedIds) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		priMenuService.menuSelectedOpt(menuId, checkedIds, priManager.getUserCode());
	}
	
	/**
	 * <p>Title: setIsHome</p>  
	 * <p>Description: 设置首页的方式改为 角色绑定gotoSelectRolePage() v1.1版本该方法过时</p>  
	 * @param menuId
	 * @return
	 */
	@RequestMapping("setIsHome")
	@ResponseBody
	@Deprecated
	public String setIsHome(String menuId) {
//		priMenuService.setIsHome(menuId);
		return "success";
	}
	
	@RequestMapping("gotoSelectRolePage")
	@ResponseBody
	public ModelAndView gotoSelectRolePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("privilege/menu/select_role");

		Map<String, String> outRoleMap = new HashMap<String, String>(16);
		outRoleMap.put("MENU_ID", formMap.get("MENU_ID"));
		outRoleMap.put("ROLE_NAME", formMap.get("OUT_ROLE_NAME"));
		modelAndView.addObject("outRoleList", priMenuService.listSelectWithOutRole(outRoleMap));

		Map<String, String> inRoleMap = new HashMap<String, String>(16);
		inRoleMap.put("MENU_ID", formMap.get("MENU_ID"));
		inRoleMap.put("ROLE_NAME", formMap.get("IN_ROLE_NAME"));
		modelAndView.addObject("inRoleList", priMenuService.listSelectWithInRole(inRoleMap));
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}
	
	@RequestMapping("selectedRole")
	@ResponseBody
	public String selectedRole(HttpSession session, String menuId, String[] checkedIds) {
		priMenuService.updateHomeRole(menuId, checkedIds);
		return "success";
	}
	

}
