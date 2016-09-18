//
//
// 系统管理员
// sys_admin.js
//
// @author chenfan
// @version 1.0, 2015/10/07
//
//


// 查询
function doSearch() {
	resetPage();
	$("#sys_admin_search_form").submit();
}

// 查询前业务处理
function doBeforeSearch() {
	var username = $("#username").val();
	if(username.length > 0 && !doMatches("search_username", username)) {
		showMessageDialog("【用户名】长度应为1~32个字符，由字母、数字、下划线组成！");
		return false;
	}
	return true;
}

// 新增、编辑
function doEdit(id) {
	doBeforeEdit(id);
	var title = id == "" ? "添加管理员" : "编辑管理员";
	$("#sys_admin_edit_div").dialog({
		modal: true,
		resizable: false,
		title: title,
		width: 500,
		buttons: [
			{ text: "清空", click: function() { doClear("sys_admin_edit_form"); } },
			{ text: "取消", click: function() { $(this).dialog("close"); } },
			{ text: "保存", click: function() { doSave(); } }
		]
	});
}

// 新增、编辑预设值
function doBeforeEdit(id) {
	var action = "";
	var username = "";
	var password = "";
	var status = "";
	var desc = "";
	
	if(id == "") {
		action = "new";
		$("#edit_pwd_span").hide();
		$("#edit_password").prop("disabled", false);
	} else {
		action = "edit1";
		$("#a_edit_password").text("编辑");
		$("#edit_pwd_span").show();
		$("#edit_password").prop("disabled", true);
		username = $("#username_" + id).val();
		password = "****************";
		status = $("#status_" + id).val();
		desc = $("#desc_" + id).val();
	}
	
	$("#action").val(action);
	$("#edit_id").val(id);
	$("#edit_username").val(username);
	$("#edit_password").val(password);
	$("#edit_status").val(status);
	$("#edit_desc").val(desc);
}

// 修改密码
function doEditPwd(obj) {
	var action = $("#action").val();
	if(action == "new") { return; }
	if(action == "edit1") {
		$(obj).text("取消");
		$("#action").val("edit2");
		$("#edit_password").prop("disabled", false);
		$("#edit_password").val("");
	} else {
		$(obj).text("编辑");
		$("#action").val("edit1");
		$("#edit_password").prop("disabled", true);
		$("#edit_password").val("****************");
	}
}

// 保存
function doSave() {
	
	//
	// 动作类型(action)
	//
	// 1.   new: 新增
	// 2. edit1: 编辑，只改信息，不改密码
	// 3. edit2: 编辑，修改信息和密码
	//
	
	/* ----- 参数 ----- */
	var action = $("#action").val();
	var id = $("#edit_id").val();
	var username = $("#edit_username").val();
	var password = $("#edit_password").val();
	var status = $("#edit_status").val();
	var desc = $("#edit_desc").val();
	
	/* ----- 校验 ----- */
	if(!doMatches("username", username)) { showMessageDialog("【用户名】长度应为3~32个字符，可使用字母、数字、下划线，需以字母开头！"); return; }
	if(!doMatches("password", password) && action != "edit1") { showMessageDialog("【密码】长度应为3~32个字符，可使用字母、数字、下划线！"); return; }
	if(!doMatches("status", status)) { showMessageDialog("【状态】不能为空！"); return; }
	
	/* ----- 提交 ----- */
	var data = { "action": action, "id": id, "username": username, "password": password, "status": status, "desc": desc };
	doSaveAjax(data);
	
}

// 保存(ajax)
function doSaveAjax(data) {
	$.ajax({
		type: "POST",
		url: basePath + "/console/sysadmin/save",
		data: data,
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) {
			window.location.href = basePath + "/console/sysadmin/list";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
}

// 删除，单个：type='id'，多个：type='ids'
function doDelete(type, val) {
	var ids = val;
	if(type == 'ids') {
		var cbs = $("input[id^='item_']:checkbox:checked");
		for(var i = 0; i < cbs.length; i++) { ids += $(cbs[i]).val() + ","; }
	}
	if(ids.length == 0) { showMessageDialog("未选中任何记录！"); return; }
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		if(r == "OK") { doDeleteAjax(ids); }
	});
}

// 删除(ajax)，ids 以逗号分割
function doDeleteAjax(ids) {
	$.ajax({
		type: "POST",
		url: basePath + "/console/sysadmin/delete",
		data: { "ids": ids },
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) {
			window.location.href = basePath + "/console/sysadmin/list";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
}

// 清空表单
function doClear(formId) {
	
	// 查询表单: sys_admin_search_form
	// 编辑表单: sys_admin_edit_form
	
	if(formId == "sys_admin_search_form") {
		$("#username").val("");
		$("#status").val("");
	} else if(formId == "sys_admin_edit_form") {
		$("#edit_username").val("");
		if($("#action").val() != "edit1") { $("#edit_password").val(""); }
		$("#edit_status").val("");
		$("#edit_desc").val("");
	}
	
}

// 生成验证码，加上时间防止浏览缓存图片器不再次加载
function reCaptcha() {
	var time = new Date().getTime();
	document.getElementById("captchaImg").src = basePath + "/captcha/image?time=" +time;
}

// 系统后端登录
function doLogin() {
	
	var username = $("#username").val();
	var password = $("#password").val();
	var captcha = $("#captcha").val();
	
	if(!doMatches("username", username)) {
		setRender("console_render", "", "【用户名】应为3~32位，由字母、数字、下划线组成！", "warning_render", 5000);
		return;
	}
	
	if(!doMatches("password", password)) {
		setRender("console_render", "", "【密码】应为3~32位，由字母、数字、下划线组成！！", "warning_render", 5000);
		return;
	}
	
	if(!doMatches("captcha", captcha)) {
		setRender("console_render", "", "【验证码】应为4位，由字母、数字组成！！", "warning_render", 5000);
		return;
	}
	
	var data = {
		"username": username,
		"password": password,
		"captcha": captcha,
		"action": "login"
	};
	
	signInAjax(data);
}

// 登录(ajax)
function signInAjax(param) {
	$.ajax({
		type: "POST",
		url: basePath + "/console/login",
		data: param,
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) {
			if(data.code == "25010") {
				window.location.href = basePath + "/console/sysadmin/list";
			} else {
				setRender("console_render", data.code, data.data, "warning_render", 5000);
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { reCaptcha(); }
	});
}

//校验，备注统一校验
function doMatches(regex, input) {
	if(regex == "username") { // 用户名
		return new RegExp(/^[a-zA-Z]{1}[a-zA-Z0-9_]{2,31}$/).test(input);
	} else if(regex == "password") { // 密码
		return new RegExp(/^[a-zA-Z0-9_]{3,32}$/).test(input);
	} else if(regex == "captcha") { // 验证码
		return new RegExp(/^[a-zA-Z0-9]{4}$/).test(input);
	} else if(regex == "status") { // 验证码
		return new RegExp(/^[0|1]$/).test(input);
	} else if(regex == "search_username") { // 验证码
		return (new RegExp(/^[a-zA-Z0-9_]{1,32}$/)).test(input);
	} else{
		return false;
	}
}
