/**
 * 
 */
package com.boco.share.function.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.boco.share.function.goods.bean.Goods;

/**
 * @author lv
 *
 */
@Mapper
public interface GoodsMapper {

	/**
	 * 查询商品列表
	 * 
	 * @param formMap
	 * @return
	 */
	public List<Goods> queryGoods(Map<String, String> formMap);
	
	/**
	 * 查询商品 by id
	 * 
	 * @param goodsId
	 * @return
	 */
	public Goods queryGoodsById(String goodsId);
	
	/**
	 * 查询用户
	 * 
	 * @param formMap
	 * @return
	 */
	public List<Goods> queryUserAvailable(Map<String, String> formMap);

}
