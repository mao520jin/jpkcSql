<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String hListActive = request.getParameter("hListActive");
	String vListActive = request.getParameter("vListActive");
%>

<h6 class="vlist">${WEB_APP_CONSOLE_DISPLAY_NAME}</h6>
<ul class="vlist">
	<li><strong>系统设置</strong>
		<ul>
			<% if("sysAdmin".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>系统管理员</strong></li> <% } else { %> <li><a href="${basePath}/console/sysadmin/list">系统管理员</a></li> <% } %>
		</ul>
	</li>
	<li><strong>公告通知</strong>
		<ul>
			<% if("noticeList".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>公告通知列表</strong></li> <% } else { %> <li><a href="${basePath}/console/notice/list">公告通知列表</a></li> <% } %>
			<% if("editNotice".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>公告通知编辑</strong></li> <% } else { %> <li><a href="${basePath}/console/notice/edit">公告通知编辑</a></li> <% } %>
		</ul>
	</li>
	<li><strong>师资团队</strong>
		<ul>
			<% if("teamGroupList".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>团队成员列表</strong></li> <% } else { %> <li><a href="${basePath}/console/group/list">团队成员列表</a></li> <% } %>
			<% if("editTeamGroup".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>团队成员编辑</strong></li> <% } else { %> <li><a href="${basePath}/console/group/edit">团队成员编辑</a></li> <% } %>
		</ul>
	</li>
	<li><strong>教学荣誉</strong>
		<ul>
			<% if("teamHonorList".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>教学荣誉列表</strong></li> <% } else { %> <li><a href="${basePath}/console/honor/list">教学荣誉列表</a></li> <% } %>
			<% if("editTeamHonor".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>教学荣誉编辑</strong></li> <% } else { %> <li><a href="${basePath}/console/honor/edit">教学荣誉编辑</a></li> <% } %>
		</ul>
	</li>
	
	<li><strong>教学资源</strong>
		<ul>
			<% if("teamResourceList".equalsIgnoreCase(vListActive)) { %> <li class="active"><strong>教学资源列表</strong></li> <% } else { %> <li><a href="${basePath}/console/resource/list">教学资源列表</a></li> <% } %>
		</ul>
	</li>
	
</ul>
