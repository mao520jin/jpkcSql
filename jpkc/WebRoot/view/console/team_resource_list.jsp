<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>资源列表 ${APP_CONSOLE_NAME_CN}  ${APP_NAME_CN}</title>

<jsp:include page="/view/console/include/style.jsp"></jsp:include>
<jsp:include page="/view/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/console/resources.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/view/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/view/console/include/header.jsp"></jsp:include>
<jsp:include page="/view/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">
	
	<!-- begin: #col1 - first float column -->
	<div id="col1" role="complementary"><div id="col1_content" class="clearfix">
		<jsp:include page="/view/console/include/vlist.jsp">
			<jsp:param name="vListActive" value="teamResourceList" />
			<jsp:param name="hListActive" value="OperationsManagement" />
		</jsp:include>
	</div></div>
	<!-- end: #col1 -->
	
	<!-- begin: #col2 second float column -->
	<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
	<!-- end: #col2 -->
	
	<!-- begin: #col3 static column -->
	<div id="col3" role="main"><div id="col3_content" class="clearfix">
	
		<form method="post" id="serach_form" action="${basePath}/console/resource/list" class="yform full" role="application">
			<jsp:include page="/view/console/include/render.jsp" />
			<fieldset>
				<div class="subcolumns">
					<div class="c20l"><div class="subcl type-text">
						<label for="title">标题检索：</label>
						<input type="text" id="title" name="title" value="${title}" />
					</div></div>
					<div class="c20l"><div class="subc type-select">
						<label for="type">资源类别</label>
						<select id="type" name="type">
							<option value="">-</option>
							<option value="1" <c:if test="${type == 1}">selected="selected"</c:if>>电子教案</option>
							<option value="2" <c:if test="${type == 2}">selected="selected"</c:if>>教学课件</option>
							<option value="3" <c:if test="${type == 3}">selected="selected"</c:if>>教学视频</option>
							<option value="4" <c:if test="${type == 4}">selected="selected"</c:if>>教学大纲</option>
							<option value="5" <c:if test="${type == 5}">selected="selected"</c:if>>实验教学资料</option>
							<option value="6" <c:if test="${type == 6}">selected="selected"</c:if>>学生反馈</option>
							<option value="7" <c:if test="${type == 7}">selected="selected"</c:if>>校内综合评价</option>
							<option value="8" <c:if test="${type == 8}">selected="selected"</c:if>>校外专家评价</option>
							<option value="9" <c:if test="${type == 9}">selected="selected"</c:if>>模拟试题</option>
							<option value="10" <c:if test="${type == 10}">selected="selected"</c:if>>资料下载</option>
							<option value="11" <c:if test="${type == 11}">selected="selected"</c:if>>名校专家讲堂</option>
						</select>
					</div></div>
					<div class="c20l"><div class="subc type-select">
						<label for="isconvert">是否已转换</label>
						<select id="isconvert" name="isconvert">
							<option value="">-</option>
							<option value="2" <c:if test="${isconvert == 2}">selected="selected"</c:if>>已转换</option>
							<option value="1" <c:if test="${isconvert == 1}">selected="selected"</c:if>>未转换</option>
						</select>
					</div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20r"><div class="subcr"></div></div>
				</div>
			</fieldset>
			
			<div class="subcolumns"><div class="c80l"><div class="subcl">
				<div id="user_search_render">&nbsp;</div>
			</div></div><div class="c20r"><div class="subcr">&nbsp;</div></div></div>
			
			<div class="type-button">
				<a href="javascrip:;" onclick="doClear('serach_form');" class="ui-button">清空</a>
				<a href="javascrip:;" onclick="doSearch();" class="ui-button">查询</a>
			</div>
			
		</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full"> 
			<thead>
				<tr><th scope="col" colspan="7">
					<a href="javascript:;" onclick="doEdit();" >添加</a>
					<span>&nbsp;|&nbsp;</span>
					<a href="javascript:;" onclick="doDelete('ids', '');">删除</a>
				</th></tr>
			</thead>
			<tbody>
				<tr>
					<th scope="col"><input id="checkAll" type="checkbox" onclick="setSelected(this,'checkAll','item_');"/></th>
					
					<th scope="col">标题</th>
					<th scope="col">名称</th>
					<th scope="col">资源类型</th>
					<th scope="col">是否已转换</th>
					<th scope="col">发布时间</th>
					<th scope="col">操作</th>
				</tr>
				
				<c:forEach items="${pager.content}" var="o" varStatus="i">
					<input type="hidden" id="content_${o.id }" value="${fn:replace(o.path,'\"','&quot;')}" />
					<tr>
						<td><input id="item_${i}" type="checkbox" onclick="setSelected(this,'checkAll','item_');" value="${o.id}"/></td>
						<td><input type="hidden" id="title_${o.id}" value="${o.title }"/>${o.title}</td>
						<td><input type="hidden" id="name_${o.id}" value="${o.name }"/>${o.name}</td>
						<td>
							<input type="hidden" id="type_${o.id}" value="${o.type }"/>  
							<c:choose> 
								<c:when test="${o.type eq 1}">电子教案 	 </c:when> 
								<c:when test="${o.type eq 2}">教学课件  	 </c:when>
								<c:when test="${o.type eq 3}">教学视频   	 </c:when> 
								<c:when test="${o.type eq 4}">教学大纲	 </c:when> 
								<c:when test="${o.type eq 5}">实验教学资料   </c:when> 
								<c:when test="${o.type eq 6}">学生反馈   </c:when> 
								<c:when test="${o.type eq 7}">校内综合评价   </c:when> 
								<c:when test="${o.type eq 8}">校外专家评价   </c:when> 
								<c:when test="${o.type eq 9}">模拟试题   </c:when> 
								<c:when test="${o.type eq 10}">资料下载   </c:when> 
								<c:when test="${o.type eq 11}">名校专家讲堂   </c:when>
							</c:choose> 
						<td>
							<input type="hidden" id="isconvert_${o.id}" value="${o.isconvert }"/>  
							<c:choose> 
								<c:when test="${o.isconvert eq 2}">已转换</c:when>
								<c:when test="${o.isconvert eq 1}">未转换</c:when> 
							</c:choose>
						</td> 
						</td>
						<td><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<c:if test="${o.isconvert eq 1 }">
								<span><a href="javascript:;" onclick="convert('${o.path}', '${o.id }', '${o.type }');">转换</a>&nbsp;|&nbsp;</span>
							</c:if>
							<span><a href="javascript:;" onclick="doDelete('id', '${o.id }');">删除</a></span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="/view/console/include/pager.jsp" flush="true">
			<jsp:param name="pageForm" value="serach_form" />
			<jsp:param name="pagePath" value="/console/resource/list" />
		</jsp:include>
		
	</div><div id="ie_clearing">&nbsp;</div></div>
	<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/view/console/include/footer.jsp"></jsp:include>
