package com.boco.share.framework.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.boco.share.framework.common.bean.SelectBean;

/**
 * 
 * @author zhouyuhua
 *
 */
public class DateUtils {

	
	public static List<SelectBean> getYearList(){
		
		List<SelectBean> yearList = new ArrayList<SelectBean>();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int a=2011;
		while(year>a) {
			
			yearList.add(new SelectBean(year+"", year+""));
			
			year--;
		};
		return yearList;
	}
	
	
	public static List<SelectBean> getMonthList(){
		
		List<SelectBean> monthList = new ArrayList<SelectBean>();
		
		int month = 1;
		int a=13;
		while(month<a) {
			
			monthList.add(new SelectBean(month+"", month+""));
			
			month++;
		};
		return monthList;
	}
	
	public static String getNowDate(){
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
	
}
