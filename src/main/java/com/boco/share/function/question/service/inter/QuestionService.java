/**
 * 
 */
package com.boco.share.function.question.service.inter;

import java.util.List;

import com.boco.share.function.question.bean.QuestionSort;

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
	public List<QuestionSort> queryQuestionSorts();
}
