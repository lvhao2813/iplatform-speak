package com.boco.share.function.question.app.v1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.function.question.bean.ApiQuestion;
import com.boco.share.function.question.service.inter.QuestionService;

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
	
	@ApiOperation(value = "单字练习")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "type", value = "题目分类", required = true) })
	@RequestMapping(value = "/queryExam", method = RequestMethod.GET)
	public ModelAndView queryExam(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/questions/onlineexam/online");
		formMap.put("questionId", "80f5230987d14bf59861d15c40856b7e");
		ApiQuestion info = questionService.info(formMap);
		mav.addObject("question", info);
		return mav;
	}
	
}
