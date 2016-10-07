<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统管理员 - 物流工程控制台</title>

<jsp:include page="/view/console/include/style.jsp" flush="true" />
<jsp:include page="/view/console/include/script.jsp" flush="true" />

<script type="text/javascript" src="${basePath}/js/console/sys_admin.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/view/console/include/skiplinks.jsp" flush="true" />
<jsp:include page="/view/console/include/header.jsp" flush="true" />
<jsp:include page="/view/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

	<!-- begin: #col1 - first float column -->
	<div id="col1" role="complementary"><div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp" flush="true">
			<jsp:param name="vListActive" value="sysAdmin" />
			<jsp:param name="hListActive" value="OperationsManagement" />
		</jsp:include>
	</div></div>
	<!-- end: #col1 -->

	<!-- begin: #col2 second float column -->
	<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col2 -->

	<!-- begin: #col3 static column -->
	<div id="col3" role="main"><div id="col3_content" class="clearfix">
		<form id="sys_admin_search_form" method="post" action="${basePath}/console/sysadmin/list" onsubmit="return doBeforeSearch();" class="yform full" role="application">
			<jsp:include page="/view/console/include/page.jsp" flush="true" />
			<fieldset>
				<div class="subcolumns">
					<div class="c20l"><div class="subcl type-text">
						<label for="username">用户名</label>
						<input type="text" id="username" name="username" value="${username}" maxlength="32" />
					</div></div>
					<div class="c20l"><div class="subc type-select">
						<label for="status">状态</label>
						<select id="status" name="status">
							<option value="">-</option>
							<option value="0" <c:if test="${status == 0}">selected="selected"</c:if>>禁用</option>
							<option value="1" <c:if test="${status == 1}">selected="selected"</c:if>>启用</option>
						</select>
					</div></div>
					<div class="c20l"><div class="subc">&nbsp;</div></div>
					<div class="c20l"><div class="subc">&nbsp;</div></div>
					<div class="c20r"><div class="subcr">&nbsp;</div></div>
				</div>
			</fieldset>
			<div class="type-button">
				<a href="javascrip:;" onclick="doClear('sys_admin_search_form');" class="ui-button">清空</a>
				<a href="javascrip:;" onclick="doSearch();" class="ui-button">查询</a>
			</div>
		</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead>
				<tr>
					<th scope="col" colspan="10">
						<a href="javascript:;" onclick="doEdit('');">添加管理员</a>
						<span>&nbsp;|&nbsp;</span>
						<a href="javascript:;" onclick="doDelete('ids', '');">删除</a>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="col"><input type="checkbox" id="checkAll" name="checkAll" onclick="setSelected(this, 'checkAll', 'item_');" /></th>
					<th scope="col">ID</th>
					<th scope="col">用户名</th>
					<th scope="col">状态</th>
					<th scope="col">备注</th>
					<th scope="col">创建人</th>
					<th scope="col">创建时间</th>
					<th scope="col">最后更新人</th>
					<th scope="col">最后更新时间</th>
					<th scope="col"><a href="javascript:;" onclick="setColumnModel();">...</a></th>
				</tr>
				<c:forEach items="${pager.content}" var="o">
				<tr>
					<td><input type="checkbox" id="item_${o.id}" value="${o.id}" onclick="setSelected(this, 'checkAll', 'item_');" /></td>
					<td><input type="hidden" id="id_${o.id}" value="${o.id}" />${o.id}</td>
					<td><input type="hidden" id="username_${o.id}" value="${o.username}" />${o.username}</td>
					<td>
						<input type="hidden" id="status_${o.id}" value="${o.status}" />
						<c:if test="${o.status == 0}"><span style="color: #7f7f7f;">禁用</span></c:if>
						<c:if test="${o.status == 1}"><span style="color: #22b14c;">启用</span></c:if>
					</td>
					<td><input type="hidden" id="desc_${o.id}" value="${o.desc}" />${o.desc}</td>
					<td><input type="hidden" id="createdBy_${o.id}" value="${o.createdBy}" />${o.createdBy}</td>
					<td><input type="hidden" id="createdDate_${o.id}" value="${o.createdDateString}" />${o.createdDateString}</td>
					<td><input type="hidden" id="lastModifiedBy_${o.id}" value="${o.lastModifiedBy}" />${o.lastModifiedBy}</td>
					<td><input type="hidden" id="lastModifiedDate_${o.id}" value="${o.lastModifiedDateString}" />${o.lastModifiedDateString}</td>
					<td>
						<a href="javascript:;" onclick="doEdit('${o.id}');">编辑</a>
						<span>&nbsp;|&nbsp;</span>
						<a href="javascript:;" onclick="doDelete('id', '${o.id}');">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="/view/console/include/pager.jsp" flush="true">
			<jsp:param name="pageForm" value="sys_admin_search_form" />
			<jsp:param name="pagePath" value="/console/sysadmin/list" />
		</jsp:include>
		
	</div><div id="ie_clearing">&nbsp;</div></div>
	<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp" flush="true" />
<jsp:include page="/view/console/include/yamlfocusfix.jsp" flush="true" />

<!-- 新增、编辑表单 -->
<div id="sys_admin_edit_div" style="display: none;">
	<form id="sys_admin_edit_form" method="post" action="" class="yform full" role="application" style="text-align: left;">
		<input type="hidden" id="action" value="" />
		<input type="hidden" id="edit_id" value="" />
		<fieldset>
			<div class="type-text">
				<label for="edit_username">用户名</label>
				<input type="text" id="edit_username" maxlength="32" />
			</div>
			<div class="type-text">
				<label for="edit_password">密码<span id="edit_pwd_span">（<a id="a_edit_password" href="javascript:;" onclick="doEditPwd(this);" style="color: red;">编辑</a>）</span></label>
				<input type="text" id="edit_password" maxlength="32" />
			</div>
			<div class="type-select">
				<label for="edit_status">状态</label>
				<select id="edit_status">
					<option value="">-</option>
					<option value="1">启用</option>
					<option value="0">禁用</option>
				</select>
			</div>
			<div class="type-text">
				<label for="edit_desc">备注</label>
				<textarea id="edit_desc" cols="30" rows="5"></textarea>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>
