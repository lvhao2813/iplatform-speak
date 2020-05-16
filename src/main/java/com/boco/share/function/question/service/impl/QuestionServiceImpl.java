/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.QuestionService;

/**
 * @author LOVE
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper mapper;

	@Override
	public List<Sort> queryQuestionSorts() {
		return mapper.queryQuestionSorts();
	}
	
	@Override
	public List<Question> loadQuestions(Map<String, String> formMap){
		return mapper.loadQuestions(formMap);
	}

}
