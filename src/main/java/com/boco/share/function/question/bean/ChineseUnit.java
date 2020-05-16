/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xp
 *
 */
@ApiModel(value = "汉字工具", description = "汉字工具表")
public class ChineseUnit implements Serializable{

	private static final long serialVersionUID = -9164558598539568966L;

	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "明细id")
	private String questionsDetailId;

	@ApiModelProperty(value = "汉字id")
	private String chineseId;

	@ApiModelProperty(value = "汉字排序")
	private int ord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionsDetailId() {
		return questionsDetailId;
	}

	public void setQuestionsDetailId(String questionsDetailId) {
		this.questionsDetailId = questionsDetailId;
	}

	public String getChineseId() {
		return chineseId;
	}

	public void setChineseId(String chineseId) {
		this.chineseId = chineseId;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

}
