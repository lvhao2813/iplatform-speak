/**
 * 
 */
package com.boco.share.function.common.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
public class Attachment {
	private String id;

	@ApiModelProperty(value = "附件名称")
	private String name;

	@ApiModelProperty(value = "附件存储的本地目录")
	private String path;

	private String uploadDate;

	private String attachmentUnitId;

	private AttachmentUnit attachmentUnit;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getAttachmentUnitId() {
		return attachmentUnitId;
	}

	public void setAttachmentUnitId(String attachmentUnitId) {
		this.attachmentUnitId = attachmentUnitId;
	}

	public AttachmentUnit getAttachmentUnit() {
		return attachmentUnit;
	}

	public void setAttachmentUnit(AttachmentUnit attachmentUnit) {
		this.attachmentUnit = attachmentUnit;
	}

}
