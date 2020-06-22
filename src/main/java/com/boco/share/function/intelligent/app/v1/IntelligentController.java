package com.boco.share.function.intelligent.app.v1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.function.intelligent.service.inter.IntelligentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "智能客服相关接口")
@RestController
@RequestMapping("/api/v1/intelligent")
public class IntelligentController {

	@Autowired
	private IntelligentService intelligentService;

	@ApiOperation(value = "查询测试列表")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "questionName", value = "问题名称", required = false) })
	@RequestMapping(value = "/queryQuestion", method = RequestMethod.GET)
	public ModelAndView queryQuestion(@RequestParam Map<String, String> formMap) {
		ModelAndView mav = new ModelAndView("function/intelligent/list");

		
		
		
		intelligentService.saveQuestion(formMap.get("questionName"));
		return mav;
	}
}
