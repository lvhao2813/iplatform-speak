/**
 * 
 */
package com.boco.share.function.question.bean.exam;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "测试题目对象", description = "试题目对象")
public class ApiExamQuestion {

	@ApiModelProperty(value = "对应附件路径")
	private String path;

	@ApiModelProperty(value = "题目分类明细")
	private List<ApiExamQuestionDetail> details = new ArrayList<ApiExamQuestionDetail>();

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<ApiExamQuestionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ApiExamQuestionDetail> details) {
		this.details = details;
	}

}
