package com.boco.share.function.intelligent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.boco.share.function.intelligent.bean.Intelligent;
import com.boco.share.function.intelligent.fegin.IntelligentFegin;
import com.boco.share.function.intelligent.service.inter.IntelligentService;

@Service
public class IntelligentServiceImpl implements IntelligentService {

	/*
	 * @Autowired private IntelligentMapper intelligentMapper;
	 */

	@Autowired
	private IntelligentFegin fegin;

	@Override
	public void saveQuestion(String question) {
//		intelligentMapper.saveQuestion(question);
	}

	@Override
	public List<Intelligent> queyQuestion(Map<String, String> formMap) {
		String queryQuestionSimil = fegin.queryQuestionSimil(formMap.get("question"), formMap.get("sim"),
				formMap.get("top"));
		List<Intelligent> parseArray = JSONObject.parseArray(queryQuestionSimil, Intelligent.class);
		return parseArray;
	}

}
