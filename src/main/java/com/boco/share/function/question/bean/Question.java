/**
 * 
 */
package com.boco.share.function.question.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */

@ApiModel(value = "题目对象", description = "问题对象")
public class Question implements Serializable {
	private static final long serialVersionUID = 4672939995708681821L;

	@ApiModelProperty(value = "题目id")
	private String id;

	@ApiModelProperty(value = "题目名称")
	private String name;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "分类id")
	private String sortId;

	@ApiModelProperty(value = "问题内容明细分组")
	private List<QuestionDetail> details = new ArrayList<QuestionDetail>();

	@ApiModelProperty(value = "语音附件包id")
	private String attachmentUnitId;

	private String formatDate;

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getAttachmentUnitId() {
		return attachmentUnitId;
	}

	public void setAttachmentUnitId(String attachmentUnitId) {
		this.attachmentUnitId = attachmentUnitId;
	}

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

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public List<QuestionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<QuestionDetail> details) {
		this.details = details;
	}

}
