<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>关于我们</title>
        <link type="text/css" href="css/public.css" rel="stylesheet"/>
        <link type="text/css" href="css/about.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="head">
            <!-- logo-->
            <div id="head_left">
                <a href="index.jsp"><img src="images/2.png"/></a>
            </div>
            <div id="head_top">
                <c:choose>
                	<c:when test="${user.user_name!=null}">
                		<a href="UserExitServlet"><span>【退出】</span></a>
                		<span>欢迎您：<c:out value="${user.user_name}"></c:out></span>
                	</c:when>
                	<c:otherwise>
                		<a href="register.jsp"><span>【注册】</span></a>
                    	<a href="register.jsp"><span>【登录】</span></a>
                	</c:otherwise>
               	</c:choose>
            </div>
            <!-- nav-->
            <div id="head_right">
                <ul>
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="shopping.jsp">我的购物车</a></li>
                    <li><a href="MemberServlet">会员管理中心</a></li>
                    <li><a href="order_search.jsp">订单查询</a></li>
                    <li><a href="about.jsp">关于我们</a></li>
                </ul>
            </div>
        </div>

        <div id="body">
            <h2>关于我们：</h2>
            
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
    </body>
</html>