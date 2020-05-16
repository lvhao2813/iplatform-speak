/**
 * 
 */
package com.boco.share.function.question.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Chinese;
import com.boco.share.function.question.bean.ChineseUnit;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.QuestionDetail;

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

	/**
	 * 保存题目
	 * 
	 */
	public void saveQuestion(Question question);

	/**
	 * 保存题目 内容分组 明细
	 * 
	 */
	public void saveQuestionDetails(List<QuestionDetail> details);

	/**
	 * 保存题目 内容分组 明细，对应的汉字包
	 * 
	 */
	public void saveChineseUnits(List<ChineseUnit> units);

	/**
	 * 保存汉字
	 * 
	 */
	public void saveChines(Chinese chinese);

	/**
	 * 获取单个中文id通过 汉字+拼音 例如：中_zhong
	 * 
	 */
	public String getOneChineseId(@Param("hanziAndPy") String hanziAndPy);

	/**
	 * 获取多个中文id通过 汉字+拼音 例如：中_zhong
	 * 
	 */
	public List<String> getListChineseId(List<String> hanziAndPy);

}
