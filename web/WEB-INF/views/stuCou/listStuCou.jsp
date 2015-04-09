<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>学生课程信息</title>

    <style type="text/css">
        table{text-align: center;}
        .module-title{font-size: 40px;}
    </style>
    <script>
        //加载课程信息用于下拉框显示
        var courseList="";
        $.ajax({
            type: "POST",
            url: "/course/loadAllCourse",
            success: function(data){
                var obj = eval("("+data+")");
                for(var i=0;i<obj.length;i++){
                    var p =obj[i];
                    courseList+="<option value='"+ p.id+"'>"+p.name+"</option>"

                }
                $("#courseNameSearch").append(courseList);
            }
        });


        //加载页面默认显示的学生上课信息
        $.ajax({
            type:"post",
            url: "/stuCou/loadStuCou",
            dataType:"json",
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
                    "<td>"+ p.stationAddress+"</td>"+
                    "<td>"+ p.studentName+"</td>"+
                    "<td>"+ p.courseName+"</td>"+
                    "<td>"+ p.costByOne+"</td>"+
                    "<td>"+ p.courseCount+"</td>"+
                    "<td>"+ p.costTotal+"</td>"+
                    "<td>"+ p.courseDate+"</td>"+
                    "<td><span onclick='toUpdateStuCou(" + p.id + ")'>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                    "</tr>";
                }
                table.append(dataStr);

            }
        });
        //分页条显示
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


        //删除学生上课信息
        function deleteStuCou(id){
            if(confirm("您确定要删除第"+id+"条数据吗")){
                $.ajax({
                    type: "POST",
                    url: "/stuCou/deleteStuCou",
                    data: "id="+id,
                    success: function(msg){
                        submitParam();
                    }
                });
            }
        }

        function addStuCou(){
            alert("addTest");
            alert("小站编号"+$("#stationIdAdd").val()+":"+"学生编号"+$("#studentIdAdd").val()+":"+"课程编号"+$("#courseListAdd").val()+":"+"课程总数"+$("#courseCountAdd").val()+":"+$("#dateAdd").val());
        }
        //显示添加学生上课信息dialog
        function addcontent(){
            $("#courseListAdd").append(courseList);
            new $.Zebra_Dialog( {
                source: {'inline': $('.addhtml').html()}, //内嵌html代码
                width: 500, //宽度
                max_height:300, //高度超出则可以显示滚动条
                title:  '增加信息',
                position:['left +200','top+20'],
                overlay_opacity:'0',
                buttons:['确定','取消'],
                'onClose':  function(caption) {
                    if (caption == "确定"){
                        addStuCou();

//                        $.ajax({
//                            type: "POST",
//                            url: "/stuCou/addStuCou",
//                            data: "stationId="+$("#stationIdAdd").val()+"&studentId="+$("#studentIdAdd").val()+"&courseId="+$("#courseListAdd").val()+"&courseCount="+$("#courseCountAdd").val()+"&courseDate="+$("#dateAdd").val(),
//                            success: function(msg){
//                                submitParam();
//                            }
//                        });
                    }
                    if (caption == "取消"){

                    }
                }
            });
        }

        //修改学生上课信息
        //@Param id 学生上课记录id
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

        //修改前先根据id获取上课记录并填充
        function toUpdateStuCou(id){
            location.href="/stuCou/toUpdateStuCou?id="+id;
        }

        //根据条件查询学生上课信息
        function submitParam(){
//            $("#paramForm").submit();
            $.ajax({
                type: "POST",
                url: "/stuCou/findStuCou",
                data: "stationId="+$("#stationId").val()+"&studentId="+$("#studentId").val()+"&courseName="+$("#courseName").val()+"&year="+$("#year").val()+"&month="+$("#month").val(),
                success: function(data){
                    var obj = eval("("+data+")");
                    var temp = obj[0];
                    $("#headTr").nextAll().remove();
                    var dataStr = "";
                    if(obj.length==0){
                        var table = $('.table');
                        dataStr+="<tr><td colspan='9' style='text-align: center'>没有符合条件的记录</td></tr>"
                        table.append(dataStr);
                    }else{
                        for(var i=0;i<obj.length;i++){
                            var p =obj[i];
                            var table = $('.table');
                            dataStr +="<tr>"+
                            "<td>"+ p.id+"</td>"+
                            "<td>"+ p.stationAddress+"</td>"+
                            "<td>"+ p.studentName+"</td>"+
                            "<td>"+ p.courseName+"</td>"+
                            "<td>"+ p.costByOne+"</td>"+
                            "<td>"+ p.courseCount+"</td>"+
                            "<td>"+ p.costTotal+"</td>"+
                            "<td>"+ p.courseDate+"</td>"+
                            "<td><span onclick='toUpdateStuCou(" + p.id + ")>修</span>&nbsp;&nbsp;<span onclick='deleteStuCou("+p.id+")'>删</span></td>"+
                            "</tr>";
                        }
                        table.append(dataStr);
                    }
                }
            });
        }
    </script>
</head>
<body>

<div style="position:relative;">
    <label class="module-title">学生上课信息管理</label>
    <input type="button" class="btn-blue" value="添加" style="position:absolute;top:0;right:0;" onclick="addcontent()">
    <input type="button" class="btn-green" value="搜索" style="position:absolute;top:45px;right:0;" onclick="submitParam()"/>
</div>

<div>
    <form action="/stuCou/findStuCou" id="paramForm" method="post">
        <table class="table" cellspacing="0">
            <tr>
                <td colspan="9">
                    <span>小站ID：</span>
                    <input type="text" name="stationName" id="stationId" class="input-text" style="width: 100px">
                    <span>学生ID：</span>
                    <input type="text" name="studentId" id="studentId" class="input-text" style="width: 100px"/>
                    <span>课程：</span>
                    <select style="width: 100px" name="courseName" id="courseNameSearch">
                    </select>
                    <span >年：</span>
                    <select style="width: 80px" name="year" id="year">
                        <option>2015</option>
                        <option>2014</option>
                        <option>2013</option>
                        <option>2012</option>
                        <option>2011</option>
                        <option>2010</option>
                        <option>2009</option>
                        <option>2008</option>
                    </select>
                    <span>月：</span>
                    <select style="width: 101px" name="month" id="month">
                        <option>01</option><option>02</option><option>03</option><option>04</option>
                        <option>05</option><option>06</option><option>07</option><option>08</option>
                        <option>09</option><option>10</option><option>11</option><option>12</option>
                    </select>

                </td>
            </tr>

            <tr id="headTr">
                <td style="width: 40px">编号</td>
                <td style="width: 130px">小站地址</td>
                <td style="width: 130px">学生名字</td>
                <td style="width: 130px">课程名称</td>
                <td style="width: 80px">单节费用</td>
                <td style="width: 80px">总上课数</td>
                <td style="width: 80px">总费用</td>
                <td style="width: 130px">上课日期</td>
                <td>操作</td>
            </tr>
        </table>
    </form>

    <div class="page"></div>
</div>
<div class="addhtml" style="display: none">
        <jsp:include page="/stuCou/inputStuCou"/>
</div>
<div class="modifyhtml" style="display: none">
        <%--<jsp:include page="/stuCou/toUpdateStuCou"/>--%>
</div>
</body>
</html>
