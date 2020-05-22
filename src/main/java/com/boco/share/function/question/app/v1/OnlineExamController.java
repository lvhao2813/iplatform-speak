package com.boco.share.function.question.app.v1;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.pagination.Pagination;
import com.boco.share.function.question.bean.ApiQuestion;
import com.boco.share.function.question.bean.Exam;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.service.inter.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "在线测试相关接口")
@RestController
@RequestMapping("/api/v1/onlineExam")
public class OnlineExamController {
	
	@Autowired
	private QuestionService questionService;
	
	@ApiOperation(value = "查询测试列表")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "name", value = "测试名称", required = false) })
	@RequestMapping(value = "/queryExam",method = RequestMethod.GET)
	public ModelAndView queryExam(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {

		PageHelper.startPage(pagination.getCurrentPageNum(), pagination.getPageCount());
		List<Exam> resultList = questionService.loadExams(formMap);

		PageInfo<Exam> pageInfo = new PageInfo<Exam>(resultList);
		pagination.setTotalCount(pageInfo.getTotal());
		pagination.setTotalPageNum(pageInfo.getPages());

		ModelAndView modelAndView = new ModelAndView("function/questions/onlineexam/list");
		modelAndView.addObject("resultList", resultList);
		modelAndView.addObject("pagination", pagination);
		modelAndView.addObject("formMap", formMap);
		
		modelAndView.addObject("questionSort", questionService.queryQuestionSorts());
		return modelAndView;
	}

	@ApiOperation(value = "新增跳转页")
	@RequestMapping(value = "/insertpage", method = RequestMethod.GET)
	public ModelAndView insertPage(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/questions/onlineexam/insert");
		List<Question> singleQuestions = questionService.queryQuestionsBySort("1");
		List<Question> multiQuestions = questionService.queryQuestionsBySort("2");
		List<Question> essayQuestions = questionService.queryQuestionsBySort("3");
		List<Question> topicQuestions = questionService.queryQuestionsBySort("11");
		mav.addObject("singleQuestions", singleQuestions);
		mav.addObject("multiQuestions", multiQuestions);
		mav.addObject("essayQuestions", essayQuestions);
		mav.addObject("topicQuestions", topicQuestions);
		return mav;
	}
	
	@ApiOperation(value = "新增测试")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "NAME", value = "测试名称", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "SINGLE_ID", value = "单字练习id", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "MULTI_ID", value = "词语练习id", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "ESSAY_ID", value = "短文练习id", required = true),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "TOPIC_ID", value = "命题练习id", required = true) })
	@RequestMapping(value = "/genExam", method = RequestMethod.POST)
	public void genQuestion(HttpServletRequest request, @RequestParam Map<String, String> formMap) throws Exception {
		questionService.genExam(formMap);
	}
	
	@ApiOperation(value = "删除跳转页")
	@RequestMapping("/deletepage")
	public ModelAndView deletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}
	
	@ApiOperation(value = "单个删除")
	@RequestMapping("/delete")
	@ResponseBody
	@ApiImplicitParams({
		@ApiImplicitParam(dataType = "String", paramType = "query", name = "deleteId", value = "删除题目id", required = true) })
	public void delete(@RequestParam Map<String, String> formMap) {
		questionService.deleteExamById(formMap.get("deleteId"));
	}
	
	@ApiOperation(value = "批量删除")
	@RequestMapping("batchDeletePage")
	public ModelAndView batchDeletePage(@RequestParam Map<String, String> formMap) {
		ModelAndView modelAndView = new ModelAndView("common/batch_delete");
		modelAndView.addObject("formMap", formMap);
		return modelAndView;
	}


	@RequestMapping("batchDelete")
	@ResponseBody
	public void batchDelete(String[] deleteIds) {
		questionService.batchDeleteExams(deleteIds);
	}
	
	@ApiOperation(value = "单字练习")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "type", value = "题目分类", required = true) })
	@RequestMapping(value = "/infoExam", method = RequestMethod.POST)
	public ModelAndView infoExam(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/questions/onlineexam/online");
		formMap.put("questionId", "80f5230987d14bf59861d15c40856b7e");
		ApiQuestion info = questionService.info(formMap);
		mav.addObject("question", info);
		return mav;
	}
	
}
