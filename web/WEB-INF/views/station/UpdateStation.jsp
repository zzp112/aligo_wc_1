<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/9 0009
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="modifyhtml" style="display: none">
    <form action="/station/updateStationById" method="post" >
        <table>
            <tr>
                <td>小站地址:</td>
                <td><input type="text" class="input-text" placeholder="请输入小站地址" id="modiaddress" name="address"/></td>
            </tr>
            <tr>
                <td>管理编号:</td>
                <td><input type="text" class="input-text" placeholder="请输入管理编号" id="addmanagerId" name="managerId"/></td>
            </tr>
            <tr>
                <td>拆账比例:</td>
                <td><input type="text" class="input-text" placeholder="请输入拆账比例" id="addaccountRatio" name="accountRatio"/></td>
            </tr>
            <tr>
                <td>总支出:</td>
                <td><input type="text" class="input-text" placeholder="请输入总支出" id="addtotalAmount" name="totalAmount"/></td>
            </tr>
            <tr>
                <td>实际支出:</td>
                <td><input type="text" class="input-text" placeholder="请输入学生名字"/></td>
                <%--<td><input type="text" class="input-text" value=$('#accountRatio').val()*$('$totalAmount').val()/></td>--%>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green" value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</div>
</body>
</html>
