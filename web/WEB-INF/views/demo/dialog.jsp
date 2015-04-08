<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8"/>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/zebra_dialog.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/zebra_dialog.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">

    <script>
        //错误提示框
        function error(){
            $.Zebra_Dialog(
            '这是错误提示窗口',
            {
                'type':     'error',
                'title':    '错误',
                position:['left +20','top+20'],
                overlay_opacity:'0'
            });
        }
        //内嵌HTML代码的对话框，使用场景：点击修改按钮，弹出该对话框修改一条记录
        function content(){
            new $.Zebra_Dialog( {
                source: {'inline': $('.myhtml').html()}, //内嵌html代码
                width: 800, //宽度
                max_height:400, //高度超出则可以显示滚动条
                title:  '信息修改的框',
                position:['left +20','top+20'],
                overlay_opacity:'0'
            });
        }
        //该对话框一般用来提示用户是否确认进行操作等，即confirm
        function customDialog(){
            $.Zebra_Dialog('这是普通的对话框，可以定制按钮', {
                'type':     'question',
                'title':    'Custom buttons',
                'buttons':  ['Yes', 'No', 'Help'],
                'position':['left +20','top+20'],
                overlay_opacity:'0',
                'onClose':  function(caption) {
                    if(caption =="")
                        alert("你没有点击按钮");
                    if(caption=="Yes")
                        alert("你点击了YES");
                    if(caption=="No")
                        alert("你点击了No");
                    if(caption=="Help")
                        alert("你点击了Help");
                }
            });
        }


    </script>
</head>
<body>

    <div>
        <label class="module-title">点击按钮弹出对话框</label>
    </div>
    <br/>

    <button onclick="error();" class="btn-green">Error</button>
    <br><br>
    <button onclick="customDialog();"class="btn-green">custom dialog</button>
    <br><br>
    <button onclick="content();"class="btn-green">可以用来做信息修改</button>

    <div>
        <br/>

        <h3>使用方法</h3>
        <h4>引入jquery-1.8.2.js。。zebra_dialog.css 和 zebra_dialog.js<br/>
            下面贴出源代码，所有使用方法均有注释<br>


            <textarea name="" id="" cols="100" rows="50"style="font-size:14pt">
                   <script>
                       //错误提示框
                       function error(){
                           $.Zebra_Dialog(
                                   '这是错误提示窗口',
                                   {
                                       'type':     'error',
                                       'title':    '错误'
                                   });
                       }
                       //内嵌HTML代码的对话框，使用场景：点击修改按钮，弹出该对话框修改一条记录
                       function content(){
                           new $.Zebra_Dialog( {
                               source: {'inline': $('.myhtml').html()}, //内嵌html代码
                               width: 800, //宽度
                               max_height:400, //高度超出则可以显示滚动条
                               title:  '信息修改的框'
                           });
                       }
                       //该对话框一般用来提示用户是否确认进行操作等，即confirm
                       function customDialog(){
                           $.Zebra_Dialog('这是普通的对话框，可以定制按钮', {
                               'type':     'question',
                               'title':    'Custom buttons',
                               'buttons':  ['Yes', 'No', 'Help'],
                               'onClose':  function(caption) {
                                   if(caption =="")
                                       alert("你没有点击按钮");
                                   if(caption=="Yes")
                                       alert("你点击了YES");
                                   if(caption=="No")
                                       alert("你点击了No");
                                   if(caption=="Help")
                                       alert("你点击了Help");
                               }
                           });
                       }


                   </script>

                    <div class="myhtml">
                        这里是要内嵌的html
                    </div>
            </textarea>
        </h4>
    </div>

    <div class="myhtml" style="display: none">
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <h2>可以在这个对话框里做信息的修改等</h2>
        <input type="text" class="input-text" placeholder="输入框"/>
        <button>按钮</button>
    </div>
</body>
</html>