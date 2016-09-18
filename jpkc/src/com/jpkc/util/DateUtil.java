package com.jpkc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 日期工具类
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 */
public class DateUtil {

	/**
	 * 
	 * 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
	 * 
	 * @return 自 1970 年 1 月 1 日 00:00:00 GMT 以来此日期表示的毫秒数。
	 * 
	 */
	public static long getTime() {
		return (new Date()).getTime();
	}

	/**
	 * 
	 * 指定格式，测试此 date1 是否在 date2 之前
	 * 
	 * @param date1
	 * @param date2
	 * @param pattern
	 *            日期和时间格式的模式
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间早，才返回 true；否则返回 false。
	 */
	public static boolean before(String date1, String date2, String pattern) {
		Date d1 = parse(date1, pattern);
		Date d2 = parse(date2, pattern);
		return before(d1, d2);
	}

	/**
	 * 
	 * 指定格式，测试此 date1 是否在 date2 之后
	 * 
	 * @param date1
	 * @param date2
	 * @param pattern
	 *            日期和时间格式的模式
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间晚，才返回 true；否则返回 false。
	 * 
	 */
	public static boolean after(String date1, String date2, String pattern) {
		Date d1 = parse(date1, pattern);
		Date d2 = parse(date2, pattern);
		return after(d1, d2);
	}

	/**
	 * 
	 * 测试此 date1 是否在 date2 之前，默认格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date1
	 * @param date2
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间早，才返回 true；否则返回 false。
	 * @see #before(Date, Date)
	 * 
	 */
	public static boolean before(String date1, String date2) {
		Date d1 = toDate(date1);
		Date d2 = toDate(date2);
		return before(d1, d2);
	}

	/**
	 * 
	 * 测试此 date1 是否在 date2 之后，默认格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date1
	 * @param date2
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间晚，才返回 true；否则返回 false。
	 * @see #after(Date, Date)
	 * 
	 */
	public static boolean after(String date1, String date2) {
		Date d1 = toDate(date1);
		Date d2 = toDate(date2);
		return after(d1, d2);
	}

	/**
	 * 
	 * 测试此 date1 是否在 date2 之前。
	 * 
	 * @param date1
	 * @param date2
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间早，才返回 true；否则返回 false。
	 * 
	 */
	public static boolean before(Date date1, Date date2) {
		return date1.before(date2);
	}

	/**
	 * 
	 * 测试此 date1 是否在 date2 之后。
	 * 
	 * @param date1
	 * @param date2
	 * @return 当且仅当此 date1 对象表示的瞬间比 date2 表示的瞬间晚，才返回 true；否则返回 false。
	 * 
	 */
	public static boolean after(Date date1, Date date2) {
		return date1.after(date2);
	}

	/**
	 * 
	 * 字符串(String)转日期(Date)类型，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            日期字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @return 如果格式不匹配则返回Null
	 * 
	 */
	public static Date toDate(String date) {
		return parse(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String toStr() {
		return toStr(new Date());
	}

	/**
	 * 
	 * 日期(Date)转字符串(String)类型，格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 * 
	 */
	public static String toStr(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * 将一个 Date 格式化为日期/时间字符串
	 * 
	 * @param date
	 *            要格式化为时间字符串的时间值
	 * @param pattern
	 *            日期和时间格式的模式
	 * @return 已格式化的时间字符串
	 * 
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 
	 * 从给定字符串的开始解析文本，以生成一个日期。
	 * 
	 * @param date
	 *            String 类型的日期
	 * @param pattern
	 *            日期和时间格式的模式
	 * @return 解析字符串得到的 Date。
	 * 
	 */
	public static Date parse(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}
