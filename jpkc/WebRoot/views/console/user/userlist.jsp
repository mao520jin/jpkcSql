<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>用户列表 ${APP_CONSOLE_NAME_CN}  ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/user.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary">
<div id="col1_content" class="clearfix">
<jsp:include page="/views/console/include/vlist.jsp">
	<jsp:param name="vListActive" value="UserList" />
	<jsp:param name="hListActive" value="OperationsManagement" />
</jsp:include>

	</div>
</div>
<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main"><div id="col3_content" class="clearfix">
		
		<form method="post" id="serach_form" action="${basePath}/user/list" class="yform full" role="application">
			<fieldset>
				<jsp:include page="/views/console/include/render.jsp" />
				<div class="subcolumns">
					<div class="c20l">
						<div class="subcl type-text">
							<label for="Uname">用户名：</label>
							<input type="text" name="Uname" id="Uname" size="15" value="${Uname }"/>
						</div>
					</div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20r"><div class="subcr"></div></div>
				</div>
			</fieldset>
			
			<div class="type-button">
					<a href="javascrip:;" onclick="doSearch();" class="ui-button">查询</a>
			</div>
	</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead>
				<tr><th scope="col" colspan="3">
						<a href="javascript:;" onclick="doAdd();">添加</a>
						<span>&nbsp;|&nbsp;</span>
						<a href="javascript:;" onclick="doDelete();">删除</a>
				</th></tr>
			</thead>
			
			<tbody>
				<tr>
					<th scope="col"><input id="checkAll" type="checkbox" onclick="doCheckAll(this);"/></th>
					<th scope="col">用户名</th>
					<th scope="col">密码</th>
				</tr>
				<c:forEach items="${page.content}" var="o" varStatus="status">
				<tr>
					<td><input id="item_${i}" type="checkbox" onclick="doCheckItem(this);" value="${o.id}"/></td>
					<td>${o.username}</td>
					<td>${o.password}</td>
				 </tr>
				</c:forEach>

			</tbody>
		</table>

		<div>
				<jsp:include page="/views/page/page.jsp"/>				
		</div>
	</div><div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>

<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/views/console/include/footer.jsp"></jsp:include>
<jsp:include page="/views/console/include/yamlfocusfix.jsp"></jsp:include>

<div id="user_form_div" title="资料内容">
	<form id="add_user_form" method="post" action="${basePath}/user/addUser" class="yform full" role="application">
			<div class="type-text" id="user_content">
				<div class="type-text">
					<label for="username">账号</label>
					<input type="text"  name="username" id="username" />
				</div>
				<div class="type-text">
					<label for="password">密码</label>
					<input type="password"  name="password" id="password" /> 
				</div>
			</div>
	</form>
</div>

</body>
</html>

