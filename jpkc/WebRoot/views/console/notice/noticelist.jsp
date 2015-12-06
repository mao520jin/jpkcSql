<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>通告列表 - ${APP_CONSOLE_NAME_CN} - ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<script type="text/javascript" src="${basePath}/js/notice.js"></script>

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
			<jsp:param name="vListActive" value="noticeList" />
			<jsp:param name="hListActive" value="OperationsManagement" />
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
		<form method="post" action="${basePath}/notice/list" class="yform columnar" role="application">
			<fieldset>
				<div class="subcolumns">
					<div class="c25l">
						<div class="subcl type-text">
							<label for="title">标题检索：</label><input type="text" name="title" id="title" size="15" value="${title }"/>
						</div>
					</div>
					<div class="c25r">
							<div class="subcr type-button">
									<input type="submit" value="提交查询" class="submit"  />
							</div>
										</div>
					</div>
			</fieldset>
		</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead><tr><th scope="col" colspan="13">
				<div>
					<jsp:include page="/views/page/page.jsp"/>				
				</div>
			</th></tr></thead>
			<tbody>
				<tr><th scope="col">序号</th><th scope="col">标题</th><th scope="col">发布时间</th><th scope="col">操作</th></tr>
				<c:forEach items="${page.content}" var="o" varStatus="status">
				<tr>
				<td>${status.index +1}</td>
				<td><a>${o.title}</a></td>
				<td>${o.createTime}</td>
				<td>
					<a href="${basePath}/notice/edit/${o.id}">编辑</a>         
					<a href="${basePath}/notice/del/${o.id}">删除</a>         
				</td>
				 </tr>
				</c:forEach>

			</tbody>
		</table>
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

