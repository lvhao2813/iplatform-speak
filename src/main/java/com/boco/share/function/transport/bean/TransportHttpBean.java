/**
 * 
 */
package com.boco.share.function.transport.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.boco.share.function.release.bean.ReleaseDetailBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "数据包传输数据，请求参数对象", description = "数据包传输数据，请求参数对象")
public class TransportHttpBean implements Serializable {

	private static final long serialVersionUID = -5985358826234808611L;

	@ApiModelProperty(value = "接口id")
	private String releaseId;

	@ApiModelProperty(value = "密码")
	private String token;
	
	@ApiModelProperty(value = "条件")
	private List<ReleaseDetailBean> condition = new ArrayList<ReleaseDetailBean>();

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<ReleaseDetailBean> getCondition() {
		return condition;
	}

	public void setCondition(List<ReleaseDetailBean> condition) {
		this.condition = condition;
	}

}
