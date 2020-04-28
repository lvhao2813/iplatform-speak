package com.boco.share.privilege.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* <p>Title: PriRoleBean</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
public class PriRoleBean implements Serializable {

	/** serialVersionUID*/  
	private static final long serialVersionUID = -4918488488549896781L;

	private String roleId;

	private String roleName;

	private String description;

	private String status;

	private String remark;

	private Date updatedDt;

	private String updatedBy;

	private Date createdDt;

	private String createdBy;

	private String isDeleted;

	private BigDecimal version;

	private String parentId;

	private String topParentId;

	private String topParentName;

	private String orgId;

	private String orgName;

	private String roleLevel;

	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getTopParentId() {
		return topParentId;
	}

	public void setTopParentId(String topParentId) {
		this.topParentId = topParentId;
	}

	public String getTopParentName() {
		return topParentName;
	}

	public void setTopParentName(String topParentName) {
		this.topParentName = topParentName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}