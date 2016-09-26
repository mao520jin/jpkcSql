<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String navActive = request.getParameter("navActive");
%>

<nav>
	<ul>
		<li class="first-li"><a href="${basePath}/front/index">首页</a></li>
		<li class="item1">
			<a href="#"><span class="iconfont">&#xe601;</span>课程概况</a>
			<div class="item1-menu menu">
				<ul>
					<li><a href="#">课程简介</a></li>
					<li><a href="#">课程特色</a></li>
					<li><a href="${basePath }/front/resource/list?type=jxdg">教学大纲</a></li>
				</ul>
			</div>
		</li>
		<li class="item2">
			<a href="#"><span class="iconfont">&#xe601;</span>师资队伍</a>
			<div class="item2-menu menu">
				<ul>
					<li><a href="#">课程负责人</a></li>
					<li><a href="#">教学团队</a></li>
					<li><a href="#">青年教师培养</a></li>
				</ul>
			</div>
		</li>
		<li class="item3">
			<a href="#"><span class="iconfont">&#xe601;</span>教学成果</a>
			<div class="item3-menu menu">
				<ul>
					<li><a href="#">科研项目</a></li>
					<li><a href="#">学术著作</a></li>
					<li><a href="#">奖励资助</a></li>
					<li><a href="#">学生成果展示</a></li>
				</ul>
			</div>
		</li>
		<li class="item4">
			<a href="#"><span class="iconfont">&#xe601;</span>教学特色</a>
			<div class="item4-menu menu">
				<ul>
					<li><a href="#">教学课件</a></li>
					<li><a href="#">校企合作教学</a></li>
					<li><a href="#">名校专家讲堂</a></li>
				</ul>
			</div>
		</li>
		<li class="item5">
			<a href="#"><span class="iconfont">&#xe601;</span>教学评价</a>
			<div class="item5-menu menu">
				<ul>
					<li><a href="#">学生反馈</a></li>
					<li><a href="#">校内综合评价</a></li>
					<li><a href="#">校外专家评价</a></li>
				</ul>
			</div>
		</li>
		<li><a href="#">申报材料</a></li>
		<li><a href="#">联系我们</a></li>
	</ul>
</nav>

