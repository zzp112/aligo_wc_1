<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
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
            width: 250px;
            float: left;
            margin-top:10px ;
        }
        .inputlong{
            width: 400px;
            float: left;
            margin-top:10px ;
        }

    </style>

    <script language="javascript" type="text/javascript"src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
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

        $.ajax({
            type:"post",
            url: "/employee/EmployeeDetailedInformation",
            dataType:"json",

            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj =  eval("("+data+")");

                $('#employeeId').val(obj.employeeId);
                $('#name').val(obj.name);
                $('#birthday').val(obj.birthday);
                $('#age').val(obj.age);
                $('#hometownAddress').val(obj.hometownAddress);
                $('#phone').val(obj.phone);
                $('#presentAddress').val(obj.presentAddress);
                $('#qq').val(obj.qq);
                $('#educationYear').val(obj.educationYear);
                $('#educationSchool').val(obj.educationSchool);
                $('#educationCollege').val(obj.educationCollege);
                $('#major').val(obj.major);
                $('#idNumber').val(obj.idNumber);
                $('#jobs').val(obj.jobs);
                $('#email').val(obj.email);
                $('#emergencyContact').val(obj.emergencyContact);
                $('#relationship').val(obj.relationship);
                $('#ecAddress').val(obj.ecAddress);
                $('#emergencyContactPhone').val(obj.emergencyContactPhone);
                    var province = document.getElementsByName("sex");
                if(obj.sex=="男")
                {
                    province[0].checked="checked";
                }
                else{
                    province[1].checked="checked";
                }

                var marr = document.getElementsByName("marry");
                if(obj.marry=="是")
                {
                    marr[0].checked="checked";
                }
                else{
                    marr[1].checked="checked";
                }

            }
        });


        function update(){
            var  employeeId=$('#employeeId').val();
            var  name=$('#name').val();
            var  birthday= $('#birthday').val();
            var  age= $('#age').val();
            var  hometownAddress= $('#hometownAddress').val();
            var  phone= $('#phone').val();
            var  presentAddress= $('#presentAddress').val();
            var  qq= $('#qq').val();
            var  educationYear= $('#educationYear').val();
            var  educationSchool= $('#educationSchool').val();
            var  educationCollege= $('#educationCollege').val();
            var  major= $('#major').val();
            var  idNumber= $('#idNumber').val();
            var  jobs= $('#jobs').val();
            var  email= $('#email').val();
            var  emergencyContact= $('#emergencyContact').val();
            var  relationship= $('#relationship').val();
            var  ecAddress= $('#ecAddress').val();
            var  emergencyContactPhone= $('#emergencyContactPhone').val();
            var sexs = document.getElementsByName("sex");
            var marr = document.getElementsByName("marry");
            var sex;
            var marriage;
            if(sexs[0].checked)
            {
             sex ="男";
            }
            else
            {
                sex="女";
            }

            if(marr[0].checked)
            {
                marriage="是";
            }
            else
            {
                marriage="否";
            }


            $.ajax({
                type:"post",
                url: "/employee/UpdateEmployeeInfo",
                data:{
                    employeeId:employeeId,sex:sex,marriage:marriage,name:name,birth:birthday,age:age,
                    hometownAddress:hometownAddress,phone:phone,presentAddress:presentAddress,qq:qq,
                    educationYear:educationYear,educationSchool:educationSchool,educationCollege:educationCollege,
                    major:major,idNumber:idNumber,jobs:jobs,email:email,emergencyContact:emergencyContact,
                    relationship:relationship,ecAddress:ecAddress,emergencyContactPhone:emergencyContactPhone
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
<body >
<div style="min-width: 1050px;width: 1050px;" >
    <div>
        <label class="module-title">员工详情</label>
    </div>
    <div class="information" >
    <input type="text" id="employeeId" style="display: none">
        <table  cellspacing="10" >
            <tr>
                <td><span>姓名:</span></td>
                <td> <input type="text" id="name" class="input-text" placeholder="输入框"/></td>
                <td></td>
            </tr>
            <tr>
                <td><span>出生年月:</span></td>
                <td> <input type="text" id="birthday" class="input-text" placeholder="输入框" onclick="WdatePicker()"/></td>
                <td><span>年龄</span></td>
                <td><input type="text" id="age" class="input-text" placeholder="输入框" /></td>
            </tr>
            <tr>
                <td><span>性别：</span></td>
                <td>
                    <input type="radio" name="sex" id="sexM" value="male" /> <label for="sexM">男</label>

                    <input type="radio" name="sex" id="sexF" value="female" /> <label for="sexF">女</label>
                </td>
                <td><span>是否已婚：</span></td>
                <td> <input type="radio" name="marry" value="yes"  id="yes"/> <label for="yes">是</label>

                    <input type="radio" name="marry" value="no"  id="no"/> <label for="no">否</label>
                </td>

            </tr>
            <tr>
                <td><span>户籍地址:</span></td>
                <td> <input type="text" id="hometownAddress" class="input-text" placeholder="输入框" /></td>
                <td><span>通讯地址:</span> </td>
                <td><input type="text" id="presentAddress" class="input-text" placeholder="输入框" /></td>
            </tr>
            <tr>
                <td><span>联系电话:</span></td>
                <td> <input type="text" id="phone" class="input-text" placeholder="输入框"/></td>
                <td><span>Q Q号码:</span></td>
                <td> <input type="text" id="qq" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>常用邮箱:</span></td>
                <td><input type="text" id="email" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><span>所在学校:</span></td>
                <td> <input type="text" id="educationSchool" class="input-text" placeholder="输入框"/></td>
                <td><span>入学年份:</span></td>
                <td><input type="text" id="educationYear" class="input-text" placeholder="输入框" /></td>
                <td></td>
            </tr>
            <tr>
                <td><span>学院:</span></td>
                <td><input type="text" id="educationCollege" class="input-text" placeholder="输入框" /></td>
                <td><span>专业:</span></td>
                <td> <input type="text" id="major" class="input-text" placeholder="输入框" /></td>
            </tr>
            <tr>
                <td><span>身份证:</span></td>
                <td> <input type="text" id="idNumber" class="input-text" placeholder="输入框"/></td>
                <td><span>工作岗位:</span></td>
                <td> <input type="text" id="jobs" class="input-text" placeholder="输入框"/></td>
            </tr>

            <tr>
                <td><span>紧急联系人:</span></td>
                <td><input type="text" id="emergencyContact" class="input-text" placeholder="输入框" /></td>
                <td><span>与员工的关系:</span></td>
                <td><input type="text" id="relationship" class="input-text" placeholder="输入框"/></td>

            </tr>

            <tr>
                <td><span>联系人地址:</span></td>
                <td> <input type="text" id="ecAddress" class="input-text" placeholder="输入框"/></td>
                <td><span>联系人的电话:</span></td>
                <td><input type="text" id="emergencyContactPhone" class="input-text" placeholder="输入框"/></td>
            </tr>
            <tr>
                <td><input type="button" class="btn-blue" style="margin-top: 20px;" value="返回信息列表"></td>
                <td><input type="button" class="btn-green" style="margin-top: 20px;" onclick="changestate()" value="修改员工信息"></td>
                <td><input type="button" id="update" class="btn-blue" style="margin-top: 20px;  display: none ;" onclick="update()" value="确定修改"></td>
            </tr>
        </table>
    </div>

    <div class="photo" >
        <img src="/resources/img/test.png">
    </div>

</div>

</body>
</html>