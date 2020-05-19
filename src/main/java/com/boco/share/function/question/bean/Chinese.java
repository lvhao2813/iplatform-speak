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
@ApiModel(value = "汉字码表", description = "汉字码表")
public class Chinese implements Serializable {
	private static final long serialVersionUID = 6654351202494111501L;

	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "中文汉字")
	private String chinese;

	@ApiModelProperty(value = "拼音")
	private String pinyin;

	@ApiModelProperty(value = "汉字+拼音，下划线分隔")
	private String hzAndpy;

	@ApiModelProperty(value = "附件名称")
	private String attachmentName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getHzAndpy() {
		return hzAndpy;
	}

	public void setHzAndpy(String hzAndpy) {
		this.hzAndpy = hzAndpy;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

}
