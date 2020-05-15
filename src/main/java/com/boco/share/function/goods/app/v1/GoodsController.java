/**
 * 
 */
package com.boco.share.function.goods.app.v1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boco.share.framework.pagination.Pagination;
import com.boco.share.function.goods.bean.Goods;
import com.boco.share.function.goods.service.inter.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author lv
 *
 */
@Api(tags = "商品相关接口")
@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@ApiOperation(value = "查询商品列表")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sortName", value = "商品分类名称，例如:套餐商品,普通商品,邮寄运费商品,教材商品", required = true) })
	@RequestMapping(value = "/queryGoods", method = RequestMethod.POST)
	public List<Goods> queryGoods(@RequestParam Map<String, String> formMap,
			@ModelAttribute(value = "pagination") Pagination pagination) {
		return goodsService.queryGoods(formMap);
	}
	
	@ApiOperation(value = "购买商品生效")
	@ApiImplicitParams({
			@ApiImplicitParam(dataType = "String", paramType = "query", name = "sortName", value = "商品分类名称，例如:套餐商品,普通商品,邮寄运费商品,教材商品", required = true) })
	@RequestMapping(value = "/buyGoodsAvailable", method = RequestMethod.POST)
	public String buyGoodsAvailable(@RequestParam Map<String, String> formMap) {
		return goodsService.buyGoodsAvailable(formMap);
	}

}
