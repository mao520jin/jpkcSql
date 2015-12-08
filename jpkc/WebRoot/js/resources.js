function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/resources/list/"+ pageNumber + "/" + pageSize;
}

function doSubmit() {
	if(!check('title')||!check('editor')||!check('type')) {
		return false;
	}
	$("#addResourcesForm").submit();
}

function check(id) {
	var content = $("#"+id).val();
	if(!null == content && !"" == content) { 
		content = content.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	if(id == 'title') {
		if(content == "" || content == null ) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>成员不能为空!!!</strong>");
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
	
	if(id == 'type') {
		if(null == content) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>请选择成员类别!!!</strong>");
			return false;
		}else{
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
}