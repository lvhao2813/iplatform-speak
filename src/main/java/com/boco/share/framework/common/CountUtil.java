package com.boco.share.framework.common;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * 计算工具
 * @author heng
 *
 */
public class CountUtil {
	
	/**
	 * 两个整数除法，转换为百分比
	 * @param a
	 * @param b
	 * @return
	 */
	public static String deciNum(int a, int b) {
		if(b == 0) {
			return "";
		}
		DecimalFormat df=new DecimalFormat("0.00");
		String format = df.format((float)a/b * 100) + "%";
		return format;
	}
	
	/**
	 * 两个浮点数除法，转换为百分比
	 * @param a
	 * @param b
	 * @return
	 */
	public static String deciNum(Float a, Float b) {
		if ( b == null || a == null || b == 0 ) {
			return "";
		}
		DecimalFormat df=new DecimalFormat("0");
		String format = df.format(a/b * 100) + "%";
		return format;
	}
	
	/**
	 * 格式化float类型为整数
	 * @param a
	 * @return
	 */
	public static String transfloat(Float a) {
		if(a == null) {
			return "";
		}
		DecimalFormat df=new DecimalFormat("0");
		String format = df.format(a);
		return format;
	}
	
	/**
	 * 获取当年年份
	 * @return
	 */
	public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
	}
	
	/**
	 * 获取当年月份
	 * @return
	 */
	public static String getSysMonth() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.MONTH));
        return year;
	}

}
