/**
 * 
 */
package com.boco.share.privilege.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
public class UserAvailable {

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "是否会员")
	private String vip;

	@ApiModelProperty(value = "全真测试次数")
	private Integer execFrequency;

	@ApiModelProperty(value = "全真测试次数有效期")
	private String execTime;

	@ApiModelProperty(value = "在线学习有效期")
	private String lineEffectiveTime;

	@ApiModelProperty(value = "用户id")
	private String userId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public Integer getExecFrequency() {
		return execFrequency;
	}

	public void setExecFrequency(Integer execFrequency) {
		this.execFrequency = execFrequency;
	}

	public String getExecTime() {
		return execTime;
	}

	public void setExecTime(String execTime) {
		this.execTime = execTime;
	}

	public String getLineEffectiveTime() {
		return lineEffectiveTime;
	}

	public void setLineEffectiveTime(String lineEffectiveTime) {
		this.lineEffectiveTime = lineEffectiveTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
