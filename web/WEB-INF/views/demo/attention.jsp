<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8"/>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">

</head>
<body>
    <div>
        <div>
            <label class="module-title">模块名称</label>
        </div>

        <div>
            <h2>大家请注意，之前的表现层DEMO使用的是AJAX来内嵌网页，<br>
                现在则改成了iframe，所以大家在做界面的时候，方法有所改变</h2>
            <h3>1.在主界面根据需求修改自己的导航栏，如下：</h3>
            <img src="<c:url value="/resources/img/p1.png"/>" alt=""/>
            <h3>2.每一个功能界面都要引入commonStyle.css样式文件，之前的版本是不用引入的。</h3>
            <h3>3.图表，分页，弹出框等插件的使用要先引入jquery-1.8.2.js，这点很重要！<br>
                然后再引入各个插件对应的样式和js文件<br>
                具体使用方法请看左侧导航的“样例网页”，</h3>
            <h3>4.已统一的样式如下<br>
                (1)按钮：.btn-blue和.btn-green<br>
                (2)表格：.table<br>
                (3)输入框：.input-text<br>
                (4)模块名称：module-title<br>
                <img src="<c:url value="/resources/img/p2.png"/>" alt=""/>
            </h3>
        </div>

    </div>
</body>
</html>