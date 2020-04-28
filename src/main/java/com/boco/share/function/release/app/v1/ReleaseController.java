package com.boco.share.function.release.app.v1;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.framework.pagination.Pagination;
import com.boco.share.function.release.bean.DataSetBean;
import com.boco.share.function.release.bean.ReleaseDataBean;
import com.boco.share.function.release.bean.ReleaseLog;
import com.boco.share.function.release.bean.ReleaseTempBean;
import com.boco.share.function.release.service.inter.ReleaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * Title: ReleaseController
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author xinxiaofei
 * @date 2020年4月22日
 */
@RestController
@RequestMapping("/api/v1/release")
public class ReleaseController {
	@Autowired
	private ReleaseService releaseService;

	/**
	 * 查询发布列表
	 * @param formMap
	 * @param pagination
	 * @return
	 */
	@RequestMapping("query")
	public ModelAndView queryReleaseList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<ReleaseDataBean> resultList= releaseService.queryReleaseDataBeanList();
		// 取分页信息
		PageInfo<ReleaseDataBean> pageInfo = new PageInfo<ReleaseDataBean>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());
		ModelAndView mav = new ModelAndView("function/release/list");
		mav.addObject("resultList", resultList);
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);
		return mav;
	}

	/**
	 * 获取发布详情
	 * @param formMap
	 * @return
	 */
	@RequestMapping("info")
	public ModelAndView updatePage(@RequestParam Map<String, String> formMap) {
		JSONObject result = releaseService.queryReleaseDeatil(formMap);
		ModelAndView mav = new ModelAndView("function/release/info");
		mav.addObject("releaseDataBean", result.get("releaseDataBean"));
		mav.addObject("info", result.get("info"));
		return mav;
	}
	/**
	 * 获取发布日志
	 * @param formMap
	 * @param pagination
	 * @return
	 */
	@RequestMapping("log")
	public ModelAndView queryLog(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<ReleaseLog> resultList= releaseService.queryReleaseLogs(formMap);
		// 取分页信息
		PageInfo<ReleaseLog> pageInfo = new PageInfo<ReleaseLog>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());
		ModelAndView mav = new ModelAndView("function/release/log");
		mav.addObject("resultList", resultList);
		mav.addObject("pagination", pagination);
		mav.addObject("formMap", formMap);
		return mav;
	}
	@ApiOperation(value = "获取数据包列")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "dataSetTableName", value = "数据包表名称", required = true) })
	@RequestMapping(value = "queryDataSetColumnList", method = RequestMethod.POST)
	public ResponseEntity<List<DataSetBean>> queryDataSetColumnList(
			@RequestParam @ApiParam(hidden = true) Map<String, String> formMap) {
		return new ResponseEntity<>(releaseService.queryDataSetColumnList(formMap), HttpStatus.OK);
	}
	
	@ApiOperation(value = "发布URL")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "ReleaseDataBean", paramType = "query", name = "releaseDataBean", value = "发布数据", required = true) })
	@RequestMapping(value = "saveReleaseDataBean", method = RequestMethod.POST)
	public ResponseEntity<ReleaseTempBean> saveReleaseDataBean(
			HttpServletRequest request,
			@RequestBody @ApiParam(hidden = true) ReleaseDataBean releaseDataBean) {
		return new ResponseEntity<>(releaseService.saveReleaseDataBean(releaseDataBean), HttpStatus.OK);
	}

}
