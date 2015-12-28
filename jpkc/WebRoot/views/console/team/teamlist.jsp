<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/console/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>团队列表 ${APP_CONSOLE_NAME_CN}  ${APP_NAME_CN}</title> 

<jsp:include page="/views/console/include/style.jsp"></jsp:include>
<jsp:include page="/views/console/include/script.jsp" flush="true" />
<script type="text/javascript" src="${basePath}/js/team.js"></script>

</head>

<body class="hidecol2">

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp"><jsp:param name="hListActive" value="OperationsManagement" /></jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary">
<div id="col1_content" class="clearfix">
<jsp:include page="/views/console/include/vlist.jsp">
	<jsp:param name="vListActive" value="teamList" />
	<jsp:param name="hListActive" value="OperationsManagement" />
</jsp:include>

	</div>
</div>
<!-- end: #col1 -->

<!-- begin: #col2 second float column -->
<div id="col2" role="complementary"><div id="col2_content" class="clearfix">&nbsp;</div></div>
<!-- end: #col2 -->

<!-- begin: #col3 static column -->
<div id="col3" role="main"><div id="col3_content" class="clearfix">
		<form method="post" id="serach_form" action="${basePath}/team/list" class="yform full" role="application">
			<fieldset>
				<jsp:include page="/views/console/include/render.jsp" />
				<div class="subcolumns">
					<div class="c20l">
						<div class="subcl type-text">
							<label for="memberName">成员名称：</label>
							<input type="text" name="memberName" id="memberName" size="15" value="${memberName }"/>
						</div>
					</div>
					<div class="c20l">
						<div class="subc type-select">
							<label for="teamType">成员身份:</label>
								<select id = "teamType" name="teamType">
									<c:choose> 
										<c:when test="${empty teamType}">
											<option value="0" selected="selected">-</option>
											<option value="1">导师</option>
											<option value="2">学生</option>
										</c:when>
										<c:when test="${teamType eq 1}">
											<option value="0" >-</option>
											<option value="1" selected="selected">导师</option>
											<option value="2">学生</option>	 
										</c:when> 
										<c:when test="${teamType eq 2}">
											<option value="0" >-</option>
											<option value="1">导师</option>
											<option value="2" selected="selected">学生</option>	 
										</c:when> 
									</c:choose> 
								</select>
						</div>
					</div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20l"><div class="subc"></div></div>
					<div class="c20r"><div class="subcr"></div></div>
				</div>
			</fieldset>
			<div class="type-button">
					<a href="javascrip:;" onclick="doSearch();" class="ui-button">查询</a>
			</div>
		</form>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead>
				<tr><th scope="col" colspan="8">
						<a href="${basePath}/team/add">添加</a>
						<span>&nbsp;|&nbsp;</span>
						<a href="javascript:;" onclick="teamDelete();">删除</a>
				</th></tr>
			</thead>
			
			<tbody>
				<tr>
					<th scope="col"><input id="checkAll" type="checkbox" onclick="doCheckAll(this);"/></th>
					<th scope="col">成员名称</th>
					<th scope="col">简介</th>
					<th scope="col">邮箱</th>
					<th scope="col">电话</th>
					<th scope="col">类型</th>
					<th scope="col">创建时间</th>
					<th scope="col">操作</th>
				</tr>
				<c:forEach items="${page.content}" var="o" varStatus="i">
						<input type="hidden" id="content_${o.id }" value="${fn:replace(o.content,'\"','&quot;')}" />
					<tr>
					   <td><input id="item_${i}" type="checkbox" onclick="doCheckItem(this);" value="${o.id}"/></td>
					   <td>${o.memberName}</td>
					   <td><a href="javascript:;" onclick="openContent('${o.id}');">详细</a></td>
					   <td>${o.email}</td>
					   <td>${o.tel}</td>
					   <td>  
					   <c:choose> 
						   <c:when test="${o.type eq 1}">导师   
					   </c:when> 
					   <c:when test="${o.type eq 2}">学生   
					   	   </c:when> 
					   </c:choose> 
						</td>
						<td><fmt:formatDate value="${o.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a href="${basePath}/team/edit/${o.id}">编辑</a>         
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

<div id="team_form" title="资料内容">
	<form method="post" action="" class="yform full" role="application">
			<div class="type-text" id="team_content">
				
			</div>
	</form>
</div>

</body>
</html>

