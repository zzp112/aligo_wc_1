<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>

<html>
<head>
    <title>
        学生信息录入...
    </title>

    <script type="text/javascript">
        //绑定指定的table加载数据并实现分页的功能
        $(function () {
            loadDataFromJson('dg','findAllStudent');
        });

        //获取选中的行的数据
        function getStudent() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                alert('姓名:' + row.student_name);
            }
        }
    </script>
</head>
<body>
<div id="dt" style="padding:2px 5px;">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="getStudent()">查看选中的数据</a>
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
        <th field="student_name" width="80">姓名</th>
        <th field="student_sex" width="100">性别</th>
        <th field="course_name" width="80">课程</th>
        <th field="teacher_name" width="180" align="right">教师</th>
        <th field="telephone" width="80" align="right">电话</th>
    </tr>
    </thead>
</table>
</body>
</html>
