package com.clothes.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {
	private static SimpleDateFormat df;
	
	public static Timestamp getTimeStamp(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	public static Timestamp getTimeStamp(String time) {
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	public static String getYear(Date date) {
		df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}
	
	public static String getMonth(Date date) {
		df = new SimpleDateFormat("MM");
		return df.format(date);
	}
	
	public static String getDay(Date date) {
		df = new SimpleDateFormat("dd");
		return df.format(date);
	}
	
	public static Date getDate(String time) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(time);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String getDateStringForExcel(Date date) {
		df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return df.format(date);
	}
	
	public static String getDateString(Date date) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static String getValidTime(int month, String time) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = getDate(time);
		Calendar cr = Calendar.getInstance();
		cr.setTime(date);
		cr.add(Calendar.MONTH, month);
		return getDateString(cr.getTime());
	}
	
	public static String mathOneDay(String time, int day) {
		Date date = getDate(time);
		Calendar cr = Calendar.getInstance();
		cr.setTime(date);
		cr.add(Calendar.DAY_OF_MONTH, day);
		return getDateString(cr.getTime());
	}
	
	public static int compareTime(String time1, String time2) {
		df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(time1));
			c2.setTime(df.parse(time2));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c1.compareTo(c2);
	}
	
	public static String dateFileName(Date date) {
		df = new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}
	
	public static boolean checkValidTime(Date date) {
		long nowTime = getDateTimeInMillis(new Date());
		long endTime = getDateTimeInMillis(date)+86399000;
		if(endTime > nowTime) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Date getEndTime() {
		df = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = mathOneDay(df.format(new Date()), -1);
		return getDate(nowTime);
	}
	
	public static long getDateTimeInMillis(Date date){
		Calendar gCal = new GregorianCalendar();
        gCal.setTime(date);
        return gCal.getTimeInMillis();
	}
}
