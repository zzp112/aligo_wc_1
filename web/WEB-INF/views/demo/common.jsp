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
    <script type="text/javascript" src="<c:url value="/resources1/js/jquery-1.8.2.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources1/css/commonStyle.css"/>">
    <script>


        $.ajax({
            type:"post",
            url: "http://121.41.51.176:8080/TestService/test",
            dataType:"jsonp",
            jsonp: "jsoncallback",
            jsonpCallback:"jsonpCallback",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj = eval(data);
                var temp = obj[0];
                var dataStr = "";
                for(var i=0;i<temp.length;i++){
                    var p =temp[i];
                    var table = $('.table');
                    dataStr +="<tr>"+
                    "<td>"+ p.name+"</td>"+
                    "<td>"+ p.age+"</td>"+
                    "<td>"+ p.sex+"</td>"+
                    "<td>"+ p.phone+"</td>"+
                    "<td>"+ p.address+"</td>"+
                    "</tr>";
                }
                table.append(dataStr);
            }
        });

    </script>
</head>
<body>
    <div>
        <div>
            <label class="module-title">模块名称</label>
        </div>

        <div>
            <table class="table" cellspacing="0">
                <tr>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>电话</td>
                    <td>家庭住址</td>
                </tr>
            </table>
        </div>
        <br/><br/>
        <div>
            <button class="btn-blue">点击</button>
            <input type="button" class="btn-green" value="点击" />
        </div>
        <br/><br/>
        <input type="text" class="input-text" placeholder="输入框"/>
        <br/><br/>

        <div>
            <h3>使用方法</h3>
            <h4>表格请引用这个样式：&lt;table class="table"&gt;&lt;/table&gt;</h4><br>
            <h4>模块名称请这样写:<br>
                &lt;div&gt;<br>
                &lt;label class="module-title"&gt;模块名称&lt;/label&gt;<br>
                &lt;/div&gt;<br>
            </h4><br>
            <h4>按钮有两种风格：蓝色和绿色。。颜色可根据情况自行定义，但一般情况下尽量不要改变<br>
                &lt;button class="btn-blue"&gt;点击&lt;/button&gt;<br>
                &lt;input type="button" class="btn-green" value="点击" /&gt;<br>
            </h4><br>
            <h4>输入框：颜色可根据情况自行定义<br>
                &lt;button class="btn-blue"&gt;点击&lt;/button&gt;<br>
                &lt;input type="text" class="input-text" placeholder="输入框"/&gt;<br>
            </h4>
        </div>
        <br><br><br><br><br><br><br>
    </div>
</body>
</html>