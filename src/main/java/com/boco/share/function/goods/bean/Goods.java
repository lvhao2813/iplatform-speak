/**
 * 
 */
package com.boco.share.function.goods.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.boco.share.function.common.bean.Sort;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "商品对象", description = "商品对象")
public class Goods implements Serializable {

	private static final long serialVersionUID = -8312383249382607083L;

	@ApiModelProperty(value = "商品id")
	private String id;

	@ApiModelProperty(value = "商品名称")
	private String name;

	@ApiModelProperty(value = "商品价格")
	private BigDecimal price;

	@ApiModelProperty(value = "商品单位")
	private String unit;

	@ApiModelProperty(value = "商品图片路径")
	private String image;

	@ApiModelProperty(value = "商品描述")
	private String desciption;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "全真测试次数")
	private Integer execFrequency;

	@ApiModelProperty(value = "套餐时间")
	private Integer effectiveTime;

	@ApiModelProperty(value = "分类")
	private Sort sort;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

}
