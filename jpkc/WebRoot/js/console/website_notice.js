
function doClear(id) {
	if(id == "serach_form") {
		$("#title").val("");
	}
}

function doEdit(type, id) {
	if(type == "edit") {
		$("#action").val("edit");
	} else {
		$("#action").val("add");
	}
	$("#edit_id").val(id);
	$("#edit_form").submit();
}

function doSave() {
	
	var id = $("#id").val();
	var title = $("#title").val();
	var content = $("#editor").val();
	var action = $("#action").val();
	
	var postData = {
		"id" : id,
		"action" : action,
		"title" : title,
		"content" : content
	};
	$.ajax({
		type: "POST",
		url: basePath + "/console/notice/add",
		data: postData, 
		dataType: "json",
		success: function(msg){
			var code = msg.code;
			var data = msg.data;
			if(code != "25010") { setRender("console_render", code, data, "warning_render", 5000); return ; }
			window.location.href = basePath + "/console/notice/list";
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
	
}

// 删除
function doDelete(type, val) {
	var ids = val;
	if(type == "ids") {
		var cbs = $("input[id^='item_']:checkbox:checked");
		for(var i = 0; i < cbs.length; i++) { ids += $(cbs[i]).val() + ","; }
	}
	if(ids.length == 0) { showMessageDialog("未选中任何记录！"); return; }
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		if(r != "OK") { return false; }
		$.ajax({
			type: "POST",
			url: basePath + "/console/notice/delete",
			data: { "ids": ids }, 
			dataType: "json",
			success: function(msg){
				var code = msg.code;
				var data = msg.data;
				if(code != "25010") {
					showOptionDialog(data, "操作结果", null, "", "ERROR_MESSAGE", "MESSAGE_DIALOG");
					return ;
				}
				window.location.href = basePath + "/console/notice/list";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
	});
}

$(function() {
	$("#content_form").dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
		          { text: "关闭", click: function() { $( this ).dialog( "close" ); } }
		          ]
	});
});

/*打开资源内容*/
function doView(id) {
	var content = $("#content_" + id).val();
	$("#content").empty();
	$("#content").append(content);
	$("#content_form").dialog("open");
}