/**
 * 
 */
package com.boco.share.function.pay.app.v1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boco.share.framework.common.CollectionUtil;
import com.boco.share.function.goods.bean.Goods;
import com.boco.share.function.goods.service.inter.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author lv
 *
 */
@Api(tags = "充值相关接口")
@RestController
@RequestMapping("/api/v1/pay")
public class PayController {

	@Autowired
	private GoodsService goodsService;

	@ApiOperation(value = "充值页面详情")
	@RequestMapping(value = "/payInfo", method = RequestMethod.GET)
	public ModelAndView payInfo() {
		ModelAndView mv = new ModelAndView("function/pay/info");
		Map<String, String> formMap = CollectionUtil.getHashMap();
		formMap.put("sortCode", "package");
		List<Goods> goods = goodsService.queryGoods(formMap);
		mv.addObject("goods", goods);
		mv.addObject("goodsSize", goods.size());
		return mv;
	}
}
