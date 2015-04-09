<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>

<html>
<head>
    <title>
        小站收入/支出明细...
    </title>

    <script>

        //修改是否成功返回给用户直观的界面
        $(function(){
            if(${IsRight==null}){

            }
            else{
                if(${IsRight=="yes"}){
                    alert("修改或添加成功!");
                }
                else{
                    alert("修改或添加失败!");
                }
            }
        });

        //内嵌HTML代码的对话框，使用场景：点击修改按钮，弹出该对话框修改一条记录
        //添加收支明细
        function addBalanceDetail() {
            new $.Zebra_Dialog( {
                source: {'inline': $('.addhtml').html()}, //内嵌html代码
                width: 500, //宽度
                max_height:300, //高度超出则可以显示滚动条
                title:  '增加信息',
                position:['left +200','top+20'],
                overlay_opacity:'0',
                buttons:['是',' 否']
            });
        }

        //获取选中的行的数据
        function deleteCurrentRowPaymentDetail(detail_id) {
//            $.Zebra_Dialog('这是普通的对话框，可以定制按钮', {
//                'type':     'question',
//                'title':    'Custom buttons',
//                'buttons':  ['Yes', 'No', 'Help'],
//                'onClose':  function(caption) {
//                    if(caption =="")
//                        alert("你没有点击按钮");
//                    if(caption=="Yes")
//                        alert("你点击了YES");
//                    if(caption=="No")
//                        alert("你点击了No");
//                    if(caption=="Help")
//                        alert("你点击了Help");
//                }
//            });
            if (confirm('您确定您要删除明细编号为：' + detail_id + "的小站吗？")) {
                location.href = "deleteCurrentRowPaymentDetail?detail_id=" + detail_id;
            }
        }

        //获取选中行并实现更新
        function updateCurrentRowPaymentDetail(detail_id) {
            if (confirm('您确定要修改明细编号为：' + detail_id + "的小站吗？")) {
                location.href = "toUpdateCurrentRowPaymentDetail?detail_id=" + detail_id;
            }
        }


        //调用搜索按钮
        function doSearch() {
            var h1 = $('#balance_state').combobox('getValue');
            var h2 = $("#start_time").datebox('getValue');
            var h3 = $("#end_time").datebox('getValue');
            $.ajax({
                type: "POST",
                url: "/searchByAll?json",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify({balance: h1, begin_time: h2, end_time: h3}),
                success: function (data) {

                    if (data.length > 0) {
                        var obj = eval("(" + data + ")");
                        var temp = obj[0];
                        var dataStr = "";
                        for (var i = 0; i < obj.length; i++) {
                            var p = obj[i];
                            var table = $('.table');
                            dataStr += "<tr>" +
                            "<td>" + p.detail_id + "</td>" +
                            "<td>" + p.balance + "</td>" +
                            "<td>" + p.balance_amount + "</td>" +
                            "<td>" + p.balance_type + "</td>" +
                            "<td>" + p.balance_comment + "</td>" +
                            "<td><span onclick='updateCurrentRowPaymentDetail(" + p.detail_id + ")'>修</span>&nbsp;&nbsp;<span onclick='deleteCurrentRowPaymentDetail(" + p.detail_id + ")'>删</span></td>" +
                            "</tr>";
                        }
                        table.append(dataStr);
                    }
                },
                error: function () {
                    alert("请求出错");
                }
            });
        }

        //获取数据
        $.ajax({
            type: "post",
            url: "/selectAllPaymentDetails",
            dataType: "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function (data) {
                var obj = eval("(" + data + ")");
                var temp = obj[0];
                var dataStr = "";
                for (var i = 0; i < obj.length; i++) {
                    var p = obj[i];
                    var table = $('.table');
                    dataStr += "<tr>" +
                    "<td>" + p.detail_id + "</td>" +
                    "<td>" + p.balance + "</td>" +
                    "<td>" + p.balance_amount + "</td>" +
                    "<td>" + p.balance_type + "</td>" +
                    "<td>" + p.balance_comment + "</td>" +
                    "<td><span onclick='updateCurrentRowPaymentDetail(" + p.detail_id + ")'>修</span>&nbsp;&nbsp;<span onclick='deleteCurrentRowPaymentDetail(" + p.detail_id + ")'>删</span></td>" +
                    "</tr>";
                }
                table.append(dataStr);
            }
        });


        //获取小站收支明细类别
            $.ajax({
                type: "post",
                url: "/toListBalanceType",
                dataType: "json",
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                },
                success: function (data) {
                    var obj = eval("(" + data + ")");
                    var temp = obj[0];
                    var dataStr="";
                    for (var i = 0; i < obj.length; i++) {
                        dataStr += "<option value='" +obj[i].paymentTypeName
                        +"'>" + obj[i].paymentTypeName+"</option>";
                    }
                    $("#DetailBalanceType").append(dataStr);
                }
            });
    </script>

    <style>
        span {
            font-size: inherit;
            font-weight: 500;
            color: #333333;
        }

        table {
            text-align: center;
        }

        .module-title {
            font-weight: 400;
            font-size: 40px;
        }
    </style>
</head>

<body>
<div>

    <div style="position:relative;">
        <label class="module-title">&nbsp;小站收支明细表</label><br>

        <div title="显示小站资金收支明细数据" style="margin-top: 10px;margin-bottom: 10px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span>收支类型:</span>
            <select  name="balance_state" style="width:160px;">
                <option value="0">===请选择===</option>
                <option value="income">收入</option>
                <option value="outcome">支出</option>
            </select>
            &nbsp;&nbsp;
            <span>类别:</span>
            <%--<div class="DetailBalanceType" name="balance_type"style="width:150px;"></div>--%>
            <select id="DetailBalanceType" name="balance_type" style="width:160px;">
                <option value="0">===请选择===</option>
            </select>
            &nbsp;&nbsp;
            <span>开始:</span>
            <input id="start_time" name="start_time" style="width: 160px;height:24px;">
            &nbsp;&nbsp;
            <span>结束:</span>
            <input id="end_time" name="end_time" style="width: 160px;height:24px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btn-green" value="查  询" onclick="doSearch();">

            <input type="button" class="btn-blue" value="添  加" style="position:absolute;top:5px;right:5px;"
                   onclick="addBalanceDetail();">
        </div>


        <%--弹框添加小站收支明细--%>
        <div class="addhtml" style="display: none;">
            <jsp:include page="toInputPaymentDetail.jsp"></jsp:include>
        </div>


        <div>
            <table class="table" cellspacing="0" style="margin-left: 10px;">
                <tr>

                    <td style="width: 80px">明细ID</td>
                    <td style="width: 100px">收入/支出</td>
                    <td style="width: 80px">金额</td>
                    <td style="width: 180px">类别</td>
                    <td style="width: 280px">备注</td>
                    <td style="width: 180px">操作</td>
                </tr>
            </table>
            <div class="page"></div>
        </div>
    </div>
</body>
</html>
