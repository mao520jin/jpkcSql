<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>123</title>

<script type="text/javascript" src="<%=basePath %>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/custom/template.css" />
<script type="text/javascript" src="<%=basePath %>/js/front/front.js"></script>
</head>

<body >
<div class="wrapper"><div class="container-fluid" id="LG">

<div class="row-fluid header">

	<div class="col-xs-6 header-left">
		<img src="<%=basePath %>/kc-images/logo.png" alt="山东科技大学精品课程" />
	</div>
	
	<div class="col-xs-6 header-right">
		<div class="title-info">
			<span class="title">物流工程</span><br />
			<span class="director">负责人：冯夕文</span>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>

<div class="navbar navbar-default"><div class="navbar-inner"><div class="container-fluid"><div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav">
		<li class="active"><a href="<%=basePath %>/front/index">首页</a></li> 
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">课程概况<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">课程简介</a></li>
				<li><a href="#">课程特色</a></li>
				<li><a href="#">教学大纲</a></li>
				<li><a href="#">校企合作助学</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">师资队伍<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">课程负责人</a></li>
				<li><a href="#">教学团队</a></li>
				<li><a href="#">青年教师培养</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">教学成果<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">科研项目</a></li>
				<li><a href="#">出版教材</a></li>
				<li><a href="#">奖励资助</a></li>
			</ul>
		</li>
		<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">课程资源<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">教学课件</a></li>
				<li><a href="#">教学视频</a></li>
				<li><a href="#">名师讲座</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">教学评价<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">学生反馈</a></li>
				<li><a href="#">校内综合评价</a></li>
				<li><a href="#">校外专家评价</a></li>
			</ul>
		</li>
		<li><a href="#">申报材料</a></li>
		<li><a href="#">联系我们</a></li>
	</ul>
</div></div></div></div>

<div class="row-fluid" style="min-height: 500px;">
	<div class="col-xs-2" style="width: 15%; padding-top: 10px;">
		<ul class="nav nav-stacked nav-pills">
			<li>
				<a href="<%=basePath %>/front/index">主要目录</a>
			</li>
			<li>
				<a href="<%=basePath%>/frontNotice/noticesIndex">通知公告</a>
			</li>
			<li >
				<a href="javascript:;" onclick="doView('2');">教学课件</a>
			</li>
			<li>
				<a href="javascript:;" onclick="doView('3');">教学视频</a>
			</li>
			<li>
				<a href="javascript:;" onclick="doView('4');">教学大纲</a>
			</li>
			<li class="active">
				<a href="javascript:;" onclick="doView('5');">实验教学资料</a>
			</li>
			<li>
				<a href="javascript:;" onclick="doView('1');">电子教案</a>
			</li>
			<li>
				<a href="#">课程实验</a>
			</li>
			<li>
				<a href="#">相关下载</a>
			</li>
		</ul>
	</div>

	<div id="content" class="col-xs-12" style="width: 85%;">  
		<div class="fl" id="yulan_div">
				<iframe id="iframe"  style="width:785px;height: 800px;" src="<%=basePath %>/views/front/readFile.jsp?fileName=${ fileName}"></iframe>
		</div>
	</div>

<div class="clear"></div>
</div>

<div class="border"></div>
<div class="row-fluid" style="padding-left: 20px;padding-right: 20px;">
	<div class="col-xs-8" style="padding-top: 15px;">
		<address style="line-height: 1.8em;color: #ddd;">
			<strong>单位地址：山东省青岛经济技术开发区前湾港路579号 邮政编码：266590</strong>
			<br />
			<abbr title="Phone">联系电话：</abbr>0532-8057073
			<br/>
			<span>维　　护：山东科技大学物流工程 E-mail:fxw6380@163.com</span>
			<br/>
			<span>版权 © 2015 物流工程精品课程 保留所有权利 Designed by 风华正茂&同门</span>
			<br/>
		</address>
	</div>
	<div class="col-xs-4">
		<div class="date-session">
			<div class="details">
				<div>访问量：1000</div>
				<div id="date" class="date"></div>
			</div>
		</div>
	</div>
</div>


</div>
</div>

<form id="view_type_form" name="view_type_form"  method="post"  action="<%=basePath %>/frontResources/resourcesIndex" style="display: none">
	<input type="hidden" id="view_type" name="type"/>
</form>
</body>
</html>