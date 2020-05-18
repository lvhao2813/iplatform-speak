/**
 * 
 */
package com.boco.share.function.goods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.share.framework.common.DateUtils;
import com.boco.share.function.goods.bean.Goods;
import com.boco.share.function.goods.dao.GoodsMapper;
import com.boco.share.function.goods.service.inter.GoodsService;
import com.boco.share.privilege.bean.UserAvailable;
import com.boco.share.privilege.dao.UserMapper;

/**
 * @author lv
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private UserMapper userMapper;

	private static String ISVIP = "1";

	@Override
	public List<Goods> queryGoods(Map<String, String> formMap) {
		return goodsMapper.queryGoods(formMap);
	}

	@Override
	public void buyGoodsAvailable(Map<String, String> formMap) {
		String userId = formMap.get("userId");
		String goodsId = formMap.get("goodsId");
		UserAvailable available = userMapper.queryUserAvailableByUserId(userId);
		Goods goods = goodsMapper.queryGoodsById(goodsId);

		// 如果是vip，则续费。如果不是vip则按生效套餐
		if (ISVIP.equals(available.getVip())) {

		} else {

		}

	}

	private void effectGoods(UserAvailable available, Goods goods) {
		if("package".equals(goods.getSort().getCode())) {
			
		}else if("book".equals(goods.getSort().getCode())) {
			
		}
	}

	private void genVip(UserAvailable available, Goods goods) {
		if (available == null) {
			available = new UserAvailable();
		}
		Integer day = 0;
		if("1".equals(goods.getId())) {
			day = 360;
		}else if("2".equals(goods.getId())) {
			day = 90;
		}else if("3".equals(goods.getId())) {
			day = 30;
		}
		
		//如果会员到期或者当前不是会员
		if(!isVip(available)) {
			available.setExecFrequency(-1);
			available.setExecTime(DateUtils.timeAddDay(available.getExecTime(), day));
		}
		
	}

	private boolean isVip(UserAvailable available) {
		//如果是空的则为未充值对象
		if(available == null) {
			return false;
		}else {
			if("0".equals(available.getVip())) {
				return false;
			}else {
				return true;
			}
		}
	}
}
