<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8"/>
	<style type="text/css">


    td{
        width: 160px;
    }
	</style>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <script>
        $(document).ready(function(){
            var chart1 = new AwesomeChart('chartCanvas1');
            chart1.title = "大家统一用这个图表控件";
            chart1.data = [51.62,31.3,10.06,4.27,1.96,0.78];
            chart1.labels = ['IE','Firefox','Chrome','Safari','Opera','Other'];
            chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
            chart1.randomColors = true;
            chart1.draw();
        });

    </script>
</head>
<body>

    <div>
        <label class="module-title">图表控件</label>
    </div>

    <div>
        <canvas id="chartCanvas1" width="400" height="400">
            Your web-browser does not support the HTML 5 canvas element.
        </canvas>
    <div>

    <div>
        <h3>使用方法</h3>
        <h4>先引用awesomechart.js</h4>
        <h4>然后在相应的位置加入以下html代码<br/>
            &lt;canvas id="chartCanvas1" width="400" height="400"&gt;<br>
                Your web-browser does not support the HTML 5 canvas element.<br>
            &lt;/canvas&gt;

        </h4>
        <br/><br/>
        <h4>然后在head中加入javascriptbr<br>
            <textarea name="" id="" cols="100" rows="20" style="font-size:14pt">

            <script>
                $(document).ready(function(){
                    var chart1 = new AwesomeChart('chartCanvas1');
                    chart1.title = "大家统一用这个图表控件";
                    chart1.data = [51.62,31.3,10.06,4.27,1.96,0.78];
                    chart1.labels = ['IE','Firefox','Chrome','Safari','Opera','Other'];
                    chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8'];
                    chart1.randomColors = true;
                    chart1.draw();
                });

            </script>
            </textarea>
        </h4>
        <h4>
        <br><br>
        属性说明：<br>
        title：图表标题<br>
        data：图表的数据<br>
        labels：每一个柱状图的名称<br>
        colors：每一个柱状图的颜色<br>
        </h4>
        <br><br><br><br><br><br>
    </div>

</body>
</html>