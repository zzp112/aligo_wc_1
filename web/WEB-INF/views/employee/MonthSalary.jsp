<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .time{
           margin-top: 10px;
            margin-bottom: 10px;
        }

        .page{
            margin-top: 5px;
            margin-left: 550px;
        }

        td{
            width: 160px;
        }
        .input{
            margin-top:10px ;
        }

    </style>

    <script>
        function changestate(){
            document.getElementById("update").style.display="inline";
            var button=document.getElementsByClassName("input-text");
            for(var i=0;i<button.length ;i++)
            {
                button[i].readOnly=false;
            }
        }

        function selectAllmonthsalary(){
            var year=$('#year').val();
            var month=$('#month').val();

            $.ajax({
                type:"post",
                url: "/employee/loadAllMonthEmployeeSalary",
                data:"year="+year+"&month="+month,
                dataType:"json",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },

                success: function(data) {
                    var obj =  eval("("+data+")");

                    var dataStr = "";
                        if(obj.length==0)
                        {  alert("没有该月数据！");
                              return;
                        }
                    for(var i=0;i<obj.length;i++){
                        var p =obj[i];
                        var table = $('.table');

                        dataStr +="<tr>"+
                        "<td>"+ p.employeeId+"</td>"+
                        "<td>"+ p.name+"</td>"+
                        "<td>"+ p.departMent+"</td>"+
                        "<td>"+ p.baseSalary+"</td>"+
                        "<td>"+ (p.abcIssue+ p.bbcIssue)+"</td>"+
                        "<td>"+"<button class='btn-blue' onclick='selectmonthsalary("+p.employeeId+")' >详细信息</button>"+"</td>"+
                        "</tr>";
                    }
                    table.append(dataStr);
                }
            });

        }
        function selectmonthsalary(employeeId){

            var year=$('#year').val();
            var month=$('#month').val();

            alert(year);

            $.ajax({
                type:"post",
                url: "/employee/gotoMonthSalaryDetailed",
                data:{employeeId:employeeId,
                yea:year,mon:month},
                dataType:"text",
                success: function(data) {

                    location='/employee/MonthSalaryDetailed';

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



    </script>
</head>
<body>
<div>
    <div>
        <label class="module-title">员工薪资</label>
    </div>
    <div class="time">
        <span style="margin-left: 100px;">年：</span>
        <select id="year">
            <option value ="2012">2012</option>
            <option value ="2013">2013</option>
            <option value="2014">2014</option>
            <option value="2015">2015</option>
            <option value="2015">2016</option>
        </select>

        <span>月：</span>
        <select id="month">
            <option value ="1">1</option>
            <option value ="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value ="5">5</option>
            <option value ="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value ="9">9</option>
            <option value ="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
        </select>

        <button  class="btn-blue" style="margin-left: 20px; width: 50px;height: 25px" onclick="selectAllmonthsalary()">查询</button>
    </div>
    <div>
        <table class="table" cellspacing="0">
            <tr>
                <td>员工号</td>
                <td>姓名</td>
                <td>岗位</td>
                <td>薪资合计</td>
                <td>已发薪资</td>
                <td>操作</td>
            </tr>
        </table>
        <div class="page">
        </div>
    </div>

    <button class='btn-blue' style="width: 120px; margin-top: -30px;" onclick="location='/employee/AddMonthSalary'">添加员工月薪资</button>


    <div class="selectmothsalary" style="display: none">

        <table>
            <tr>
                <td><span>员工号：</span></td>
                <td><input type="text" id="employeeid" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr><td><h3>险金</h3></td><td></td></tr>
            <tr>
                <td><span>公司险金：</span></td>
                <td><input type="text" id="companyPremium" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>个人险金：</span></td>
                <td><input type="text" id="selfPremium" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>以往现金代缴：</span></td>
                <td></span><input type="text" id="cashIncome" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><h3>缺勤扣薪</h3></td>
                <td></td>
            </tr>
            <tr>
                <td><span>缺勤总天数：</span></td>
                <td><input type="text" id="absentDay" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>缺勤扣薪：</span></td>
                <td><input type="text" id="dockPay" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>上月错误回款：</span></td>
                <td><input type="text" id="receivable" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><h3>薪资发放记录</h3></td>
                <td></td>
            </tr>
            <tr>
                <td><span>农行发放：</span></td>
                <td><input type="text" id="abcIssue" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>建行发放：</span></td>
                <td><input type="text" id="bbcIssue" class="input-text" placeholder="输入框"/></td>
            </tr>


        </table>
        <button class="btn-green" style="margin-left: 5px; " onclick="changestate()">修改员工信息</button>
        <button id="update" class="btn-blue" style="margin-left: 5px ;">确定修改</button>

</div>
</div>
</body>
</html>