<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/sourcelib.jsp" %>
<html>
<head>
    <title>小站管理</title>

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
                    "<td><span onclick='modifycontent("+p.id+")'>修</span>&nbsp;&nbsp;<span onclick='deleteStation("+p.id+")'>删</span></td>"+
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


        function deleteStation(id){
            if(confirm("您确定要删除第"+id+"条数据吗")){
                $.ajax({
                    type: "POST",
                    url: "/station/delStationById",
                    data: "id="+id,
                    success: function(data){
                        location.reload();
                    }
                });
            }
        }


        function addcontent(){
            new $.Zebra_Dialog({

                source: {'inline': $('.addhtml').html()}, //内嵌html代码
                type:'question',
                width: 500, //宽度
                max_height: 300, //高度超出则可以显示滚动条
                title: '增加信息',
                position: ['left +200', 'top+20'],
                overlay_opacity: '0',
                buttons: ['']
            })
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
    <form action="/student/findStudentByName" method="post">
    <table class="table" cellspacing="0">
        <tr id="letitsave">
            <td style="width: 130px">编号</td>
            <td style="width: 130px">小站地址</td>
            <td style="width: 130px">管理编号</td>
            <td style="width: 130px">拆账比例</td>
            <td style="width: 130px">总支出</td>
            <td style="width: 130px">实际支出</td>
            <td>操作</td>
        </tr>
    </table>
    </form>
    <div class="page"></div>
</div>
<div class="addhtml" style="display: none">
    <form action="/station/addStation" method="post" >
        <table>
            <tr>
                <td>小站地址:</td>
                <td><input type="text" class="input-text" placeholder="请输入小站地址" id="addaddress" name="address"/></td>
            </tr>
            <tr>
                <td>管理编号:</td>
                <td><input type="text" class="input-text" placeholder="请输入管理编号" id="addmanagerId" name="managerId"/></td>
            </tr>
            <tr>
                <td>拆账比例:</td>
                <td><input type="text" class="input-text" placeholder="请输入拆账比例" id="addaccountRatio" name="accountRatio"/></td>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green"  value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</div>
<div class="modifyhtml" style="display: none">
    <form action="/station/updateStationById" method="post" >
        <table>
            <tr>
                <td>小站地址:</td>
                <td><input type="text" class="input-text" placeholder="请输入小站地址" id="updaaddress" name="address"/></td>
            </tr>
            <tr>
                <td>管理编号:</td>
                <td><input type="text" class="input-text" placeholder="请输入管理编号" id="updamanagerId" name="managerId"/></td>
            </tr>
            <tr>
                <td>拆账比例:</td>
                <td><input type="text" class="input-text" placeholder="请输入拆账比例" id="updaaccountRatio" name="accountRatio"/></td>
            </tr>
            <tr>
                <td>总支出:</td>
                <td><input type="text" class="input-text" placeholder="请输入总支出" id="updatotalAmount" name="totalAmount"/></td>
            </tr>
            <tr>
                <td>实际支出:</td>
                <td><input type="text" class="input-text" placeholder="请输入学生名字"/></td>
                <%--<td><input type="text" class="input-text" value=$('#accountRatio').val()*$('$totalAmount').val()/></td>--%>
            </tr>
        </table>
        <div style="text-align:center;padding:5px">
            <input type="submit" class="btn-green" value="提交" style="width:63px;height: 33px;">
            &nbsp;&nbsp;&nbsp;<input type="reset" class="btn-green" value="重置" style="width:63px;height: 33px;">
        </div>
    </form>
</div>

</body>
</html>
