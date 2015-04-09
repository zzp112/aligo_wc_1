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
    <script language="javascript" type="text/javascript"src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" ></script>

    <style type="text/css">

        .input{
            margin-top:10px ;
        }

        td{
            width: 160px;
        }
        .Basicinformation{

        }
        .salarystructure{
            position: absolute;
            left: 400px;
            top: 30px;
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


        <!-- 信息回填-->
        $.ajax({
            type:"post",
            url:"/employee/BaseSalaryDetailedInformation" ,
            dataType:"json",

            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj =  eval("("+data+")");
                var temp1=obj[0];
                $('#name').val(temp1.name);


                var temp=obj[1];
                $('#employeeId').val(temp.employeeId);
                $('#departMent').val(temp.departMent);
                $('#bbcId').val(temp.bbcId);
                $('#abcId').val(temp.abcId);
                $('#hireTime').val(temp.hireTime);

                var temp2=obj[2];
                $('#id').val(temp2.id);
                $('#baseSalary').val(temp2.baseSalary);
                $('#professionalAllowance').val(temp2.professionalAllowance);
                $('#performanceAllowance').val(temp2.performanceAllowance);
                $('#cadresAllowance').val(temp2.cadresAllowance);
                $('#otherAllowance').val(temp2.otherAllowance);
                $('#selfPremiumBenefits').val(temp2.selfPremiumBenefits);



            }
        });

        function update(){
            var id=$('#id').val();
            var employeeId=$('#employeeId').val();
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
                url: "/employee/UpdateBaseSalary",
                data:{
                    employeeId:employeeId,departMent:departMent,abcId:abcId,bbcId:bbcId,date:hireTime,id:id,
                    baseSalary:baseSalary,professionalAllowance:professionalAllowance,performanceAllowance:performanceAllowance,
                    otherAllowance:otherAllowance,selfPremiumBenefits:selfPremiumBenefits,cadresAllowance:cadresAllowance
                },
                dataType:"text",
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },
                success: function(data) {
                    if(data=="ok")
                        alert("修改成功！");
                    else
                        alert(data);
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

    <div class="Basicinformation">
    <h2>基本信息</h2>
<table>
    <tr><td><span>员工号</span></td>
        <td><input type="text" id="employeeId" class="input-text" placeholder="输入框"/></td>
    </tr>
    <tr>
        <td><span>部门：</span></td>
        <td><input type="text" id="departMent" class="input-text" placeholder="输入框"/></td>
    </tr>
    <tr>
        <td><span>姓 名：</span></td>
        <td><input type="text" id="name" class="input-text" placeholder="输入框"/></td>
    </tr>


    <tr>
        <td><span>农行卡号：</span></td>
        <td><input type="text" id="abcId" class="input-text" placeholder="输入框"/></td>
    </tr>
    <tr>
        <td><span>建行卡号：</span></td>
        <td><input type="text" id="bbcId" class="input-text" placeholder="输入框"/></td>
    </tr>
    <tr>
        <td><span>起聘时间：</span></td>
        <td><input type="text" id="hireTime" class="input-text" placeholder="输入框" onclick="WdatePicker()"/></td>
    </tr>
</table>
    </div>

    <br/>
    <div class="salarystructure " >
        <h2>薪资结构</h2>
        <table>
            <tr>
                <td><span>基本薪资：</span></td>
                <td><input type="text" id="baseSalary" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>专业津贴：</span></td>
                <td><input type="text" id="professionalAllowance" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>绩效津贴：</span></td>
                <td><input type="text" id="performanceAllowance" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>干部津贴：</span></td>
                <td><input type="text" id="cadresAllowance" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>其他津贴：</span></td>
                <td><input type="text" id="otherAllowance" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>个人险金福利：</span></td>
                <td><input type="text" id="selfPremiumBenefits" class="input-text" placeholder="输入框"/></td>
            </tr>
        </table>
        <input id="id" type="text" style="display: none">
    </div>
    <button class="btn-green" style="margin-left: 5px; " onclick="changestate()">修改员工信息</button>
    <button id="update" class="btn-blue" style="margin-left: 5px; display: none" onclick="update()">确定修改</button>

</div>

</body>
</html>