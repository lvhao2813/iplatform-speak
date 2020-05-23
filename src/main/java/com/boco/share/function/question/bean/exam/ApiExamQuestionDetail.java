/**
 * 
 */
package com.boco.share.function.question.bean.exam;

import java.util.ArrayList;
import java.util.List;

import com.boco.share.function.question.bean.ApiChineseDetail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "测试题目词组or短文分类对象", description = "测试题目词组or短文分类对象")
public class ApiExamQuestionDetail {

	@ApiModelProperty(value = "单词or短文段落集合对象")
	private List<ApiChineseDetail> chinese = new ArrayList<ApiChineseDetail>();

	public List<ApiChineseDetail> getChinese() {
		return chinese;
	}

	public void setChinese(List<ApiChineseDetail> chinese) {
		this.chinese = chinese;
	}
	
	
}
