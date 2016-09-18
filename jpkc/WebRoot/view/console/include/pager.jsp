<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/taglib.jsp" %>

<%
	String pageForm = request.getParameter("pageForm");
	String pagePath = request.getParameter("pagePath");
%>

<c:if test="${not empty pager}">
<p>
	<span>总数&nbsp;${pager.totalElements}&nbsp;条</span><span>&nbsp;</span>
	<a href="javascript:;" onclick="setPageSize('<%=pageForm%>', '<%=pagePath%>', '${pager.pageNumber}');">每页&nbsp;${pager.pageSize}&nbsp;条</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pageForm%>', '<%=pagePath%>', '1');">首页</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pageForm%>', '<%=pagePath%>', '${pager.previous}');">上一页</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pageForm%>', '<%=pagePath%>', '');">${pager.pageNumber}&nbsp;/&nbsp;${pager.totalPages}</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pageForm%>', '<%=pagePath%>', '${pager.next}');">下一页</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pageForm%>', '<%=pagePath%>', '${pager.totalPages}');">尾页</a><span>&nbsp;</span>
</p>
</c:if>