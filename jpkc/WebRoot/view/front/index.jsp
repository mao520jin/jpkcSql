<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/front/include/base.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>首页-工程爆破精品课程</title>
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
							<div class="imgbox"><img src="${basePath}/images/front/06 .JPG"></div>
							<p class="p1">大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师</p>
							<p class="p2">的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可</p>
						</div>
					</div>
					<div class="main-info">
						<h3 class="maintitle">课程特色</h3>
						<div class="box">
							<div class="imgbox"><img src="${basePath}/images/front/abc.jpg"></div>
							<p class="p1">大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师大师傅开关时看见是会计师</p>
							<p class="p2">的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可的思考近代史上即可</p>
							<p class="p3">过法国的进口空间的更快更丰富的时间紧都深深地过法国的进口空间的更快更丰富的时间紧都深深地过法国的进口空间的更快更丰富的时间紧都深深地过法国的进口空间的更快更丰富的时间紧都深深地过法国的进口空间的更快更丰富的时间紧都深深地过法国的进口空间的更快更丰富的时间紧都深深地</p>
						</div>
					</div>
				</div>
				<div class="center-msg2">2222</div>
				<div class="center-msg3">3333</div>
			</section>
			
			<section class="right">
				<div class="right-proclaim right-info">
					<h3 class="maintitle">通知公告</h3>
					<ul>
						<c:forEach begin="0" end="3" items="${noticePager.content}" var="o">
							<a href="${basePath }/front/notice/detail/${o.id }">${o.title }</a>
							<p><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></p>
						</c:forEach>
					</ul>
				</div>
				
				<div class="right-teach right-info">
					<h3 class="maintitle">试验教学</h3>
					<ul>
						<c:forEach begin="0" end="2" items="${resourcePager.content}" var="o">
							<a href="#">${o.title }</a>
							<p><fmt:formatDate value="${o.createdDate}" pattern="yyyy-MM-dd hh:mm:ss" /></p>
						</c:forEach>
					</ul>
				</div>
				
				<div class="right-link right-info">
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
					<div class="teachImg-box"><img src="${basePath}/images/front/R222YOHDXHYTDR8_129_130.jpg"> <span>任大伟</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/QNQR_PA00PZZ7BIUE9R_130_130.jpg"> <span>高海东（兼职）</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/2_130_130.jpg"> <span>陈连军</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/whl_130_130.jpg"> <span>王海亮</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/B_8KOCFMNVI6JW1Q_130_130.jpg"> <span>陈连军</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/111111_130_130.jpg"> <span>王海亮</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/QP_Y6V_NSK4D3YDPDV_106_116.jpg"> <span>XXX</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/R222YOHDXHYTDR8_129_130.jpg"> <span>任大伟</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/QNQR_PA00PZZ7BIUE9R_130_130.jpg"> <span>高海东（兼职）</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/2_130_130.jpg"> <span>陈连军</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/whl_130_130.jpg"> <span>王海亮</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/B_8KOCFMNVI6JW1Q_130_130.jpg"> <span>陈连军</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/111111_130_130.jpg"> <span>王海亮</span></div>
					<div class="teachImg-box"><img src="${basePath}/images/front/QP_Y6V_NSK4D3YDPDV_106_116.jpg"> <span>XXX</span></div>
				</div>
			</div>
		</article>
		
		<jsp:include page="/view/front/include/footer.jsp"></jsp:include>
		
		<script src="${basePath }/js/front/yui-min.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/calendar.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/jquery3.min.js" charset="utf-8"></script>
		<script src="${basePath }/js/front/zyindex.js" charset="utf-8"></script>
	</body>

</html>