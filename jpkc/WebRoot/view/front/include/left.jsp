<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String menuActive = request.getParameter("menuActive");
%>

<section class="left">
	<div class="leftnav">
		<h3 class="maintitle">课程资源</h3>
		<ul>
			<% if("notice".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/notice/list">※ &nbsp;通知公告</a></li> <% } else { %> <li><a href="${basePath }/front/notice/list">※ &nbsp;通知公告</a></li> <% } %>
			<% if("jxdg".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=jxdg">※ &nbsp;教学大纲</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=jxdg">※ &nbsp;教学大纲</a></li> <% } %>
			<% if("dzja".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=dzja">※ &nbsp;电子教案</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=dzja">※ &nbsp;电子教案</a></li> <% } %>
			<% if("jxkj".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=jxkj">※ &nbsp;教学课件</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=jxkj">※ &nbsp;教学课件</a></li> <% } %>
			<% if("jxsp".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=jxsp">※ &nbsp;教学视频</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=jxsp">※ &nbsp;教学视频</a></li> <% } %>
			<% if("cksm".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/notice/list">※ &nbsp;参考书目</a></li> <% } else { %> <li><a href="${basePath }/front/notice/list">※ &nbsp;参考书目</a></li> <% } %>
			<% if("kcsx".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/notice/list">※ &nbsp;课程实习</a></li> <% } else { %> <li><a href="${basePath }/front/notice/list">※ &nbsp;课程实习</a></li> <% } %>
			<% if("mnst".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=mnst">※ &nbsp;模拟试题</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=mnst">※ &nbsp;模拟试题</a></li> <% } %>
			<% if("syjx".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=syjx">※ &nbsp;实验教学</a></li> <% } else { %> <li><a href="${basePath }/front/resource/list?type=syjx">※ &nbsp;实验教学</a></li> <% } %>
			<% if("shsj".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/notice/list">※ &nbsp;社会实践</a></li> <% } else { %> <li><a href="${basePath }/front/notice/list">※ &nbsp;社会实践</a></li> <% } %>
			<% if("ksap".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/notice/list">※ &nbsp;考试安排</a></li> <% } else { %> <li><a href="${basePath }/front/notice/list">※ &nbsp;考试安排</a></li> <% } %>
			<% if("zlxz".equalsIgnoreCase(menuActive)) { %> <li><a class="firsta" href="${basePath }/front/resource/list?type=zlxz">※ &nbsp;资料下载</a></li> <% } else { %> <li><a class="lasta" href="${basePath }/front/resource/list?type=zlxz">※ &nbsp;资料下载</a></li> <% } %>
		</ul>
	</div>
	
	<div class="calendar">
		<h3 class="maintitle">日历</h3>
		<div class="calendar-container">
			<div id="J_calendar"></div>
		</div>
	</div>
</section>