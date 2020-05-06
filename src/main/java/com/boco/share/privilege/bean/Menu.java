/**
 * 
 */
package com.boco.share.privilege.bean;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "菜单对象", description = "菜单对象")
public class Menu {

	@ApiModelProperty(value = "菜单id")
	private String id;

	@ApiModelProperty(value = "菜单父id")
	private String parentId;

	@ApiModelProperty(value = "菜单标题")
	private String title;

	@ApiModelProperty(value = "菜单连接")
	private String href;

	@ApiModelProperty(value = "菜单图标")
	private String icon;

	@ApiModelProperty(value = "菜单右侧图标")
	private String rightIcon;

	@ApiModelProperty(value = "菜单目标，默认:_self")
	private String target = "_self";

	@ApiModelProperty(value = "菜单等级")
	private String level;
	
	@ApiModelProperty(value = "编码")
	private String code;
	
	@ApiModelProperty(value = "菜单排序")
	private String ord;

	@ApiModelProperty(value = "子菜单")
	private List<Menu> child = new ArrayList<Menu>();
	
	@ApiModelProperty(value = "是否是叶子节点")
	private String isLeaf;
	
	@ApiModelProperty(value = "菜单描述")
	private String description;
	
	public String getIsLeaf() {
		return isLeaf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getOrd() {
		return ord;
	}

	public void setOrd(String ord) {
		this.ord = ord;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", parentId=" + parentId + ", title=" + title + ", href=" + href + ", icon=" + icon
				+ ", rightIcon=" + rightIcon + ", target=" + target + ", level=" + level + ", child=" + child + "]";
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRightIcon() {
		return rightIcon;
	}

	public void setRightIcon(String rightIcon) {
		this.rightIcon = rightIcon;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
