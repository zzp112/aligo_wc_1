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

        .photo{
            min-width: 120px;
            width:150px;
            float: left;
            height: 160px;


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
    <script language="javascript" type="text/javascript"src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <script>
        $.ajax({
            type:"post",
            url: "/employee/finEmployeeId",
            dataType:"json",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj =  eval("("+data+")");

                var dataStr = "";

                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    var table = $('#select');
                    dataStr +=" <option>"+ p+"</option> ";
                }
                table.append(dataStr);
            }
        });


        function addbasesalary(){
            var employeeId=$('#select').val();
           var departMent=$('#departMent').val();
            var abcId=$('#abcId').val();
            var bbcId=$('#bbcId').val();
            var hireTime=$('#hireTime').val();
            var baseSalary=$('#baseSalary').val();
            var professionalAllowance=$('#professionalAllowance').val();
            var performanceAllowance=$('#performanceAllowance').val();
            var cadresAllowance=$('#cadresAllowance').val();
            var otherAllowance=$('#otherAllowance').val();
            var selfPremiumBenefits=$('#selfPremiumBenefits').val();

            $.ajax({
                type:"post",
                url: "/employee/AddBaseSalarys",
                data:{
                    employeeId:employeeId,departMent:departMent,abcId:abcId,bbcId:bbcId,
                    hireTimes:hireTime,baseSalary:baseSalary,professionalAllowance:professionalAllowance,
                    performanceAllowance:performanceAllowance,cadresAllowance:cadresAllowance,
                    otherAllowance:otherAllowance,selfPremiumBenefits:selfPremiumBenefits
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
        <label class="module-title">添加员工基础薪资信息</label>
    </div>
<div class="addbaseinfo">
    <div class="Basicinformation">
        <h2>基本信息</h2>
        <div class="input"><span>员工号&nbsp;：</span><select  id="select"></select></div>
        <div class="input"><span>部 &nbsp;&nbsp;&nbsp;门：</span><input type="text" id="departMent" class="input-text" placeholder="输入框"/></div>
        <div class="input"><span>农行卡号：</span><input type="text" id="abcId" class="input-text" placeholder="输入框"/></div>
        <div class="input"><span>建行卡号：</span><input type="text" id="bbcId" class="input-text" placeholder="输入框"/></div>
        <div class="input"><span>起聘时间：</span><input type="text" id="hireTime" class="input-text" placeholder="输入框" onclick="WdatePicker()"/></div>
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

    <button class="btn-blue" style="margin-top: 20px;" onclick="addbasesalary()">添加</button>
</div>
</div>
</body>
</html>