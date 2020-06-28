package com.boco.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 数据中心
 * 
 * @author
 *
 */

@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@EnableFeignClients
@ComponentScan(basePackages = { "com.boco.share" })
public class ShareApplication {

	private static String exception = "org.springframework.boot.devtools.restart.SilentExitExceptionHandler$SilentExitException";

	public static void main(String[] args) {
		try {
			SpringApplication.run(ShareApplication.class, args);
		} catch (Exception e) {
			if (!exception.equals(e.toString())) {
			}
		}
	}

}