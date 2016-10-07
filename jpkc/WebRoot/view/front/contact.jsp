<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>联系我们 - 物流工程</title>
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
				<div class="leftnav">
					<p class="MsoNormal" style="text-indent:80pt;">
						冯夕文
						办公电话：0532-86057073       邮箱：fxw6380@163.com
					</p>
					<p class="MsoNormal" style="text-indent:80pt;">
						李美燕
						办公电话：0532-86057163       邮箱：limeiyanqdu@163.com
					</p>
					<p class="MsoNormal" style="text-indent:80pt;">
						任大伟
						办公电话：0532-86057163       邮箱：dawei_ren_2000@163.com
					</p>
					<p class="MsoNormal" style="text-indent:80pt;">
						祝朱武
						办公电话：0532-86057036       邮箱：skdzzw@sdust.edu.cn
					</p>
					<p class="MsoNormal" style="text-indent:80pt;">
						贾　顺
						办公电话：0532-86057044       邮箱：herojiashun@163.com
					</p>
					<p class="MsoNormal" style="text-indent:80pt;">
						颜　伟
						办公电话：0532-86057044       邮箱：yanwei_sdust@163.com
					</p>
				</div>
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