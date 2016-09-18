//
//
// 分页
// pager.js
//
// @author chenfan
// @version 1.0, 2015/10/07
//
//


// 分页跳转
function goToPage(pageForm, pagePath, pageNumber) {
	var b = (new RegExp(/^[0-9]{1,}$/)).test(pageNumber);
	if(pageForm == "noform") { if(b) { window.location.href = basePath + pagePath + pageNumber; } return; }
	if(b) { $("#pageNumber").val(pageNumber); $("#" + pageForm).submit(); return; }
	showInputDialog("页码：", "操作提示", function(r) {
		if(r != null && (new RegExp(/^[0-9]{1,}$/)).test(r)) {
			goToPage(pageForm, pagePath, r);
		}
	});
}

// 指定分页大小
function setPageSize(pageForm, pagePath, pageNumber) {
	if(pageForm == "noform") { return; }
	showInputDialog("显示记录（条）：", "操作提示", function(r) {
		if(r != null && (new RegExp(/^[0-9]{1,}$/)).test(r)) {
			$("#pageSize").val(r);
			goToPage(pageForm, pagePath, pageNumber);
		}
	});
}

// 重置分页
function resetPage() {
	$("#pageNumber").val("");
}