package com.jpkc.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
*
* File: UtilConvertDate.java
*
* Description:
* 转换时间类型公有类
*
* Notes:UtilConvertDate.java 2015-4-9 by zhangyi
*/
public class UtilConverterDate {
	
	/**
	 * 字符串类型转日期
	 * @param dateStr String 
	 * @param converterDateStr String 
	 * @return Date
	 */
	public static Date converterDate(String dateStr,String converterDateStr){
		SimpleDateFormat dateformat = new SimpleDateFormat(converterDateStr);
		Date date = null;
		try {
			date = dateformat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期转字符串
	 * @param date Date
	 * @param converterDateStr String 
	 * @return
	 */
	public static String converterDateString(Date date,String converterDateStr){
		SimpleDateFormat dateformat = new SimpleDateFormat(converterDateStr);
		String dateStr = dateformat.format(date);
		return dateStr;
	}
	
	/**
	 * 系统当前时间
	 * @return String
	 */
	public static String currentDate2String(){
		Date date = new Date();
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return converterDateString(date,"yyyy-MM-dd");
	}
	
	public static String currentDate2String1(){
		Date date = new Date();
		return converterDateString(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	public static String currentDateTime2String(){
		Date date = new Date();
		return converterDateString(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * string日期转Timestamp
	 * @param String
	 * @return Timestamp
	 */
	public static Timestamp convertTimestamp(String time){
		Timestamp ts=null;
		try {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date11;
		date11 = df1.parse(time);
		String times = df1.format(date11);
		ts = Timestamp.valueOf(times);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return ts;
	}
	
	/**
	 * 系统当前时间
	 * @return Timestamp
	 */
	public static Timestamp getCurrentTimestamp(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return convertTimestamp(UtilConverterDate.converterDateString(date, df.format(new Date())));
		
	}
	
	/**
	 * 时间大小比较
	 * @param t1
	 * @param t2
	 * @return true / false
	 */
	public static boolean TimeCompare(String t1,String t2){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		    boolean flag=false;
			try {
				 Date d1 = df.parse(t1);
			     Date d2 = df.parse(t2);
			     long diff = d1.getTime() - d2.getTime();
			     if(diff>0){
			    	 flag = true;
			     }else{
			    	 flag = false;
			     }
		     } catch (ParseException e) {
					e.printStackTrace();
			}
		return flag;
	}
	
	
	public static void main(String[] args) {
		System.out.println(converterDateString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
	}
}
