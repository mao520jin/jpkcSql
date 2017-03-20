<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>公告通知编辑 - 物流工程控制台 </title>

<jsp:include page="/view/console/include/style.jsp"></jsp:include>
<jsp:include page="/view/console/include/script.jsp"></jsp:include>
<script type="text/javascript" src="${basePath}/js/console/website_notice.js"></script>

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
				allowFileManager : true,
				allowImageRemote:false,
				filterMode : false,
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
<div id="col1" role="complementary">
	<div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp">
			<jsp:param name="hListActive" value="OperationsManagement" />
			<jsp:param name="vListActive" value="editNotice" />
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
		<form method="post" action="${basePath}/notice/edit" class="yform" role="application" id="addNoticeForm">
			<input type="hidden" name="id" id="id"  value="${websiteNotice.id}"/>
			<fieldset>
				<jsp:include page="/view/console/include/render.jsp" />
				<div class="subcolumns" >
					<div class="c80l"><div class="subcl type-text">
						<label for="title">公告标题：</label>
						<input type="text" name="title" id="title" size="20" value="${websiteNotice.title}" />
					</div></div>
					
					<div class="c20r"><div class="subcr "></div></div>
				</div>
				<div class="type-text" id="editorDiv">
					<label for="content">公告内容：</label>
					<textarea id="editor" name="content" style="width:700px;height:300px; visibility:hidden;" >${websiteNotice.content}
					</textarea>
				</div>
				
				<div class="subcolumns"><div class="c80l"><div class="subcl">
					<div id="console_render">&nbsp;</div>
				</div></div><div class="c20r"><div class="subcr">&nbsp;</div></div></div>
				
			</fieldset>
		</form>
		
		<div class="type-button ">
			<a href="javascrip:;" onclick="doSave();"  class="ui-button ">提交</a>
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
