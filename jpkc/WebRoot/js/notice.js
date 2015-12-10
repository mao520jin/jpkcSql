function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/notice/list/"+ pageNumber + "/" + pageSize;
}

function doSubmit() {
	if(!check('title')||!check('editor')) {
		return false;
	}
	$("#addNoticeForm").submit();
}

function check(id) {
	var content = $("#"+id).val();
	content = content.replace(/(^\s*)|(\s*$)/g, "");
	if(id == 'title') {
		if(content == "" || content == null ) {
				$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>标题不能为空!!!</strong>");
			return false;
		}else {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
	
	if(id == 'editor') {
		if(content == "" || content == null) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>内容不能为空!!!</strong>");
			return false;
		}else {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
}