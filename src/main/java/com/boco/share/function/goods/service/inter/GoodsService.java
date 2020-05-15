/**
 * 
 */
package com.boco.share.function.goods.service.inter;

import java.util.List;
import java.util.Map;

import com.boco.share.function.goods.bean.Goods;

/**
 * @author lv
 *
 */
public interface GoodsService {

	/**
	 * 查询商品列表
	 * 
	 * @param formMap sortName 商品分类名称
	 * @return
	 */
	public List<Goods> queryGoods(Map<String, String> formMap);

	/**
	 * 购买商品后生效逻辑
	 * 
	 * @param formMap
	 * @return
	 */
	public void buyGoodsAvailable(Map<String, String> formMap);
}
