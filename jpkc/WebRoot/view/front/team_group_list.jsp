<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>教学团队 - 物流工程</title>
	<jsp:include page="/view/front/include/style.jsp"></jsp:include>
	<jsp:include page="/view/front/include/script.jsp" flush="true" />
</head>

	<body>
		<jsp:include page="/view/front/include/header.jsp"></jsp:include>
		
		<jsp:include page="/view/front/include/nav.jsp" flush="true">
			<jsp:param name="navActive" value="jxtd" />
		</jsp:include>
		
		<article class="main">
			
			<jsp:include page="/view/front/include/left.jsp" flush="true">
				<jsp:param name="menuActive" value="jxtd" />
			</jsp:include>
		
			<section class="wlmain wlmain_item1">
				<c:forEach items="${pager.content}" var="o">
					<p>
						<a href="${basePath }/front/group/detail/${o.id }">${o.name }</a>
						<span class="wlmain_alink"><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></span>
					</p>
				</c:forEach>
				<jsp:include page="/view/front/include/pager.jsp" flush="true">
					<jsp:param name="pagePath" value="/front/group/list?type=${type }" />
				</jsp:include>
			</section>
			
			<div class="main-bottom"></div>
		</article>
		
		<jsp:include page="/view/front/include/footer.jsp"></jsp:include>
	</body>

</html>