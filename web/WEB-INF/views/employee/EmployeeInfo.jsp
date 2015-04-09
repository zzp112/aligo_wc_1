<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8"/>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <style type="text/css">

        .query{
            margin-left: 800px;
        }
        .page{
            margin-top: 5px;
            margin-left: 550px;
        }
        td{
            width: 160px;
        }
    </style>

    <script>

        function select(){
            var select=$('#query').val();

            $.ajax({
                type:"post",
                url: "/employee/finEmployeeBySelect",
                data:{select:select},
                dataType:"json",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },

                success: function(data) {
                    var obj =  eval("("+data+")");

                    var dataStr = "";
                    dataStr="  <tr><td>员工号</td> <td>姓名</td><td>电话号码</td><td>岗位</td> <td>状态</td>  <td>操作</td> </tr>";

                    for(var i=0;i<obj.length;i++){
                        var p =obj[i];
                        var table = $('.table');
                        dataStr +="<tr>"+
                        "<td>"+ p.employeeId+"</td>"+
                        "<td>"+ p.name+"</td>"+
                        "<td>"+ p.phone+"</td>"+
                        "<td>"+ p.jobs+"</td>"+
                        "<td>"+ p.state+"</td>"+
                        "<td>"+"<button class='btn-blue' onclick='goto("+p.employeeId+")' >详细信息</button>"+"</td>"+
                        "</tr>";
                    }
                    table.html("");
                    table.append(dataStr);
                }
            });

        }
        function goto(employeeId){
            $.ajax({
                type:"post",
                url: "/employee/gotoEmployeeDetailed",
                data:{employeeId:employeeId},
                dataType:"text",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },
                success: function(data) {
                    location='/employee/EmployeeDetailed';
                }
            });


        }
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

        $.ajax({
            type:"post",
            url: "/employee/loadAllEmployee",
            dataType:"json",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj =  eval("("+data+")");

                var dataStr = "";

                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    var table = $('.table');
                    dataStr +="<tr>"+
                            "<td>"+ p.employeeId+"</td>"+
                            "<td>"+ p.name+"</td>"+
                            "<td>"+ p.phone+"</td>"+
                            "<td>"+ p.jobs+"</td>"+
                            "<td>"+ p.state+"</td>"+
                            "<td>"+"<button class='btn-blue' onclick='goto("+p.employeeId+")' >详细信息</button>"+"</td>"+
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
        <label class="module-title">员工信息</label>
    </div>
    <div class="query">

        <input type="text" id="query" class="input-text" placeholder="输入框"/>
        <button  class="btn-blue" style="margin-left: 20px; width: 50px;height: 25px" onclick="select()">查询</button>
    </div>
    <div>
        <table class="table" cellspacing="0">
            <tr>
                <td>员工号</td>
                <td>姓名</td>
                <td>电话号码</td>
                <td>岗位</td>
                <td>状态</td>
                <td>操作</td>
            </tr>
        </table>
    </div>
    <div class="page">
    </div>

    <br/><br/>
    <div>
        <button class="btn-blue" onclick="location='/employee/AddEmployee'" style="margin-top: -70px">添加员工</button>

    </div>



</div>
</body>
</html>