/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boco.share.function.question.bean.QuestionSort;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.QuestionService;

/**
 * @author LOVE
 *
 */
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionMapper mapper;
	
	@Override
	public List<QuestionSort> queryQuestionSorts() {
		return mapper.queryQuestionSorts();
	}

}
