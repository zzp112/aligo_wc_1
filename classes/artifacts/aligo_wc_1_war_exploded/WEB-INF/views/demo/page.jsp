<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.paginate.js"/>" ></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/commonStyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/page.css"/>" />



    <title>page test</title>
<head>


    <script>
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

    </script>

</head>
<body>

<div>
    <label class="module-title">分页</label>
</div>
<br/>
    <div class="box"></div>

    <div class="page">
    </div>

<br/>

<div>
    <h3>使用方法</h3>
    <h4>引入jquery-1.8.2.js<br>jquery.paginate.js<br>page.css</h4><br>
    <h4>在相应的位置加入以下html代码<br/>
        &lt;div id="page"&gt;&lt;/div&gt;
    </h4><br>
    <h4>在head标签中中加入以下代码<br>
        <textarea name="" id="" cols="100" rows="25"style="font-size:14pt">
                <script>
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
                </script>
        </textarea>
    </h4>

</div>
</body>
<html>