<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>

<html>
<head>
    <title>
        小站收入/支出明细...
    </title>
    <script type="text/javascript">
        //默认关闭添加窗口
        $(function(){
            $('#w').window('close');
        });
        //绑定指定的table加载数据并实现分页的功能
        $(function () {
            loadDataFromJson('dg','selectAllPaymentDetails');
        });

        //获取选中的行的数据
        function deleteCurrentRowPaymentDetail() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                if(confirm('您确定您要删除明细编号为：' + row.detail_id+"的小站吗？")){
                    location.href="deleteCurrentRowPaymentDetail?row.detail_id";
                }
            }
        }
        //调用搜索按钮
        function doSearch(value) {
            alert('You input: ' + value);
        }

        //添加收支明细
        function addBalanceDetail(){

        }

    </script>

    <script type="text/javascript">
        //格式化时间
        function myformatter(date) {
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
        }
        function myparser(s) {
            if (!s) return new Date();
            var ss = (s.split('-'));
            var y = parseInt(ss[0], 10);
            var m = parseInt(ss[1], 10);
            var d = parseInt(ss[2], 10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
                return new Date(y, m - 1, d);
            } else {
                return new Date();
            }
        }
    </script>

    <style>
        span {
            font-size: inherit;
            font-weight: 500;
            color: #333333;
        }
    </style>
</head>

<body>
<div>
    <div class="easyui-panel" title="显示小站资金收支明细数据" style="width: 920px">
        &nbsp
        <span>收支类型:</span>
        <select class="easyui-combobox" name="balance_state" style="width:150px;">
            <option value="0">===请选择===</option>
            <option value="income">收入</option>
            <option value="outcome">支出</option>
        </select>

        <span>类别:</span>
        <select class="easyui-combobox" name="balance_type" style="width:150px;">
            <option value="0">===请选择===</option>
            <option value="income">小站拆账</option>
        </select>

        <span>开始:</span>
        <input id="start_time" name="start_time" class="easyui-datetimebox"
               data-options="formatter:myformatter,parser:myparser" required style="width:150px">

        <span>结束:</span>
        <input id="end_time" name="end_time" class="easyui-datetimebox"
               data-options="formatter:myformatter,parser:myparser" required style="width:150px">
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="">查询</a>
    </div>



    <table id="dg" style="width:920px;height:310px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
        <thead>
        <tr>
            <th field="detail_id"width="100">明细id</th>
            <th field="balance" width="80">收入/支出</th>
            <th field="balance_amount" width="100">金额</th>
            <th field="balance_type" width="110">类别</th>
            <th field="balance_comment" width="487" align="center">备注</th>
        </tr>
        </thead>
    </table>



    <div class="easyui-panel" style="width: 920px">
        <div id="dt" style="padding:2px 5px;">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"onclick="$('#w').window('open')">添加一条收支明细数据</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"onclick="deleteCurrentRowPaymentDetail();">删除选中的收支明细数据</a>
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getStudent()">修改选中的收支明细数据</a>
        </div>
    </div>




    <%--弹出窗口--%>
    <div id="w" class="easyui-window" title="添加一条资产明细" data-options="iconCls:'icon-save'" style="width:570px;height:440px;padding:5px;">
        <div class="easyui-layout" data-options="fit:true">
            <div style="margin-top: 40px;margin-left: 70px">
                <jsp:include page="toInputPaymentDetail.jsp"></jsp:include>
            </div>
        </div>
    </div>

</div>
</body>
</html>
