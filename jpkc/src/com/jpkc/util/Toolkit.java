package com.jpkc.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 
 * 工具类
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 *
 */
public class Toolkit {

	/**
	 * 
	 * 获取当前时间毫秒 <br>
	 * 格式：13位数字 <br>
	 * 
	 * @return
	 * 
	 */
	public static String time() {
		return String.valueOf((new Date()).getTime());
	}

	/**
	 * 
	 * 获取随机数 <br>
	 * 格式：8位数字 <br>
	 * 
	 * @return
	 * 
	 */
	public static String random() {
		String r = String.valueOf((new Random()).nextDouble());
		return r.length() < 10 ? random() : r.substring(2, 10);
	}

	/**
	 * 
	 * 生成随机ID <br>
	 * 长度：32位 <br>
	 * 格式：t1234567890123_r1020304050607080 <br>
	 * 
	 * @return
	 * 
	 */
	public static String trId() {
		return "t".concat(time()).concat("_r").concat(random()).concat(random());
	}

	/**
	 * 
	 * 获取随机UUID值 <br>
	 * 长度：32位 <br>
	 * 格式：小写，无中划线（减号"-"） <br>
	 * 
	 * @return
	 * 
	 */
	public static String uuid() {
		return randomUUID().toLowerCase().replaceAll("-", "");
	}

	/**
	 * 
	 * 获取随机UUID值 <br>
	 * 长度：36位 <br>
	 * 
	 * @return
	 * 
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 
	 * 校验ID <br>
	 * 长度：数字1~18位 <br>
	 * 组成：数字 <br>
	 * 开头：1~9 <br>
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isId(String input) {
		return isNum(input, 1, 18);
	}

	/**
	 * 
	 * 校验数字 <br>
	 * 长度：数字 n 位 <br>
	 * 开头：1~9 <br>
	 * 
	 * @param input
	 * @param n
	 * @return
	 * 
	 */
	public static boolean isNum(String input, int n) {
		return isNum(input, n, n);
	}

