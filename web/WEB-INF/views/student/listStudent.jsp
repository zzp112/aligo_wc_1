<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<!DOCTYPE html>

<html>
<head>
    <title>学生管理</title>

    <style type="text/css">
        table{text-align: right;}
        .module-title{font-size: 40px;}
    </style>
    <script type="text/javascript">
        $.ajax({
            type:"post",
            url: "/student/loadAllStudent",
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
                    "<td>"+ p.sex+"</td>"+
                    "<td>"+ p.grade+"</td>"+
                    "<td>"+ p.parentsTel+"</td>"+
                    "<td><span onclick='modifycontent("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStudentById("+p.id+")'>删</span></td>"+
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


        function deleteStudentById(id){
            if(confirm("您确定要删除第"+id+"条数据吗")){
                $.ajax({
                    type: "POST",
                    url: "/student/delStudentById",
                    data: "id="+id,
                    success: function(data){
                        findStudent();
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
        function findById(id){
            $.ajax({
                type: "POST",
                url: "/student/findStudentById",
                data: "id="+ id,
                success: function (data) {
                    var obj = eval("(" + data + ")");
//                    var mo = obj[0];


                    new $.Zebra_Dialog( {
                        source: {'inline': $('.modifyhtml').html()}, //内嵌html代码
                        width: 500, //宽度
                        max_height:300, //高度超出则可以显示滚动条
                        title:  '修改信息',
                        position:['left +200','top+20'],
                        overlay_opacity:'0',
                        buttons:[]

                    });
//                    var a = $("#nameKEY").val();
//                    alert(a);
//                    $("#nameKEY").val('1111');
//                    var b = $("#nameKEY").val();
//                    alert(b);
                }
            })
        }
        function modifycontent(id){
            findById(id);


        }
        function findStudent(){
                $.ajax({
                    type: "POST",
                    url: "/student/findStudentByNameAndGrade",
                    data: "name="+ $("#nameKEY").val() +"&grade="+ $("#gradeKEY").val(),
                    success: function (data) {
                        $('#letitsave').nextAll().remove();
                        var obj = eval("(" + data + ")");
                        var temp = obj[0];
                        var dataStr = "";
                        for (var i = 0; i < obj.length; i++) {
                            var p = obj[i];
                            var table = $('.table');
                            dataStr += "<tr>" +
                            "<td>" + p.id + "</td>" +
                            "<td>" + p.name + "</td>" +
                            "<td>" + p.sex + "</td>" +
                            "<td>" + p.grade + "</td>" +
                            "<td>" + p.parentsTel + "</td>" +
                            "<td><span onclick='modifycontent(" + p.id + ")'>修</span>&nbsp;&nbsp;<span onclick='deleteStudentById(" + p.id + ")'>删</span></td>" +
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
    <label class="module-title">学生信息管理</label>

</div>
<div>
    <table class="table" cellspacing="0">
        <tr>
            <td colspan="9">
                姓名搜索：
                <input  type="text" class="input-text" style="width: 104px" id="nameKEY" name="nameKEY">
                年级搜索：
                <input type="text" class="input-text" style="width: 104px" id="gradeKEY" name="gradeKEY"/>
                <input type="button" class="btn-green" value="搜索" onclick="findStudent()" />
                <input type="button" class="btn-blue" value="添加"  onclick="addcontent()">
            </td>
        </tr>

        <tr id="letitsave">
            <td style="width: 130px">编号</td>
            <td style="width: 130px">姓名</td>
            <td style="width: 130px">性别</td>
            <td style="width: 130px">年级</td>
            <td style="width: 130px">家长电话</td>
            <td style="width: 130px">操作</td>
        </tr>
    </table>
    <div class="page"></div>
</div>
<div class="addhtml" style="display: none">
    <form action="/student/addStudent" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" class="input-text" placeholder="请输入姓名" name="name"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td style="text-align: left">男：<input type="radio" name="sex" value="男" checked/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女：<input type="radio" name="sex" value="女"/></td>
            </tr>
            <tr>
                <td>年级:</td>
                <td><input type="text" class="input-text" placeholder="请输入年级" name="grade"/></td>
            </tr>
            <tr>
                <td>家长电话:</td>
                <td><input type="text" class="input-text" placeholder="请输入家长电话" name="parentsTel"/></td>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</div>
<div class="modifyhtml" style="display: none">
    <form action="/student/updateStudentById" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" id="nameEdit" name = "nameEdit"  class="input-text" value="text"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td style="text-align: left">男：<input type="radio" name="sex" checked/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;女：<input type="radio" name="sex"/></td>
            </tr>
            <tr>
                <td>年级:</td>
                <td><input type="text" class="input-text"  name="grade"/></td>
            </tr>
            <tr>
                <td>家长电话:</td>
                <td><input type="text" class="input-text"  name="parentsTel"/></td>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</div>
</body>
</html>
