/**
 * 
 */
package com.boco.share.function.question.bean;

import io.swagger.annotations.ApiModel;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "前段题目详情，字对象", description = "前段题目详情，字对象")
public class ApiChineseDetail {

	private String chineseUnitId;

	private String chineseId;

	private String chinese;

	private String pinyin;

	public String getChineseUnitId() {
		return chineseUnitId;
	}

	public void setChineseUnitId(String chineseUnitId) {
		this.chineseUnitId = chineseUnitId;
	}

	public String getChineseId() {
		return chineseId;
	}

	public void setChineseId(String chineseId) {
		this.chineseId = chineseId;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

}
