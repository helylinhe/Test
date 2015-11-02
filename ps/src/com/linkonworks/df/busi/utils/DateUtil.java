package com.linkonworks.df.busi.utils;
/**
 *	Copyright (c) 2010-2020 www.tq365.cn
 *	Company：上海天擎信息技术有限公司 
 * 	Create Date:2011-6-16
 *  Author：lili
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 计算两个日期之间相隔天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDaysBetween(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		d1.setTime(date1);
		d2.setTime(date2);
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	public static String format2AdwordsTimestamp(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, -8);
		return format("yyyyMMdd HHmmss", c.getTime()) + " UTC";
	}
	public static String formatTime(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return format("yyyy-MM-dd HH:mm:ss", c.getTime());
	}
	/**
	 * 日期加天数得到新的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	/**
	 * 获取指定格式的日期字符串
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String format(String pattern, Date date) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}

	/**
	 * 获取指定日期的当月第一天的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		return c.getTime();
	}

	/**
	 * 根据时间字符串生成日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date newDate(String dateStr, String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		try {
			return f.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得当前系统时间，格式可以自定义
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String format) {
		Calendar day = Calendar.getInstance();// 当前系统日期//day.add(Calendar.DATE,
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String date = simpleDateFormat.format(day.getTime());
		return date;
	}

	/**
	 * 获得得系统当天日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return getCurrentTime("yyyy-MM-dd");
	}

	/**
	 * 获得系统以往的日期(yyyy-MM-dd)
	 * 
	 * @param days
	 * @return
	 */
	public static String getInsertDayDate(int days) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, -days);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(day.getTime());
	}

	/**
	 * 取得指定日期的月份起始日期
	 * @param weekday
	 * @return
	 */
	public static Date getMonthFirstDay(Date day){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(day);
		cal.add(cal.DATE, 1-cal.get(cal.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * 取得指定日期的月份结束日期
	 * @param weekday
	 * @return
	 */
	public static Date getMonthLastDay(Date day){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(day);
		int days = cal.getActualMaximum(cal.DAY_OF_MONTH);
		cal.add(cal.DATE, days-cal.get(cal.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * 取得指定日期的星期起始日期(星期一开始)
	 * @param weekday
	 * @return
	 */
	public static Date getWeekFirstDay(Date weekday){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(weekday);
		if(cal.get(cal.DAY_OF_WEEK)==1){//sunday
			cal.add(cal.DATE, -6);
		}else{
			cal.add(cal.DATE, 2-cal.get(cal.DAY_OF_WEEK));
		}
		return cal.getTime();
	}
	/**
	 * 取得指定日期的星期结束日期(星期一开始)
	 * @param weekday
	 * @return
	 */
	public static Date getWeekLastDay(Date weekday){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(weekday);
		int days = cal.getActualMaximum(cal.DAY_OF_WEEK);
		if(cal.get(cal.DAY_OF_WEEK)==1){//sunday
			cal.add(cal.DATE, 0);
		}else{
			cal.add(cal.DATE, days-cal.get(cal.DAY_OF_WEEK)+1);
		}
		return cal.getTime();
	}
	public static void main(String[] args) {
		// 1324425600000
		/*Calendar c = Calendar.getInstance();
		// c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 21);
		// System.out.println(c.getTimeInMillis());
		// c.setTimeInMillis(1324425600000L);
		c.setTimeInMillis(1324446337625L);
		System.out.println(DateUtil.format("yyyy-MM-dd", c.getTime()));*/
		
		System.out.println(formatTime(new  Date()));
	}

}
