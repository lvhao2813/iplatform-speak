/**
 * 
 */
package com.boco.share.function.question.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boco.share.function.common.bean.Attachment;
import com.boco.share.function.common.bean.AttachmentUnit;
import com.boco.share.function.common.bean.Sort;
import com.boco.share.function.question.bean.Chinese;
import com.boco.share.function.question.bean.ChineseUnit;
import com.boco.share.function.question.bean.Question;
import com.boco.share.function.question.bean.QuestionDetail;
import com.boco.share.function.question.bean.exam.Exam;

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

	/**
	 * 通过 question_id 查询所有的 question_detail_id
	 * @return
	 */
	public List<String> queryDetialIdByQuestId(@Param("deleteId")String deleteId);
	
	/**
	 * 通过  DetailId 删除 chinese_unit 表记录
	 * @return
	 */
	public void deleteUnitByDetailId(List<String> deleteDetailIds);
	
	/**
	 * 通过 question_id 删除  question_detail 表记录
	 * @return
	 */
	public void deleteDetailByQuetionId(@Param("deleteId") String deleteId);
	
	/**
	 * 通过 question_id 删除 question 记录
	 * @return
	 */
	public void deleteQuestionById(@Param("deleteId") String deleteId);
	
	/**
	 * 通过 question_id 查询question对象
	 * @return
	 */
	public Question queryQuestionById(@Param("questionId") String questionId);
	
	
	/**
	 * 通过 chinese_unid_id 修改 chinese_id
	 */
	public void updateChineseUnit(Map<String, String> formMap);
	
	/**
	 * 新增 attachment_unit
	 */
	public void saveAttachmentUnit(AttachmentUnit unit);
	
	/**
	 * 新增 attachment
	 */
	public void saveAttachment(Attachment attachment);

	/**
	 * 给Chinese表单 attachment_unit_id 列更新数据
	 * @param formMap
	 */
	public void addChineseAttUnitId(Map<String, String> formMap);
	
	/**
	 * 通过attachment_unit_id 获取单个attachment记录
	 * @return 
	 */
	public Attachment queryAttachByUnitId(@Param("unitId") String unitId);
	
	/**
	 * 通过 chineseId 获取对应的 attachment_unit_id
	 */
	public String queryAttachUnitIdByChineseId(@Param("chineseId") String chineseId);
	
	/**
	 * 通过id 删除 Attachment_unit表
	 */
	public void deleteAttachUnitById(@Param("Id") String Id);
	
	/*
	 * 通过 attachmentUnitId 删除 attachment表记录
	 */
	public void deleteAttachByUnitId(@Param("attachmentUnitId") String attachmentUnitId);
	
	/**
	 * 查询所有练习
	 */
	public List<Exam> loadExams(Map<String, String> formMap);
	
	/**
	 *  通过 sortId 查出所有的Question
	 */
	public List<Question> queryQuestionsBySort(@Param("sortId") String sortId);
	
	/**
	 * 根据 选择的题目id 生成 测试题
	 */
	public void saveExam(Exam exam);
	
	/**
	 * 根据id 删除测试题
	 */
	public void deleteExamById(@Param("deleteId")String deleteId);
	
	/**
	 * 根据id 批量删除测试题
	 */
	public void batchDeleteExams(String[] deleteIds);
	
	/**
	 * 根据 id 查找 exam
	 * @param Id
	 * @return
	 */
	public Exam queryExamById(@Param("Id")String Id);
	
	/**
	 * 查询汉字列表 通过 ids
	 */
	public List<Chinese> queryChineseListByIds(List<String> chineseIds);
}
