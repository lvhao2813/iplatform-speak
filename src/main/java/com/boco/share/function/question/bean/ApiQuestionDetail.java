package com.boco.share.function.question.bean;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "前端题目详情对象", description = "前端题目detail对象")
public class ApiQuestionDetail {
	
	@ApiModelProperty(value = "Detailid")
	private String id;

	@ApiModelProperty(value = "题目全内容，字对象 ")
	private List<ApiChineseDetail> chinese = new ArrayList<ApiChineseDetail>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ApiChineseDetail> getDetails() {
		return chinese;
	}

	public void setDetails(List<ApiChineseDetail> chinese) {
		this.chinese = chinese;
	}

}
