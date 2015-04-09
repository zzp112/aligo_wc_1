<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/zebra_dialog.js"/>"></script>
    <script language="javascript" type="text/javascript" src="/resources/js/My97DatePicker/WdatePicker.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/zebra_dialog.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />
    <style type="text/css">
        table{text-align: center;}
        .module-title{font-size: 40px;}
    </style>
    <script>
        //加载课程信息用于下拉框显示
        var courseList="";
        $.ajax({
            type: "POST",
            url: "/course/loadAllCourse",
            success: function(data){
                var obj = eval("("+data+")");
                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    courseList+="<option value='"+ p.id+"'>"+p.name+"</option>"
                }
                $("#courseListAdd").append(courseList);
            }
        });

        $.ajax({
            type: "POST",
            url: "/stuCou/preUpdateStuCou",
            success: function(msg){
                var stuCou=eval("("+msg+")");

                $("#id").val(stuCou.id);
                $("#stationId").val(stuCou.stationId);
                $("#studentId").val(stuCou.studentId);
                $("#courseListAdd").val(stuCou.courseName);
                $("#courseCount").val(stuCou.courseCount);
                $("#courseDate").val(stuCou.courseDate);
            }
        });

        //根据条件查询学生上课信息
        function submitParam(){
//            $("#paramForm").submit();
            $.ajax({
                type: "POST",
                url: "/stuCou/findStuCou",
                data: "stationId="+$("#stationId").val()+"&studentId="+$("#studentId").val()+"&courseName="+$("#courseName").val()+"&year="+$("#year").val()+"&month="+$("#month").val(),
                success: function(data){
                    var obj = eval("("+data+")");
                    var temp = obj[0];
                    $("#headTr").nextAll().remove();
                    var dataStr = "";
                    if(obj.length==0){
                        var table = $('.table');
                        dataStr+="<tr><td colspan='9' style='text-align: center'>没有符合条件的记录</td></tr>"
                        table.append(dataStr);
                    }else{
                        for(var i=0;i<obj.length;i++){
                            var p =obj[i];
                            var table = $('.table');
                            dataStr +="<tr>"+
                            "<td>"+ p.id+"</td>"+
                            "<td>"+ p.stationAddress+"</td>"+
                            "<td>"+ p.studentName+"</td>"+
                            "<td>"+ p.courseName+"</td>"+
                            "<td>"+ p.costByOne+"</td>"+
                            "<td>"+ p.courseCount+"</td>"+
                            "<td>"+ p.costTotal+"</td>"+
                            "<td>"+ p.courseDate+"</td>"+
                            "<td><span onclick='modifycontent("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                            "</tr>";
                        }
                        table.append(dataStr);
                    }
                }
            });
        }
    </script>
</head>
<body>
<h1>添加学生上课记录</h1>
<form action="/stuCou/updateStuCou" method="post">
    <input type="hidden" name="id" id="id">
    <table>
        <tr>
            <td>小站编号:</td>
            <td><input type="text" class="input-text" name="stationId" id="stationId" placeholder="请输入小站编号"/></td>
        </tr>
        <tr>
            <td>学生学号:</td>
            <td><input type="text" class="input-text" name="studentId" id="studentId" placeholder="请输入学生学号"/></td>
        </tr>
        <tr>
            <td>课程名称:</td>
            <td>
                <select style="width: 180px" id="courseListAdd" name="courseId">
                </select>
            </td>
        </tr>
        <tr>
            <td>总上课数:</td>
            <td><input type="text" class="input-text" name="courseCount" id="courseCount" placeholder="请输入总上课数"/></td>
        </tr>
        <tr>
            <td>上课日期:</td>
            <td><input class="Wdate" id="courseDate" name="courseDate" onclick="WdatePicker()"></td>
        </tr>
    </table>
    <input type="submit" value="确定" class="btn-green"/>
</form>


</body>
</html>
