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
import com.boco.share.privilege.service.inter.ISysDataService;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * Title: SysdataController
 * </p>
 * <p>
 * Description: 数据字典管理类
 * </p>
 * 
 * @author RayLLi
 * @date 2018年8月27日
 */
@Controller
@RequestMapping("/privilege/sysdata")
public class SysdataController extends BaseController {

	@Autowired
	public ISysDataService sysDataService;

	@RequestMapping("query")
	public ModelAndView querySysData(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<HashMap<String, String>> resultList = sysDataService.querySysData(formMap);

		// 取分页信息
		PageInfo<HashMap<String, String>> pageInfo = new PageInfo<HashMap<String, String>>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("sysdata/list");
		modelAndView.addObject("sysdataList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);

		return modelAndView;
	}

	@RequestMapping("insertpage")
	public String insertPage() {
		return "sysdata/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public void addSysData(@RequestParam Map<String, String> formMap, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		formMap.put("ID", UniqueIDGenerator.getUUID());
		formMap.put("CREATED_BY", priManager.getUserCode());

		sysDataService.insertSysData(formMap);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap) {
		List<HashMap<String, String>> resultList = sysDataService.querySysData(formMap);

		ModelAndView modelAndView = new ModelAndView("sysdata/update");
		if (resultList != null && resultList.size() > 0) {
			modelAndView.addObject("resultMap", resultList.get(0));
		}
		return modelAndView;
	}

	@RequestMapping("update")
	@ResponseBody
	public void updateSysData(@RequestParam Map<String, String> formMap) {
		sysDataService.updateSysData(formMap);

		ModelAndView modelAndView = new ModelAndView("redirect:/privilege/sysdata/query");
		modelAndView.addObject("formMap", formMap);
		modelAndView.addObject(formMap);
	}

	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("delete")
	@ResponseBody
	public void deleteSysData(@RequestParam Map<String, String> formMap) {
		sysDataService.deleteSysData(formMap.get("deleteId"));
	}

	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	public void batchDeleteSysData(String[] deleteIds) {
		sysDataService.batchDeleteSysData(deleteIds);
	}

	@RequestMapping("setReadOnly")
	@ResponseBody
	public String setReadOnly(String id) {
		sysDataService.setReadOnlyStatus(id);
		return "success";
	}

}
