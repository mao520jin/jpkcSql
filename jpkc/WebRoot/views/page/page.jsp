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
		<strong>总数&nbsp;${page.totalElements}&nbsp;条，</strong>
		<strong>每页&nbsp;</strong>${page.pageSize}<strong>&nbsp;条，</strong>
		<strong>页码&nbsp;${page.pageNumber}/${page.totalPages}&nbsp;，</strong>
		<a href="#" onclick = "goPage(1,${page.pageSize });">首页</a>
		<a href="#" onclick = "goPage(${page.previous} ,${page.pageSize });">上一页</a>
		<a href="#" onclick = "goPage(${page.next} ,${page.pageSize });">下一页</a>
		<a href="#" onclick = "goPage(${page.totalPages},${page.pageSize });">尾页</a>
		共${page.totalElements}条数据
		共${page.totalPages} 页
		</p>
	</div>
</body>
</html>
