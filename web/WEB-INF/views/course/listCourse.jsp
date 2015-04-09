<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>课程管理</title>


    <style type="text/css">
        table{text-align: center;}
        .module-title{font-size: 40px;}
    </style>

    <script>
        $.ajax({
            type:"post",
            url: "/course/loadAllCourse",
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
                    "<td>"+ p.name+"</td>"+
                    "<td>"+ p.cost+"</td>"+
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
                    url: "/course/delCourseById",
                    data: "id="+id,
                    success: function(data){
                        findCourseByName();
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
        function findCourseByName(){
                $.ajax({
                    type: "POST",
                    url: "/course/findCourseByName",
                    data: "name="+$("#nameKEY").val(),
                    success: function(data){
                        $('#letitsave').nextAll().remove();
                        var obj = eval("("+data+")");
                        var temp = obj[0];
                        var dataStr = "";
                        for(var i=0;i<obj.length;i++){
                            var p =obj[i];
                            var table = $('.table');
                            dataStr +="<tr>"+
                            "<td>"+ p.id+"</td>"+
                            "<td>"+ p.name+"</td>"+
                            "<td>"+ p.cost+"</td>"+
                            "<td><span onclick='modifycontent("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                            "</tr>";
                        }
                        table.append(dataStr);
                    }
                });
        }

    </script>
</head>
<body>
<div style="position:relative;">
    <label class="module-title">课程信息管理</label>

</div>
<div>

    <table class="table" cellspacing="0">
        <tr>
            <td colspan="9">
                课程搜索：
                <input type="text" id="nameKEY" name="nameKEY"/>
                <input type="button" class="btn-green" value="搜索" onclick="findCourseByName()"/>
                <input type="button" class="btn-blue" value="添加" onclick="addcontent()">
            </td>
        </tr>

        <tr id="letitsave">
            <td style="width: 180px">编号</td>
            <td style="width: 230px">课程名称</td>
            <td style="width: 230px">课程花费</td>
            <td>操作</td>
        </tr>

    </table>
    <div class="page"></div>
</div>
<div class="addhtml" style="display: none">
    <table>
        <tr>
            <td>课程名称:</td>
            <td>
                <select style="width: 180px" class="coursechoose"></select>
            </td>
        </tr>
        <tr>
            <td>课程费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入单节费用"/></td>
        </tr>
    </table>
</div>
<div class="modifyhtml" style="display: none">
    <table>
        <tr>
            <td>课程名称:</td>
            <td>
                <select style="width: 180px" class="coursechoose"></select>
            </td>
        </tr>
        <tr>
            <td>课程费用:</td>
            <td><input type="text" class="input-text" placeholder="请输入单节费用"/></td>
        </tr>
    </table>

</div>
</body>
</html>
