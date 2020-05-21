package com.boco.share.framework.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

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
	
	/**
	 * 传入的时间是否 比当天时间小
	 * @param oneDate
	 * @return
	 */
	public static boolean isVipOverTime(String oneDate){
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1 = null;
		try {
			date1 = df.parse(oneDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return date1.before(new Date());
    }
	
	/**
	 * 传入的时间 增加天数后返回
	 * @param oneDate
	 * @return
	 */
	public static String timeAddDay(String time, Integer addCount) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = null;
		    String result = "";
			try {
				if(!StringUtils.isEmpty(time)) {
					date = df.parse(time);
				}else {
					date = new Date();
				}
				
				Calendar cl = Calendar.getInstance();
	            cl.setTime(date);
	            cl.add(Calendar.DATE, addCount);
	            result = df.format(cl.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return result;
	}
	
	/**
	 *  获取当前时间 数字字符串格式
	 * @param oneDate
	 * @return
	 */
	public static String getNowDateNum() {
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(now);
	}
}
