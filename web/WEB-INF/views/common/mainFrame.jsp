<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>Aligo</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.js"/>"></script>
    <script src="<c:url value="/resources/js/iframe.js"/>" type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function(){
		$(".div2").click(function(){
			$(this).next("div").slideToggle("slow")
			.siblings(".div3:visible").slideUp("slow");
		});
	});

//        $("#ifm").load(function(){
//            var mainheight = $(this).contents().find("body").height()+30;
//            $(this).height(mainheight);
//        });


    </script>
</head>
<body>



    <!-- 顶部 -->
	<div class="header">
		<h4 class="logo fl">学立方管理系统</h4>
		<a href="#" class="fr header-item">
			<img src="<c:url value="/resources/img/user.jpg"/>">
			个人中心
		</a>
		<div class="fr header-item">
			<label>您好，xxx</label>
		</div>
	</div>
	<div>
        <!-- 左侧导航 -->
		<div class="nav fl">
			<ul>
                <!-- 一级菜单 -->
				<li>
                    <a href="<c:url value="/WEB-INF/views/demo/attention.jsp"/>" target="frame">
                        <div class="div2" >注意，请注意</div>
                    </a>
				</li><!-- 一级菜单结束 -->

                <!-- 一级菜单 -->
                <li>
                    <a href="<c:url value="/WEB-INF/views/error.jsp"/>" target="frame">
                        <div class="div2" >错误网页</div>
                    </a>
                </li><!-- 一级菜单结束 -->

                <!-- 多级菜单 -->
				<li>
					<div class="div2">样例网页
						<label class="fr">></label>
					</div>
					<div class="div3">
				      <ul>
                          <li><a href="/station/listStation" target="frame">小站管理</a></li>
                          <li><a href="/student/listStudent" target="frame">学生管理</a></li>
                          <li><a href="/course/listCourse" target="frame">课程管理</a></li>
                          <li><a href="/toListPaymentDetails" target="frame">小站收支明细</a></li>
                          <li><a href="/stuCou/listStuCou" target="frame">小站营运明细</a></li>
				      </ul>
			   		</div>
				</li><!-- 多级菜单结束 -->
				
			</ul>
		</div>


        <!-- 内嵌网页 -->
        <iframe src="<c:url value="/WEB-INF/views/demo/attention.jsp"/>" frameborder="0" scrolling="no" name="frame"
                id="ifm" name="ifm" onload="javascript:dyniframesize('ifm');IFrameReSizeWidth('ifm');" style="border: 1px solid;width:1050px;height: 540px" >
        </iframe>
	</div>
</body>
</html>