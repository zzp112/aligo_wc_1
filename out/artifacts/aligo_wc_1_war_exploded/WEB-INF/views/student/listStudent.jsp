<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>

<html>
<head>
    <title>
        学生管理
    </title>

    <script type="text/javascript">
        $(function () {
            loadDataFromJson('dg','/student/loadAllStudent');
        });
    </script>
</head>
<body>
<div id="dt" style="padding:2px 5px;">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick=""></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
</div>
<table id="dg" title="显示学生数据" style="width:920px;height:400px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
    <thead>
    <tr>
        <th field="id" width="100" align="center">学生编号</th>
        <th field="name" width="100" align="center">姓名</th>
        <th field="sex" width="100" align="center">性别</th>
        <th field="grade" width="100" align="center">年级</th>
        <th field="parentsTel" width="200" align="center">电话</th>
    </tr>
    </thead>
</table>
</body>
</html>
