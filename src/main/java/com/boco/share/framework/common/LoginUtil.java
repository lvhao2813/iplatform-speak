package com.boco.share.framework.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* <p>Title: LoginUtil</p>  
* <p>Description: 首页 显示当前日期</p>  
* @author RayLLi  
* @date 2018年5月24日
 */
public class LoginUtil {

	public static String getTodayFormat() {
		// 计算时间
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy年M月d日");
		Date d = new Date();
		String date = dateFm.format(d);
		String[] chars = new String[] { "日", "一", "二", "三", "四", "五", "六" };
		Calendar c = Calendar.getInstance();
		int dw = c.get(Calendar.DAY_OF_WEEK);
		String today = date + " 星期" + chars[dw - 1];
		return today;
	}
}
