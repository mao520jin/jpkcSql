<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="header" role="banner">
	<div class="page_margins">
		<div class="page">
			<div id="topnav" role="contentinfo">
				<c:if test="${not empty SESSION_USER}">
					<span><a href="#">${sessionScope.sysAdmin.username}</a> | <a href="${basePath }/console/sysadmin/logout">退出</a></span>
				</c:if>
				<c:if test="${empty SESSION_USER}">
					<span>&nbsp;</span>
				</c:if>
			</div>
			<h1>管理控制台</h1>
			<span>&#8226; 欢迎进入精品课程后台管理平台！</span>
		</div>
	</div>
</div> 