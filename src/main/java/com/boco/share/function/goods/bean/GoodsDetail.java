/**
 * 
 */
package com.boco.share.function.goods.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "商品明细对象", description = "商品明细对象")
public class GoodsDetail implements Serializable {

	private static final long serialVersionUID = -7752318396423270133L;

	@ApiModelProperty(value = "商品明细id")
	private String id;

	@ApiModelProperty(value = "全真测试次数")
	private Integer execFrequency;

	@ApiModelProperty(value = "套餐时间天数")
	private Integer effectiveTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getExecFrequency() {
		return execFrequency;
	}

	public void setExecFrequency(Integer execFrequency) {
		this.execFrequency = execFrequency;
	}

	public Integer getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Integer effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

}
