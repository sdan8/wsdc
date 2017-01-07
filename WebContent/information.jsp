<%@page import="vo.Menu"%>
<%@page import="factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>详细信息</title>
        <link type="text/css" href="css/public.css" rel="stylesheet"/>
        <style>
            #body h2{
                width: 100%;
                /*background-color: gainsboro;*/
                text-align: center;
                border-bottom: 1px dashed gainsboro;
                /*margin-bottom: 5px;*/
                padding-top: 15px;
                padding-bottom: 15px;
            }
            #body .left{
                width: 45%;
                float: left;
                text-align: center;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            #body .img{
                width: 400px;
                /*float: left;*/
                /*text-align: center;*/
            }
            #body .form{
                margin-top: 50px;
            }
            #body .table .text{
                width: 120px;
                height: 40px;
                text-align: center;
                line-height: 40px;
                font-family: "微软雅黑";
            }
            #body .table .td input[type="text"]{
                width: 80px;
            }
            #body .table .td textarea{
                width: 200px;
            }
            #body .form input[type="submit"]{
                width: 100px;
                height: 30px;
                margin: 20px;
                border: none;
                background: #ff4500;
            }
            .rate{
                background-color: gray;
                font-size: 23px;
                clear: both;
                padding-left: 10px;
                font-family: "微软雅黑";
            }
            #body .ul{
                list-style: none;
            }
            #body .ul .li{
                width: 90%;
                height: 100px;
                margin: 0 auto;
                background-color: gainsboro;
                margin-top: 20px;
                margin-bottom: 20px;
                /*font-family: "微软雅黑";*/
            }
            .ul .li .text{
                width: 50%;
                height: 30px;
                /*background-color: aliceblue;*/
                line-height: 30px;
                padding-left: 10px;
                float: left;
                font-size: 20px;
                font-family: "微软雅黑";
            }
            .ul .li .text1{
                width: 49.1%;
                height: 30px;
                /*background-color: aliceblue;*/
                line-height: 30px;
                /*padding-right: 10px;*/
                float: right;
                text-align: right;
            }
            .ul .li .text2{
                clear: both;
                width: 80%;
                margin: 0 auto;
                background-color: ;
            }
        </style>
    </head>
    <body>
    	<jsp:useBean id="messageBean" scope="page" class="vo.Message"></jsp:useBean>
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

		<%
			//获取菜品信息
			Menu menu = DAOFactory.getMenuDAOInstance().searchById(Integer.parseInt(request.getParameter("id")));
		%>
        <div id="body">
            <h2><%=menu.getMenu_name() %> 详细信息 欢迎选购</h2>
            <div class="left"><img src="images/<%=menu.getMenu_image()%>.jpg" class="img"/></div>
            <form class="form" action="OrderAddServlet" method="post" onsubmit="return validateForm()">
            	<input type="hidden" name="id" value="<%=menu.getMenu_id() %>">
                <table class="table">
                    <tr class="tr">
                        <td class="text">单价：</td>
                        <td class="td"><%=menu.getMenu_price()%>元</td>
                    </tr>
                    <tr class="tr">
                        <td class="text">菜肴简介：</td>
                        <td class="td"><%=menu.getMenu_content()%></td>
                    </tr>
                    <tr class="tr">
                        <td class="text">付款方式：</td>
                        <td class="td">先送货再付款</td>
                    </tr>
                    <tr class="tr">
                        <td class="text">选择口味：</td>
                        <td class="td">
                            <input type="radio" name="notice" value="清淡" checked="checked"/><span>清淡</span>
                            <input type="radio" name="notice" value="微辣"/><span>微辣</span>
                            <input type="radio" name="notice" value="中辣"/><span>中辣</span>
                            <input type="radio" name="notice" value="特辣"/><span>特辣</span>
                            <input type="radio" name="notice" value="重口味"/><span>重口味</span>
                        </td>
                    </tr>
                    <tr class="tr">
                        <td class="text">选购数量：</td>
                        <td class="td">
                            <input type="text" name="number" value="1" id="num"/><span>份</span>
                        </td>
                    </tr>
                    <tr class="tr">
                        <td class="text">其他要求：</td>
                        <td class="td">
                            <textarea name="otherNotice" id="noticeTextarea"></textarea>
                        </td>
                    </tr>
                </table>
                <c:choose>
                	<c:when test="${user.user_name!=null}">
	            		<input type="submit" value="加入购物车" name="提交"/>
	                	</c:when>
	                	<c:otherwise>
	                    	<a href="register.jsp"><span>【登录】</span></a>
	                	</c:otherwise>
                </c:choose>
            </form>
            <%-- <div class="rate">用户评价</div>
            <ul class="ul">
            	<jsp:getProperty property="showMessageList" name="messageBean"/>
            </ul> --%>
        </div>
        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
        <script type="text/javascript">
        	function validateForm(){
        		var num = document.getElementById('num').value;
        		if (num <= 0){
        			alert("请正确填写数量！");
        			return false;
        		}
        	}
        </script>
    </body>
</html>