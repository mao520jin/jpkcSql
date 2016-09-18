
// 加载数据
function loadData(pageNumber, pageSize, url) {
	var basePath = $("#basePath").val();
	$.ajax({
		type : "POST",
		url : url,
		data : {"pageNumber":pageNumber,"pageSize":pageSize},
		dataType : "json",
		beforeSend: function(XMLHttpRequest) {
		},
		success :function(msg){
			var page = msg.data;
			var content = page.content;
			
			/**加载数据与分页**/
			var titleTr= "<div id='data_div'><table>";
			var dataTr = ""; 
			title = "<tr><td style=\"width: 600px;\">公告标题</td><td>发布时间</td></tr>"; 
			for(var i=0;i<content.length;i++){
				var url1 = basePath + "/frontNotice/noticeDetail/" + content[i].id;
				dataTr += "<tr style=\"height: 30px;\"><td><a href=\""+ url1 +" \">" + content[i].title + "</a></td><td>" + formatDateTime(new Date(content[i].createTime)) + "</td></tr>";
			}
			titleTr += title + dataTr +"</table></div>";
			$("#data_div").remove();
			$("#notice_content").append(titleTr );
			
			var p = initPager(page,url,'page_wrap_div');
			$("#notice_content").append(p);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		},
		complete: function(XMLHttpRequest, textStatus) {
		}
	});
}

function initPager(pageObj,pagePath,removeDiv) {
	$("#"+removeDiv).remove();
	var p =  getPage(pageObj.pageNumber,pageObj.totalElements,pageObj.totalPages,pageObj.previous,pageObj.next, pageObj.pageSize, pagePath);
	return p;
}

function getPage(pageNumber, totalElements, totalPages, previous, next,  pageSize, pagePath) {
	var p = "";
	p += "<div id='page_wrap_div'>";
	p += "	<strong>总数&nbsp;"+ totalElements +"&nbsp;条，</strong>";
	p += "	<strong>每页&nbsp;" + pageSize +" </a><strong>&nbsp;条，</strong>";
	p += "	<strong>页码&nbsp;"+ pageNumber +"/"+ totalPages +"&nbsp;，</strong>";
	p += "	<a href='javascript:;' onclick='goToPage("+ 1 +","+ pageSize +",\""+ pagePath +"\");'>首页</a>";
	p += "	<a href='javascript:;' onclick='goToPage("+ previous +","+ pageSize +",\""+ pagePath +"\");'>上一页</a>";
	p += "	<a href='javascript:;' onclick='goToPage("+ next +","+ pageSize +",\""+ pagePath +"\");'>下一页</a>";
	p += "	<a href='javascript:;' onclick='goToPage("+ totalPages +","+ pageSize +",\""+ pagePath +"\");'>尾页</a>";
	p += "</div>";
	return p;
}

function goToPage(pageNumber, pageSize, pagePath) {
	loadData(pageNumber, pageSize, pagePath);
}

var formatDateTime = function (date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    var second = date.getSeconds();
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d+' '+h+':'+minute + ":" +second;
};