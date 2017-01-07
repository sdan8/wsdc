<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>找回密码</title>
        <link rel="stylesheet" href="css/public.css" type="text/css"/>
        <style>
            #body {
                width: 75%;
                height: 300px;
                margin: 0 auto;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            #body h2{
                text-align: center;
            }
            #body .psw{
                margin: 0 auto;
                width: 404px;
                height: 366px;
            }
            #body .psw form{
                margin: 0 auto;
                margin-top: 20px;
                display: inline-block;
            }
            #body .psw .div{
                margin-top: 5px;
            }
            #body .psw .name {
                display: inline-block;
                width: 100px;
                font-size: 15px;
                font-weight: bolder;
                text-align: center;
            }
            #body .psw  input[type="password"]{
                width: 300px;
                height: 40px;
            }
            #body .psw  input[type="email"]{
                width: 300px;
                height: 40px;
            }
            #body  input[type="submit"]{
                width: 100px;
                height: 30px;
                margin-top: 30px;
                margin-left: 100px;
            }
			#body .psw  input[type="text"]{
                width: 300px;
                height: 40px;
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
            <h2>找回密码</h2>
            <div class="psw">
                <form method="post" action="UserUpdateServlet?info=findpsw" name="form" onsubmit="return validatePsw()">
                	<div class="div"><span class="name">用户名：</span><input type="text" name="username" placeholder="请输入用户名"/></div>
                    <div class="div"><span class="name">E-mail：</span><input type="email" name="email" placeholder="请输入正确的电子邮件"/></div>
                    <div class="div"><span class="name">新的密码：</span><input type="password" name="password1" placeholder="请输入不少于6为字符" id="psw1"/></div>
                    <div class="div"><span class="name">确认密码：</span><input type="password" name="password2" placeholder="确认密码" id="psw2"/></div>
                    <div class="input"><input type="submit" name="reset" value="找回密码"/></div>
                </form>

            </div>
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
        <script type="text/javascript">
        function validatePsw(){
	        var psw1 = document.getElementById('psw1').value;
	        var psw2 = document.getElementById('psw2').value;
	        if (psw1 != psw2){
	        	alert('两次密码输入不一致！');
	        	return false;
	        }
	        return true;
        }
        </script>
    </body>
</html>