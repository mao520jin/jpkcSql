package com.jpkc.util;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 校验类
 * 
 * @author zhangyi
 * @version 1.0, 2015-10-9
 * 
 */
public class VerifyUtil {

	public static void main(String[] args) {
		String a = null;
		String b = "null";
		String c = "";
		System.out.println(isEmpty(a) + "--" + isEmpty(b) + "--" + isEmpty(c));
	}

	/***
	 * 验证值是否是空
	 * 
	 * @param object
	 *            验证值
	 * @return 验证值是否是空
	 */
	@SuppressWarnings("unused")
	public static boolean isEmpty(Object object) {
		boolean isEmpty = false;

		if (object == null) {
			isEmpty = true;
		}
		// 验证字符串类型
		else if (object instanceof String) {
			String validatedObject = (String) object;
			if (validatedObject == null || "".equals(validatedObject)) {
				isEmpty = true;
			}
		}
		// 验证集合类型
		else if (object instanceof Collection) {
			@SuppressWarnings("unchecked")
			Collection<Object> validatedObject = (Collection<Object>) object;
			if (validatedObject == null || validatedObject.size() == 0) {
				isEmpty = true;
			}
		}
		// 验证Map类型
		else if (object instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<Object, Object> validatedObject = (Map<Object, Object>) object;
			if (validatedObject == null || validatedObject.size() == 0) {
				isEmpty = true;
			}
		}
		// 验证日期类型
		else if (object instanceof Date) {
			Date validatedObject = (Date) object;
			if (validatedObject == null) {
				isEmpty = true;
			}
		}
		// 验证日期类型
		else if (object instanceof Timestamp) {
			Timestamp validatedObject = (Timestamp) object;
			if (validatedObject == null) {
				isEmpty = true;
			}
		}
		// 验证Set类型
		else if (object instanceof Set) {
			@SuppressWarnings("unchecked")
			Set<Object> validatedObject = (Set<Object>) object;
			if (validatedObject == null || validatedObject.size() == 0) {
				isEmpty = true;
			}
		}

		return isEmpty;
	}

	/**
	 * 验证数组是否为空
	 * 
	 * @param object
	 *            对象数组
	 * @return
	 */
	public static boolean isEmpty(Object[] objects) {
		boolean isEmpty = false;

		if (objects == null || objects.length == 0) {
			isEmpty = true;
		}

		return isEmpty;
	}

	/***
	 * 校验用户名:不为空,不含特殊字符,长度控制
	 * 
	 * @param userName
	 * @return
	 */
	public static Map<String, String> verifyUserName(String userName) {
		boolean result = isEmpty(userName.replace(" ", ""));
		Map<String, String> map = new HashMap<String, String>();
		if (result) {
			map.put("code", "412");
			map.put("data", "用户名不能为空!");
			return map;
		}
		if (!userName.matches("^[A-Za-z0-9]+")) {
			map.put("code", "412");
			map.put("data", "用户名只能输入数字和字母!");
			return map;
		}
		if (userName.replace(" ", "").length() < 4 || userName.replace(" ", "").length() > 20) {
			map.put("code", "411");
			map.put("data", "用户名长度4-15有效!");
			return map;
		}
		map.put("code", "200");
		return map;
	}

	/***
	 * 校验密码:不为空，包含字母和数字，长度控制
	 * 
	 * @param passWord
	 * @return
	 */
	public static Map<String, String> verifyPassWord(String passWord) {
		boolean result = isEmpty(passWord.replace(" ", ""));
		Map<String, String> map = new HashMap<String, String>();
		if (result) {
			map.put("code", "412");
			map.put("data", "密码不能为空!");
			return map;
		}

		if (passWord.length() < 6 || passWord.length() > 20) {
			map.put("code", "411");
			map.put("data", "密码长度6-20位有效");
			return map;
		}

		if (!passWord.matches("^[A-Za-z0-9]+")) {
			map.put("code", "412");
			map.put("data", "密码只能输入数字和字母!");
			return map;
		}

		boolean status1 = false;
		boolean status2 = false;
		for (int i = 0; i < passWord.length(); i++) {
			if (Character.isDigit(passWord.charAt(i))) {
				status1 = true;
			}
			if (Character.isLetter(passWord.charAt(i))) {
				status2 = true;
			}
		}
		if (!status1 || !status2) {
			map.put("code", "412");
			map.put("data", "密码要同时包含数字和字母!");
			return map;
		}

		map.put("code", "200");
		return map;
	}

	/**
	 * 
	 * 校验QQ号码
	 * 
	 * @param qq
	 * @return
	 */
	public static Map<String, String> verifyQq(String qq) {
		boolean result = isEmpty(qq.replace(" ", ""));
		Map<String, String> map = new HashMap<String, String>();
		if (result) {
			map.put("code", "412");
			map.put("data", "qq不能为空!");
			return map;
		}

		if (qq.length() < 5) {
			map.put("code", "411");
			map.put("data", "qq长度不正确!");
			return map;
		}

		if (!qq.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")) {
			map.put("code", "412");
			map.put("data", "qq必须是数字组成!");
			return map;
		}

		map.put("code", "200");
		return map;
	}

	/**
	 * 
	 * 校验邮箱格式
	 * 
	 * @param email
	 * @return
	 */
	public static boolean verifyEmail(String email) {
		String str = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
