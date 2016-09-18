<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% String hListActive = request.getParameter("hListActive"); %>

<!-- begin: main navigation #nav -->
<div id="nav" role="navigation">
		<div class="page_margins">
		<div class="page">
			<div class="hlist">
				<ul>
<% if("OperationsManagement".equalsIgnoreCase(hListActive)) { %>
					<li class="active"><strong>精品课程</strong></li>
				<% } else { %>
					<li><a href="${basePath}/user/list">精品课程</a></li>
				<% } %>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- end: main navigation -->