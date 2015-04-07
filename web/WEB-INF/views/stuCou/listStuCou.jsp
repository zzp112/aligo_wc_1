<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />
    <style type="text/css">
        table{text-align: center;}
        .module-title{font-size: 40px;}
        /*td{*/
        /*text-align: center;*/
        /*}*/
    </style>
    <script>
        $.ajax({
            type:"post",
            url: "/stuCou/loadStuCou",
            dataType:"json",
//        jsonp: "jsoncallback",
//        jsonpCallback:"jsonpCallback",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj = eval("("+data+")");
                var temp = obj[0];
                var dataStr = "";
                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    var table = $('.table');
                    dataStr +="<tr>"+
                    "<td>"+ p.id+"</td>"+
                    "<td>"+ p.stationAddress+"</td>"+
                    "<td>"+ p.studentName+"</td>"+
                    "<td>"+ p.courseName+"</td>"+
                    "<td>"+ p.costByOne+"</td>"+
                    "<td>"+ p.courseCount+"</td>"+
                    "<td>"+ p.costTotal+"</td>"+
                    "<td>"+ p.courseDate+"</td>"+
                    "<td><span onclick='preUpdate("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                    "</tr>";
                }
                table.append(dataStr);
            }
        });
        $(function() {
            $(".page").paginate({
                count 		: 40, //一共多少页
                start 		: 1, //默认从第几页开始
                display     : 12, //显示多少页码
                border					: false,
                text_color  			: '#0E90D2',
                background_color    	: 'none',
                text_hover_color  		: 'red',
                background_hover_color	: 'none',
                images		: false,
                mouse		: 'press',
                onChange:function(pageno){ //pageno参数是你点击的页号
                    $(".box").text("你点击了第"+pageno+"页");
                }
            });

        });


        function deleteStuCou(id){
            if(confirm("您确定要删除第"+id+"条数据吗")){
                $.ajax({
                    type: "POST",
                    url: "some.php",
                    data: "name=John&location=Boston",
                    success: function(msg){
                        alert( "Data Saved: " + msg );
                    }
                });
            }
        }

        function preUpdate(id){
            alert("您要修改的是第"+id+"条数据");
        }
    </script>
</head>
<body>

<div style="position:relative;">
    <label class="module-title">学生上课信息管理</label>
    <input type="button" class="btn-blue" value="添加" style="position:absolute;top:0;right:0;">
</div>

<div>
    <table class="table" cellspacing="0">
        <tr>

            <td style="width: 40px">编号</td>
            <td style="width: 130px">小站地址</td>
            <td style="width: 130px">学生名字</td>
            <td style="width: 130px">课程名称</td>
            <td style="width: 80px">单节费用</td>
            <td style="width: 80px">总上课数</td>
            <td style="width: 80px">总费用</td>
            <td style="width: 130px">上课日期</td>
            <td>操作</td>
        </tr>
    </table>
    <div class="page"></div>
</div>
</body>
</html>
