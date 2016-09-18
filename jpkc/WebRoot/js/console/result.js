$(function() {
	$("#result_form").dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
		          { text: "关闭", click: function() { $( this ).dialog( "close" ); } }
		          ]
	});
});

function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/result/list/"+ pageNumber + "/" + pageSize;
}

/*添加信息*/
function doSubmit() {
	var teamId = $("#teamId").val();
	var editor = $("#editor").val(); 
	var type = $("#type").val();
	if(teamId == "" || teamId == null) {showMessageDialog("请选择项目人，没有请先添加！"); return;}
	if(editor == 0) {showMessageDialog("资源内容不能为空!"); return;} 
	if(type == "" || type == null) {showMessageDialog("请选择成果类别!"); return;}
	$("#addResultForm").submit();
}

function doClear(formId) {
	if(formId == "serach_form") {
		$("#memberName").val("");
		$("#resultType").val("");
	}
}

/*搜索*/
function doSearch() {
	$("#serach_form").submit();
}


/*打开资源内容*/
function openContent(id) {
	$("#result_content").empty();
	var content = $("#content_" + id).val();
	$("#result_content").append(content);
	$( "#result_form" ).dialog( "open" );
}

//删除勾选
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
			url: basePath + "/result/del/",
			data: { "ids": ids }, 
			dataType: "json",
			success: function(msg){
				var code = msg.code;
				var data = msg.data;
				if(code != "25010") {
					showMessageDialog("删除失败！"); return;
					return ;
				}
				location.href = basePath + "/result/list/";
			}
		});
	});
}

function doAdd() {
	location.href = basePath + "/result/add"
}

function doEdit(id) {
	location.href = basePath + "/result/edit/"+id;
}
