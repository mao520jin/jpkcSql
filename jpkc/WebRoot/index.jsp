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
<script type="text/javascript">
	$(function(){
		$(document).off('click.bs.dropdown.data-api');
		showDate();
		setInterval(showDate, 1000);
	});

	function getDate(str) {
		var date = new Date(str);
		Y = date.getFullYear() + '-';
		M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds(); 
		return Y+M+D+h+m+s;
	}

function loadData() {
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/jpkc/front/loadNotice",
		dataType: "json",
		success: function(msg){
			
		var code = msg.code;
		var data = msg.data;
		if(code != "20000") {
			return false;
		}
		
		var  notice =  [];
		if(data.length > 3) {
			for(var i=0; i<3; i++) {
				var title = data[i].title;
				if(title.length >16) {
					title = title.substring(0,15) + "...";
				}
				var content = {
					"title": title,
					"time": getDate(data[i].createTime),
					"id": data[i].id
				};
				notice.push(content); 
			}
		}else{
			for(var i=0; i<data.length; i++) {
				var title = data[i].title;
				if(title.length >16) {
					title = title.substring(0,15) + "...";
				}
				var content = {
					"title": title, 
					"time": getDate(data[i].createTime),
					"id": data[i].id
				};
				notice.push(content); 
			}
		}
		
		var data1 = { "notice": notice };
		var myTemplate = Handlebars.compile($("#list").html());
		//将json对象用刚刚注册的Handlebars模版封装，得到最终的html，插入到基础table中。
		$('#notice-details').html(myTemplate(data1)); 
		}
	});
}
</script>

<script id="list" type="text/x-handlebars-template">
	{{#each notice}}
		<dl>
			<dd>
				<a href="javascript:void(0);">{{title}}</a><span>{{time}}</span>
			</dd>
		</dl>
	{{/each}}
</script>
</head>

<body onload="loadData();">
<div class="wrapper"><div class="container-fluid" id="LG">

<div class="row-fluid header">

	<div class="col-xs-6 header-left">
		<img src="<%=basePath %>/kc-images/logo.png" alt="山东科技大学精品课程">
	</div>
	
	<div class="col-xs-6 header-right">
		<div class="title-info">
			<span class="title">物流工程</span><br />
			<span class="director">负责人：冯夕文</span>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
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
			<li class="active">
				<a href="#">主要目录</a>
			</li>
			<li>
				<a href="#">通知公告</a>
			</li>
			<li>
				<a href="#">教学大纲</a>
			</li>
			<li>
				<a href="#">教学课件</a>
			</li>
			<li>
				<a href="#">参考书目</a>
			</li>
			<li>
				<a href="#">习题解答</a>
			</li>
			<li>
				<a href="#">模拟试题</a>
			</li>
			<li>
				<a href="#">课程实验</a>
			</li>
			<li>
				<a href="#">相关下载</a>
			</li>
		</ul>
	</div>

<div id="content" class="col-xs-10" style="width: 85%;">
	<div class="row-fluid">
		<div class="col-xs-7">
			<div class="center">
				<div class="info survey">
					<h3>课程概要</h3>
					<div class="details">
						<img src="<%=basePath %>/kc-images/book1.png">
						<p>《物流工程》是以物流系统为研究对象，研究物流系统的规划设计与资源优化配置、物流运作过程的计划与控制以及经营管理的工程领域。现代物流作为一门新兴的综合性边缘科学，在发达国家已有较早、较全面的研究，并形成了一系列的理论和方法，在指导其物流产业的发展中发挥了重要作用。</p>
					</div>
					<div style="clear:both;"></div>
				</div>
				
				<div class="info feature">
					<h3>课程特色</h3>
					<div class="details">
						<img src="<%=basePath %>/kc-images/book2.png">
						<p>《物流工程》课程的授课形式以系统讲解为主，辅以启发式、案例式、讨论式等教学模式，形成了课堂讲授、课程设计、课外辅导、校企合作、实验教学、现场教学等相结合的教学体系；系统开发了具有独立知识产权的教学课件和教学模具。依托在物流管理与成本核算方向的科研优势，选择合适的素材，扩展该课程的教学内容，加强了现代物流管理方法的教学。</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="right">
				<div class="info notice">
					<h3>通知公告<a href="">More...</a></h3>
					<div class="details" id="notice-details"></div>
				</div>
				
				<div class="info link">
					<h3>友情链接</h3>
					<div class="details">
						<ul>
							<li><a href="">中国物流学会</a></li>
							<li><a href="">中国物流与采购联合会</a></li>
							<li><a href="">全国高校精品课程资源库</a></li>
							<li><a href="">山东科技大学</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
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
</body>
</html>