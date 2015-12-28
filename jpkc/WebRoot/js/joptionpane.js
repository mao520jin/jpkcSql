/**
 * 
 * JQuery JOptionPane v1.0.0
 * http://www.xinxinke.com/
 * 
 * Copyright (c) 2014 - 2015 http://www.xinxinke.com/
 * 
 * 
 * Author: chenfan
 * Date: 2015/10/07
 * 
 */


/**
 * 
 * 询问一个确认问题。
 * 
 * @param message 消息内容
 * @param title 标题
 * @param callback 回调函数
 * 
 */
function showConfirmDialog(message, title, callback) {
	showOptionDialog(message, title, callback, "OK_CANCEL_OPTION", "QUESTION_MESSAGE", "CONFIRM_DIALOG");
}

/**
 * 
 * 提示要求某些输入。
 * 
 * @param message
 * @param title
 * @param callback
 * 
 */
function showInputDialog(message, title, callback) {
	showOptionDialog(message, title, callback, "OK_CANCEL_OPTION", "PLAIN_MESSAGE", "INPUT_DIALOG");
}

/**
 * 
 * 告知用户某事已发生。
 * 
 * @param message 消息内容
 * @param title 标题
 * @param callback 回调函数
 * 
 */
function showMessageDialog(message, title, callback) {
	showOptionDialog(message, title, callback, "", "INFORMATION_MESSAGE", "MESSAGE_DIALOG");
}

/**
 * 
 * 上述三项的大统一 (Grand Unification)。
 * 
 * @param message 消息内容
 * @param title 标题
 * @param callback 回调函数
 * @param optionType 操作类型：DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION
 * @param messageType 消息类型: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
 * @param dialogType 对话框类型: CONFIRM_DIALOG, INPUT_DIALOG, MESSAGE_DIALOG
 * 
 */
function showOptionDialog(message, title, callback, optionType, messageType, dialogType) {
	
	// 初始设置
	message = message == null ? "<br />" : "<br />" + message;
	title = title == null ? "操作提示": title;
	callback = callback == null ? function(r) { } : callback;
	optionType = optionType == null ? "DEFAULT_OPTION": optionType;
	messageType = messageType == null ? "INFORMATION_MESSAGE": messageType;
	dialogType = dialogType == null ? "MESSAGE_DIALOG": dialogType;
	
	// 操作项
	var options = [{ text: "确定", click: function() { var result = getOptionDialogInputValue(this, "OK", dialogType); removeOptionDialog(this); callback(result); } }];
	if(optionType == "YES_NO_OPTION") {
		options = [
			{ text: "是", click: function() { var result = getOptionDialogInputValue(this, "YES", dialogType); removeOptionDialog(this); callback(result); } },
			{ text: "否", click: function() { var result = getOptionDialogInputValue(this, "NO", dialogType); removeOptionDialog(this); callback(result); } }
		];
	}
	if(optionType == "YES_NO_CANCEL_OPTION") {
		options = [
			{ text: "是", click: function() { var result = getOptionDialogInputValue(this, "YES", dialogType); removeOptionDialog(this); callback(result); } },
			{ text: "否", click: function() { var result = getOptionDialogInputValue(this, "NO", dialogType); removeOptionDialog(this); callback(result); } },
			{ text: "取消", click: function() { var result = getOptionDialogInputValue(this, "CANCEL", dialogType); removeOptionDialog(this); callback(result); } }
		];
		
	}
	if(optionType == "OK_CANCEL_OPTION") {
		options = [
			{ text: "确定", click: function() { var result = getOptionDialogInputValue(this, "OK", dialogType); removeOptionDialog(this); callback(result); } },
			{ text: "取消", click: function() { var result = getOptionDialogInputValue(this, "CANCEL", dialogType); removeOptionDialog(this); callback(result); } }
		];
	}

	// 图标
	var icon = "";
	if(messageType == "ERROR_MESSAGE") { icon = "<span class='joptionpane-icon joptionpane-icon-error'></span>"; }
	if(messageType == "INFORMATION_MESSAGE") { icon = "<span class='joptionpane-icon joptionpane-icon-information'></span>"; }
	if(messageType == "WARNING_MESSAGE") { icon = "<span class='joptionpane-icon joptionpane-icon-warning'></span>"; }
	if(messageType == "QUESTION_MESSAGE") { icon = "<span class='joptionpane-icon joptionpane-icon-question'></span>"; }
	if(messageType == "PLAIN_MESSAGE") { icon = "<span class='joptionpane-icon joptionpane-icon-plain'></span>"; }

	// 生成临时 ID
	var t = "" + (new Date()).getTime(); // 当前时间毫秒(13位)
	var s = "" + Math.random(); while(s.length < 10) { s = "" + Math.random(); } // 随机数
	var r = "" + s.substring(2, 10); // 随机数(8位)
	
	// 构造 Dialog 组件
	var id = "JOptionPane_" + t + r; // ID
	var input = dialogType != "INPUT_DIALOG" ? "" : "<br /><input type='text' id='" + id + "_input' style='width: 220px;' />"
	var msg = icon + message + input
	$("body").append("<div id='" + id + "' class='joptionpane'>" + msg + "</div>");
	
	$("#" + id).dialog({
		modal: true,
		resizable: false,
		title: title,
		width: 350,
		close: function(event, ui) { var result = getOptionDialogInputValue(this, "X", dialogType); removeOptionDialog(this); callback(result); },
		buttons: options
	});
	
}

/**
 * 
 * 获取输入对话框值
 * 
 * @param dialogObj 对话框对象
 * @param optionType 操作类型（具体）：OK, YES, NO, CANCEL, X
 * @param dialogType 对话框类型
 * 
 * @returns
 * 
 */
function getOptionDialogInputValue(dialogObj, optionType, dialogType) {
	if(dialogType != "INPUT_DIALOG") { return optionType; }
	if(optionType != "YES" && optionType != "OK") { return null; }
	return $("#" + dialogObj.id + "_input").val();
}

/**
 * 
 * 移除对话框
 * 
 * @param dialogObj 对话框对象
 * 
 */
function removeOptionDialog(dialogObj) {
	try { $(dialogObj).dialog("destroy"); } catch (e) { }
	try { $(dialogObj).remove(); } catch (e) { }
}

