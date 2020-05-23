/**
 * 
 */
package com.boco.share.function.question.service.inter;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.ApiQuestion;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.exam.Exam;

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
	 * 
	 * @return
	 */
	public List<Question> loadQuestions(Map<String, String> formMap);

	/**
	 * 根据录入的题目内容，生成对应的题目
	 * 
	 * @param formMap type-题目分类,name-题目名称,details-题目内容
	 * @return
	 */
	public void genQuestion(Map<String, String> formMap, MultipartFile file) throws Exception;

	/**
	 * 根据题目id，查询详情
	 * 
	 * @param formMap questionId 题目id
	 * @return
	 */
	public ApiQuestion info(Map<String, String> formMap);

	/**
	 * 根据选定Id删除题目
	 * 
	 * @param deleteId 要删除的question id
	 */
	public void deleteQuestion(String deleteId);

	/**
	 * 批量删除题目
	 * 
	 * @param deleteId 要删除的 勾选的 question id
	 */
	public void batchDeleteQuestions(String[] deleteIds);
	
	/**
	 * 	通过单个单字，在 chinese 表中找到所有的候选读音
	 */
	public List<String> getAllChooseFromChinese(Map<String, String> formMap);
	
	/**
	 *  通过传来的 unitId 和 用户选择的读音，更正unit表对应关系
	 */
	public void changePinYin(Map<String, String> formMap);
	
	/**
	 * 	添加单字音频附件
	 */
	public void addSingleAttach(Map<String, String> formMap, MultipartFile file) throws Exception;
	
	/**
	 * 	查询所有测试题目
	 */
	public List<Exam> loadExams(Map<String, String> formMap);
	
	/**
	 * 按sort_ud 查询question
	 */
	public List<Question> queryQuestionsBySort( String sortId);
	
	/**
	 * 根据选择的题目，生成测试题目
	 * @param formMap
	 */
	public void genExam(Map<String, String> formMap);
	
	/**
	 * 根据 id 删除Exam
	 */
	public void deleteExamById(String deleteId);
	
	/**
	 * 批量删除测试题目
	 * @param deleteIds
	 */
	public void batchDeleteExams(String[] deleteIds);
	
	/**
	 * 通过exam 的id字段查找exam
	 */
	public Exam queryExamById(String Id);
}