	/**
	 * 
	 * 校验数字 <br>
	 * 长度：数字 n ~ m 位 <br>
	 * 开头：1~9 <br>
	 * 
	 * @param input
	 * @param n
	 * @param m
	 * @return
	 * 
	 */
	public static boolean isNum(String input, int n, int m) {
		if (input == null || n < 1 || m < 1 || n > m) {
			return false;
		}
		String regex = "[1-9][0-9]{" + --n + "," + --m + "}";
		return Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 校验数字 <br>
	 * 长度：数字 n 位 <br>
	 * 开头：0~9 <br>
	 * 
	 * @param input
	 * @param n
	 * @return
	 * 
	 */
	public static boolean isNumber(String input, int n) {
		return isNumber(input, n, n);
	}

	/**
	 * 
	 * 校验数字 <br>
	 * 长度：数字 n ~ m 位 <br>
	 * 
	 * @param input
	 * @param n
	 * @param m
	 * @return
	 * 
	 */
	public static boolean isNumber(String input, int n, int m) {
		if (input == null || n < 0 || m < 0 || n > m) {
			return false;
		}
		String regex = "[0-9]{" + n + "," + m + "}";
		return Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 校验数字 <br>
	 * 长度：不限
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isNumber(String input) {
		String regex = "[0-9]{1,}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 用户名校验 <br>
	 * 长度：3~32个字符<br>
	 * 组成：字母、数字或下划线<br>
	 * 开头：英文字母<br>
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isUsername(String input) {
		String regex = "[a-zA-Z][a-zA-Z0-9_]{2,31}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 密码校验 <br>
	 * 长度：3~32个字符<br>
	 * 组成：字母、数字或下划线<br>
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isPassword(String input) {
		return isWord(input, 3, 32);
	}

	/**
	 * 
	 * 校验QQ号码 <br>
	 * 长度：5~10数字<br>
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isQQ(String input) {
		String regex = "[1-9]{1}[0-9]{4,9}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 校验手机号码（单个）
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isMobile(String input) {
		String regex = "1[3-5,7,8][0-9]{9}$";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 校验任意字符长度 <br>
	 * 长度： n 位 <br>
	 * 
	 * @param input
	 * @param n
	 * @return
	 * 
	 */
	public static boolean length(String input, int n) {
		return length(input, n, n);
	}

	/**
	 * 
	 * 校验任意字符长度 <br>
	 * 长度： n ~ m 位 <br>
	 * 
	 * @param input
	 * @param n
	 * @param m
	 * @return
	 * 
	 */
	public static boolean length(String input, int n, int m) {
		if (input == null || n < 0 || m < 0 || n > m) {
			return false;
		}
		String regex = ".{" + n + "," + m + "}";
		return Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 匹配包括下划线的任何单词字符。 <br>
	 * 长度： n 位 <br>
	 * 
	 * @param input
	 * @param n
	 * @return
	 * 
	 */
	public static boolean isWord(String input, int n) {
		return isWord(input, n, n);
	}

	/**
	 * 
	 * 匹配包括下划线的任何单词字符。 <br>
	 * 长度： n ~ m 位 <br>
	 * 
	 * @param input
	 * @param n
	 * @param m
	 * @return
	 * 
	 */
	public static boolean isWord(String input, int n, int m) {
		if (input == null || n < 0 || m < 0 || n > m) {
			return false;
		}
		String regex = "[a-zA-Z0-9_]{" + n + "," + m + "}";
		return Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 匹配包括下划线的任何单词字符。 <br>
	 * 长度： 不限 <br>
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isWord(String input) {
		String regex = "[a-zA-Z0-9_]{1,}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 获取 Exception.printStackTrace() 内容
	 * 
	 * @param e
	 * @return
	 * 
	 */
	public static String getException(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		return sw.toString();
	}

	/**
	 * 
	 * 匹配日期，格式：yyyy-MM-dd
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isDate(String input) {
		String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 匹配时间，格式：HH:mm:ss
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isTime(String input) {
		String regex = "[0-9]{2}:[0-9]{2}:[0-9]{2}";
		return input == null ? false : Pattern.matches(regex, input);
	}

	/**
	 * 
	 * 校验字符串是否为空
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isEmpty(String input) {
		return input == null ? true : input.length() == 0;
	}

	/**
	 * 
	 * 校验字符串是否为空，忽略前导空白和尾部空白
	 * 
	 * @param input
	 * @return
	 * 
	 */
	public static boolean isTrimEmpty(String input) {
		return isEmpty(input) ? true : input.trim().length() == 0;
	}

	/**
	 * 
	 * 校验 values 是否包含 input 值，如果 input 为 null，否则返回 false
	 * 
	 * @param ignoreCase
	 *            是否忽略大小写
	 * @param input
	 *            进行比较的 String
	 * @param values
	 *            进行比较的 String 集合
	 * @return
	 * 
	 */
	public static boolean contains(boolean ignoreCase, String input, String... values) {
		if (input == null) {
			return false;
		}
		for (String value : values) {
			if (ignoreCase && input.equalsIgnoreCase(value)) { // 忽略大小写
				return true;
			}
			if (!ignoreCase && input.equals(value)) { // 区分大小写
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 校验数据字典key <br>
	 * 长度：1-64个字符<br>
	 * 组成：字母、数字或下划线且字母开头<br
	 * 
	 * @param key
	 * @return
	 */
	public static boolean isKey(String key) {
		String regex = "[a-zA-Z][a-zA-Z0-9_]{0,63}";
		return key == null ? false : Pattern.matches(regex, key);
	}

	/**
	 * 
	 * 转义字符实体
	 * 
	 * @param input
	 * @return
	 * 
	 * @see http://www.w3school.com.cn/html/html_entities.asp
	 * @see http://www.w3school.com.cn/tags/html_ref_entities.html
	 * 
	 */
	public static String escape(String input) {

		// [显示结果]-[描述]-[实体名称]-[实体编号]
		// [ ]-[空格]-[&nbsp;]-[&#160;]
		// [<]-[小于号]-[&lt;]-[&#60;]
		// [>]-[大于号]-[&gt;]-[&#62;]
		// [&]-[和号]-[&amp;]-[&#38;]
		// ["]-[引号]-[&quot;]-[&#34;]
		// [']-[撇号 ]-[&apos;]-[&#39;]
		// [￠]-[分]-[&cent;]-[&#162;]
		// [£]-[镑]-[&pound;]-[&#163;]
		// [¥]-[日圆]-[&yen;]-[&#165;]
		// [€]-[欧元]-[&euro;]-[&#8364;]
		// [§]-[小节]-[&sect;]-[&#167;]
		// [©]-[版权]-[&copy;]-[&#169;]
		// [®]-[注册商标]-[&reg;]-[&#174;]
		// [™]-[商标]-[&trade;]-[&#8482;]
		// [×]-[乘号]-[&times;]-[&#215;]
		// [÷]-[除号]-[&divide;]-[&#247;]

		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll("\"", "&quot;");
		input = input.replaceAll("'", "&apos;");
		input = input.replaceAll(" ", "&nbsp;");
		return input;

	}

	public static void main(String[] args) {
		System.out.println(isNum("123", 1, 3));
		System.out.println(isNumber("123", 0, 3));
		System.out.println(length("一二三", 0, 3));
		System.out.println(isWord("abc", 0, 3));
	}

}
