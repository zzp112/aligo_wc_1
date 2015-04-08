<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小站管理</title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/zebra_dialog.js"/>"></script>
    <script language="javascript" type="text/javascript" src="/resources/js/My97DatePicker/WdatePicker.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/zebra_dialog.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />
    <style type="text/css">
        table{text-align: center;}
        .module-title{font-size: 40px;}
    </style>
    <script type="text/javascript">
        $.ajax({
            type:"post",
            url: "/station/loadAllStation",
            dataType:"json",
//        jsonp: "jsoncallback",
//        jsonpCallback:"jsonpCallback",
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
            },

            success: function(data) {
                var obj = eval("("+data+")");
                var temp = obj[0];
                var dataStr = "";
                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    var table = $('.table');
                    dataStr +="<tr>"+
                    "<td>"+ p.id+"</td>"+
                    "<td>"+ p.address+"</td>"+
                    "<td>"+ p.managerId+"</td>"+
                    "<td>"+ p.accountRatio+"</td>"+
                    "<td>"+ p.totalAmount+"</td>"+
                    "<td>"+ p.actualAmountString+"</td>"+
                    "<td><span onclick='modifycontent("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                    "</tr>";
                }
                table.append(dataStr);
            }
        });
        $(function() {
            $(".page").paginate({
                count 		: 40, //一共多少页
                start 		: 1, //默认从第几页开始
                display     : 12, //显示多少页码
                border					: false,
                text_color  			: '#0E90D2',
                background_color    	: 'none',
                text_hover_color  		: 'red',
                background_hover_color	: 'none',
                images		: false,
                mouse		: 'press',
                onChange:function(pageno){ //pageno参数是你点击的页号
                    $(".box").text("你点击了第"+pageno+"页");
                }
            });

        });


        function deleteStuCou(id){
            if(confirm("您确定要删除第"+id+"条数据吗")){
                $.ajax({
                    type: "POST",
                    url: "some.php",
                    data: "name=John&location=Boston",
                    success: function(msg){
                        alert( "Data Saved: " + msg );
                    }
                });
            }
        }


        function addcontent(){
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
        function modifycontent(id){
            new $.Zebra_Dialog( {
                source: {'inline': $('.modifyhtml').html()}, //内嵌html代码
                width: 500, //宽度
                max_height:300, //高度超出则可以显示滚动条
                title:  '修改信息',
                position:['left +200','top+20'],
                overlay_opacity:'0',
                buttons:
                        [{caption:'保存',callback:function(){confirm('是否保存')}},'取消']

            });

        }
    </script>
</head>
<body>

<div style="position:relative;">
    <label class="module-title">小站信息管理</label>
    <input type="button" class="btn-blue" value="添加" style="position:absolute;top:0;right:0;" onclick="addcontent()">
</div>
<div>
    <table class="table" cellspacing="0">
        <tr>
            <td colspan="9">
                小站搜索：
                <input  type="text" class="input-text" style="width: 185.7px">
                管理编号搜索：
                <input type="text" class="input-text" style="width: 185.7px"/>
                拆账比例：
                <input type="text" class="input-text" style="width: 185.6px"/>

                <input type="button" class="btn-green" value="搜索" />
            </td>
        </tr>

        <tr>
            <td style="width: 40px">编号</td>
            <td style="width: 130px">小站地址</td>
            <td style="width: 130px">管理编号</td>
            <td style="width: 130px">拆账比例</td>
            <td style="width: 80px">总支出</td>
            <td style="width: 80px">实际支出</td>
            <td>操作</td>
        </tr>
    </table>
    <div class="page"></div>
</div>
<div class="addhtml" style="display: none">
    <table>
        <tr>
            <td>小站地址:</td>
            <td><input type="text" class="input-text" placeholder="请输入小站地址"/></td>
        </tr>
        <tr>
            <td>管理编号:</td>
            <td><input type="text" class="input-text" placeholder="请输入学生名字"/></td>
        </tr>
        <tr>
            <td>拆账比例:</td>
            <td>
                <select style="width: 180px">
                    <option>=====================</option>
                    <option>在线英语</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>单节费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入单节费用"/></td>
        </tr>
        <tr>
            <td>总上课数:</td>
            <td><input type="text" class="input-text" placeholder="请输入总上课数"/></td>
        </tr>
        <tr>
            <td>总费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入课程名称"/></td>
        </tr>
        <tr>
            <td>上课日期:</td>
            <td><input class="Wdate" onclick="WdatePicker()"></td>
        </tr>
    </table>
</div>
<div class="modifyhtml" style="display: none">
    <table>
        <tr>
            <td>小站地址:</td>
            <td><input type="text" class="input-text" placeholder="请输入小站地址"/></td>
        </tr>
        <tr>
            <td>学生名字:</td>
            <td><input type="text" class="input-text" placeholder="请输入学生名字"/></td>
        </tr>
        <tr>
            <td>课程名称:</td>
            <td>
                <select style="width: 180px">
                    <option>=====================</option>
                    <option>在线英语</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>单节费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入单节费用"/></td>
        </tr>
        <tr>
            <td>总上课数:</td>
            <td><input type="text" class="input-text" placeholder="请输入总上课数"/></td>
        </tr>
        <tr>
            <td>总费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入课程名称"/></td>
        </tr>
        <tr>
            <td>上课日期:</td>
            <td></td>
        </tr>
    </table>

</div>
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
