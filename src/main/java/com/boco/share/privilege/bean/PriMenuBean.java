package com.boco.share.privilege.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class PriMenuBean implements Serializable {

	/** serialVersionUID*/  
	private static final long serialVersionUID = -4097947205286109031L;

	private String menuId;

	private String parentId;

	private String menuCode;

	private String menuName;

	private String lpadMenuName;

	private String optCount;

	private String allParentsId;

	private String treeParentsId;

	private String treeId;

	private String childCount;

	private String selectedMenu;

	private String description;

	private String menuLink;

	private BigDecimal isLeaf;

	private int menuLevel;

	private int menuOrd;

	private String status;

	private String remark;

	private String updatedDt;

	private String updatedBy;

	private Date createdDt;

	private String createdBy;

	private String isDeleted;

	private BigDecimal version;
	
	private String isHome;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getLpadMenuName() {
		return lpadMenuName;
	}

	public void setLpadMenuName(String lpadMenuName) {
		this.lpadMenuName = lpadMenuName;
	}

	public String getOptCount() {
		return optCount;
	}

	public void setOptCount(String optCount) {
		this.optCount = optCount;
	}

	public String getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(String selectedMenu) {
		this.selectedMenu = selectedMenu;
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

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public BigDecimal getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(BigDecimal isLeaf) {
		this.isLeaf = isLeaf;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public int getMenuOrd() {
		return menuOrd;
	}

	public void setMenuOrd(int menuOrd) {
		this.menuOrd = menuOrd;
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

	public String getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(String updatedDt) {
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

	public String getIsHome() {
		return isHome;
	}

	public void setIsHome(String isHome) {
		this.isHome = isHome;
	}
	
	
}