/**
 * 
 */
package com.boco.share.function.goods.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if(ISVIP.equals(available.getVip())) {
			
		}else {
			
		}
		
	}
	
	private void effectGoods(UserAvailable available, Goods goods) {
		switch (goods.getId()) {
		//年费
		case "1": 
			
			break;
		//季度
		case "2":
			break;
		//月度
		case "3":
			break;
		//在线学习
		case "4":
			break;
		//次数
		case "5":
			break;
		default:
			break;
		}
		
	}
	

}
