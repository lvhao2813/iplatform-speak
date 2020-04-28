package com.boco.share.framework.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Title: InitApplicationData
 * </p>
 * <p>
 * Description: 项目启动预加载类
 * </p>
 * 
 * @author RayLLi
 * @date 2018年5月4日
 */
@Component
public class InitApplicationData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Sysdata.getInstance().initData();
	}

}
