/**
 * 
 */
package com.boco.share.function.question.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Question;

/**
 * @author LOVE
 *
 */
@Mapper
public interface QuestionMapper {

	/**
	 * 查询题目分类列表
	 * 
	 * @return
	 */
	public List<Sort> queryQuestionSorts();
	
	/**
	 * 查询所有题目
	 * 
	 */
	public List<Question> loadQuestions(Map<String, String> formMap);

}
