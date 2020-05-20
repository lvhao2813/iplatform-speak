/**
 * 
 */
package com.boco.share.function.question.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "前段题目详情，字对象", description = "前段题目详情，字对象")
public class ApiChineseDetail {

	@ApiModelProperty(value = "chinese_unit表id")
	private String chineseUnitId;

	@ApiModelProperty(value = "chineseId")
	private String chineseId;

	@ApiModelProperty(value = "每个汉字")
	private String chinese;

	@ApiModelProperty(value = "汉字对应拼音")
	private String pinyin;

	@ApiModelProperty(value = "拼音对应附件名称")
	private String attachmentName;

	@ApiModelProperty(value = "拼音对应附件路径")
	private String path;

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
