package com.boco.share.framework.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 占用内存小的集合类工具包
 * 
 * @author zyh
 */
public class CollectionUtil {

	/**
	 * Title: getHashMap
	 * Description: 缺省大小默认16
	 * @author RayLi
	 */
	public static <T> Map<T, T> getHashMap() {
		return getHashMap(16);
	}
	
	/**
	 * HashMap的大小规则是达到指定的大小75%就开始自增长，所以通过运算在增长值之前与所需大小一致
	 * 
	 * @param size
	 * @return hashMap
	 * @author zyh
	 */
	public static <T> Map<T, T> getHashMap(int size) {
		int length = (int) (size / 0.75 + 2);
		Map<T, T> hashMap = new HashMap<>(length);
		return hashMap;
	}
	
}
