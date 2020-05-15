/**
 * 
 */
package com.boco.share.function.goods.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lv
 *
 */
@ApiModel(value = "订单明细", description = "订单明细")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = -5596338788703664048L;

	@ApiModelProperty(value = "订单明细id")
	private String id;

	@ApiModelProperty(value = "数量")
	private BigDecimal quantity;

	@ApiModelProperty(value = "商品")
	private Goods goods;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
