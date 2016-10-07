<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/taglib.jsp" %>

<%
	String pagePath = request.getParameter("pagePath");
%>

<c:if test="${not empty pager}">
<p>
	&nbsp;&nbsp;总数&nbsp;${pager.totalElements}&nbsp;条<span>&nbsp;&nbsp;</span>
	每页&nbsp;${pager.pageSize}&nbsp;条<span>&nbsp;&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pagePath%>', '1');">首页</a><span>&nbsp;&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pagePath%>', '${pager.previous}');">&nbsp;&nbsp;上一页</a><span>&nbsp;&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pagePath%>', '');">&nbsp;&nbsp;${pager.pageNumber}&nbsp;/&nbsp;${pager.totalPages}</a><span>&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pagePath%>', '${pager.next}');">&nbsp;&nbsp;下一页</a><span>&nbsp;&nbsp;</span>
	<a href="javascript:;" onclick="goToPage('<%=pagePath%>', '${pager.totalPages}');">&nbsp;&nbsp;尾页</a><span>&nbsp;&nbsp;</span>
</p>
</c:if>