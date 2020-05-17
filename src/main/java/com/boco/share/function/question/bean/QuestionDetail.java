/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "题目明细分组", description = "题目明细分组")
public class QuestionDetail implements Serializable {
	private static final long serialVersionUID = 1571266141403350297L;

	@ApiModelProperty(value = "题目明细id")
	private String id;

	@ApiModelProperty(value = "题目内容分组内容")
	private String word;

	@ApiModelProperty(value = "排序")
	private Integer ord;

	@ApiModelProperty(value = "问题id")
	private String questionId;

	@ApiModelProperty(value = "汉字")
	private List<ChineseUnit> details = new ArrayList<ChineseUnit>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public List<ChineseUnit> getDetails() {
		return details;
	}

	public void setDetails(List<ChineseUnit> details) {
		this.details = details;
	}

}
