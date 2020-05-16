/**
 * 
 */
package com.boco.share.function.question.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.boco.share.framework.common.UuidUtil;
import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Chinese;
import com.boco.share.function.question.bean.ChineseUnit;
import com.boco.share.function.question.bean.Hanzi;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.QuestionDetail;
import com.boco.share.function.question.dao.QuestionMapper;
import com.boco.share.function.question.service.inter.QuestionService;
import com.boco.share.function.util.PinYinUtil;

/**
 * @author LOVE
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper mapper;

//	private static final Map<String, Chinese> chineses = new HashMap<String, Chinese>();

	@Override
	public List<Sort> queryQuestionSorts() {
		return mapper.queryQuestionSorts();
	}

	@Override
	public List<Question> loadQuestions(Map<String, String> formMap) {
		return mapper.loadQuestions(formMap);
	}

	@Override
	@Transactional
	public void genQuestion(Map<String, String> formMap) {
		// 保存题目对象
		Question question = new Question();
		question.setId(UuidUtil.genUUID());
		question.setName(formMap.get("name"));
		question.setCreateDate(new Date());
		question.setSortId(formMap.get("type"));
		mapper.saveQuestion(question);
		// 保存题目分组明细
		String type = formMap.get("type");
		switch (type) {
		case "1":
			saveSingleDetail(question.getId(), formMap.get("details"));
			break;
		case "2":

			break;
		case "3":

			break;
		default:
			break;
		}
	}

	/**
	 * 保存单字题目
	 * 
	 * @param questionId 问题对象id
	 * @param content    题目内容
	 */
	private void saveSingleDetail(String questionId, String content) {
		// 题目分隔单个中文
		char[] contents = content.toCharArray();
		String[] chinesePinyin = PinYinUtil.getPinyinByWord(content);
		// 题目内容分类明细
		List<QuestionDetail> details = new ArrayList<QuestionDetail>();
		// 明细对应的汉字包
		List<ChineseUnit> units = new ArrayList<ChineseUnit>();
		for (int i = 0; i < contents.length; i++) {
			String word = String.valueOf(contents[i]);

			QuestionDetail detail = new QuestionDetail();
			String detailId = UuidUtil.genUUID();
			detail.setId(detailId);
			detail.setQuestionId(questionId);
			detail.setWord(word);
			detail.setOrd(i + 1);

			// 对应单字，一个detail就是一个字，对应的汉字包也是一个
			ChineseUnit unit = new ChineseUnit();
			unit.setId(UuidUtil.genUUID());
			unit.setQuestionsDetailId(detailId);
			unit.setOrd(1);
			unit.setChineseId(getOneChineseId(word, chinesePinyin[i]));
			units.add(unit);
			details.add(detail);
		}
		mapper.saveQuestionDetails(details);
		mapper.saveChineseUnits(units);
	}

	/**
	 * 获取单个汉字的id
	 * 
	 * @param hanziAndPy 汉字 拼音
	 * @return chinese对象id
	 */
	private String getOneChineseId(String hanzi, String pinyin) {
		String hzAndPy = hanzi + "_" + pinyin;
		String chineseId = mapper.getOneChineseId(hzAndPy);
		if (!StringUtils.isEmpty(chineseId)) {
			return chineseId;
		} else {
			chineseId = UuidUtil.genUUID();
			Chinese chinese = new Chinese();
			chinese.setId(chineseId);
			chinese.setChinese(hanzi);
			chinese.setPinyin(pinyin);
			chinese.setHzAndpy(hzAndPy);
			mapper.saveChines(chinese);

			return chineseId;
		}

	}

	/**
	 * 获取多个汉字的id
	 * 
	 * @param hanziAndPy 汉字+拼音 例如：中_zhong
	 * @return chinese对象id
	 */
	private List<String> getListChineseId(List<String> hanziAndPys) {
		// TODO 补充
		return null;
	}

}
