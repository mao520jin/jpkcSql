<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>详情 - 物流工程</title>
<jsp:include page="/view/front/include/style.jsp"></jsp:include>
<jsp:include page="/view/front/include/script.jsp" flush="true" />
</head>

<body>
	<jsp:include page="/view/front/include/header.jsp"></jsp:include>

	<jsp:include page="/view/front/include/nav.jsp" flush="true">
		<jsp:param name="navActive" value="${type }" />
	</jsp:include>

	<article class="main">

		<jsp:include page="/view/front/include/left.jsp" flush="true">
			<jsp:param name="menuActive" value="${type }" />
		</jsp:include>

		<section class="wlmain wlmain_item1">
			<div>
				<div>
					<iframe id="iframe" style="width:785px;height: 800px;" src="<%=basePath %>/view/front/readFile.jsp?id=${id}"></iframe>
				</div>
			</div>
		</section>

		<div class="main-bottom"></div>
	</article>

	<jsp:include page="/view/front/include/footer.jsp"></jsp:include>

</body>

</html>