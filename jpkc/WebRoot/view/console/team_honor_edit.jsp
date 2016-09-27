<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>添加公告 </title>

<jsp:include page="/view/console/include/style.jsp"></jsp:include>
<jsp:include page="/view/console/include/script.jsp"></jsp:include>
<script type="text/javascript" src="${basePath}/js/console/honor.js"></script>

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
<div id="col1" role="complementary">
	<div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp">
			<jsp:param name="hListActive" value="OperationsManagement" />
			<jsp:param name="vListActive" value="editTeamHonor" />
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
		<form method="post" class="yform" role="application">
			<input type="hidden" name="id" id="id" size="20" value="${teamHonor.id}" />
			<input type="hidden" name="groupId" id="groupId" size="20" value="${teamHonor.teamGroupId}" />
			<div class="subcolumns">
			  <fieldset>
				<div class="subcolumns" >
					
					<div class="c33l"><div class="subcl type-select">
						<label for="name">成果人:</label>
						<select name="name" id="name" style="width: 200px;" >
							<option value="">-</option>
							<c:forEach var="o" items="${list }">
								<option value="${o.id }" <c:if test="${o.id eq teamHonor.teamGroupId }">selected="selected"</c:if> >${o.name }</option>
							</c:forEach>
						</select>
					</div></div>
					
					<div class="c33l"><div class="subc type-text">
						<label for="type">成果标题:</label>
						<input type="text" name="title" id="title" size="20" value="${teamHonor.title}" />
					</div></div>
					
					<div class="c33r"><div class="subcr type-select">
						<label for="type">成果类别:</label>
						<select id="type" name="type">
							<option value="" >-</option>
							<option value="1" <c:if test="${teamHonor.type eq 1}">selected="selected"</c:if>>科研项目</option>
							<option value="2" <c:if test="${teamHonor.type eq 2}">selected="selected"</c:if>>学术著作</option>
							<option value="3" <c:if test="${teamHonor.type eq 3}">selected="selected"</c:if>>奖励资助</option>
							<option value="4" <c:if test="${teamHonor.type eq 4}">selected="selected"</c:if>>学生成果展示</option>
						</select>
					</div></div>
				</div>
				<div class="type-text" id="editorDiv">
					<label for="editor">成果简介：</label>
					<textarea id="editor" name="about" style="width:700px;height:300px; visibility:hidden;" onblur="check(id);">${teamHonor.about }
					</textarea>
				</div>
			</fieldset>
			</div>
		</form>
		
		<div class="subcolumns"><div class="c80l"><div class="subcl">
			<div id="console_render">&nbsp;</div>
		</div></div><div class="c20r"><div class="subcr">&nbsp;</div></div></div>
		
		<div class="type-button" style="margin-top: 20px;">
			<a href="javascrip:;" onclick="doSave();"  class="ui-button">提交</a>
		</div>
		
	</div>
	
	<div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>
<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp"></jsp:include>
<jsp:include page="/view/console/include/yamlfocusfix.jsp"></jsp:include>

</body>
</html>
