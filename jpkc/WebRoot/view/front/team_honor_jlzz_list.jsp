<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>首页-工程爆破精品课程</title>
	<jsp:include page="/view/front/include/style.jsp"></jsp:include>
	<jsp:include page="/view/front/include/script.jsp" flush="true" />
</head>

	<body>
		<jsp:include page="/view/front/include/header.jsp"></jsp:include>
		
		<jsp:include page="/view/front/include/nav.jsp" flush="true">
			<jsp:param name="navActive" value="kyxm" />
		</jsp:include>
		
		<article class="main">
			
			<jsp:include page="/view/front/include/left.jsp" flush="true">
				<jsp:param name="menuActive" value="kyxm" />
			</jsp:include>
		
			<section class="wlmain wlmain_item1">
				<c:forEach items="${pager.content}" var="o">
					<div>
						<span><a href="${basePath }/front/honor/detail/${o.id }">${o.title }</a></span>
						<span><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></span>
					</div>
				</c:forEach>
				<jsp:include page="/view/front/include/pager.jsp" flush="true">
					<jsp:param name="pagePath" value="/front/notice/list" />
				</jsp:include>
			</section>
			
			<div class="main-bottom"></div>
		</article>
		
		<jsp:include page="/view/front/include/footer.jsp"></jsp:include>
		
		<script src="${basePath }/js/front/yui-min.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/calendar.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/jquery3.min.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/zyindex.js" charset="utf-8"></script>
	</body>

</html>