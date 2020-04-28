package com.boco.share.config;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;


/**
* Title: MybatisConfig 
* Description:   
* @author RayLLi  
* @date 2018年8月27日
 */
@Configuration
public class MybatisConfig {

	Log log = LogFactory.getLog(MybatisConfig.class);

	@Bean
	public PageHelper pageHelper() {
		log.info("=====MyBatisConfiguration.pageHelper()=====");
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		
		return pageHelper;
	}

}
