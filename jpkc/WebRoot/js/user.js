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

//添加提交
function doSubmit() {
	var username = $("#username").val();
		$.ajax({
			type: "POST",
			url: basePath + "/user/checkUsername",
			data:{"username" : username},
			dataType: "json",
			beforeSend: function(XMLHttpRequest) { },
			success: function(data) {
				var code = data.code;
				if(code == '40001'){
					alert("用户名已经存在!!!");
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

//全选
function doCheckAll(obj) {
	$("input[id^='item_']:checkbox").prop("checked", obj.checked);
}

//勾选
function doCheckItem(obj) {
	if(!obj.checked) { $("#checkAll").prop("checked", false); return; }
	var cbs = $("input[id^='item_']");
	for(var i = 0; i < cbs.length; i++) {
		if(!cbs[i].checked) { return; }
	}
	$("#checkAll").prop("checked", true);
}