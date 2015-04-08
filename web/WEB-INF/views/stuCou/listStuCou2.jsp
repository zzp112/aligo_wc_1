<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>课程管理</title>
    <script type="text/javascript">
        $(function () {
            loadDataFromJson('dg','/stuCou/loadStuCou');
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
<table id="dg" title="显示课程数据" style="width:920px;height:400px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
    <thead>
    <tr>
        <th field="id" width="100" align="center">上课记录编号</th>
        <th field="address" width="200" align="center">小站位置</th>
        <%--<th field="courseId" width="100" align="center">课程编号</th>--%>
        <th field="courseName" width="100" align="center">课程名</th>
        <th field="courseCount" width="100" align="center">上课总数</th>
        <th field="costByOne" width="100" align="center">单节课费用</th>
        <th field="costTotal" width="100" align="center">总费用</th>
        <th field="courseDate" width="100" align="center">上课日期</th>
    </tr>
    </thead>
</table>
</body>
</html>
