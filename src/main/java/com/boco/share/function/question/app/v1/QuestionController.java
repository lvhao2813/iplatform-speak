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
import com.boco.share.privilege.bean.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
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

	@ApiOperation(value = "查询题目列表页面")
	@ResponseBody
	@RequestMapping(value = "/queryQuestionList", method = RequestMethod.POST)
	public ModelAndView queryQuestionList(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		ModelAndView mv = new ModelAndView("function/question/list");
		// 题目分类下拉框
		mv.addObject("questionSort", questionService.queryQuestionSorts());

		mv.addObject("formMap", formMap);

		return mv;
	}
	
	@ApiOperation(value = "查询题目列表")
	@ResponseBody
	@RequestMapping("query")
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

		return modelAndView;
	}

	

}
