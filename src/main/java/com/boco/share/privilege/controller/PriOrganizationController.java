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
import org.thymeleaf.util.StringUtils;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.framework.common.UniqueIDGenerator;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.framework.springmvc.BaseController;
import com.boco.share.privilege.bean.PriManagerBean;
import com.boco.share.privilege.bean.PriOrganizationBean;
import com.boco.share.privilege.service.inter.IPriOrganizationService;
import com.boco.share.privilege.util.PrivilageConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
* <p>Title: PriOrganizationController</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
@Controller
@RequestMapping("/privilege/org")
public class PriOrganizationController extends BaseController {
	
	@Autowired
	public IPriOrganizationService priOrganizationService;
	
	final String orgTypeColName = "ORG_TYPE";
	
	@RequestMapping("query")
	public ModelAndView queryOrg(@RequestParam Map<String, String> formMap, @ModelAttribute(value = "pagination") Pagination pagination) {
		if(StringUtils.isEmpty(formMap.get(orgTypeColName))) {
			formMap.put("ORG_TYPE", "1");
		}
		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<PriOrganizationBean> resultList = priOrganizationService.queryOrganization(formMap);
		
		// 取分页信息
		PageInfo<PriOrganizationBean> pageInfo = new PageInfo<PriOrganizationBean>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());
				
		ModelAndView mav = new ModelAndView("privilege/org/list");
		mav.addObject("resultList", resultList);
		mav.addObject("formMap", formMap);

		return mav;
	}
	
	@RequestMapping("insertpage")
	public ModelAndView insertPage(@RequestParam Map<String, String> formMap,@ModelAttribute(value = "priOrganizationBean") PriOrganizationBean priOrganizationBean) {
		List<PriOrganizationBean> orgtList = priOrganizationService.queryOrganization(formMap);
		
		ModelAndView mav = new ModelAndView("privilege/org/add");
		mav.addObject("orgtList", orgtList);
		mav.addObject("priOrganizationBean", priOrganizationBean);
		mav.addObject("formMap", formMap);
		return mav;
	}

	@RequestMapping("add")
	@ResponseBody
	public void addMenu(@RequestParam Map<String, String> formMap,@ModelAttribute(value = "PriOrganizationBean") PriOrganizationBean priOrganizationBean, HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);

		formMap.put("PARENT_ID", priOrganizationBean.getParentId());
		List<PriOrganizationBean> parentList = priOrganizationService.queryOrganization(formMap);
		if (parentList != null && parentList.size() > 0) {
			priOrganizationBean.setOrgLevel(((PriOrganizationBean) parentList.get(0)).getOrgLevel() + 1);
		} else {
			priOrganizationBean.setOrgLevel(1);
		}
		
		priOrganizationBean.setOrgId(UniqueIDGenerator.getUUID());
		priOrganizationBean.setCreatedBy(priManager.getUserCode());

		priOrganizationService.insertOrganization(priOrganizationBean);
	}

	@RequestMapping("updatepage")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap) {
		List<PriOrganizationBean> currentOrgList = priOrganizationService.queryOrganization(formMap);
		
		List<PriOrganizationBean> orgList = priOrganizationService.queryOrganization(CollectionUtil.getHashMap());
		

		ModelAndView mav = new ModelAndView("privilege/org/update");
		if (currentOrgList != null && currentOrgList.size() > 0) {
			mav.addObject("priOrganizationBean", currentOrgList.get(0));
		}
		mav.addObject("orgList", orgList);
		return mav;
	}

	@RequestMapping("update")
	@ResponseBody
	public void updateMenu(@ModelAttribute(value = "PriOrganizationBean") PriOrganizationBean priOrganizationBean,HttpSession session) {
		PriManagerBean priManager = (PriManagerBean) session.getAttribute(PrivilageConstants.PRI_MANAGER);
		priOrganizationBean.setUpdatedBy(priManager.getUserCode());
		
		Map<String, String> parentMap = new HashMap<String, String>(16);
		parentMap.put("ORG_ID", priOrganizationBean.getParentId());
		List<PriOrganizationBean> parentList = priOrganizationService.queryOrganization(parentMap);
		if (parentList != null && parentList.size() > 0) {
			priOrganizationBean.setOrgLevel(((PriOrganizationBean) parentList.get(0)).getOrgLevel() + 1);
		} else {
			priOrganizationBean.setOrgLevel(1);
		}
		
		priOrganizationService.updateOrganization(priOrganizationBean);
	}
	
	@RequestMapping("deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap",formMap);
		return modelAndView;
	}

	@RequestMapping("delete")
	@ResponseBody
	public void deleteMenu(@RequestParam Map<String, String> formMap) {
		priOrganizationService.delete(formMap.get("deleteId"));
	}
	
	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap",formMap);
		return modelAndView;
	}

	@RequestMapping("batchDelete")
	@ResponseBody
	public void batchDelete(String[] deleteIds) {
		priOrganizationService.batchDelete(deleteIds);
	}

}
