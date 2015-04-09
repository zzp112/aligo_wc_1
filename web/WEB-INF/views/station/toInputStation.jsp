<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/9 0009
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title></title>
    <script>
        function a(){
            $("form").submit(function(e){
                alert($("#address").val);
            });
        }
    </script>
</head>
<body>
<div class="addhtml">
    <div>
    <form action="/station/addStation" method="post" >
        <table>
            <tr>
                <td>小站地址:</td>
                <td><input type="text" class="input-text" placeholder="请输入小站地址" id="addaddress" name="address"/></td>
            </tr>
            <tr>
                <td>管理编号:</td>
                <td><input type="text" class="input-text" placeholder="请输入管理编号" id="addmanagerId" name="managerId"/></td>
            </tr>
            <tr>
                <td>拆账比例:</td>
                <td><input type="text" class="input-text" placeholder="请输入拆账比例" id="addaccountRatio" name="accountRatio"/></td>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
    </div>
</div>
</body>
</html>
