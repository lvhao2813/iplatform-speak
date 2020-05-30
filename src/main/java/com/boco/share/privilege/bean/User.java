/**
 * 
 */
package com.boco.share.privilege.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LOVE
 *
 */
@ApiModel(value = "用户对象", description = "用户对象")
public class User {

	@ApiModelProperty(value = "用户id")
	private String id;

	@ApiModelProperty(value = "用户名称")
	private String name;

	@ApiModelProperty(value = "账户")
	private String code;

	@ApiModelProperty(value = "用户头像路径")
	private String headPath;

	@ApiModelProperty(value = "用户头像文件名称")
	private String headName;

	@ApiModelProperty(value = "电话")
	private String phone;

	@ApiModelProperty(value = "是否启用")
	private String activeFlag;

	@ApiModelProperty(value = "是否管理员")
	private String manager;

	@ApiModelProperty(value = "密码")
	private String passWord;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "描述")
	private String descrition;

	@ApiModelProperty(value = "用户权益对象")
	private UserAvailable userAvaliable;

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserAvailable getUserAvaliable() {
		return userAvaliable;
	}

	public void setUserAvaliable(UserAvailable userAvaliable) {
		this.userAvaliable = userAvaliable;
	}

}
