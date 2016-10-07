$(function() {
	$( "#user_form_div" ).dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
			{ text: "提交", click: function() { doSubmit(); } },
			{ text: "取消", click: function() { $( this ).dialog( "close" ); } }
		]
	});
});

function doAdd() {
	$( "#user_form_div" ).dialog("open");
}

function doClear(formId) {
	if(formId == "serach_form") {
		$("#Uname").val("");
	}
}

//添加提交
function doSubmit() {
	var username = $("#username").val();
	var password = $("#password").val();
	if(username == "" || username == null) {showMessageDialog("添加用户姓名不能为空!"); return;}
	if(!username.match("^[a-zA-Z]\\w{1,64}$")){showMessageDialog("用户名只能有数字字母下划线构成且字母开头!"); return;} 
	if(password == "" || password == null) {showMessageDialog("添加用户密码不能为空!"); return;}
	if(password.length>32 ) {showMessageDialog("密码长度不合法!"); return;}
	$.ajax({
			type: "POST",
			url: basePath + "/user/checkUsername",
			data:{"username" : username},
			dataType: "json",
			beforeSend: function(XMLHttpRequest) { },
			success: function(data) {
				var code = data.code;
				if(code == '40001'){
					showMessageDialog("用户名已经存在!!!"); return;
					return false;
				}else{
					$("#add_user_form").submit();
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
}

function loginSubmit() {
	var username = $("#username").val();
	var password = $("#password").val();
	
	var data = { "username": username, "password": password };
	
	if(!isUsername(username)) { 
		setRender("console_render", "", "用户名应为3~32位，由字母、数字、下划线组成！", "warning_render", 5000);
		return false; 
	}
	if(!isPassword(password)) { 
		setRender("console_render", "", "密码应为3~32位，由字母、数字、下划线组成！", "warning_render", 5000);
		return false; 
	}
	
	$.ajax({
		type: "POST",
		url: basePath + "/console/sysadmin/loginIn",
		data: data,
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) {
			if(data.code != "25001") {
				setRender("console_render", "", data.data, "warning_render", 5000);
				return;
			}
			window.location.href = basePath + "/console/resource/list";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
}

function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/user/list/"+ pageNumber + "/" + pageSize;
}

function doSearch() {
	$("#serach_form").submit();
}

//删除勾选
function doDelete() {
	var cbs = $("input[id^='item_']:checked");
	if(cbs.length <= 0) { showMessageDialog("未选中任何记录！"); return; }
	var ids = new Array();
	for(var i = 0; i < cbs.length; i++) {
		ids.push($(cbs[i]).val());
	}
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		if(r == "OK") {
			location.href = basePath + "/user/del/"+ids;
		}
	});
}
