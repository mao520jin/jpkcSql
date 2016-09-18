// 加载数据
function loadData(pageNumber, pageSize, url, type) { 
	var basePath = $("#basePath").val();
	$.ajax({
		type : "POST",
		url : url,
		data : { "pageNumber": pageNumber, "pageSize": pageSize, "type": type },
		dataType : "json",
		beforeSend: function(XMLHttpRequest) {
		},
		success :function(msg){
			var page = msg.data;
			var content = page.content;
			
			/**加载数据与分页**/
			var titleTr= "<div id='data_div'><table>";
			var dataTr = "";  
			title = "<tr><td style=\"width: 600px;\">标题</td><td>发布时间</td></tr>"; 
			for(var i=0;i<content.length;i++){
				dataTr += "<tr style=\"height: 30px;\"><td><a href=\"javascript:;\" onclick=\"dosub('" + content[i].path + "', '" + content[i].type + "');\" >" + content[i].title + "</a></td><td>" + formatDateTime(new Date(content[i].createTime)) + "</td></tr>";
			}
			
			titleTr += title + dataTr +"</table></div>";
			$("#data_div").remove();
			$("#resources_content").append(titleTr);

			var p = initPager(page,url,'page_wrap_div');
			$("#resources_content").append(p);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
		},
		complete: function(XMLHttpRequest, textStatus) {
		}
	});
}

function dosub(path, type) {
	$("#path").val(path); 
	$("#type").val(type); 
	var basePath = $("#basePath").val();
	var action = basePath+ "/view/office";
	if(type == "3") {
		action = basePath+ "/view/media";
	}
	$("#view_office_form").attr("action", action);
	$("#view_office_form").submit();
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

//查看资源类型
function doView(type) {
	$("#view_type").val(type);
	$("#view_type_form").submit();
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