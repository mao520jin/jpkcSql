<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>添加公告 - ${APP_CONSOLE_NAME_CN} - ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/team.js"></script>

	<link rel="stylesheet" href="${basePath}/editor/themes/default/default.css" />
	<link rel="stylesheet" href="${basePath}/editor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${basePath}/editor/kindeditor.js"></script>
	<script charset="utf-8" src="${basePath}/editor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${basePath}/editor/plugins/code/prettify.js"></script>
<script>
		var editor1;
		KindEditor.ready(function(K) {
				editor1 = K.create('#editor', {
				cssPath : '${basePath}/editor/plugins/code/prettify.css',// '样式路径',
				uploadJson : '${basePath}/editor/jsp/upload_json.jsp',	//file  '动态上传处理程序文件',
				//uploadJson : '${basePath}/user/upload',
				fileManagerJson : '${basePath}/editor/jsp/file_manager_json.jsp',//image  '已上传文件管理程序文件',
				allowFileManager : true,
				allowImageRemote:false,
				width:800,
				height:400,
				afterBlur: function() {
					var self = this;
					this.sync();
					K.ctrl(document, 13, function() {
						doSubmit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						doSubmit();
					});
				}
			});
			prettyPrint();
		});
		
	</script>
</head>

<body class="hidecol2">

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp">
	<jsp:param name="hListActive" value="OperationsManagement" />
</jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary">
	<div id="col1_content" class="clearfix">
		<jsp:include page="/views/console/include/vlist.jsp">
			<jsp:param name="hListActive" value="OperationsManagement" />
			<jsp:param name="vListActive" value="addTeam" />
		</jsp:include>
	</div>
</div>
<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main">
	<div id="col3_content" class="clearfix">
		<form method="post" action="${basePath}/team/addTeam" class="yform" role="application" id="addTeamForm">
			<div class="subcolumns">
			  <div class="c50l">
				 	<div class="type-text" id="memberNameDiv">
						<label for="memberName">成员名称:</label>
						<input type="text" name="memberName" id="memberName" size="20" style="width: 300px;" value="${teamList[0].memberName}" />
					</div>
					<input type="hidden" name="id" id="id" size="20" style="width: 300px;" value="${teamList[0].id}" />
					<div class="type-text" id="emailDiv">
						<label for="email">邮箱:</label>
						<input type="text" name="email" id="email" size="20" style="width: 300px;" value="${teamList[0].email}" />
					</div>
					
					<div class="type-text" id="editorDiv">
						<label for="editor">成员简介：</label>
						<textarea id="editor" name="content" style="width:700px;height:300px; visibility:hidden;" >${teamList[0].content}
						</textarea>
					</div>
					
			  </div>
			  <div class="c50r">
			  		 <div class="type-text" id="telDiv">
						<label for="tel">电话:</label>
						<input type="text" name="tel" id="tel" size="20" style="width: 300px;" value="${teamList[0].tel}" />
					</div>
				  	<div class="subcl type-select" id="typeDiv">
							<label for="select-1">成员类别:</label>
							<select name="type" id="type" size="1" style="width: 200px;" >
								  <c:choose> 
									  <c:when test="${teamList[0].type eq 1 }">   
									    <option value="1" selected="selected">导师</option>
								  		<option value="2">学生</option>  
									  </c:when> 
									  <c:when test="${teamList[0].type eq 2 }">   
									    <option value="1" >导师</option>
								  		<option value="2" selected="selected">学生</option>  
									  </c:when> 
									  <c:otherwise>   
									    <option value="0" selected="selected" disabled="disabled">-----------------请选择-----------------</option>
									    <option value="1">导师</option>
								  		<option value="2">学生</option> 
									  </c:otherwise> 
								</c:choose> 
							</select>
					 </div>
			  </div>
			</div>
		</form>
			<div class="type-button ">
				<a href="javascrip:;" onclick="doSubmit();"  class="ui-button">提交</a>
			</div> 
	</div>
	<div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>
<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/views/console/include/footer.jsp"></jsp:include>
<jsp:include page="/views/console/include/yamlfocusfix.jsp"></jsp:include>

</body>
</html>
