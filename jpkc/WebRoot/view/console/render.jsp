<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${WEB_APP_CONSOLE_DISPLAY_NAME}</title>

<jsp:include page="/view/console/include/style.jsp" flush="true" />
<jsp:include page="/view/console/include/script.jsp" flush="true" />

</head>

<body>

<jsp:include page="/view/console/include/skiplinks.jsp" flush="true" />
<jsp:include page="/view/console/include/header.jsp" flush="true" />
<jsp:include page="/view/console/include/nav.jsp" flush="true" />

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

	<!-- begin: #col1 - first float column -->
	<div id="col1" role="complementary"><div id="col1_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col1 -->

	<!-- begin: #col2 second float column -->
	<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col2 -->

	<!-- begin: #col3 static column -->
	<div id="col3" role="main"><div id="col3_content" class="clearfix"><jsp:include page="/view/console/include/render.jsp" /></div><div id="ie_clearing">&nbsp;</div></div>
	<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp" flush="true" />
<jsp:include page="/view/console/include/yamlfocusfix.jsp" flush="true" />

</body>
</html>
