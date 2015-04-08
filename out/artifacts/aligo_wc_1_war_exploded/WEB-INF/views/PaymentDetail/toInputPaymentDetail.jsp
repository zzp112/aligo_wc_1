<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index</title>
    <script>
        function submitForm() {
            $('#ff').form('submit');
        }
        function clearForm() {
            $('#ff').form('clear');
        }


    </script>
</head>
<body>
<div class="easyui-panel" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="/CreatePaymentDetail">
            <table cellpadding="5">
                <tr>
                    <td>小站id:</td>
                    <c:forEach items="${stationList}" var="station">
                        ${station.id}
                    </c:forEach>
                    <td>
                        <select name="station_id" >
                            <option value="0">===请选择===</option>
                            <c:forEach items="${stationList}" var="station">
                                <option value="${station.id}">${station.id}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>添加日期:</td>
                    <td><input class="easyui-datetimebox" name="create_date" data-options="multiline:true"
                            ></td>
                </tr>
                <tr>
                    <td>收入/支出:</td>
                    <td>
                        <select class="easyui-combobox" name="balance">
                            <option value="income">收入</option>
                            <option value="outcome">支出</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>收入/支出金额:</td>
                    <td><input class="easyui-textbox" name="balance_amount" data-options="multiline:true"
                            ></td>
                </tr>
                <tr>
                    <td>收入/支出类别:</td>
                    <td><input class="easyui-textbox" name="balance_type" data-options="multiline:true"
                            ></td>
                </tr>
                <tr>
                    <td>小站支出备注:</td>
                    <td><input class="easyui-textbox" name="advice" data-options="multiline:true"
                            ></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>
    </div>
</div>
</body>
</html>
