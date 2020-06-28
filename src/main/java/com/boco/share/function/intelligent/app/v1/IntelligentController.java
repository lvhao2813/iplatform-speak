package com.boco.share.function.intelligent.app.v1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.function.intelligent.bean.Intelligent;
import com.boco.share.function.intelligent.service.inter.IntelligentService;

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
	public ModelAndView queryQuestion(@RequestParam  @ApiParam(hidden = true) Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/intelligent/list");

		List<Intelligent> queyQuestion = intelligentService.queyQuestion(formMap);
		mav.addObject("formMap", formMap);
		mav.addObject("resultList", queyQuestion);
		return mav;
	}
	
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "question", value = "问题名称", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sim", value = "阈值0~1", required = false),
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "top", value = "获取前几个", required = false)})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam  @ApiParam(hidden = true) Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/intelligent/list");
		mav.addObject("formMap", formMap);
		mav.addObject("resultList", null);
		return mav;
	}
}
