<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>用户登录</title>
        <link rel="stylesheet" type="text/css" href="css/public.css">
        <link rel="stylesheet" type="text/css" href="css/register.css">
    </head>
    <body>
    	<c:if test="${user.user_name!=null}">
    		<% response.sendRedirect("index.jsp"); %>
    	</c:if>
        <div class="index_main">
            <div id="head">
                <!-- logo-->
                <div id="head_left">
                    <a href="index.jsp"><img src="images/2.png"/></a>
                </div>
                <div id="head_top">
                    <a href="register.jsp"><span>【注册】</span></a>
                    <a href="register.jsp"><span>【登录】</span></a>
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
            <div class="indx_main_body">
                <div class="index_header">
                    <div class="index_tab_nav">
                        <div class="name">
                            <a href="#" id="signup">注册</a>
                            <a href="#" id="signin">登录</a>
                        </div>
                    </div>
                    <div class="signup">
                        <form class="form" name="signupForm" action="UserRegisterServlet" method="post" onsubmit="return validateSignUp()">
                            <div><span class="name">用户名：</span><input type="text" name="username" placeholder="姓名" maxlength="30" id="username"/></div>
                            <div><span class="name">密码：</span><input type="password" name="password" placeholder="请输入不少于6为字符" maxlength="30" id="password"/></div>
                            <div><span class="name">确认密码：</span><input type="password" name="password2" placeholder="确认密码" id="password2"/></div>
                            <div><span class="name">性别：</span><input type="radio" name="sex" value="男" checked="checked"/><span>男</span><input type="radio" name="sex" value="女"/><span>女</span></div>
                            <div><span class="name">真实姓名：</span><input type="text" name="realname" placeholder="真实姓名" id="realname"/></div>
                            <div><span class="name">E-mail：</span><input type="text" name="email" placeholder="请输入正确的电子邮件" id="email"/></div>
                            <div><span class="name"></span><input type="submit" value="立即注册" name="提交"/></div>
                        </form>
                    </div>
                    <div class="signin" style="display: none;">
                        <form class="form" name="signinForm" action="UserLoginServlet" method="post" onsubmit="return validateSignIn()">
                            <div><span class="name">用户名：</span><input type="text" name="username" placeholder="请输入用户ID或者用户名" id="username2"/></div>
                            <div><span class="name">密码：</span><input type="password" name="password" placeholder="请输入密码" id="password3"/></div>
                            <div><span class="name1"></span><input type="submit" value="登录"/>
                                <input type="reset" value="重置"/>
                                <a href="find_psw.jsp"><span class="name1">忘记密码?</span></a></div>
                        </form>
                    </div>
                </div>
            </div>
            <div id="footer">
                <span>© 2016 ❤ _._桃子小姐mm</span>
            </div>
        </div>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript">
        	$('#signup').click(function(){
        		$('.signup').css('display', 'block');
        		$('.signin').css('display', 'none');
        	});
        	$('#signin').click(function(){
        		$('.signin').css('display', 'block');
        		$('.signup').css('display', 'none');
        	});
        	
        	function validateSignUp(){
        		var password = document.getElementById('password').value;
        		var password2 = document.getElementById('password2').value;
        		if (password != password2){
        			alert('两次密码输入不一致！');
        			return false;
        		} else {
        			return true;
        		}
        	}
        	function validateSignIn(){
        		var username = document.getElementById('username2').value;
        		var password = document.getElementById('password3').value;
        		if (username == ""){
        			alert('用户名不能为空！');
        			return false;
        		}
        		if (password == ""){
        			alert('密码不能为空！');
        			return false;
        		}
        	}
        </script>
    </body>
</html>