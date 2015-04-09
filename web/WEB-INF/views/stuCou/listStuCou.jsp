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
        /*td{*/
        /*text-align: center;*/
        /*}*/
    </style>
    <script>
        $.ajax({
            type:"post",
            url: "/stuCou/loadStuCou",
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
                    "<td>"+ p.stationAddress+"</td>"+
                    "<td>"+ p.studentName+"</td>"+
                    "<td>"+ p.courseName+"</td>"+
                    "<td>"+ p.costByOne+"</td>"+
                    "<td>"+ p.courseCount+"</td>"+
                    "<td>"+ p.costTotal+"</td>"+
                    "<td>"+ p.courseDate+"</td>"+
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
                    success: function(data){

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
        function preUpdate(id){
            alert("您要修改的是第"+id+"条数据");
        }

        function submitParam(){
            $.ajax({
                type: "POST",
                url: "/stuCou/findStuCou",
                data: "stationName="+$("#stationName").val(),
                success: function(msg){
                    alert( "Data Saved: " + msg );
                }
            });
        }
    </script>
</head>
<body>

<div style="position:relative;">
    <label class="module-title">学生上课信息管理</label>
    <input type="button" class="btn-blue" value="添加" style="position:absolute;top:0;right:0;" onclick="addcontent()">
</div>

<div>
    <form action="/stuCou/findStuCou" method="post">
        <table class="table" cellspacing="0">
            <tr>
                <td colspan="9">
                    <span>小站：</span>
                    <input  type="text" id="stationName" name="stationName" class="input-text" style="width: 100px">
                    <span>学生：</span>
                    <input type="text" name="studentName" class="input-text" style="width: 100px"/>
                    <span>课程：</span>
                    <select style="width: 100px" name="courseName">
                        <option>alj</option>
                        <option>ba</option>
                        <option>ba</option>
                        <option>ba</option>
                        <option>ba</option>
                    </select>
                    <span >年：</span>
                    <select style="width: 80px" name="year">
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
                    <select style="width: 101px" name="month">
                        <option>01</option><option>02</option><option>03</option><option>04</option>
                        <option>05</option><option>06</option><option>07</option><option>08</option>
                        <option>09</option><option>10</option><option>11</option><option>12</option>
                    </select>

                    <input type="submit"  class="btn-green" value="搜索" />
                </td>
            </tr>

            <tr>
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
</body>
</html>
