package com.boco.spss.function.intelligent.app.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.boco.spss.framework.pagination.Pagination;
import com.boco.spss.function.intelligent.bean.Intelligent;
import com.boco.spss.function.intelligent.service.inter.IntelligentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "智能客服相关接口")
@RestController
@RequestMapping("/api/v1/intelligent")
public class IntelligentController {

	@Autowired
	private IntelligentService intelligentService;

	@ApiOperation(value = "查询测试列表")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "question", value = "问题名称", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sim", value = "阈值0~1", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "top", value = "获取前几个", required = false)})
	@RequestMapping(value = "/queryQuestion", method = RequestMethod.GET)
	public ModelAndView queryQuestion(@RequestParam  @ApiParam(hidden = true) Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		ModelAndView mav = new ModelAndView("function/intelligent/list");
		List<Intelligent> resultList = null;
		if(!StringUtils.isEmpty(formMap.get("question"))) {
			List<Intelligent> queyQuestion = intelligentService.queyQuestion(formMap);
			pagination.setTotalCount(queyQuestion.size());
			pagination.setTotalPageNum(queyQuestion.size()/pagination.getPageCount());
			//查询开始条数
			int startNo = (pagination.getCurrentPageNum()-1)*pagination.getPageCount();
			if(startNo > queyQuestion.size()) {
				startNo = 0;
				pagination.setCurrentPageNum(1);
			}
			resultList=queyQuestion.subList(startNo, startNo + pagination.getPageCount() < queyQuestion.size() ? 
							startNo + pagination.getPageCount() : queyQuestion.size());
		} else {
			resultList = new ArrayList<>();
			
		}
		mav.addObject("formMap", formMap);
		mav.addObject("pagination", pagination);
		mav.addObject("resultList", resultList);
		return mav;
	}
	
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "question", value = "问题名称", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sim", value = "阈值0~1", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "top", value = "获取前几个", required = false)})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam  @ApiParam(hidden = true) Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		ModelAndView mav = new ModelAndView("function/intelligent/list");
		mav.addObject("formMap", formMap);
		mav.addObject("resultList", null);
		mav.addObject("pagination", pagination);
		return mav;
	}
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(dataType = "String", paramType = "query", name = "questionId", value = "问题ID", required = true)
	})
	@RequestMapping(value = "answerInfo", method = RequestMethod.GET)
	public ModelAndView answerInfo(@RequestParam  @ApiParam(hidden = true) Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/intelligent/info");
		String answerInfo = intelligentService.answerInfo(formMap);
		mav.addObject("answerInfo", answerInfo);
		return mav;
	}
}
