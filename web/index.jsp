<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>index</title>
    <script>
        $(function(){
            window.open('/common/welcome','mainFrame');
        })
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:80px;padding:10px">header</div>

    <div data-options="region:'west',split:true,title:'点击收缩'" style="width:200px;padding:10px;">
        <jsp:include page="WEB-INF/views/common/left.jsp"></jsp:include>
    </div>

    <div data-options="region:'south',border:false" style="height:50px;padding:10px;">footer</div>

    <div data-options="region:'east',split:true,collapsed:true,title:'点击收缩'" style="width:100px;padding:10px;">east region</div>
    <div data-options="region:'center',title:'资金收入支出'">
        <iframe height="98%" id="mainFrame" name="mainFrame" width="99%" scrolling="no" >

        </iframe>
    </div>

</body>
</html>