function showDate() {
    var date = new Date();
    var year = date.getFullYear(),
        month = date.getMonth() + 1,
        day = date.getDate(),
        hour = date.getHours(),
        minute = date.getMinutes(),
        second = date.getSeconds();
    if (month < 10) {
        month = "0" + month
    }
    if (day < 10) {
        day = "0" + day
    }
    if (hour < 10) {
        hour = "0" + hour
    }
    if (minute < 10) {
        minute = "0" + minute
    }
    if (second < 10) {
        second = "0" + second
    }

    var dateStr = year + " 年 " + month + " 月 " + day + " 日 " + hour + ":" + minute + ":" + second;
    $("#date").html(dateStr);
}
