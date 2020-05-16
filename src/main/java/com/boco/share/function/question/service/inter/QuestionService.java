/**
 * 
 */
package com.boco.share.function.question.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Hanzi;
import com.boco.share.function.question.bean.Question;

/**
 * @author LOVE
 *
 */
public interface QuestionService {
	/**
	 * 查询题目分类列表
	 * 
	 * @return
	 */
	public List<Sort> queryQuestionSorts();
	
	/**
	 * 查询所有题目
	 * @return
	 */
	public List<Question> loadQuestions(Map<String, String> formMap);
	
	/**
	 * 通过formMap中的details 传来的字，得到其所有可能的读音。
	 * @param formMap
	 * @return
	 */
	public List<Hanzi> getAllDuyin(Map<String, String> formMap);

}
