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
@ApiModel(value = "前段题目详情对象", description = "问前段题目详情对象")
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

	@ApiModelProperty(value = "题目全内容，字对象")
	private List<ApiChineseDetail> details = new ArrayList<ApiChineseDetail>();

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

	public void setContent(String content) {
		this.content = content;
	}

	public List<ApiChineseDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ApiChineseDetail> details) {
		this.details = details;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

}
