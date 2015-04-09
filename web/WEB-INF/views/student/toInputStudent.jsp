<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/9 0009
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="/student/addStudent" method="post">
            <table>
                <tr>
                    <td>姓名:</td>
                    <td><input type="text" class="input-text" placeholder="请输入姓名" name="name"/></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td style="text-align: left">男：<input type="radio" name="sex" value="男" checked/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女：<input type="radio" name="sex" value="女"/></td>
                </tr>
                <tr>
                    <td>年级:</td>
                    <td><input type="text" class="input-text" placeholder="请输入年级" name="grade"/></td>
                </tr>
                <tr>
                    <td>家长电话:</td>
                    <td><input type="text" class="input-text" placeholder="请输入家长电话" name="parentsTel"/></td>
                </tr>
            </table>
            <div style="text-align:center;padding:5px">
                <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
                &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
            </div>
    </form>
</body>
</html>
