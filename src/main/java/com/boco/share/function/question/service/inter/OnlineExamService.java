/**
 * 
 */
package com.boco.share.function.question.service.inter;

import java.util.Map;

import com.boco.share.function.question.bean.exam.ApiExamQuestion;

/**
 * @author LOVE
 *
 */
public interface OnlineExamService {

	/**
	 * 根据题目id，查询详情
	 * 
	 * @param formMap questionId 题目id
	 * @return
	 */
	public ApiExamQuestion info(Map<String, String> formMap);

}
