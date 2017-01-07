<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>订单查询</title>
        <link href="css/public.css" rel="stylesheet" type="text/css"/>
        <style>
            #body{
                margin-bottom: 500px;
            }
            #body #body_left{
                width: 20%;
                float: left;
                margin-top: 20px;
                background-color: gainsboro;
                padding-top: 40px;
                padding-bottom: 40px;
            }
            #body_left table{
                width: 80%;
                margin: 0 auto;
            }
            #body #body_left table tr{
                width: 80%;
                height: 40px;
                background-color: aliceblue;
            }
            #body #body_left table .title{
                text-align: left;
                padding-left: 5px;
                /*margin-top: 15px;*/
            }
            #body #body_left table a{
                text-decoration: none;
                color: black;
            }
            #body #body_left table .content{
                text-align: center;
                font-size: 13px;
                /*font-family: "微软雅黑";*/
            }

            #body #body_right{
                width: 78%;
                float: right;
                margin-top: 20px;
            }
            #body #body_right #iframe{
                width: 100%;
                height: 460px;
                /*border-style: none;*/
            }
        </style>
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
            <div id="body_left">
                <table>
                    <tr><th class="title">我的订单</th></tr>
                    <tr><td class="content"><a href="no_pay.jsp" target="frame">未消费</a></td></tr>
                    <tr><td class="content"><a href="pay.jsp" target="frame">已消费</a></td></tr>
                </table>
            </div>
            <div id="body_right">
                <iframe name="frame" id="iframe" src="no_pay.jsp"></iframe>
            </div>
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
    </body>
</html>