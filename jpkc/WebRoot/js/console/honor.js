
function doClear(id) {
	if(id == "serach_form") {
		$("#name").val("");
		$("#type").val("");
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
	var teamGroupId = $("#name").val();
	var about = $("#editor").val();
	var type = $("#type").val();
	
	var postData = {
		"id" : id,
		"teamGroupId" : teamGroupId,
		"about" : about,
		"type" : type
	};
	$.ajax({
		type: "POST",
		url: basePath + "/console/honor/add",
		data: postData, 
		dataType: "json",
		success: function(msg){
			var code = msg.code;
			var data = msg.data;
			if(code != "25010") { setRender("console_render", code, data, "warning_render", 5000); return ; }
			window.location.href = basePath + "/console/honor/list";
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
			url: basePath + "/console/honor/delete",
			data: { "ids": ids }, 
			dataType: "json",
			success: function(msg){
				var code = msg.code;
				var data = msg.data;
				if(code != "25010") {
					showOptionDialog(data, "操作结果", null, "", "ERROR_MESSAGE", "MESSAGE_DIALOG");
					return ;
				}
				window.location.href = basePath + "/console/honor/list";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
	});
}

//标记是否已加载成员
var names = new Array();

// 加载网关通道
function load() {
	if(isLoad) { return; }
	$.ajax({
		type: "POST",
		url: basePath + "/console/group/load",
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) { 
			for (var i = 0; i < data.data.length; i++) {
				var obj = data.data[i];
				names.push(obj); // 缓存安全问题到数组中
			}
			makeNameSelect();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
}

function makeNameSelect(data) {
	$("#name").html("");
	var option = "";
	option = "<option value=\"\">-</option>";
	$("#name").append(option);
	
	for(var i=0; i<names.length; i++) {
		var obj = names[i];s
		var name = obj.name;
		option = "<option value=" + obj.idString + ">" + obj.username + name + "</option>";
		$("#name").append(option);
	}
}


$(function() {
	$("#about_form").dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
		          { 
		        	  text: "关闭", click: function() { $( this ).dialog( "close" ); } }
		          ]
	});
});

/*打开资源内容*/
function doView(id) {
	var about = $("#about_" + id).val();
	$("#about_form").empty();
	$("#about_form").append(about);
	$("#about_form").dialog("open");
}