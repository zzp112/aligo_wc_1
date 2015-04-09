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
</head>
<body>
    <h1>添加学生上课记录</h1>
    <form action="/stuCou/addStuCou" method="post">
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
                <td><input class="Wdate" id="courseDate" name="courseDate" onclick="WdatePicker()"/></td>
            </tr>
        </table>
        <input type="submit" value="确定" class="btn-green"/>
    </form>


</body>
</html>
