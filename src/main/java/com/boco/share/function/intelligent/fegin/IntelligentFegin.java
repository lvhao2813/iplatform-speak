package com.boco.share.function.intelligent.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accessPlatform", url = "http://127.0.0.1:9040")
public interface IntelligentFegin {

	@RequestMapping(value = "/demo/test", method = RequestMethod.GET)

	String queryQuestionSimil(@RequestParam("question") String question, @RequestParam("sim") String sim,
			@RequestParam("top") String top);

}