<jsp:include page="/view/console/include/yamlfocusfix.jsp"></jsp:include>

<div id="resource_edit_div" style="display: none;">
	<form id="resource_edit_form" method="post" action="${basePath }/console/resource/save" enctype="multipart/form-data" class="yform full" role="application" style="text-align: left;">
		<fieldset>
			<div class="type-text">
				<label for="edit_title">标题</label>
				<input type="text" id="edit_title" name="title" />
			</div>

			<div class="type-text">
				<label for="edit_resource_type"></label>
				<input type="hidden" id="edit_resource_type" name="type" />
			</div>
			
			<div id="edit_path_div" class="type-text" style="display: ">
				<label for="edit_path">文件：</label>
				<input type="file" id="edit_path" name="file" />
			</div>
			
			<div class="type-select">
				<label for="edit_type">资源类别</label>
				<select id="edit_type" name="resourcesType">
					<option value="">-</option>
					<option value="1">电子教案</option>
					<option value="2">教学课件</option>
					<option value="3">教学视频</option>
					<option value="4">教学大纲</option>
					<option value="5">实验教学资料</option>
					<option value="6">学生反馈</option>
					<option value="7">校内综合评价</option>
					<option value="8">校外专家评价</option>
					<option value="9">模拟试题</option>
					<option value="10">资料下载</option>
					<option value="11">名校专家讲堂</option>
				</select>
			</div>
			
			<div class="subcolumns"><div class="c80l"><div class="subcl">
				<div id="edit_render">&nbsp;</div>
			</div></div><div class="c20r"><div class="subcr">&nbsp;</div></div></div>
		
		</fieldset>
	</form>
</div>

</body>
</html>

