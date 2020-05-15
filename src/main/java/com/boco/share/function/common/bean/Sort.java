/**
 * 
 */
package com.boco.share.function.common.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "分类对象", description = "分类对象")
public class Sort implements Serializable {

	private static final long serialVersionUID = -3843196360754119437L;

	@ApiModelProperty(value = "分类id")
	private String id;

	@ApiModelProperty(value = "分类编码")
	private String code;

	@ApiModelProperty(value = "分类名称")
	private String name;

	@ApiModelProperty(value = "排序")
	private int ord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

}
