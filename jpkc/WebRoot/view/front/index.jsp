<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>首页 - 物流工程</title>
	<jsp:include page="/view/front/include/style.jsp"></jsp:include>
	<jsp:include page="/view/front/include/script.jsp" flush="true" />
</head>

	<body>
		<jsp:include page="/view/front/include/header.jsp"></jsp:include>
		
		<jsp:include page="/view/front/include/nav.jsp" flush="true">
			<jsp:param name="navActive" value="index" />
		</jsp:include>
		
		<article class="main">
			
			<jsp:include page="/view/front/include/left.jsp" flush="true">
				<jsp:param name="menuActive" value="index" />
			</jsp:include>
		
			<section class="center">
				<ul class="bottom-fy">
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ul>
				<div class="center-msg1" style="display:block">
					<div class="main-info">
						<h3 class="maintitle">课程介绍</h3>
						<div class="box">
							<div class="imgbox"><a href="${basePath }/front/about"><img src="${basePath}/images/front/KCJS.jpg"></a></div>
							<p class="p1">《物流工程》是工业工程学科领域中的主干课程之一，物流工程对国民经济建设具有重要的意义和作用，物流工程侧重于利用系统工程理论和方法以及工程技术来研究物流系统的规划、设计和运行，物流工程不仅可以用来解决生产制造企业的物流系统规划、设计、库存与仓储管理，也可用于社会物资调配、建设项目选址、商贸系统规划与管理，乃至经济区域发展的规划、设计、管理等，其理论与技术应用范围相当广泛。本课程系统地讲述了物流工程、设施规划与设计、物料搬运系统设计、仓储系统的规划与设计、运输系统的规划与设计、物流系统规划的分析与评价、物流系统建模与仿真、现代物流工程的基本概念、理论、方法及物流工程的实施步骤等。</p>
						</div>
					</div>
					<div class="main-info">
						<h3 class="maintitle">课程特色</h3>
						<div class="box">
							<div class="imgbox"><img style="height: 200px;" src="${basePath}/images/front/KCTS.jpg"></div>
							<p class="p1">《物流工程》课程的授课形式以系统讲解为主，辅以启发式、案例式、讨论式等教学模式，形成了课堂讲授、课程设计、课外辅导、校企合作、实验教学、现场教学等相结合的教学体系；系统开发了具有独立知识产权的教学课件和教学模具。依托在物流管理与成本核算方向的科研优势，选择合适的素材，扩展该课程的教学内容，加强了现代物流管理方法的教学。</p>
							<p class="p2">同时，不断改进传统教学形式和教学设备，将先进的教学手段应用到不同的教学环节之中，普及了多媒体教学。为了培养学生的实际操作能力和现场实践经验，本课程特别注重实践教学，开辟了与山东宏宇农机股份有限公司等企业合作的产学研基地，任课教师经常带领学生深入青岛市物流工程一线开展实践教学，取得了良好的教学效果。</p>
						</div>
					</div>
				</div>
			</section>
			
			<section class="right">
				<div class="iconfont icon-more more01"></div>
				<div class="right-proclaim right-info">
					<h3 class="maintitle">通知公告</h3>
					<ul>
						<c:forEach begin="0" end="3" items="${noticePager.content}" var="o">
							<li><a href="${basePath }/front/notice/detail/${o.id }">${o.title }</a>
							<p><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></p></li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="right-teach right-info">
					<div class="iconfont icon-more more01"></div>
					<h3 class="maintitle">试验教学</h3>
					<ul>
						<c:forEach begin="0" end="2" items="${resourcePager.content}" var="o">
							<li>
								<a href="${basePath }/view/office?id=${o.id }">${o.title }</a>
								<p><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></p>
							</li>
						</c:forEach>
					</ul>
				</div>
				
				<div class="right-link right-info">
					<div class="iconfont icon-more more01"></div>
					<h3 class="maintitle">相关链接</h3>
					<ul>
						<li><a href="http://csl.chinawuliu.com.cn/" target="blank">中国物流学会</a></li>
						<li><a href="http://www.chinawuliu.com.cn/" target="blank">中国物流与采购联合会</a></li>
						<li><a href="http://www.jpkcw.com/" target="blank">国家精品课程网</a></li>
						<li><a href="http://sync.cctr.net.cn/" target="blank">中国高等学校教学资源网</a></li>
						<li><a href="http://www.sdust.edu.cn/" target="blank">山东科技大学</a></li>
					</ul>
				</div>
			</section>
			
			<div class="main-bottom"></div>
		</article>
		
		<article class="teacherShow">
			<h3 class="maintitle">教师风采</h3>
			<div class="teach-box">
				<div class="teach-lb">
					<c:forEach items="${groupList}" var="o">
						<c:if test="${not empty o.photo }">
							<div class="teachImg-box">
								<a href="${basePath}/front/group/detail/${o.id}"><img src="${basePath}/image/view?path=${o.photo}"></a>
								<span>${o.name}</span>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</article>
		
		<jsp:include page="/view/front/include/footer.jsp"></jsp:include>
	</body>

</html>