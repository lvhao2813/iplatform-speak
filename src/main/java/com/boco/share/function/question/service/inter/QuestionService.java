/**
 * 
 */
package com.boco.share.function.question.service.inter;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.ApiQuestion;
import com.boco.share.function.question.bean.Chinese;
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
	public List<Chinese> getAllChooseFromChinese(Map<String, String> formMap);
}
