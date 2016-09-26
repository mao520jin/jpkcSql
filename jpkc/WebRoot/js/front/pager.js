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
function goToPage(pagePath, pageNumber) {
	var b = (new RegExp(/^[0-9]{1,}$/)).test(pageNumber);
	if(b) {
		var url = basePath + pagePath;
		var tempForm = "";
		tempForm += "<form action='" + url + "' id='temp_form' name='temp_form' method='post'>";
		tempForm += "        <input type='hidden' id='pageNumber' name='pageNumber' value='" + pageNumber + "' />";
		tempForm += "</form>";
		$("body").after(tempForm);
		$("#temp_form").submit();
		return;
	} 
}

// 重置分页
function resetPage() {
	$("#pageNumber").val("");
}