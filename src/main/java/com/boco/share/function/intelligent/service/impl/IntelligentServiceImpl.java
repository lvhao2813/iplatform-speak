package com.boco.share.function.intelligent.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.boco.share.function.intelligent.bean.Intelligent;
import com.boco.share.function.intelligent.dao.IntelligentMapper;
import com.boco.share.function.intelligent.fegin.IntelligentFegin;
import com.boco.share.function.intelligent.service.inter.IntelligentService;

@Service
public class IntelligentServiceImpl implements IntelligentService {

	
	@Autowired 
	private IntelligentMapper intelligentMapper;
	 

	@Autowired
	private IntelligentFegin fegin;
	
	private final String nullString = "{}[]";
	
	private final String threshold = "0.85";

	@Override
	public void saveQuestion(Map<String, String> formMap) {
		List<Map<String, String>> existQes = intelligentMapper.queryExistQes(formMap);
		if(existQes == null || existQes.size() == 0) {
			intelligentMapper.saveQuestion(formMap);
		}
	}

	@Override
	public List<Intelligent> queyQuestion(Map<String, String> formMap) {
		String question = formMap.get("question");
		String queryQuestionSimil = fegin.queryQuestionSimil(question, formMap.get("sim"),
				formMap.get("top"));
		if(!StringUtils.isEmpty(queryQuestionSimil) && !queryQuestionSimil.contains(nullString)) {
			List<Intelligent> parseArray = JSONObject.parseArray(queryQuestionSimil, Intelligent.class);
			String noAnswer = fegin.queryQuestionSimil(question, threshold, formMap.get("top"));
			if(StringUtils.isEmpty(noAnswer) || nullString.equals(noAnswer)) {
				saveQuestion(formMap);
			}
			return parseArray;
		} else {
			if(!StringUtils.isEmpty(question)) {
				saveQuestion(formMap);
			}
			return new ArrayList<>();
		}
	}

	@Override
	public String answerInfo(Map<String, String> formMap) {
		return intelligentMapper.answerInfo(formMap);
	}

}
