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
        td{
            width: 160px;
        }

    </style>

    <script>
        $(document).ready(function(){
            var button=document.getElementsByClassName("input-text");
            for(var i=0;i<button.length ;i++)
            {
                button[i].readOnly="readonly";
            }
        })

        function changestate(){
            document.getElementById("update").style.display="inline";
            var button=document.getElementsByClassName("input-text");
            for(var i=0;i<button.length ;i++)
            {
                button[i].readOnly=false;
            }
        }


        function update(){
            var year=$('#year').val();
            var moth=$('#moth').val();

            var employeeId=$('#employeeId').val();
            var companyPremium=$('#companyPremium').val();
            var selfPremium=$('#selfPremium').val();
            var cashIncome=$('#cashIncome').val();
            var absentDay=$('#absentDay').val();
            var dockPay=$('#dockPay').val();
            var receivable=$('#receivable').val();

            var abcIssue=$('#abcIssue').val();
            var bbcIssue=$('#bbcIssue').val();

        }
        <!-- 信息回填-->
        $.ajax({
            type:"post",
            url:"/employee/MonthSalaryDetailedInformation" ,
            dataType:"json",

            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {

                var obj =  eval("("+data+")");
                var temp1=obj[0];
                $('#employeeid').val(temp1.employeeId);
                $('#companyPremium').val(temp1.companyPremium);
                $('#selfPremium').val(temp1.selfPremium);
                $('#cashIncome').val(temp1.cashIncome);
                $('#premiumId').val(temp1.id);
                $('#year').val(temp1.years);
                var temp=obj[1];
                $('#absentDay').val(temp.absentDay);
                $('#dockPay').val(temp.dockPay);
                $('#receivable').val(temp.receivable);
                $('#dockPayId').val(temp.id);

                var temp2=obj[2];
                $('#abcIssue').val(temp2.abcIssue);
                $('#bbcIssue').val(temp2.bbcIssue);;
                $('#payrecordId').val(temp2.id);

            }
        });


    </script>
</head>
<body>
<div>
    <div>
        <label class="module-title">员工薪资</label>
    </div>

    <div class="selectmothsalary">

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
        <input type="text" id="premiumId" style="display: none">
        <input type="text" id="dockPayId" style="display: none" >
        <input type="text" id="payrecordId" style="display: none">
        <input type="text" id="year" style="display: none">
        <button class="btn-green" style="margin-left: 5px; " onclick="changestate()">修改员工信息</button>
        <button id="update" class="btn-blue" style="margin-left: 5px ; display: none">确定修改</button>

    </div>
</div>
</body>
</html>