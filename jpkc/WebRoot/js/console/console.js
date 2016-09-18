//
//
// 控制台
// console.js
//
// @author chenfan
// @version 1.0, 2015/10/07
//
//

function setRender(id, code, data, cls, delay) {
	$("#" + id).removeClass().addClass(cls).html(data);
	if(!delay || delay == null || delay == 0) { return; }
	setTimeout(function() { $("#" + id).html("&nbsp;"); }, delay);
}

function setConsoleRender(code, data, cls) { setRender("console_render", code, data, cls, 0) }
function setInfoRender(code, data) { setConsoleRender(code, data, "info_render"); }
function setNoteRender(code, data) { setConsoleRender(code, data, "note_render"); }
function setImportantRender(code, data) { setConsoleRender(code, data, "important_render"); }
function setWarningRender(code, data) { setConsoleRender(code, data, "warning_render"); }

function isRender(obj) { return !(!obj || obj == null || !obj.code || obj.code == null); }

function isEmptyRender(obj) {
	return !isRender(obj) || (!obj.data || obj.data == null || obj.data.length == 0);
}
