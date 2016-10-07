<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>团队成员编辑 - 物流工程控制台 </title>

<jsp:include page="/view/console/include/style.jsp"></jsp:include>
<jsp:include page="/view/console/include/script.jsp" flush="true" />
<script charset="utf-8" src="${basePath}/editor/kindeditor.js"></script>
<script charset="utf-8" src="${basePath}/editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${basePath}/editor/plugins/code/prettify.js"></script>
<script src="<%=basePath%>/js/console/ajaxfileupload.js" type="text/javascript"></script>
<link rel="stylesheet" href="${basePath}/editor/themes/default/default.css" />
<link rel="stylesheet" href="${basePath}/editor/plugins/code/prettify.css" />

<script type="text/javascript" src="${basePath}/js/console/group.js"></script>
<script>
	var editor1;
	KindEditor.ready(function(K) {
		editor1 = K.create('#editor', {
		cssPath : '${basePath}/editor/plugins/code/prettify.css',// '样式路径',
		uploadJson : '${basePath}/file/upload',
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

<jsp:include page="/view/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/view/console/include/header.jsp"></jsp:include>
<jsp:include page="/view/console/include/nav.jsp">
<jsp:param name="hListActive" value="OperationsManagement" />
</jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">
	
	<!-- begin: #col1 - first float column -->
	<div id="col1" role="complementary"><div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp">
			<jsp:param name="hListActive" value="OperationsManagement" />
			<jsp:param name="vListActive" value="editTeamGroup" />
		</jsp:include>
	</div></div>
	<!-- end: #col1 -->
	
	<!-- begin: #col2 second float column -->
	<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col2 -->
	
	<!-- begin: #col3 static column -->
	<div id="col3" role="main"><div id="col3_content" class="clearfix">
		<form method="post" action="${basePath}/team/addTeam" class="yform full" role="application" id="addTeamForm">
			<input type="hidden" name="id" id="id" size="20" style="width: 300px;" value="${teamGroup.id}" />
			<fieldset>
				<div class="subcolumns">
					
					<div class="c50l"><div class="subcl type-text">
						<div class="c50l" id="memberNameDiv"><div class="subcl type-text">
							<label for="name">成员名称:</label>
							<input type="text" name="name" id="name" size="20" value="${teamGroup.name}" />
						</div></div>
						
						<div class="c50r" id="emailDiv"><div class="subcr  type-text">
							<label for="email">邮箱:</label>
							<input type="text" name="email" id="email" size="20" value="${teamGroup.email}" />
						</div></div>
						
						<div class="c50l" id="telDiv"><div class="subcl  type-text">
							<label for="mobile">电话:</label>
							<input type="text" name="mobile" id="mobile" size="20" value="${teamGroup.mobile}" />
						</div></div>
						
						<div class="c50r" id="typeDiv"><div class="subcr type-select"> 
							<label for="type">成员类别</label>
							<select id="type" name="type">
								<option value="0" >-</option>
								<option value="1" <c:if test="${teamGroup.type eq 1}">selected="selected"</c:if>>导师</option>
								<option value="2" <c:if test="${teamGroup.type eq 2}">selected="selected"</c:if>>学生</option>
								<option value="3" <c:if test="${teamGroup.type eq 3}">selected="selected"</c:if>>课程负责人</option>
							</select>
						</div></div>
					</div></div>

					<div class="c50r"><div class="subcr type-text">
						<div class="c50l"><div class="subcl ">
							<label for="photo">成员照片:</label>
							<input type="file" name="image" id="image" onchange="changePhoto();"/>
							<p style="margin-top: 15px;" class="important_render">支持上传文件最大尺寸：2 M</p>
						</div></div>
						
						<c:if test="${not empty teamGroup.photo }">
							<div class="c50r"><div class="subcr type-text">
								<img id="photo_img" src="${basePath }/file/view?path=${teamGroup.photo}" width="200px;"/>
							</div></div>
						</c:if>
					</div></div>
				
				</div>
				<div class="subcolumns">
					<div class="type-text" id="editorDiv">
						<label for="editor">成员简介：</label>
						<textarea id="editor" name="about" style="width:700px;height:300px; visibility:hidden;" >${teamGroup.about}
						</textarea>
					</div>
				</div>
			
			</fieldset>
		</form>
		
		<div class="subcolumns"><div class="c80l"><div class="subcl">
			<div id="console_render">&nbsp;</div>
		</div></div><div class="c20r"><div class="subcr">&nbsp;</div></div></div>
		
		<div class="type-button" style="margin-top: 20px;">
			<a href="javascrip:;" onclick="doSave();"  class="ui-button">提交</a>
		</div>
		
	</div>
	</div><div id="ie_clearing">&nbsp;</div></div>
	<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp"></jsp:include>
<jsp:include page="/view/console/include/yamlfocusfix.jsp"></jsp:include>

</body>
</html>
