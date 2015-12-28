<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${WEB_APP_CONSOLE_DISPLAY_NAME}</title>

<jsp:include page="/views/console/include/style.jsp" flush="true" />
<jsp:include page="/views/console/include/script.jsp" flush="true" />

<script type="text/javascript">

function doShowConfirmDialog() {
	showConfirmDialog("确定要删除吗？", "操作提示", function(r) {
		alert("showConfirmDialog: " + r);
	});
}

function doShowMessageDialog() {
	showMessageDialog("操作成功！", "操作提示", function(r) {
		alert("showMessageDialog: " + r);
	});
}

function doShowInputDialog() {
	showInputDialog("请输入：", "操作提示", function(r) {
		alert("showInputDialog: " + r);
	});
}

function doShowOptionDialog() {
	showOptionDialog("操作异常，确定要回滚吗？", "操作提示", function(r) {
		alert("showOptionDialog: " + r);
	}, "YES_NO_CANCEL_OPTION", "QUESTION_MESSAGE", "CONFIRM_DIALOG");
}

</script>

<style type="text/css">

</style>

</head>

<body>

<jsp:include page="/views/console/include/skiplinks.jsp" flush="true" />
<jsp:include page="/views/console/include/header.jsp" flush="true" />
<jsp:include page="/views/console/include/nav.jsp" flush="true" />

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

	<!-- begin: #col1 - first float column -->
	<div id="col1" role="complementary"><div id="col1_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col1 -->

	<!-- begin: #col2 second float column -->
	<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col2 -->

	<!-- begin: #col3 static column -->
	<div id="col3" role="main"><div id="col3_content" class="clearfix">
	
		<a href="javascrip:;" onclick="doShowConfirmDialog();" class="ui-button">showConfirmDialog</a>
		
		<br /><br /><br />
		
		<a href="javascrip:;" onclick="doShowMessageDialog();" class="ui-button">showMessageDialog</a>
		
		<br /><br /><br />
		
		<a href="javascrip:;" onclick="doShowInputDialog();" class="ui-button">showInputDialog</a>
		
		<br /><br /><br />
		
		<a href="javascrip:;" onclick="doShowOptionDialog();" class="ui-button">showOptionDialog</a>
		
	</div><div id="ie_clearing">&nbsp;</div></div>
	<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/views/console/include/footer.jsp" flush="true" />
<jsp:include page="/views/console/include/yamlfocusfix.jsp" flush="true" />

</body>
</html>
