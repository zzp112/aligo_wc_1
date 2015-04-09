<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工基础薪资信息</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <style type="text/css">


        .time{
               margin-top: 10px;
                margin-bottom: 5px;
            }
        td{
            width: 160px;
        }

        .input{
            margin-top:10px ;
        }
        .addbaseinfo{
            margin-left:50px;;
        }

    </style>
    <script language="javascript" type="text/javascript"src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <script>
    function addmonthsalary(){
        var year=$('#year').val();
        var moth=$('#moth').val();
        var  years=year+"-"+moth+"-1";

        var employeeId=$('#employeeId').val();
        var companyPremium=$('#companyPremium').val();
        var selfPremium=$('#selfPremium').val();
        var cashIncome=$('#cashIncome').val();
        var absentDay=$('#absentDay').val();
        var dockPay=$('#dockPay').val();
        var receivable=$('#receivable').val();

        var abcIssue=$('#abcIssue').val();
        var bbcIssue=$('#bbcIssue').val();

        $.ajax({
            type:"post",
            url: "/employee/AddMonthSalarys",
            data:{
                yea:years,employeeId:employeeId,companyPremium:companyPremium,selfPremium:selfPremium,
                cashIncome:cashIncome,absentDay:absentDay,dockPay:dockPay,
                receivable:receivable,abcIssue:abcIssue,
                bbcIssue:bbcIssue
            },
            dataType:"text",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },
            success: function(data) {
                if(data=="ok")
                    alert("添加成功！");
                else
                    alert(data);
            }
        });


    }

    </script>
</head>
<body >
<div  >
    <div>
        <label class="module-title">添加员工月薪资</label>
    </div>

    <div class="addbaseinfo">
        <div class="Basicinformation">
            <h3>员工和时间</h3>
            <div class="time">
                <span >年：</span>
                <select id="year">
                    <option value ="2012">2012</option>
                    <option value ="2013">2013</option>
                    <option value="2014">2014</option>
                    <option value="2015">2015</option>
                </select>
                <span>月：</span>
                <select id="moth">
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
                <table>
                    <tr>
                        <td><span>员工号：</span></td>
                        <td><input type="text" id="employeeId" class="input-text" placeholder="输入框"/></td>
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


        <button class="btn-blue" style="margin-top: 20px;" onclick="addmonthsalary()">添加</button>
    </div>
</div>
</body>
</html>