package com.boco.share.function.release.bean;
/**
 * 发布接口 列条件 明细对象
 * 
 * @author lv
 *
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "接口信息，列条件 明细对象", description = "明细对象")
public class ReleaseDetailBean {

	@ApiModelProperty(value = "column明细id")
	private String id;

	@ApiModelProperty(value = "接口id")
	private String releaseId;

	@ApiModelProperty(value = "列名称")
	private String comments;

	@ApiModelProperty(value = "列编码")
	private String code;

	@ApiModelProperty(value = "列，表达式")
	private String condition;

	@ApiModelProperty(value = "列，值")
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
