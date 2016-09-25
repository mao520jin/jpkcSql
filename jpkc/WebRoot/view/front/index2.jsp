<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>首页-工程爆破精品课程</title>
		<link rel="stylesheet" href="../css/base.css">
		<link rel="stylesheet" href="../css/zyindex.css">
		<link rel="stylesheet" href="//at.alicdn.com/t/font_1474707830_8697941.css">
		<link rel="stylesheet" type="text/css" href="../css/default.css"/>
	</head>
	<body>
		<header>
			<h2>物流工程</h2>
			<h3>负 责 人 ： 冯 夕 文</h3>
			<div class="headerSearch"><input type="search" name="headerSearch" id="searchInp" placeholder="搜索..">
				<a href="javascript:;" id="searchBtn" class="iconfont">&#xe600;</a>
			</div>
		</header>
		<nav>
			<ul>
				<li class="first-li">
					<a href="#">首页</a>
				</li>
				<li class="item1">
					<a href="#"><span class="iconfont">&#xe601;</span>课程概况</a>
					<div class="item1-menu menu">
						<ul>
							<li>
								<a href="#">课程简介</a>
							</li>
							<li>
								<a href="#">课程特色</a>
							</li>
							<li>
								<a href="#">教学大纲</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="item2">
					<a href="#"><span class="iconfont">&#xe601;</span>师资队伍</a>
					<div class="item2-menu menu">
						<ul>
							<li>
								<a href="#">课程负责人</a>
							</li>
							<li>
								<a href="#">教学团伍</a>
							</li>
							<li>
								<a href="#">青年教师培养</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="item3">
					<a href="#"><span class="iconfont">&#xe601;</span>教学成果</a>
					<div class="item3-menu menu">
						<ul>
							<li>
								<a href="#">科研项目</a>
							</li>
							<li>
								<a href="#">学术著作</a>
							</li>
							<li>
								<a href="#">奖励资助</a>
							</li>
							<li>
								<a href="#">学生成果展示</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="item4">
					<a href="#"><span class="iconfont">&#xe601;</span>教学特色</a>
					<div class="item4-menu menu">
						<ul>
							<li>
								<a href="#">教学课件</a>
							</li>
							<li>
								<a href="#">校企合作教学</a>
							</li>
							<li>
								<a href="#">名校专家讲堂</a>
							</li>
						</ul>
					</div>
				</li>
				<li class="item5">
					<a href="#"><span class="iconfont">&#xe601;</span>教学评价</a>
					<div class="item5-menu menu">
						<ul>
							<li>
								<a href="#">学生反馈</a>
							</li>
							<li>
								<a href="#">校内综合评价</a>
							</li>
							<li>
								<a href="#">校外专家评价</a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#">申报材料</a>
				</li>
				<li>
					<a href="#">联系我们</a>
				</li>
			</ul>
		</nav>
		<article class="main">
			<section class="left">
				<div class="leftnav">
					<h3 class="maintitle">课程资源</h3>
					<ul class="wlkc">
						<li>
							<a  class="firsta" href="javascript:;">主要目录</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;通知公告</a>	
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;教学大纲</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;教学课件</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;参考书目</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;习题解答</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;模拟试题</a>
						</li>
						<li>
							<a href="javascript:;">※  &nbsp;课程实验</a>
						</li>						
						<li>
							<a  class="lasta"  href="javascript:;">※  &nbsp;资料下载</a>
						</li>
					</ul>
				</div>
			</section>
			<section class="wlmain wlmain_item1">
					<div class="fyBtn">
						<a href="javascript:;" class="prev">上一页</a>
						<a href="javascript:;" class="next">下一页</a>
					</div>
			</section>

		</article>
		<footer>
			<p>单位地址：山东省青岛技术开发区前弯港路579号 邮政编码：266590</p>
			<p> 联系电话：0532-8057073 </p>
			<p>维　　护：山东科技大学物流工程 E-mail:fxw6380@163.com</p>
			<p>版权 © 2015 物流工程精品课程 保留所有权利 Designed by 风华正茂&amp;同门</p>
			<div class="wlfooter"></div>
				
			
		</footer>
		<script src="../js/jquery3.min.js" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$(".wlkc li a").click(function(){
					$(this).addClass("leftnav_active");
					$(this).parent().siblings().find("a").removeClass("leftnav_active");
									
				})			
			})
		</script>
	</body>

</html>