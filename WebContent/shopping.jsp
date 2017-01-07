<%@page import="vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>网上订餐系统——我的购物车</title>
        <link type="text/css" href="css/public.css" rel="stylesheet"/>
        <style>
            #body h2{
                width: 100%;
                text-align: center;
                border-bottom: 1px dashed gainsboro;
                padding-top: 15px;
                padding-bottom: 15px;
            }
            #body .table{
                width: 80%;
                margin: 0 auto;
                text-align: center;
                margin-top: 30px;
            }
            #body .table .td{
                font-weight: bolder;
                width: 133px;
                height: 60px;
                line-height: 60px;
            }
            #body .table .td1{
                font-size: 15px;
            }
            #body .table .td1 a{
                text-decoration: none;
                color: #104E8B;
            }

            #body .span{
                width: 20%;
                float: left;
                margin: 0 auto;
                text-align: center;
                margin-top: 50px;
                font-weight: bolder;
                margin-bottom: 20px;
            }
            #body #span{
                margin-left: 370px;
            }

            #body .button{
                width: 20%;
                margin: 0 auto;
                margin-bottom: 150px;
            }
            #body .button input[type="submit"]{
                width: 200px;
                height: 40px;
                border: none;
                background-color: orangered;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
    	<jsp:useBean id="user" class="vo.Person" scope="session"></jsp:useBean>    	
    	<jsp:useBean id="ordersBean" class="vo.Orders" scope="page"></jsp:useBean>
    	<jsp:setProperty property="user" name="ordersBean" value="${user}"/>
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
            <h2>您的购物车列表信息：</h2>
            <table class="table">
                <tr class="tr">
                    <td class="td"><span class="text">编号</span></td>
                    <td class="td"><span class="text">菜名</span></td>
                    <td class="td"><span class="text">数量</span></td>
                    <td class="td"><span class="text">单价</span></td>
                    <td class="td"><span class="text">总价</span></td>
                    <td class="td"><span class="text">备注</span></td>
                    <td class="td"><span class="text">操作</span></td>
                </tr>
                <jsp:getProperty property="showBuyList" name="ordersBean"/>
            </table>
            <div class="span" id="span"><span class="num">总数量：</span><span><jsp:getProperty property="total" name="ordersBean"/></span></div>
            <div class="span"><span>总价：</span><span class="pri"><jsp:getProperty property="totalPrice" name="ordersBean"/></span></div>
            <div class="button">
            	<form action="OrdersPayServlet" method="post">
	            	<input type="submit" value="结算"/>
            	</form>
            </div>
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
    </body>
</html>