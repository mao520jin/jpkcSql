<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/views/include/base.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>${APP_CONSOLE_NAME_CN} - ${APP_NAME_CN}</title>

<jsp:include page="/views/console/include/style.jsp"></jsp:include>

</head>

<body class="hidecol2">

<jsp:include page="/views/console/include/skiplinks.jsp"></jsp:include>
<jsp:include page="/views/console/include/header.jsp"></jsp:include>
<jsp:include page="/views/console/include/nav.jsp">
	<jsp:param name="hListActive" value="OperationsManagement" />
</jsp:include>

<!-- begin: main content area #main -->
<div id="main"><div class="page_margins"><div class="page">

<!-- begin: #col1 - first float column -->
<div id="col1" role="complementary">
	<div id="col1_content" class="clearfix">
		<jsp:include page="/views/console/include/vlist.jsp">
			<jsp:param name="hListActive" value="OperationsManagement" />
			<jsp:param name="vListActive" value="vlist3" />
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
		<form method="post" action="" class="yform columnar" role="application">
			<fieldset>
				<div class="subcolumns">
					<div class="c25l">
						<div class="subcl type-text">
							<label for="input-1">用户ID：</label><input type="text" name="input-1" id="input-1" size="20" />
						</div>
					</div>
					
					<div class="c25l">
						<div class="subc type-text">
							<label for="input-2">开始于：</label><input type="text" name="input-2" id="input-2" size="20" />
						</div>
					</div>
					
					<div class="c25l">
						<div class="subc type-text">
							<label for="input-3">结束于：</label><input type="text" name="input-3" id="input-3" size="20" />
						</div>
					</div>
					
					<div class="c25r">
						<div class="subcr type-button">
							<input type="submit" value="submit" class="submit" id="submit1" name="submit1" />
						</div>
					</div>
					
				</div>
			</fieldset>
		</form>
		
		<p class="highlight">总共<span style="color: red; font-size: 20px;">79405</span>个用户进行了充值，总金额￥<span style="color: red; font-size: 20px;">10732622</span>(RMB)，总爱码币<span style="color: red; font-size: 20px;">1073261833</span>。</p>
		
		<table border="0" cellpadding="0" cellspacing="0" class="full">
			<thead><tr><th scope="col" colspan="7">
				<div>
					<span>页码：2/365</span>
					<a href="#">首页</a>
					<a href="#">上一页</a>
					<a href="#">下一页</a>
					<a href="#">尾页</a>
					<a href="#">转到</a>
				</div>
			</th></tr></thead>
			<tbody>
				<tr><th scope="col">序号</th><th scope="col">编号</th><th scope="col">用户ID</th><th scope="col">总充值金额</th><th scope="col">总充值爱码币</th><th scope="col">总充值次数</th><th scope="col">最后充值时间</th></tr>
				<tr><td>1</td><td>1</td><td>user-1</td><td>732277</td><td>8989605</td><td>147</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>2</td><td>2</td><td>user-2</td><td>297172</td><td>1571049</td><td>334</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>3</td><td>3</td><td>user-3</td><td>646382</td><td>3212263</td><td>78</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>4</td><td>4</td><td>user-4</td><td>32357</td><td>8884764</td><td>211</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>5</td><td>5</td><td>user-5</td><td>578751</td><td>297161</td><td>118</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>6</td><td>6</td><td>user-6</td><td>31515</td><td>2096705</td><td>540</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>7</td><td>7</td><td>user-7</td><td>228794</td><td>2707025</td><td>266</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>8</td><td>8</td><td>user-8</td><td>338554</td><td>854619</td><td>331</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>9</td><td>9</td><td>user-9</td><td>789705</td><td>8681265</td><td>380</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>10</td><td>10</td><td>user-10</td><td>384519</td><td>1200279</td><td>119</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>11</td><td>11</td><td>user-11</td><td>291020</td><td>8458320</td><td>261</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>12</td><td>12</td><td>user-12</td><td>34161</td><td>4031616</td><td>59</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>13</td><td>13</td><td>user-13</td><td>978951</td><td>6679392</td><td>369</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>14</td><td>14</td><td>user-14</td><td>191426</td><td>3631720</td><td>374</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>15</td><td>15</td><td>user-15</td><td>22255</td><td>9760347</td><td>133</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>16</td><td>16</td><td>user-16</td><td>441273</td><td>223217</td><td>241</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>17</td><td>17</td><td>user-17</td><td>962596</td><td>7583419</td><td>281</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>18</td><td>18</td><td>user-18</td><td>452758</td><td>6077814</td><td>388</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>19</td><td>19</td><td>user-19</td><td>461101</td><td>8656927</td><td>340</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>20</td><td>20</td><td>user-20</td><td>368293</td><td>5682293</td><td>305</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>21</td><td>21</td><td>user-21</td><td>536721</td><td>2342251</td><td>162</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>22</td><td>22</td><td>user-22</td><td>950948</td><td>4599084</td><td>322</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>23</td><td>23</td><td>user-23</td><td>235612</td><td>8837603</td><td>538</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>24</td><td>24</td><td>user-24</td><td>25141</td><td>2349624</td><td>83</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>25</td><td>25</td><td>user-25</td><td>783817</td><td>3583610</td><td>75</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>26</td><td>26</td><td>user-26</td><td>129157</td><td>4503170</td><td>334</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>27</td><td>27</td><td>user-27</td><td>553953</td><td>7796490</td><td>149</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>28</td><td>28</td><td>user-28</td><td>27610</td><td>7034379</td><td>292</td><td>2015-09-28 17:18:45</td></tr>
				<tr><td>29</td><td>29</td><td>user-29</td><td>994795</td><td>7049211</td><td>165</td><td>2015-09-28 17:18:45</td></tr>
			</tbody>
		</table>
	</div>
	<div id="ie_clearing">&nbsp;</div>
	<!-- End: IE Column Clearing -->
</div>
<!-- end: #col3 -->

</div></div></div>
<!-- end: #main -->

<jsp:include page="/views/console/include/footer.jsp"></jsp:include>
<jsp:include page="/views/console/include/yamlfocusfix.jsp"></jsp:include>

</body>
</html>
