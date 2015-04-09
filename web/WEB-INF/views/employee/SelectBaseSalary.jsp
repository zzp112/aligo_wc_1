<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加员工基础薪资信息</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <style type="text/css">

        .information{
            min-width: 900px;
            width: 900px;
            float: left;
            height: 160px;
        }
        .informationnext{
            min-width: 1150px;
            width: 900px;
            float: left;
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

</head>
<body >
<div  >
    <div>
        <label class="module-title">员工基础薪资信息</label>
    </div>
    <div class="addbaseinfo">
        <div class="Basicinformation">
            <h2>基本信息</h2>
            <div class="input"><span>员工号&nbsp;：</span><input type="text" id="employeeid" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>部 &nbsp;&nbsp;&nbsp;门：</span><input type="text" id="department" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>姓 &nbsp;&nbsp;&nbsp;名：</span><input type="text" id="name" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>工作类型：</span><input type="text" id="jobtype" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>身份证号：</span><input type="text" id="idnumber" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>农行卡号：</span><input type="text" id="abcID" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>建行卡号：</span><input type="text" id="bbcId" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>起聘时间：</span><input type="text" id="hireTime" class="input-text" placeholder="输入框"/></div>
        </div>
        <br/>
        <div class="salarystructure">
            <h2>薪资结构</h2>
            <div class="input"><span>基本薪资：</span><input type="text" id="baseSalary" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>专业津贴：</span><input type="text" id="professionalAllowance" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>绩效津贴：</span><input type="text" id="performanceAllowance" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>干部津贴：</span><input type="text" id="cadresAllowance" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>其他津贴：</span><input type="text" id="otherAllowance" class="input-text" placeholder="输入框"/></div>
            <div class="input"><span>个人险金福利：</span><input type="text" id="selfPremiumBenefits" class="input-text" placeholder="输入框"/></div>

        </div>

        <button class="btn-blue" style="margin-top: 20px;">修改</button>
    </div>
</div>
</body>
</html>