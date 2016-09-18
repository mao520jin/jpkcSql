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
	$("#loginForm").submit();
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
