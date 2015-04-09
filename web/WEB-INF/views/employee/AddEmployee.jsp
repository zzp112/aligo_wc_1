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
            min-width: 750px;
            width: 750px;
            float: left;


        }


        .photo{
            min-width: 120px;
            width:150px;
            float: left;
            height: 160px;


        }

        td{
            margin-top: 10px;
        }


    </style>
    <script language="javascript" type="text/javascript"src="<c:url value="/resources/js/My97DatePicker/WdatePicker.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/awesomechart.js"/>"></script>
    <script>
       function addemployee(){

           var sex;
          var check =document.getElementsByName('sex');
          if( check[0].checked)
          {
              sex="男";
          }
           else
          {
              sex="女";
          }

           var marriage;
           var checkmarry=document.getElementsByName('marry');
           if( checkmarry[0].checked)
           {
               marriage="是";
           }
           else
           {
               marriage="否";
           }


           var name=$('#name').val();
           var birthday=$('#birthday').val();
           var age=$('#age').val();
           var hometownAddress=$('#hometownAddress').val();
           var phone=$('#phone').val();
           var presentAddress=$('#presentAddress').val();
           var qq=$('#qq').val();
           var educationYear=$('#educationYear').val();
           var educationSchool=$('#educationSchool').val();
           var educationCollege=$('#educationCollege').val();
           var major=$('#major').val();
           var idNumber=$('#idNumber').val();
           var jobs=$('#jobs').val();
           var email=$('#email').val();
           var emergencyContact=$('#emergencyContact').val();
           var relationship=$('#relationship').val();
           var ecAddress=$('#ecAddress').val();
           var emergencyContactPhone=$('#emergencyContactPhone').val();

           $.ajax({
                       type:"post",
                       url: "/employee/AddEmployeeInfo",
                       data:{
                           sex:sex,marriage:marriage,name:name,birth:birthday,age:age,
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
                    alert("添加成功！");
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
        <label class="module-title">添加员工</label>
    </div>

    <div class="information" >

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
                    <input type="radio" name="sex" id="sexM" value="male" checked="true" /> <label for="sexM">男</label>

                    <input type="radio" name="sex" id="sexF" value="female" /> <label for="sexF">女</label>
                </td>
                <td><span>是否已婚：</span></td>
                <td> <input type="radio" name="marry" value="yes"  id="yes"/> <label for="yes">是</label>

                    <input type="radio" name="marry" value="no"  id="no" checked="true"/> <label for="no">否</label>
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
                <td><input type="button" class="btn-blue" style="margin-top: 20px;" onclick="addemployee()" value="添加员工"></td>
            </tr>
        </table>
        </div>

    <div class="photo" >
        <img src="/resources/img/test.png">
    </div>




</div>
</body>
</html>