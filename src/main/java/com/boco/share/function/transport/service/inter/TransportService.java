/**
 * 
 */
package com.boco.share.function.transport.service.inter;

import com.boco.share.function.transport.bean.TransportHttpBean;

/**
 * @author lv
 *
 */
public interface TransportService {

	/**
	 * 根据传入参数，获取数据包数据，传输
	 * 
	 * @param transportHttpBean
	 * @return
	 */
	public String getHttpDatas(TransportHttpBean transportHttpBean);
}
