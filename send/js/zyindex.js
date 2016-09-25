			function teachLb() {
				m -= 163, $(".teach-lb").stop().animate({
					left: m + "px"
				}, 3e3, "linear", function() {
					m == -1131 && ($(".teach-lb").css("left", "10px"), m = 10, console.log("????")), setTimeout(function() {
						teachLb();
					}, 1e3)
				})
			}

			function topTime() {
				setInterval(function() {
					var e = new Date,
						t = e.getFullYear(),
						n = e.getMonth() + 1,
						a = e.getDate(),
						o = e.getHours(),
						c = e.getMinutes(),
						i = e.getSeconds();
					i = i < 10 ? "0" + i : i, c = c < 10 ? "0" + c : c, o = o < 10 ? "0" + o : o, $(".headerTime").text(t + "年" + n + "月" + a + "日 " + o + ":" + c + ":" + i)
				}, 1e3)
			}
			var m = 10;
			teachLb(), topTime()
//...........................................................
//下面配置日历的js
var c = {};
var showdate = function(n,d){//计算d天的前几天或者后几天，返回date,注：chrome下不支持date构造时的天溢出
	var uom = new Date(d-0+n*86400000);
	uom = uom.getFullYear() + "/" + (uom.getMonth()+1) + "/" + uom.getDate();
	return new Date(uom);
};
YUI({
	combine:true,
	comboBase:'http://a.tbcdn.cn/??',
	root:'s/yui/3.3.0/build/',
	filter:{
		'searchExp': "&", 
		'replaceStr': ","
	},
	modules:{
		'calendar-skin':{//默认皮肤
			fullpath:'css/default.css',
			type:'css'
		},
		'calendar':{
			fullpath:'js/calendar.js',
			requires:['calendar-skin','node']
		}
	}
}).use('calendar','console','dump',function(Y){
	//new Y.Console().render();
	//alert(Y.dump(Y.UA));


	//静态日历,单击回调
	c = new Y.Calendar('J_calendar').on('select',function(d){

	});

});