function check(id) {
	var content = $("#"+id).val();
	if(id == 'username') {
		if(content == "" || content == null) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>用户名不能为空!!!</strong>");
			return false;
		}else {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
	
	if(id == 'password') {
		if(content == "" || content == null) {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").addClass("error");
			$("#" + id + "Div").append("<strong class='message' id='"+id+"Msg'>密码不能为空!!!</strong>");
			return false;
		}else {
			$("#" + id + "Msg").remove();
			$("#" + id + "Div").removeClass("error");
			return true;
		}
	}
}

function doSubmit() {
	if(!check('username')||!check('password')) {
		return false;
	}
	var username = $("#username").val();
		$.ajax({
			type: "POST",
			url: basePath + "/user/checkUsername",
			data:{"username" : username},
			dataType: "json",
			beforeSend: function(XMLHttpRequest) { },
			success: function(data) {
				var code = data.code;
				if(code == '40001'){
					alert("用户名已经存在!!!");
					return false;
				}else{
					$("#addUserForm").submit();
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) { },
			complete: function(XMLHttpRequest, textStatus) { }
		});
}

function loginSubmit() {
	if(!check('username')||!check('password')) {
		return false;
	}
	$("#loginForm").submit();
}

function goPage(pageNumber,pageSize) {
	window.location.href = basePath + "/user/list/"+ pageNumber + "/" + pageSize;
}