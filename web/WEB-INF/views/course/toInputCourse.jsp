<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/9 0009
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="post" action="/course/addCourse">
        <table>
            <tr>
                <td>课程名称:</td>
                <td><input type="text" class="input-text" placeholder="请输入课程名称" name="name"/></td>
            </tr>
            <tr>
                <td>课程费用:</td>
                <td><input type="text" class="input-text" placeholder="请输入单节费用" name="cost"/></td>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</body>
</html>
