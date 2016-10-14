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
			<jsp:param name="navActive" value="lxwm" />
		</jsp:include>
		
		<article class="main">
			
			<jsp:include page="/view/front/include/left.jsp" flush="true">
				<jsp:param name="menuActive" value="kyxm" />
			</jsp:include>
		
			<section class="wlmain wlmain_item1">
				<div class="leftnav">
					<p class="MsoTitle">
						<span style="font-family:宋体;font-size:30px;">课程联系人</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">冯夕文</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057073 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>fxw6380@163.com</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">李美燕</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057163 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>limeiyanqdu@163.com</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">任大伟</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057163 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>dawei_ren_2000@163.com</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">朱祝武</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057036 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>skdzzw@sdust.edu.cn</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">贾　顺</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057044 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>herojiashun@163.com</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">颜　伟</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057044 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>yanwei_sdust@163.com</span>
					</p>
					<p class="MsoNormal">
						<span>&nbsp;</span>
					</p>
					<p class="MsoNormal">
						<b><span style="font-family:宋体;">刘兆霞</span><span></span></b>
					</p>
					<p class="MsoNormal">
						<span style="font-family:宋体;">办公电话：</span><span>0532-86057044 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family:宋体;">邮箱：</span><span>zhaoxialiu@163.com</span>
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