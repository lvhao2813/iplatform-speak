package com.boco.share.function.intelligent.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.function.intelligent.bean.Intelligent;

public interface IntelligentService {

	/**
	 * 保存问题
	 * 
	 * @param question
	 */
	public void saveQuestion(Map<String, String> formMap);

	public List<Intelligent> queyQuestion(Map<String, String> formMap);

	public String answerInfo(Map<String, String> formMap);

}
