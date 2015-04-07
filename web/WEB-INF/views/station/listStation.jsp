<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>小站管理</title>
    <script type="text/javascript">
        $(function () {
            loadDataFromJson('dg','/station/loadAllStation');
        });
        function a(){
            window.showModalDialog( "/toListStudent", "window","height=100, width=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
        }
    </script>
</head>
<body>
<div id="dt" style="padding:2px 5px;">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="a()">查看选中的数据</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
</div>
<table id="dg" title="显示小站数据" style="width:920px;height:400px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
    <thead>
    <tr>
        <th field="id" width="100" align="center">小站编号</th>
        <th field="address" width="200" align="center">小站地址</th>
        <th field="managerId" width="100" align="center">负责人</th>
        <th field="accountRatio" width="100" align="center">拆账比例</th>
        <th field="totalAmount" width="100" align="center">总金额</th>
        <th field="actualAmountString" width="100" align="center">应付金额</th>
    </tr>
    </thead>
</table>
</body>
</html>
