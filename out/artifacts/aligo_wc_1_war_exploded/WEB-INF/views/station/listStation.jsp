<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>小站管理</title>
    <script type="text/javascript">
        $(function () {
            loadDataFromJson('dg','/station/loadAllStation');
        });
    </script>
</head>
<body>
<div id="dt" style="padding:2px 5px;">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="">查看选中的数据</a>
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
        <th field="managerid" width="100" align="center">负责人</th>
        <th field="accountratio" width="100" align="center">拆账比例</th>
        <th field="totalamount" width="100" align="center">总金额</th>
        <th field="actualamount" width="100" align="center">应付金额</th>
    </tr>
    </thead>
</body>
</html>
