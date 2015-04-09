<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
<div class="easyui-panel" style="width:300px">
    <div >
        <form id="ff" method="post" action="/CreatePaymentDetail">
            <table >
                <tr>
                    <td>小 站 ID :</td>
                    <td>&nbsp;&nbsp;
                        <select name="station_id" style="width:160px;margin-bottom: 5px;">
                            <option value="0">====请选择====</option>
                            <c:forEach items="${stationList}" var="station">
                                <option value="${station.id}">${station.id}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>添加日期 :</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<input class="input-text" name="create_date" placeholder="请选择日期" style="width:160px;margin-bottom: 5px;">
                </tr>
                <tr>
                    <td>收入/支出:</td>
                    <td>&nbsp;&nbsp;
                        <select name="balance" style="width:160px;margin-bottom: 5px;">
                            <option value="income">收入</option>
                            <option value="outcome">支出</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>收支金额 :</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<input class="input-text" name="balance_amount" placeholder="请选择收入或支出金额" style="width:160px;margin-bottom: 5px;margin-top: 5px;">
                </tr>
                <tr>
                    <td>收支类别 :</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<input class="input-text" name="balance_type" placeholder="请选择收入或支出类别" style="width:160px;margin-bottom: 5px;margin-top: 5px;">
                </tr>
                <tr>
                    <td>明细备注 :</td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<input class="input-text" name="balance_comment" placeholder="请输入小站支出的备注" style="width:160px;margin-bottom: 15px;margin-top: 5px;"
                            ></td>
                </tr>
            </table>
            <div style="text-align:center;padding:5px">
                <input type="submit" class="btn-green" value="提交" style="width:63px;height: 33px;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <%--<a href="javascript:void(0)" class="btn-blue" style="width:130px;" onclick="submitForm()">提交</a>--%>
                <%--<a href="javascript:void(0)" class="btn-green" style="width:130px;" onclick="clearForm()">重置</a>--%>
            </div>
        </form>
    </div>
</div>
</body>
</html>
