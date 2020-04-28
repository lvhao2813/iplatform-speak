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

import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.service.inter.IPriOptService;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* <p>Title: PriOptController</p>  
* <p>Description: 操作管理类</p>  
* @author RayLLi  
* @date 2018年8月27日
 */
@Controller
@RequestMapping("/privilege/opt")
public class PriOptController extends BaseController {

	@Autowired
	public IPriOptService priOptService;

	@RequestMapping("query")
	public ModelAndView queryMenu(@RequestParam Map<String, String> formMap, @ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<Map<String, String>> resultList = priOptService.queryOpt(formMap);

		// 取分页信息
		PageInfo<Map<String, String>> pageInfo = new PageInfo<Map<String, String>>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView mav = new ModelAndView("privilege/opt/list");
		mav.addObject("resultList", resultList);
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);

		return mav;
	}

	@RequestMapping("insertpage")
	public ModelAndView insertPage(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("privilege/opt/add");
		mav.addObject("formMap", formMap);
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public void addMenu(@RequestParam Map<String, String> formMap, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		formMap.put("OPT_ID", UniqueIDGenerator.getUUID());
		formMap.put("CREATED_BY", priManager.getUserCode());

		priOptService.insert(formMap);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap) {
		List<Map<String, String>> currentOptList = priOptService.queryOpt(formMap);

		ModelAndView mav = new ModelAndView("privilege/opt/update");
		if (currentOptList != null && currentOptList.size() > 0) {
			mav.addObject("resultMap", currentOptList.get(0));
		}
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void updateMenu(@RequestParam Map<String, String> formMap, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		formMap.put("UPDATED_BY", priManager.getUserCode());
		priOptService.update(formMap);
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
		priOptService.delete(formMap.get("deleteId"));
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
		priOptService.batchDelete(deleteIds);
	}
	
	@RequestMapping("setIsStop")
	@ResponseBody
	public String setIsStop(String optId) {
		priOptService.setIsStop(optId);
		return "success";
	}

}
