/**
 * 
 */
package com.boco.share.function.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.function.common.bean.Sort;

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

}
