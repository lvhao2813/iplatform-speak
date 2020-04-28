package com.boco.share.privilege.bean;

import java.io.Serializable;
import java.util.Date;

/**
* <p>Title: PriOrganizationBean</p>  
* <p>Description: </p>  
* @author RayLLi  
* @date 2018年8月27日
 */
public class PriOrganizationBean implements Serializable {

	/** serialVersionUID*/  
	private static final long serialVersionUID = 3589409421750375612L;

	private String orgId;

	private String orgName;

	private String orgAbbreviation;

	private String childCount;

	private String allParentsId;

	private String treeParentsId;

	private String treeId;

	private int treeChdIndex;

	private String isFolder;

	private String orgType;

	private String orgTypeName;

	private Date updatedDt;

	private String updatedBy;

	private Date createdDt;

	private String createdBy;

	private String parentId;

	private int orgOrder;

	private String orgOrderName;

	private int orgLevel;

	private String orgLevelName;

	private String remark;

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

	public String getOrgAbbreviation() {
		return orgAbbreviation;
	}

	public void setOrgAbbreviation(String orgAbbreviation) {
		this.orgAbbreviation = orgAbbreviation;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	public String getAllParentsId() {
		return allParentsId;
	}

	public void setAllParentsId(String allParentsId) {
		this.allParentsId = allParentsId;
	}

	public String getTreeParentsId() {
		return treeParentsId;
	}

	public void setTreeParentsId(String treeParentsId) {
		this.treeParentsId = treeParentsId;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public int getTreeChdIndex() {
		return treeChdIndex;
	}

	public void setTreeChdIndex(int treeChdIndex) {
		this.treeChdIndex = treeChdIndex;
	}

	public String getIsFolder() {
		return isFolder;
	}

	public void setIsFolder(String isFolder) {
		this.isFolder = isFolder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getOrgOrder() {
		return orgOrder;
	}

	public void setOrgOrder(int orgOrder) {
		this.orgOrder = orgOrder;
	}

	public int getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(int orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getOrgTypeName() {
		return orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}

	public String getOrgOrderName() {
		return orgOrderName;
	}

	public void setOrgOrderName(String orgOrderName) {
		this.orgOrderName = orgOrderName;
	}

	public String getOrgLevelName() {
		return orgLevelName;
	}

	public void setOrgLevelName(String orgLevelName) {
		this.orgLevelName = orgLevelName;
	}

}
