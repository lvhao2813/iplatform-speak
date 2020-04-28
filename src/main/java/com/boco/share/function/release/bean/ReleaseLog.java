/**
 * 
 */
package com.boco.share.function.release.bean;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "接口使用日志对象", description = "接口使用日志")
public class ReleaseLog {

	@ApiModelProperty(value = "日志id")
	private String id;

	@ApiModelProperty(value = "接口信息id")
	private String releaseId;

	@ApiModelProperty(value = "操作人")
	private String operator;

	@ApiModelProperty(value = "操作时间")
	private Date operDate;

	@ApiModelProperty(value = "使用数据条数")
	private String count;

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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
