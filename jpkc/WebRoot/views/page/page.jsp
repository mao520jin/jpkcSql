<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/include/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<title>jpkc</title>

<jsp:include page="/views/include/style.jsp"></jsp:include>
<jsp:include page="/views/include/script.jsp"></jsp:include>

</head>
<body>
	<div>
		<p>
		当前第${page.currentPage } 页
		每页${page.pageSize }条
		<a href="#" onclick = "goPage(1,${page.pageSize },${page.pageCount });">首页</a>
		<a href="#" onclick = "goPage(${page.currentPage - 1} ,${page.pageSize },${page.pageCount });">上一页</a>
		<a href="#" onclick = "goPage(${page.currentPage + 1} ,${page.pageSize },${page.pageCount });">下一页</a>
		<a href="#" onclick = "goPage(${page.totalCount},${page.pageSize },${page.pageCount });">尾页</a>
		共${page.totalCount }条数据
		共${page.pageCount } 页
		</p>
	</div>
</body>
</html>
