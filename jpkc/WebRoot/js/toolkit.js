//
//
// 公共 JS 函数
// toolkit.js
//
// @author chenfan
// @version 1.0, 2015/10/07
//
//

// 获取当前时间毫秒(13位)
function time() {
	return "" + (new Date()).getTime();
}

// 获取随机数(8位)
function random() {
	var r = "" + Math.random();
	return r.length < 10 ? random() : r.substring(2, 10);
}

// 获取随ID(32位)，格式：t1234567890123_r1020304050607080
function trId() {
	return "t" + time() + "_r" + random() + random();
}

// 校验ID(1~18位)
function isId(input) {
	var regex = new RegExp(/^[1-9]{1}[0-9]{0,17}$/);
	return regex.test(input);
}

// 用户名校验(3~32位)，格式：字母、数字或下划线
function isUsername(input) {
	var regex = new RegExp(/^[a-zA-Z]{1}[a-zA-Z0-9_]{2,31}$/);
	return regex.test(input);
}

// 密码校验(3~32位)，格式：字母、数字或下划线
function isPassword(input) {
	var regex = new RegExp(/^[a-zA-Z0-9_]{3,32}$/);
	return regex.test(input);
}

// 验证码校验(3~8位)，格式：字母、数字或下划线
function isCaptcha(input) {
	var regex = new RegExp(/^[a-zA-Z0-9]{3,8}$/);
	return regex.test(input);
}

/**
 * 
 * 设置复选框(checkbox)关联勾选状态
 * 
 * @param o 当前对象
 * @param pId 父ID
 * @param cId 子ID(前缀)
 * 
 */
function setSelected(o, pId, cId) {
	if(o.id == pId) {
		$("input[id^='" + cId + "']:checkbox").prop("checked", o.checked);
	} else {
		if(!o.checked) { $("#" + pId).prop("checked", o.checked); return; }
		var cbs = $("input[id^='" + cId + "']:checkbox");
		for(var i = 0; i < cbs.length; i++) { if(!cbs[i].checked) { return; } }
		$("#" + pId).prop("checked", true);
	}
}

// 设置表的列模型
function setColumnModel(columnModel) {
	
}