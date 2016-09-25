<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/taglib.jsp" %>

<c:if test="${not empty render}">
	<c:if test="${fn:startsWith(render.code, '1')}"><c:set var="cls" value="info" /></c:if>
	<c:if test="${fn:startsWith(render.code, '2')}"><c:set var="cls" value="note" /></c:if>
	<c:if test="${fn:startsWith(render.code, '3')}"><c:set var="cls" value="info" /></c:if>
	<c:if test="${fn:startsWith(render.code, '4')}"><c:set var="cls" value="warning" /></c:if>
	<c:if test="${fn:startsWith(render.code, '5')}"><c:set var="cls" value="warning" /></c:if>
	<c:if test="${fn:startsWith(render.code, '6')}"><c:set var="cls" value="important" /></c:if>
	<p class="${cls}">${render.data}</p>
</c:if>