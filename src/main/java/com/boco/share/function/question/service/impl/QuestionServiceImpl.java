/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Hanzi;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.QuestionService;
import com.boco.share.function.util.PinYinUtil;
import com.mysql.fabric.xmlrpc.base.Array;

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

	@Override
	public List<Hanzi> getAllDuyin(Map<String, String> formMap) {
		String content = formMap.get("details");
		char[] contents = content.toCharArray();
		List<Hanzi> HanziList = new ArrayList<>();
		for(char c : contents) {
			String[] duyin = PinYinUtil.getPinyinBySingWord(c);
			Hanzi zi = new Hanzi(c,duyin);
			HanziList.add(zi);
		}		
		return HanziList;
	}

}
