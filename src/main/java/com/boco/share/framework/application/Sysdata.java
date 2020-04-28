package com.boco.share.framework.application;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;

import com.boco.share.framework.common.SpringUtils;
import com.boco.share.privilege.service.impl.SysDataServiceImpl;
import com.boco.share.privilege.service.inter.ISysDataService;

/**
 * <p>
 * Description: 加载数据字典表
 * </p>
 * 
 * @author RayLLi
 * @date 2018年5月4日
 */
public class Sysdata {

	private Sysdata() {
	}

	private static Sysdata sysdata = null;

	private static ISysDataService sysDataService;

	private static ApplicationContext applicationContext;

	/**
	 *  静态工厂方法
	 * Title: getInstance
	 * Description: 
	 * @return
	 */
	public static Sysdata getInstance() {
		if (sysdata == null) {
			sysdata = new Sysdata();
		}
		return sysdata;
	}


	List<HashMap<String, String>> sysdataList = null;

	public List<HashMap<String, String>> getData() {
		if (sysdataList == null) {
			initData();
		}

		return sysdataList;
	}

	public void initData() {
		if (sysDataService == null){
			initSysdataService();
		}

		try {
			sysdataList = sysDataService.loadData();
		} catch (Exception e) {
		}
	}

	private void initSysdataService() {
		if (sysDataService == null) {
			applicationContext = SpringUtils.getApplicationContext();
			sysDataService = applicationContext.getBean(SysDataServiceImpl.class);
		}
	}

	public String getProperty(String typeCode, String code) {
		return getProperty(typeCode, code, false);
	}

	public String getProperty(String typeCode, String code, boolean isDescription) {
		if (sysdataList == null) {
			sysdataList = getData();
		}

		if (sysdataList != null) {
			for (HashMap<String, String> sysdata : sysdataList) {
				if (ObjectUtils.nullSafeToString(sysdata.get("TYPE_CODE")).equals(typeCode)) {
					if (ObjectUtils.nullSafeToString(sysdata.get("CODE")).equals(code)) {
						if (isDescription) {
							return ObjectUtils.nullSafeToString(sysdata.get("DESCRIPTION"));
						} else {
							return ObjectUtils.nullSafeToString(sysdata.get("NAME"));
						}
					}
				}
			}
		}

		return "";
	}

	public List<HashMap<String, String>> getSysData() {
		if (sysdataList == null) {
			initData();
		}
		return sysdataList;
	}

}
