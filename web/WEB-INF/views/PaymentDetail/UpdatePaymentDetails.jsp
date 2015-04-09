<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>index</title>
    <%--<script>--%>
    <%--function submitForm() {--%>
    <%--$('#ff').form('submit');--%>
    <%--}--%>
    <%--function clearForm() {--%>
    <%--$('#ff').form('clear');--%>
    <%--}--%>

    <%--</script>--%>

    <style>
        #error {
            color: red;
            font-size: 15px;
            font-family: Arial;
            font-weight: 600;
        }

        #success {
            color: #0000FF;
            font-size: 15px;
            font-family: Arial;
            font-weight: 600;
        }

        /*.updateBox {*/
        /*dborder: 3px solid blue*/
        /*}*/
    </style>
</head>
<body>

<div class="updateBox" style="width:400px;text-align: center;margin:0 auto;margin-top: 8%;border:solid #EDEDED;box-shadow: 10px 10px 25px #ccc;"><div style="margin-bottom: 20px;"></div>
    <center><label class="module-title"> 小站"${paymentDetail.station_id}"的"${paymentDetail.detail_id}"号明细</label>
    </center><br><br>
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="/updateCurrentRowPaymentDetail">
            <table cellpadding="5">
                <tr>
                    <td>小 站 名 称  :</td>
                    <td>
                        <input class="input-text" type="text" name="station_id" value="${paymentDetail.station_id}" style="width: 160px;margin-bottom:5px;">
                    </td>
                </tr>

                <tr>
                    <td>添 加 日 期  :</td>
                    <td><input class="input-text" name="create_date" data-options="multiline:true"
                               value="${paymentDetail.create_date}" style="width: 160px;margin-bottom:5px;"
                            ></td>
                </tr>
                <tr>
                    <td>收 入/支 出 :</td>
                    <td>
                        <select name="balance" style="width: 160px;margin-bottom:5px;">
                            <c:if test="${paymentDetail.balance=='income'}">
                                <option value="income" selected>收入</option>
                                <option value="outcome">支出</option>
                            </c:if>
                            <c:if test="${paymentDetail.balance=='outcome'}">
                                <option value="income">收入</option>
                                <option value="outcome" selected>支出</option>
                            </c:if>
                            <c:if test="${paymentDetail.balance==null}">
                                <option value="income" selected>收入</option>
                                <option value="outcome">支出</option>
                            </c:if>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        <c:if test="${paymentDetail.balance=='income'}">
                            收 入 金 额  ：
                        </c:if>
                        <c:if test="${paymentDetail.balance=='outcome'}">
                            支 出 金 额  ：
                        </c:if>
                        <c:if test="${paymentDetail.balance==null}">
                            收入/支出金额:
                        </c:if>
                    </td>
                    <td><input class="input-text" name="balance_amount" data-options="multiline:true"
                               value="${paymentDetail.balance_amount}" style="width: 160px;margin-bottom:5px;"></td>
                </tr>
                <tr>
                    <td>
                        <c:if test="${paymentDetail.balance=='income'}">
                            收 入 类 别  ：
                        </c:if>
                        <c:if test="${paymentDetail.balance=='outcome'}">
                            支 出 类 别  ：
                        </c:if>
                        <c:if test="${paymentDetail.balance==null}">
                            收入/支出类别:
                        </c:if>
                    </td>
                    <td><input class="input-text" name="balance_type" data-options="multiline:true"
                               value="${paymentDetail.balance_type}" style="width: 160px;margin-bottom:5px;"></td>
                </tr>
                <tr>
                    <td>
                        <c:if test="${paymentDetail.balance=='income'}">
                            小站收入备注：
                        </c:if>
                        <c:if test="${paymentDetail.balance=='outcome'}">
                            小站支出备注：
                        </c:if>
                        <c:if test="${paymentDetail.balance==null}">
                            小站收入支出备注:
                        </c:if>
                    </td>
                    <td><input class="input-text" name="advice" data-options="multiline:true"
                               value="${paymentDetail.balance_comment}" style="width: 160px;margin-bottom:10px;"></td>
                </tr>
            </table>
            <div style="text-align:center;padding:10px;">
                <input type="submit" class="btn-green" value="提交"
                       style="width:63px;height: 33px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" class="btn-green" value="重置"
                       style="width:63px;height: 33px;">
                <%--<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>--%>
                <%--<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>--%>
            </div>
        </form>
        <c:if test="${successImfor!=null}">
            <center><span id="success">${successImfor}</span></center>
        </c:if>
        <c:if test="${failImfor!=null}">
            <center><span id="error">${failImfor}</span></center>
        </c:if>
    </div>
</div>
</body>
</html>
