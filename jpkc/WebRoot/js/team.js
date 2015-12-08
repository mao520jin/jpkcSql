function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/team/list/"+ pageNumber + "/" + pageSize;
}

function doSubmit() {
	if(!check('memberName')||!check('editor')||!check('email')||!check('tel')||!check('type')) {
		return false;
	}
	$("#addTeamForm").submit();
}

function check(id) {
	var content = $("#"+id).val();
	if(!null == content && !"" == content) { 
		content = content.replace(/(^\s*)|(\s*$)/g, "");
	}
	
	if(id == 'memberName') {
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
	
	if(id == 'email') {
		if(content == "" || content == null) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>邮箱不能为空!!!</strong>");
			return false;
		}else {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
	
	if(id == 'tel') {
		if(content == "" || content == null) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>电话不能为空!!!</strong>");
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