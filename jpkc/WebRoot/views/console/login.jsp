<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>登录 -  精品课程</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/console/include/script.jsp"></jsp:include>
<script type="text/javascript" src="${basePath}/js/user.js"></script>
</head>

<body>

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp"><jsp:param name="hListActive" value="login" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary"><div id="col1_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main">
	<div id="col3_content" class="clearfix">
		<form method="post" action="<%=basePath %>/user/login" class="yform" role="application" id="loginForm">
			<fieldset>
				<legend>管理控制台登录</legend>
				<strong class='message' id='"+id+"Msg' style="color: red;">${errorMsg }</strong>
				<div class="type-text" id="usernameDiv">
					<label for="username">用户名：</label>
					<input type="text" name="username" id="username" size="20" value="${user.username }"/>
				</div>
				<div class="type-text" id="passwordDiv">
					<label for="password">密　码：</label>
					<input type="password" name="password" id="password" size="20" value="${user.password }"/>
				</div>
			</fieldset>
			<div class="type-button">
					<a href="javascrip:;" onclick="loginSubmit();" class="ui-button">登录</a>
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
