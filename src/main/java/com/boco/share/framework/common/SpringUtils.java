package com.boco.share.framework.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
* <p>Title: SpringUtils</p>  
* <p>Description: 实现java类获取spring托管的service</p>  
* @author RayLLi  
* @date 2018年5月4日
* 
* 范例
* private static ISysDataService sysDataService =
* SpringUtils.getApplicationContext().getBean(SysDataServiceImpl.class);
 */
@Component
public class SpringUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtils.applicationContext == null) {
			SpringUtils.applicationContext = applicationContext;
		}
	}

	/**
	 *  获取applicationContext
	 * Title: getApplicationContext
	 * Description: 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 *  通过name获取 Bean.
	 * Title: getBean
	 * Description: 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 *  通过class获取Bean.
	 * Title: getBean
	 * Description: 
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	/**
	 *  通过name,以及Clazz返回指定的Bean
	 * Title: getBean
	 * Description: 
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		
		return getApplicationContext().getBean(name, clazz);
	}
}
