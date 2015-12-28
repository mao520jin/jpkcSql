
$(function() {
	$("#team_form").dialog({
		autoOpen: false,
		width: 400,
		modal: true,
		buttons: [
		          { text: "关闭", click: function() { $( this ).dialog( "close" ); } }
		          ]
	});
});


function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/team/list/"+ pageNumber + "/" + pageSize;
}

/*添加信息*/
function doSubmit() {
	var memberName = $("#memberName").val();
	var email = $("#email").val();
	var content = $("#editor").val();
	var tel = $("#tel").val();
	var type = $("#type").val();
	if(memberName == "" || memberName == null) {showMessageDialog("成员名字不能为空!"); return;}
	if(memberName.length>64 ) {showMessageDialog("成员名字过长!"); return;}
	if(email == "" || email == null) {showMessageDialog("邮箱不能为空!"); return;}
	if(!email.match("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")){showMessageDialog("邮箱格式不合法!"); return;}
	if(content == "" || content == null) {showMessageDialog("成员简介不能为空!"); return;}
	if(tel == "" || tel == null) {showMessageDialog("电话不能为空!"); return;}
	if(!tel.match("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")){showMessageDialog("电话号码格式不合法!"); return;}
	if(type == 0 || type == "" || type == null) {showMessageDialog("请选择成员类型!"); return;} 
	$("#addTeamForm").submit();
}

/*搜索*/
function doSearch() {
	$("#serach_form").submit();
}


/*打开资源内容*/
function openContent(id) {
	$("#team_content").empty();
	var content = $("#content_" + id).val();
	$("#team_content").append(content);
	$( "#team_form" ).dialog( "open" );
}

//删除勾选
function teamDelete() {
	var cbs = $("input[id^='item_']:checked");
	if(cbs.length <= 0) { showMessageDialog("未选中任何记录！"); return; }
	var ids = new Array();
	for(var i = 0; i < cbs.length; i++) {
		ids.push($(cbs[i]).val());
	}
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		if(r == "OK") {
			location.href = basePath + "/team/del/"+ids;
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