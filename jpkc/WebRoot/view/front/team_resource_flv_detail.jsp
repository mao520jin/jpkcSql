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

<script type="text/javascript" src="<%=basePath %>/js/flow/flowplayer-3.2.11.min.js"></script>

</head>

<body>
	<jsp:include page="/view/front/include/header.jsp"></jsp:include>

	<jsp:include page="/view/front/include/nav.jsp" flush="true">
		<jsp:param name="navActive" value="jxsp" />
	</jsp:include>

	<article class="main">

		<jsp:include page="/view/front/include/left.jsp" flush="true">
			<jsp:param name="menuActive" value="jxsp" />
		</jsp:include>

		<section class="wlmain wlmain_item1">
			<div id="content" class="col-xs-12" style="width: 85%;">  
				<div class="fl" id="yulan_div">
				  <div id="tl_player" style="width: 670px; height: 450px;"> </div>
				  <script>
				   	 flowplayer("tl_player", "<%=basePath %>/js/flow/flowplayer-3.2.12.swf", { clip: { url: "<%=basePath %>/view/converMedia/${resource.id}", autoPlay: true, autoBuffering: true} });
				  </script>
				</div>
			</div>
		</section>

		<div class="main-bottom"></div>
	</article>

	<jsp:include page="/view/front/include/footer.jsp"></jsp:include>
</body>

</html>