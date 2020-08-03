package com.boco.spss.function.intelligent.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accessPlatform", url = "http://180.76.154.20:9040")
public interface IntelligentFegin {

	@RequestMapping(value = "/demo/test", method = RequestMethod.GET)
	String queryQuestionSimil(@RequestParam("question") String question, @RequestParam("sim") String sim,
			@RequestParam("top") String top);

}
