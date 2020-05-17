/**
 * 
 */
package com.boco.share.function.question.app.v1;

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

import com.boco.share.framework.pagination.Pagination;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.service.inter.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author LOVE
 *
 */
@Api(tags = "题目相关接口")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@ApiOperation(value = "查询题目列表")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "name", value = "题目名称", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sortId", value = "分类id", required = false) })
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	public ModelAndView queryManagerList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<Question> resultList = questionService.loadQuestions(formMap);

		PageInfo<Question> pageInfo = new PageInfo<Question>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("function/questions/list");
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);
		
		modelAndView.addObject("questionSort", questionService.queryQuestionSorts());
		return modelAndView;
	}

	@ApiOperation(value = "新增跳转页")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "type", value = "题目分类", required = true) })
	@RequestMapping(value = "/insertpage", method = RequestMethod.GET)
	public ModelAndView insertPage(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/questions/insert");
		mav.addObject("type", formMap.get("type"));
		return mav;
	}

	@ApiOperation(value = "新增题目")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "type", value = "题目分类", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "name", value = "题目名称", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "details", value = "题目内容", required = true) })
	@RequestMapping(value = "/genQuestion", method = RequestMethod.POST)
	public void genQuestion(@RequestParam Map<String, String> formMap) {
		questionService.genQuestion(formMap);
	}
	
	@ApiOperation(value = "题目编辑页面")
	@ApiImplicitParams({
		@ApiImplicitParam(dataType = "String", paramType = "query", name = "questionId", value = "题目id", required = true)})
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public ModelAndView info(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/questions/info");
		mav.addObject("question", questionService.info(formMap));
		return mav;
	}

	@ApiOperation(value = "删除跳转页")
	@RequestMapping("/deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}
	
	@ApiOperation(value = "删除跳转页")
	@RequestMapping("/delete")
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(dataType = "String", paramType = "query", name = "deleteId", value = "题目id", required = true) })
	public void delete(@RequestParam Map<String, String> formMap) {
		questionService.deleteQuestion(formMap.get("deleteId"));
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
		questionService.batchDeleteQuestions(deleteIds);
	}
}
