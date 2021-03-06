
//清空表单
function doClear(formId) {
	if(formId == "serach_form") {
		$("#title").val("");
		$("#type").val("");
		$("#isconvert").val("");
	}else{
		$("#edit_title").val("");
		$("#edit_path").val("");
		$("#edit_type").val("");
	}
}

/*分页查询*/
function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/console/resource/list/"+ pageNumber + "/" + pageSize;
}

/*搜索*/
function doSearch() {
	$("#serach_form").submit();
}		

function doEdit() {
	doBeforeEdit();
	$("#resource_edit_div").dialog({
		modal: true,
		resizable: false,
		title: "新增",
		width: 400,
		buttons: [
			{ text: "清空", click: function() { doClear("resource_edit_form"); } },
			{ text: "取消", click: function() { $( this ).dialog("close"); } },
			{ text: "保存", click: function() { doSave(); } }
		          ]
	});
}

function doBeforeEdit() {
	$("#edit_title").val("");
	$("#resourcesType").val("");
	$("#edit_type").val("");
	$("#edit_path_div").css({"display": "block"});
}

function doSave() {
	var title = $("#edit_title").val();
	var path = $("#edit_path").val();
	var type = $("#edit_type").val();
	var suffix = path.split('.').pop().toLowerCase();
	$("#edit_resource_type").val(type);

	if(title == "" || title == null) { setRender("edit_render", "", "标题不能为空！", "warning_render", 5000);  return; }
	if(path == "" || path == null) { setRender("edit_render", "", "请选择文件！！", "warning_render", 5000);  return;}
	if(type == "") { setRender("edit_render", "", "请选择资源类别！", "warning_render", 5000); }
	if(type == 3 || type == 11) {
		var filetype = new Array();
		filetype.push("flv");
		if(filetype.indexOf(suffix) == -1) {
			setRender("edit_render", "", "允许上传的文件格式为：flv", "warning_render", 5000);
			return; 
		}
	} else {
		var filetype = new Array();
		filetype.push("swf");
		if(filetype.indexOf(suffix) == -1) { 
			setRender("edit_render", "", "允许上传的文件格式为：swf！", "warning_render", 5000);
			return; 
		}
	}
	$("#resource_edit_form").submit();
	$("#wait_image_div").css({"display": "block"});
}


/*打开资源内容*/
function convert(path, id, type) {
	showConfirmDialog("确定要转换吗？", "操作提示", function(r) {
		if(r != "OK") { return false; }
		$.ajax({
			type: "POST",
			url: basePath + "/console/resource/convert",
			data: { "path": path, "id": id, "type": type},
			dataType: "json",
			async: false,
			cache: false,
			beforeSend: function(XMLHttpRequest) { },
			success: function(data, textStatus) {
				if(data == null || data.code != "25010" || data.data == null || data.data.length == 0) {
					setRender("edit_render", "", "转换失败，请联系技术支持！", "warning_render", 5000);
					return;
				}
				window.location.href = basePath + "/console/resource/list/";
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
	});
}

// 编辑
function doEditEdit(id) {
	beforeEdit(id);
	$("#resource_edit_edit_div").dialog({
		modal: true,
		resizable: false,
		title: "编辑",
		width: 400,
		buttons: [
			{ text: "清空", click: function() { doClear("resource_edit_edit_form"); } },
			{ text: "取消", click: function() { $( this ).dialog("close"); } },
			{ text: "保存", click: function() { doEditSave(id); } }
		          ]
	});
}

function beforeEdit(id) {
	var title = $("#title_" + id).val();
	var type = $("#type_" + id).val();
	console.log(id);
	console.log(type);
	$("#edit_edit_title").val(title);
	$("#edit_edit_type").val(type);
}

function doEditSave(id) {
	var title = $("#edit_edit_title").val();
	var type = $("#edit_edit_type").val();
	$.ajax({
		type: "POST",
		url: basePath + "/console/resource/editSave",
		data: { "title": title, "type": type, "id": id }, 
		dataType: "json",
		success: function(msg){
			var code = msg.code;
			var data = msg.data;
			if(code != "25010") {
				setRender("edit_edit_render", "", "编辑失败，请联系技术支持！", "warning_render", 5000);
				return;
			}
			location.href = basePath + "/console/resource/list/";
		}
	});
}

//删除
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
			url: basePath + "/console/resource/del",
			data: { "ids": ids }, 
			dataType: "json",
			success: function(msg){
				var code = msg.code;
				var data = msg.data;
				if(code != "25010") {
					showMessageDialog("删除失败！"); return;
					return ;
				}
				location.href = basePath + "/console/resource/list/";
			}
		});
	});
}
