<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String hListActive = request.getParameter("hListActive");
	String vListActive = request.getParameter("vListActive");
%>

<% if("OperationsManagement".equalsIgnoreCase(hListActive)) { %>
<h6 class="vlist">后台管理</h6>
<ul class="vlist">
	
	<li><strong>用户管理</strong>
		<ul>
		<% if("UserList".equalsIgnoreCase(vListActive)) { %>
				<li class="active"><strong>用户列表</strong></li>
		<% } else { %>
			<li><a href="${basePath}/user/list">用户列表</a></li>
		<% } %>
		</ul>
	</li>
	
	<li><strong>通知公告</strong>
		<ul>
		<% if("noticeList".equalsIgnoreCase(vListActive)) { %>
				<li class="active"><strong>公告列表</strong></li>
		<% } else { %>
			<li><a href="${basePath}/notice/list">公告列表</a></li>
		<% } %>
		
		<% if("addNotice".equalsIgnoreCase(vListActive)) { %>
			<li class="active"><strong>添加公告</strong></li>
		<% } else { %>
			<li><a href="${basePath}/notice/add">添加公告</a></li>
		<% } %>
		
		</ul>
	</li>
	
	<li><strong>科研团队</strong>
		<ul>
		<% if("teamList".equalsIgnoreCase(vListActive)) { %>
				<li class="active"><strong>团队成员列表</strong></li>
		<% } else { %>
			<li><a href="${basePath}/team/list">团队成员列表</a></li>
		<% } %>
		
		<% if("addteam".equalsIgnoreCase(vListActive)) { %>
			<li class="active"><strong>添加成员</strong></li>
		<% } else { %>
			<li><a href="${basePath}/team/add">添加成员</a></li>
		<% } %>
		
		</ul>
	</li>
	
	<li><strong>成果展示</strong>
		<ul>
		<% if("resultList".equalsIgnoreCase(vListActive)) { %>
				<li class="active"><strong>成果列表</strong></li>
		<% } else { %>
			<li><a href="${basePath}/result/list">成果列表</a></li>
		<% } %>
		
		<% if("addResult".equalsIgnoreCase(vListActive)) { %>
			<li class="active"><strong>添加成果</strong></li>
		<% } else { %>
			<li><a href="${basePath}/result/add">添加成果</a></li>
		<% } %>
		
		</ul>
	</li>
	 
	<li><strong>资源管理</strong>
		<ul>
		<% if("resourcesList".equalsIgnoreCase(vListActive)) { %>
				<li class="active"><strong>资源列表</strong></li>
		<% } else { %>
			<li><a href="${basePath}/resources/list">资源列表</a></li>
		<% } %>
		
		<% if("addresources".equalsIgnoreCase(vListActive)) { %>
			<li class="active"><strong>添加资源</strong></li>
		<% } else { %>
			<li><a href="${basePath}/resources/add">添加资源</a></li>
		<% } %>
		</ul>
	</li>
	
</ul>
<% } %>
<!--  
<% if("MobileDb".equalsIgnoreCase(hListActive)) { %>
<h6 class="vlist">取号库管理</h6>
<ul class="vlist">
	
	<li><strong>项目管理</strong>
		<ul>
			<li><a href="#">项目管理</a></li>
			<li><a href="#">项目迁移</a></li>
		</ul>
	</li>

	<li><strong>号码管理</strong>
		<ul>
			<li><a href="#">在线号码列表</a></li>
			<li><a href="#">释放号码列表</a></li>
			<li><a href="#">锁定号码列表</a></li>
			<li><a href="#">黑名单列表</a></li>
			<li><a href="#">项目黑名单列表</a></li>
			<li><a href="#">资源库列表</a></li>
			<li><a href="#">已做号码列表</a></li>
			<li><a href="#">平台请求号码情况</a></li>
		</ul>
	</li>
	
	<li><strong>其他</strong>
		<ul>
			<li><a href="#">卡商未勾选项列表</a></li>
			<li><a href="#">平台运行状况</a></li>
			<li><a href="#">用户可用号码预测</a></li>
		</ul>
	</li>
	
</ul>
<% } %>
-->
