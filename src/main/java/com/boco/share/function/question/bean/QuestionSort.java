/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "题目分类对象", description = "题目分类对象")
public class QuestionSort implements Serializable{
	
	private static final long serialVersionUID = -6716388284395038375L;

	@ApiModelProperty(value = "分类id")
	private String id;

	@ApiModelProperty(value = "分类编码")
	private String code;
	
	@ApiModelProperty(value = "分类名称")
	private String name;
	
	@ApiModelProperty(value = "排序")
	private int ord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}
	
	
}
