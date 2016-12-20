
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

function changePhoto() {
	$("#photo_img").css({"display": "none"});
}

function doSave() {
	
	var id = $("#id").val();
	var name = $("#name").val();
	var type = $("#type").val();
	var email = $("#email").val();
	var about = $("#editor").val();
	var mobile = $("#mobile").val();
	
	$.ajaxFileUpload({
		type: "POST",
		url: basePath + "/console/group/add?id=" + id + "&name=" + name + "&type=" + type + "&email=" + email + "&about=" + about + "&mobile=" + mobile,
		secureuri: false,//安全协议  
	    fileElementId: "image",
		dataType: "JSON",
		async : false,
		success: function(ddd){
			var start = ddd.indexOf(">");
			if(start != -1) {   
				var end = ddd.indexOf("<", start + 1);   
				if(end != -1) {
					ddd = ddd.substring(start + 1, end);
				}   
			} 
			var msg = jQuery.parseJSON(ddd);
			var code = msg.code;
			var data = msg.data;
			if(code != "25010") { setRender("console_render", code, data, "warning_render", 5000); return ; }
			window.location.href = basePath + "/console/group/list";
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
			url: basePath + "/console/group/delete",
			data: { "ids": ids }, 
			dataType: "json",
			success: function(msg){
				var code = msg.code;
				var data = msg.data;
				if(code != "25010") {
					showOptionDialog(data, "操作结果", null, "", "ERROR_MESSAGE", "MESSAGE_DIALOG");
					return ;
				}
				window.location.href = basePath + "/console/group/list";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
	});
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