<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>通告列表 ${APP_CONSOLE_NAME_CN}  ${APP_NAME_CN}</title>

<jsp:include page="/view/console/include/style.jsp"></jsp:include>
<jsp:include page="/view/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/console/honor.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/view/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/view/console/include/header.jsp"></jsp:include>
<jsp:include page="/view/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary">
	<div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp">
			<jsp:param name="vListActive" value="teamHonorList" />
			<jsp:param name="hListActive" value="OperationsManagement" />
		</jsp:include>
	</div>
</div>
<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main">
	<div id="col3_content" class="clearfix">
		
		<form method="post" id="serach_form" action="${basePath}/console/honor/list" class="yform full" role="application">
		<jsp:include page="/view/console/include/page.jsp" flush="true" />
			<fieldset>
				<jsp:include page="/view/console/include/render.jsp" />
				<div class="subcolumns">
					<div class="c20l"><div class="subcl type-text">
							<label for="name">成员检索：</label>
							<input type="text" name="name" id="name" size="15" value="${name }"/>
					</div></div>
					<div class="c20l"><div class="subc type-select">
						<label for="type">类型</label>
						<select id="type" name="type">
							<option value="">-</option>
							<option value="1" <c:if test="${type == 1}">selected="selected"</c:if>>科研项目</option>
							<option value="2" <c:if test="${type == 2}">selected="selected"</c:if>>学术著作</option>
							<option value="3" <c:if test="${type == 3}">selected="selected"</c:if>>奖励资助</option>
							<option value="4" <c:if test="${type == 4}">selected="selected"</c:if>>学生成果展示</option>
						</select>
					</div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20r"><div class="subcr"></div></div>
				</div>
			</fieldset>
			<div class="type-button">
				<a href="javascrip:;" onclick="doClear('serach_form');" class="ui-button">清空</a>
				<a href="javascrip:;" onclick="javascript:$('#serach_form').submit();;" class="ui-button">查询</a>
			</div>
		</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead>
				<tr>
					<th scope="col" colspan="18">
						<a href="javascript:;" onclick="doEdit('new', '');">添加</a> 
							<span>&nbsp;|&nbsp;</span>
						<a href="javascript:;" onclick="doDelete('ids', '');">删除</a>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="col" style="width: 20px;"><input type="checkbox" id="checkAll" name="checkAll" onclick="setSelected(this,'checkAll','item_');" /></th>
					<th scope="col">成员名称</th>
					<th scope="col">标题</th>
					<th scope="col">简介</th>
					<th scope="col">荣誉类型</th>
					<th scope="col">备注</th>
					<th scope="col" style="width: 80px;">创建人</th>
					<th scope="col" style="width: 150px;">创建时间</th>
					<th scope="col" style="width: 80px;">最后更新人</th>
					<th scope="col" style="width: 150px;">最后更新时间</th>	
					<th scope="col">操作</th>	
				</tr>
				<c:forEach items="${pager.content}" var="o">
					<tr>    
						<td ><input type="checkbox" id="item_${o.id }" value="${o.id }" onclick="setSelected(this,'checkAll','item_');" /></td>
						<td><input type="hidden" id="name_${o.id}" value="${o.name}" />${o.name }</td>
						<td><input type="hidden" id="title_${o.id}" value="${o.title}" />${o.title }</td>
						<td>
							<input type="hidden" id="about_${o.id }" value="${fn:replace(o.about,'\"','\'')}" />
							<a href="javascript:;" onclick="doView('${o.id }');">详情</a>
						</td>
						<td>
							<input type="hidden" id="type_${o.id}" value="${o.type}" />
							<c:if test="${o.type == 1}">科研项目</c:if>
							<c:if test="${o.type == 2}">学术著作</c:if>
							<c:if test="${o.type == 3}">奖励资助</c:if>
							<c:if test="${o.type == 4}">学生成果展示</c:if>
						</td>
						<td><input type="hidden" id="desc_${o.id}" value="${o.desc }" />${o.desc }</td>
						<td><input type="hidden" id="createdBy_${o.id}" value="${o.createdBy }" />${o.createdBy }</td>
						<td><input type="hidden" id="createdDate_${o.id}" value="${o.createdDate }" /><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><input type="hidden" id="lastModifiedBy_${o.id}" value="${o.lastModifiedBy }" />${o.lastModifiedBy }</td>
						<td><input type="hidden" id="lastModifiedDate_${o.id}" value="${o.lastModifiedDate }" /><fmt:formatDate value="${o.lastModifiedDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a href="javascript:;" onclick="doEdit('edit', '${o.id }');">编辑</a>&nbsp;|&nbsp;
							<a href="javascript:;" onclick="doDelete('id', '${o.id}');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
			<!-- 表单提交，避免超链接显示path -->
		<form id="edit_form" method="post" action="${basePath }/console/honor/edit">
			<input type="hidden" id="action" name="action"/>
			<input type="hidden" id="edit_id" name="id"/>
		</form>
	
		<jsp:include page="/view/console/include/pager.jsp" flush="true">
			<jsp:param name="pageForm" value="serach_form" />
			<jsp:param name="pagePath" value="/console/honor/list" />
		</jsp:include>

	</div><div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>
<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp"></jsp:include>
<jsp:include page="/view/console/include/yamlfocusfix.jsp"></jsp:include>

<div id="about_form" title="公告内容">
	<form method="post" action="" class="yform full" role="application">
			<div class="type-text" id="about"></div>
	</form>
</div>

</body>
</html>

