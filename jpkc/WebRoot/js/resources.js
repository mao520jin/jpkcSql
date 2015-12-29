$(function() {
	$("#resource_form").dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
		          { text: "关闭", click: function() { $( this ).dialog( "close" ); } }
		          ]
	});
});

/*分页查询*/
function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/resources/list/"+ pageNumber + "/" + pageSize;
}

/*添加信息*/
function doSubmit() {
	var title = $("#title").val();
	var editor = $("#editor").val();
	var type = $("#type").val();
	if(title == "" || title == null) {showMessageDialog("资源标题不能为空!"); return;}
	if(editor == 0) {showMessageDialog("资源内容不能为空!"); return;} 
	if(type == "" || type == null) {showMessageDialog("请选择资源类别!"); return;}
	$("#addResourcesForm").submit();
}

/*搜索*/
function doSearch() {
	$("#serach_form").submit();
}


/*打开资源内容*/
function openContent(id) {
	$("#resource_content").empty();
	var content = $("#content_" + id).val();
	$("#resource_content").append(content);
	$( "#resource_form" ).dialog( "open" );
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
			location.href = basePath + "/resources/del/"+ids;
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
	location.href = basePath + "/resouces/add"
}
function doEdit(id) {
	location.href = basePath + "/resouces/edit/"+id;
}