package com.boco.spss.function.intelligent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lv
 *
 */
@Mapper
public interface IntelligentMapper {

	/**
	 * 保存问题
	 * @param formMap
	 */
	public void saveQuestion(Map<String, String> formMap);

	public List<Map<String, String>> queryExistQes(Map<String, String> formMap);

	public String answerInfo(Map<String, String> formMap);
	
}
