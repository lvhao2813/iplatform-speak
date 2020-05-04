package com.boco.share.privilege.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author li970
 *
 */

@ApiModel(value = "角色对象", description = "角色对象")
public class Role {

	@ApiModelProperty(value = "角色id")
	private String id;

	@ApiModelProperty(value = "角色名称")
	private String name;

	@ApiModelProperty(value = "角色描述")
	private String description;

	@ApiModelProperty(value = "角色描述")
	private String status;

	@ApiModelProperty(value = "角色编码")
	private String code;

	public Role() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Role(String id, String name, String description, String status, String code) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.code = code;
	}

}
