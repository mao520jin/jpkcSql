<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>添加公告 - ${APP_CONSOLE_NAME_CN} - ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/include/script.jsp"></jsp:include>
<script type="text/javascript" src="${basePath}/js/notice.js"></script>

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
			<jsp:param name="vListActive" value="addNotice" />
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
		<form method="post" action="${basePath}/notice/addNotice" class="yform" role="application" id="addNoticeForm">
				<div class="type-text" id="titleDiv">
					<label for="title">标题:<sup >*</sup></label>
					<input type="text" name="title" id="title" size="20" value="${noticeList[0].title}" onblur="check(id);"/>
				</div>
					<input type="hidden" name="id" id="id"  value="${noticeList[0].id}"/>
				<div class="type-text" id="editorDiv">
					<label for=content>内容：<sup >*</sup></label>
					<textarea id="editor" name="content" style="width:700px;height:300px; visibility:hidden;" >${noticeList[0].content}
					</textarea>
				</div>
				
			<div class="type-button">
				<input type="button" value="确认提交"    onclick="doSubmit();"/>
			</div>
		</form>
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
