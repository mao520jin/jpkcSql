	$(function(){
		$(document).off('click.bs.dropdown.data-api');
		showDate();
		setInterval(showDate, 1000);
	});
	
	//查看资源类型
	function doView(type) {
		$("#view_type").val(type);
		$("#view_type_form").submit();
	}