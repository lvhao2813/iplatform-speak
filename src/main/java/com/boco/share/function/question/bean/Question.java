/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */

@ApiModel(value = "题目对象", description = "问题对象")
public class Question implements Serializable{
	private static final long serialVersionUID = 4672939995708681821L;

	@ApiModelProperty(value = "题目id")
	private String id;

	@ApiModelProperty(value = "题目名称")
	private String name;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "问题分类")
	private QuestionSort sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public QuestionSort getSort() {
		return sort;
	}

	public void setSort(QuestionSort sort) {
		this.sort = sort;
	}

}
