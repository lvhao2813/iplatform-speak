/**
 * 
 */
package com.boco.share.function.goods.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.boco.share.function.common.bean.Sort;
import com.boco.share.privilege.bean.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "订单对象", description = "订单对象")
public class Order implements Serializable {

	private static final long serialVersionUID = -8194672064208697025L;

	@ApiModelProperty(value = "商品id")
	private String id;

	@ApiModelProperty(value = "订单名称")
	private String name;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "分类")
	private Sort sort;

	@ApiModelProperty(value = "用户")
	private User user;

	private List<OrderDetail> details = new ArrayList<OrderDetail>();

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

}
