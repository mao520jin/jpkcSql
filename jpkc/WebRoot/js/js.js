
/**
 * 
 * 这里填写方法描述
 * 
 * @param id
 * @param name 名称
 * @param desc 备注
 * 
 * @see doSearch()
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doTest(id, name, desc) {
	
}

/**
 * 
 * 查询
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doSearch() { }

/**
 * 
 * 查看
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doView() { }

/**
 * 
 * 预览
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doPreview() { }

/**
 * 
 * 新增、编辑
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doEdit() { }

/**
 * 
 * 校验
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doCheck() { }

/**
 * 
 * 保存
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doSave() { }

/**
 * 
 * 删除
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doRemove() { }

/**
 * 
 * 清空
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doClear() { }

/**
 * 
 * 导入
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doImport() { }

/**
 * 
 * 导出
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doExport() { }

/**
 * 
 * 显示
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doShow() { }

/**
 * 
 * 显示
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doHide() { }

/**
 * 
 * 异步请求(ajax)
 * 
 * @author chenfan
 * @version 1.0, 2015/10/07
 * 
 */
function doAjax() {
	$.ajax({
		type: "type",
		url: "url",
		data: { "key1": "value1" },
		dataType: "json",
		async: false,
		cache: false,
		beforeSend: function(XMLHttpRequest) { },
		success: function(data, textStatus) { },
		error: function(XMLHttpRequest, textStatus, errorThrown) { },
		complete: function(XMLHttpRequest, textStatus) { }
	});
}