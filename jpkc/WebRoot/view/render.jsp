<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${WEB_APP_MY_DISPLAY_NAME}</title>

<jsp:include page="/view/console/include/style.jsp" flush="true" />
<jsp:include page="/view/console/include/script.jsp" flush="true" />
<style >
  /* --- 字体 --- */
	.s_f12pxb,
	.p_f12px,
	.p_f14px,
	.p_f16pxb,
	.p_f18px,
	.p_f18pxb,
	.p_f24pxb {
		font-family: "Microsoft YaHei", "微软雅黑", "Lantinghei SC", "Open Sans", Arial, "Hiragino Sans GB", "STHeiti", "WenQuanYi Micro Hei", SimSun, sans-serif;
		color: #555;
	}
	.p_f14px { font-size: 14px; font-weight: normal; }
	.p_f24pxb { font-size: 24px;  font-weight: bold; }
</style>

</head>

<body style="background-color: #fff;">

<jsp:include page="/view/console/include/skiplinks.jsp" flush="true" />

<div id="main" style="background-color: #fff;"><div class="page_margins"><div class="page" style="padding-top: 100px;">

	<div class="subcolumns">
		<div class="c25l"><div class="subcl">&nbsp;</div></div>
		<div class="c50l"><div class="subc">
			<p class="p_f24pxb">很抱歉，服务器无法处理您的请求！</p>
			<p class="p_f14px">温馨提示：</p>
			<p class="p_f14px">1、请检查您访问的网址是否正确。</p>
			<p class="p_f14px">2、如果您不能确认访问的网址，请<a href="${basePath}/" style="color: rgb(255,127,39);">浏览首页</a>查看更多说明。</p>
			<p class="p_f14px">3、稍后重新尝试。</p>
			<p class="p_f14px">4、如有任何意见或建议，请及时反馈给我们。</p>
		</div></div>
		<div class="c25r"><div class="subcr">&nbsp;</div></div>
	</div>

</div></div></div>

<jsp:include page="/view/console/include/yamlfocusfix.jsp" flush="true" />


</body>
</html>
