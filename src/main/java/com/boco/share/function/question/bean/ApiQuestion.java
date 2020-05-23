/**
 * 
 */
package com.boco.share.function.question.bean;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "前段题目概况", description = "前段题目概况对象")
public class ApiQuestion {

	@ApiModelProperty(value = "题目id")
	private String id;

	@ApiModelProperty(value = "题目名称")
	private String name;

	@ApiModelProperty(value = "创建时间")
	private String createDate;

	@ApiModelProperty(value = "分类名称")
	private String sortName;

	@ApiModelProperty(value = "题目全内容")
	private String content;
	
	@ApiModelProperty(value = "附件名称")
	private String attachmentName;
	
	@ApiModelProperty(value = "拼音对应附件路径")
	private String path;

	@ApiModelProperty(value = "题目details内容，用于存放后台所有details")
	private List<ApiQuestionDetail> details = new ArrayList<ApiQuestionDetail>();

	@ApiModelProperty(value = "题目details内容，用于存放后台所有汉字")
	private List<ApiChineseDetail> chineses = new ArrayList<ApiChineseDetail>();
	
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getContent() {
		return content;
	}

	public List<ApiChineseDetail> getChineses() {
		return chineses;
	}

	public void setChineses(List<ApiChineseDetail> chineses) {
		this.chineses = chineses;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ApiQuestionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ApiQuestionDetail> details) {
		this.details = details;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
