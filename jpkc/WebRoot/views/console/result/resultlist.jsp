<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>教学成果 ${APP_CONSOLE_NAME_CN}  ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/result.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->

<div id="col1" role="complementary"><div id="col1_content" class="clearfix">
	<jsp:include page="/views/console/include/vlist.jsp">
		<jsp:param name="vListActive" value="resultList" />
		<jsp:param name="hListActive" value="OperationsManagement" />
	</jsp:include>
</div></div>

<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main">

	<div id="col3_content" class="clearfix">
		<form method="post" id="serach_form" action="${basePath}/result/list" class="yform full" role="application">
			<fieldset>
				<jsp:include page="/views/console/include/render.jsp" />
				<div class="subcolumns">
					<div class="c25l">
						<div class="subcl type-text">
							<label for="memberName">标题检索：</label>
							<input type="text" name="memberName" id="memberName" size="15" value="${memberName }"/>
						</div>
					</div>
					<div class="c25l">
						<div class="subc type-select">
							<label for="resultType">资源类型:</label>
							<select id = "resultType" name="resultType">
								<c:choose> 
									<c:when test="${empty resultType}">
										<option value="0" selected="selected">-</option>
										<option value="1">主持项目</option>
										<option value="2">发表论文</option>
										<option value="3">出版教材</option>
										<option value="4">奖励情况</option>
									</c:when>
									<c:when test="${resultType eq 1}">
										<option value="0">-</option>
										<option value="1" selected="selected">主持项目</option>
										<option value="2">发表论文</option>
										<option value="3">出版教材</option>
										<option value="4">奖励情况</option> 
									</c:when> 
									<c:when test="${resultType eq 2}">
										<option value="0" selected="selected">-</option>
										<option value="1">主持项目</option>
										<option value="2" selected="selected">发表论文</option>
										<option value="3">出版教材</option>
										<option value="4">奖励情况</option>
									</c:when> 
									<c:when test="${resultType eq 3}">
										<option value="0">-</option>
										<option value="1">主持项目</option>
										<option value="2">发表论文</option>
										<option value="3" selected="selected">出版教材</option>
										<option value="4">奖励情况</option>	 
									</c:when> 
									<c:when test="${resultType eq 4}">
										<option value="0">-</option>
										<option value="1">主持项目</option>
										<option value="2">发表论文</option>
										<option value="3">出版教材</option>
										<option value="4" selected="selected">奖励情况</option>
									</c:when> 
								</c:choose> 
							</select>
						</div>
					</div>
					<div class="c25l"><div class="subc"></div></div>
					<div class="c25r"><div class="subcr"></div></div>
				</div>
			</fieldset>
			<div class="type-button">
					<a href="javascrip:;" onclick="doSearch();" class="ui-button">查询</a>
			</div>
	</form>
	
	<table border="0" cellpadding="0" cellspacing="0" class="full">
		<thead>
			<tr><th scope="col" colspan="6">
					<a href="${basePath}/result/add">添加</a>
					<span>&nbsp;|&nbsp;</span>
					<a href="javascript:;" onclick="doDelete();">删除</a>
			</th></tr>
		</thead>
		
		<tbody>
				<tr>
					<th scope="col"><input id="checkAll" type="checkbox" onclick="doCheckAll(this);"/></th>
					<th scope="col">成果者</th>
					<th scope="col">作品简介</th>
					<th scope="col">类型</th>
					<th scope="col">时间</th>
					<th scope="col">操作</th>
				</tr>
			<c:forEach items="${page.content}" var="o" varStatus="i">
					<input type="hidden" id="content_${o.id }" value="${fn:replace(o.content,'\"','&quot;')}" />
				<tr>
					<td><input id="item_${i}" type="checkbox" onclick="doCheckItem(this);" value="${o.id}"/></td>
					<td>${o.member_name}</td>
					<td><a href="javascript:;" onclick="openContent('${o.id}');">查看</a></td>
					<td>  
						<c:choose> 
							<c:when test="${o.type eq 1}">主持项目   
							</c:when> 
							<c:when test="${o.type eq 2}">发表论文   
							</c:when> 
							<c:when test="${o.type eq 3}">出版教材   
							</c:when>
							<c:when test="${o.type eq 4}">奖励情况   
							</c:when>
						</c:choose> 
					 </td>
					 <td><fmt:formatDate value="${o.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					 <td>
						<a href="${basePath}/result/edit/${o.id}">编辑</a>         
					 </td>
				 </tr>
			</c:forEach>
		</tbody>
	</table>
		
		<div>
				<jsp:include page="/views/page/page.jsp"/>				
		</div>
		
	</div><div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>
<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/views/console/include/footer.jsp"></jsp:include>
<jsp:include page="/views/console/include/yamlfocusfix.jsp"></jsp:include>

<div id="result_form" title="资料内容">
	<form method="post" action="" class="yform full" role="application">
			<div class="type-text" id="result_content"></div>
	</form>
</div>
</body>
</html>

