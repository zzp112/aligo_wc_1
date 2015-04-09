<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="utf-8"/>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/zebra_dialog.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/zebra_dialog.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">



    <style type="text/css">

        .input-nochangge{
            border-radius: 3px;
            font-size: 11pt;
            padding: 3px;
            border: 1px solid dodgerblue;
        }
        .query{
            margin-left: 600px;
        }
        .page{
            margin-left: 400px;
            margin-top: 5px;;
        }


        td{
            width: 160px;
        }


    </style>
    <script>
        function selectBy(){
            var  select =$('#query').val();
            $.ajax({
                type:"post",
                url: "/employee/loadAllBaseSalaryByselecy",
                data:{select:select},
                dataType:"json",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },

                success: function(data) {
                    var obj =  eval("("+data+")");

                    var dataStr = "";
                    dataStr="  <tr><td>员工号</td> <td>姓名</td><td>部门</td> <td>基本薪资</td><td>操作</td> </tr>";



                    for(var i=0;i<obj.length;i++){
                        var p =obj[i];
                        var table = $('.table');
                        dataStr +="<tr>"+
                        "<td>"+ p.employeeId+"</td>"+
                        "<td>"+ p.name+"</td>"+
                        "<td>"+ p.departMent+"</td>"+
                        "<td>"+ p.baseSalary+"</td>"+
                        "<td>"+"<button class='btn-blue' onclick='SelectBaseSalary("+p.employeeId+")' >详细信息</button>"+"</td>"+
                        "</tr>";
                    }
                    table.html("");
                    table.append(dataStr);
                }
            });

        }

        function changestate(){
            document.getElementById("update").style.display="inline";
            var button=document.getElementsByClassName("input-text");
            for(var i=0;i<button.length ;i++)
            {
                button[i].readOnly=false;
            }
        }

        function SelectBaseSalary(employeeId){


            $.ajax({
                type:"post",
                url: "/employee/gotoBaseSalaryDetailed",
                data:{employeeId:employeeId},
                dataType:"text",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },

                success: function(data) {

                    location='/employee/BaseSalaryDetailed';

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
            url: "/employee/loadAllBaseSalary",
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
                    "<td>"+ p.departMent+"</td>"+
                    "<td>"+ p.baseSalary+"</td>"+
                    "<td>"+"<button class='btn-blue' onclick='SelectBaseSalary("+p.employeeId+")' >详细信息</button>"+"</td>"+
                    "</tr>";
                }
                table.append(dataStr);
            }
        });
        function goto(employeeId){
            alert(employeeId);

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
    </script>
</head>
<body>
<div>
    <div>
        <label class="module-title">员工基础薪资</label>
    </div>

    <div class="query">

       <input type="text" id="query" class="input-nochangge" placeholder="输入框"/>
        <button  class="btn-blue" style="margin-left: 20px; width: 50px;height: 25px" onclick="selectBy()">查询</button>
    </div>

    </div>
    <div>
        <table class="table" cellspacing="0">
            <tr>
                <td>员工号</td>
                <td>姓名</td>
                <td>部门</td>
                <td>基本薪资</td>
                <td>操作</td>
            </tr>
        </table>
        <div class="page">
        </div>
    </div>


    <button class='btn-blue' style="width: 160px; margin-top: -30px;" onclick="location='/employee/AddBaseSalary'">添加员工薪资基础信息</button>
</div>





</div>

</body>
</html>