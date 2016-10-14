<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String navActive = request.getParameter("navActive");
%>

<nav>

	<ul class="indexNavUl">
		<% if("index".equalsIgnoreCase(navActive)) { %> <li class="firstLi indexFirst"><a href="${basePath}/front/index">首页</a></li> <% } else { %> <li class="indexFirst"><a href="${basePath}/front/index">首页</a></li> <% } %>
		<% if("kcgk".equalsIgnoreCase(navActive)) { %> <li class="firstLi item1"> <% } else { %> <li class="item1"> <% } %>
			<a href="javascript:;"><span class="iconfont">&#xe601;</span>课程概况</a>
			<div class="item1-menu menu">
				<ul>
					<li><a href="${basePath }/front/about">课程简介</a></li>
					<li><a href="javascript:;">课程特色</a></li>
					<li><a href="${basePath }/front/resource/list?type=jxdg">教学大纲</a></li>
				</ul>
			</div>
		</li>
		
		<% if("szdw".equalsIgnoreCase(navActive)) { %> <li class="firstLi item2"> <% } else { %> <li class="item2"> <% } %>
			<a href="javascript:;"><span class="iconfont">&#xe601;</span>师资队伍</a>
			<div class="item2-menu menu">
				<ul>
					<li><a href="${basePath }/front/group/list?type=kcfzr">课程负责人</a></li>
					<li><a href="${basePath }/front/group/list?type=jxtd">教学团队</a></li>
					<li><a href="${basePath }/front/group/list?type=qnjspx">青年教师培养</a></li>
				</ul>
			</div>
		</li>
		
		<% if("jxcg".equalsIgnoreCase(navActive)) { %> <li class="firstLi item3"> <% } else { %> <li class="item3"> <% } %>
			<a href="javascript:;"><span class="iconfont">&#xe601;</span>教学成果</a>
			<div class="item3-menu menu">
				<ul>
					<li><a href="${basePath }/front/honor/list?type=kyxm">科研项目</a></li>
					<li><a href="${basePath }/front/honor/list?type=xszz">学术著作</a></li>
					<li><a href="${basePath }/front/honor/list?type=jlzz">奖励资助</a></li>
					<li><a href="${basePath }/front/honor/list?type=cgzs">学生成果展示</a></li>
				</ul>
			</div>
		</li>
		
		<% if("jxts".equalsIgnoreCase(navActive)) { %> <li class="firstLi item4"> <% } else { %> <li class="item4"> <% } %>
			<a href="javascript:;"><span class="iconfont">&#xe601;</span>教学特色</a>
			<div class="item4-menu menu">
				<ul>
					<li><a href="${basePath }/front/resource/list?type=jxkj">教学课件</a></li>
					<li><a href="${basePath }/front/notice/list">校企合作教学</a></li>
					<li><a href="${basePath }/front/resource/list?type=mxzjjt">名校专家讲堂</a></li>
				</ul>
			</div>
		</li>
		
		<% if("jxpj".equalsIgnoreCase(navActive)) { %> <li class="firstLi item5"> <% } else { %> <li class="item5"> <% } %>
			<a href="javascript:;"><span class="iconfont">&#xe601;</span>教学评价</a>
			<div class="item5-menu menu">
				<ul>
					<li><a href="${basePath }/front/resource/list?type=xsfk">学生反馈</a></li>
					<li><a href="${basePath }/front/resource/list?type=xnzhpj">校内综合评价</a></li>
					<li><a href="${basePath }/front/resource/list?type=xwzjpj">校外专家评价</a></li>
				</ul>
			</div>
		</li>
		<% if("declare".equalsIgnoreCase(navActive)) { %> <li class="firstLi"><a href="${basePath }/front/declare">申报材料</a></li> <% } else { %> <li><a href="${basePath }/front/declare">申报材料</a></li> <% } %>
		<% if("lxwm".equalsIgnoreCase(navActive)) { %> <li class="firstLi"><a href="${basePath }/front/contact">联系我们</a></li> <% } else { %> <li><a href="${basePath }/front/contact">联系我们</a></li> <% } %>
	</ul>
</nav>

