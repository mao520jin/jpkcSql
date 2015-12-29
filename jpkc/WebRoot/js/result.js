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
	if(teamId == "" || teamId == null) {showMessageDialog("请选择项目人!"); return;}
	if(editor == 0) {showMessageDialog("资源内容不能为空!"); return;} 
	if(type == "" || type == null) {showMessageDialog("请选择成果类别!"); return;}
	$("#addResultForm").submit();
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
function doDelete() {
	var cbs = $("input[id^='item_']:checked");
	if(cbs.length <= 0) { showMessageDialog("未选中任何记录！"); return; }
	var ids = new Array();
	for(var i = 0; i < cbs.length; i++) {
		ids.push($(cbs[i]).val());
	}
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		if(r == "OK") {
			location.href = basePath + "/result/del/"+ids;
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

function doAdd() {
	location.href = basePath + "/result/add"
}

function doEdit(id) {
	location.href = basePath + "/result/edit/"+id;
}
