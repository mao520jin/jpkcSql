/**
 * 
 * JQuery jConsole v1.0.0
 * http://www.xinxinke.com/
 * 
 * Copyright (c) 2014 - 2015 http://www.xinxinke.com/
 * 
 * 
 * Author: chenfan
 * Date: 2015/10/07
 * 
 */

// 调试模式
var debugMode = false;

// 控制台对话框对象
var consoleDialog = null;

// 控制台对象
var consoleObj = null;

// 打开控制台
function openConsole() {
	
	closeConsole();
	debugMode = true;
	
	$("body").append("<div id='jConsoleDiv'><textarea id='jConsoleTextarea' style='width: 99%; height: 150px;'></textarea></div>");
	
	consoleDialog = $("#jConsoleDiv").dialog({
		title: "控制台",
		width: 600,
		buttons: [
			{ text: "清空", click: function() { $(consoleObj).val(""); } },
			{ text: "关闭", click: function() { closeConsole(); } }
		],
		close: function(event, ui) { closeConsole(); }
	});
	
	consoleObj = $("#jConsoleTextarea");
	
}

// 关闭控制台
function closeConsole() {
	try { $(consoleDialog).dialog("destroy"); } catch (e) { }
	try { $(consoleDialog).remove(); } catch (e) { }
	debugMode = false;
}

// 输出一行
function println(str) {
	if(!debugMode) { return; }
	print(str + "\n");
}

// 输出
function print(str) {
	
	if(!debugMode) { return; }
	
	// 返回 Date 对象。
	var dateObj = new Date();
	
	// 返回 Date 对象四位数字年份。
	var y = "" + dateObj.getFullYear();
	
	// 返回 Date 对象月份 (0 ~ 11)。
	var m = "" + (dateObj.getMonth() + 1); m = m.length == 1 ? "0" + m : m;
	
	// 返回 Date 对象一个月中的某一天 (1 ~ 31)。
	var d = "" + dateObj.getDate(); d = d.length == 1 ? "0" + d : d;
	
	// 返回 Date 对象的小时 (0 ~ 23)。
	var h = "" + dateObj.getHours(); h = h.length == 1 ? "0" + h : h;
	
	// 返回 Date 对象的分钟 (0 ~ 59)。
	var mi = "" + dateObj.getMinutes(); mi = mi.length == 1 ? "0" + mi : mi;
	
	// 返回 Date 对象的秒数 (0 ~ 59)。
	var s = "" + dateObj.getSeconds(); s = s.length == 1 ? "0" + s : s;
	
	// 返回 Date 对象的毫秒(0 ~ 999)。
	var ms = "" + dateObj.getMilliseconds(); ms = ms.length == 1 ? "00" + ms : ms.length == 2 ? "0" + ms : ms;
	
	// 返回当前日期字符串，格式：2015-12-15 17:35:28.267。
	var dateStr = y + "-" + m + "-" + d + " " + h + ":" + mi + ":" + s + "," + ms;
	
	var oldStr = $(consoleObj).val();
	var newStr = dateStr + " - " + str;
	
	$(consoleObj).val(newStr + oldStr);
	
}

