package com.boco.share.framework.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title: i-courseWare<br>
 * Description:唯一ID生成类（UUID） 该ID生成器调用开源ID生成器JUG <br>
 * Create DateTime: 2009-11-3 下午05:45:47 <br>
 * CVS last modify person: RayLi <br>
 * CVS last modify DateTime: 2009-11-3 下午05:45:47 <br>
 * CVS last version: <br>
 * 
 * @author 李凌
 */
public class UniqueIDGenerator {
	
	public static void main(String[] args) {
		System.out.println(UniqueIDGenerator.getUUID());
		System.out.println(UniqueIDGenerator.getLongUUID());
	}

	public static String getUUID() {
		String uuid = java.util.UUID.randomUUID().toString();

		return uuid.replaceAll("-", "");
	}

	public static String getLongUUID() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String format = formatter.format(d);
		return format;
	}

}
