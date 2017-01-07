<%@page import="vo.Person"%>
<%@page import="factory.DAOFactory"%>
<%@page import="vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>会员管理中心</title>
        <link href="css/public.css" rel="stylesheet" type="text/css"/>
        <style>
            #body #body_left{
                width: 20%;
                height: 300px;
                /*height: 500px;*/
                /*background-color: #f7941d;*/
                float: left;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            #body #body_left .text{
                width: 80%;
                margin: 0 auto;
                text-align: center;
                margin-top: 20px;
            }
            #body #body_left .text a{
                text-decoration: none;
                color: black;
            }

            #body #body_right{
                width: 75%;
                height: 300px;
                /*height: 500px;*/
                /*background-color: aqua;*/
                float: right;
                margin-top: 50px;
                margin-bottom: 120px;
                border-left: 3px solid gray;
                border-top: 3px solid gray;
                border-bottom: 3px solid gray;
            }


            #body #body_right  table{
                margin: 0 auto;
                margin-top: 30px;
            }
            #body #body_right  table tr{
                /*width: 400px;*/
                height: 50px;
                background-color: gainsboro;
                line-height: 50px;
                text-align: center;
            }
            #body #body_right  table input{
                border-style: none;
                background-color: gainsboro;
                text-align: center;
            }
            #body #body_right  table .text{
                width: 300px;
                font-family: "微软雅黑";
                font-weight: bolder;
            }
            #body #body_right  table .content{
                width: 200px;
            }
            #body #body_right .input{
                width: 50%;
                margin: 0 auto;
                margin-top: 20px;
            }
            #body #body_right input[type="submit"]{
                width: 100px;
                height: 30px;
            }


        </style>
    </head>
    <body>
    	<jsp:useBean id="user" class="vo.Person" scope="session"></jsp:useBean>
    	<%
    	UserInfo userInfo = DAOFactory.getUserInfoDAOInstance().searchByUser(user);
    	request.setAttribute("userInfo", userInfo);
    	%>
    	
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

        <!-- body-->
        <div id="body">
            <div id="body_left">
                <div class="text"><a href="#" id="person">【修改个人信息】</a></div>
                <div class="text"><a href="#" id="psw">【修改密码】</a></div>
                <div class="text"><a href="#" id="add">【修改配送地址】</a></div>
            </div>
            <div id="body_right">
                <div class="person">
                    <form method="post" action="UserUpdateServlet?info=updateinfo" name="form1">
                        <table>
                            <tr>
                                <td class="text">用户名：</td>
                                <td class="content">${user.user_name}</td>
                            </tr>
                            <tr>
                                <td class="text">真实姓名：</td>
                                <td class="content"><input type="text" name="realname" value="${user.user_realname}"/></td>
                            </tr>
                            <tr>
                                <td class="text">性别：</td>
                                <td class="content"><input type="text" name="sex" value="${user.user_sex}"/></td>
                            </tr>
                            <tr>
                                <td class="text">E-mail：</td>
                                <td class="content"><input type="email" name="email" value="${user.user_mail}"/></td>
                            </tr>
                        </table>
                        <div class="input"><input type="submit" name="reset" value="修改个人信息"/></div>
                    </form>
                </div>
                <div class="psw" style="display: none">
                    <form method="post" action="UserUpdateServlet?info=updatepsw" name="form2" onsubmit="return updatepsw()">
                        <table>
                            <tr>
                                <td class="text">原密码：</td>
                                <td class="content"><input type="password" name="psw"/></td>
                            </tr>
                            <tr>
                                <td class="text">新密码：</td>
                                <td class="content"><input type="password" name="psw1" id="psw1"/></td>
                            </tr>
                            <tr>
                                <td class="text">确认密码：</td>
                                <td class="content"><input type="password" name="psw2" id="psw2"/></td>
                            </tr>
                        </table>
                        <div class="input"><input type="submit" name="reset" value="修改密码"/></div>
                    </form>
                </div>
                <div class="add" style="display: none">
                    <form method="post" action="UpdateUserInfoServlet" name="form3">
                        <table>
                            <tr>
                                <td class="text">送货地址：</td>
                                <td class="content"><input type="text" name="address" value="${userInfo.address}"/></td>
                            </tr>
                            <tr>
                                <td class="text">用户电话：</td>
                                <td class="content"><input type="text" name="tel" value="${userInfo.tel}"/></td>
                            </tr>
                            <tr>
                                <td class="text">用户手机：</td>
                                <td class="content"><input type="text" name="mobile" value="${userInfo.mobile}"/></td>
                            </tr>
                        </table>
                        <div class="input"><input type="submit" name="reset" value="修改配送地址"/></div>
                    </form>
                </div>
            </div>
        </div>

        <!-- foot-->
        <div id="footer">
            <span>© 2016 ❤ _._桃子小姐mm</span>
        </div>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript">
            $('#person').click(function(){
                $('.person').css('display', 'block');
                $('.add').css('display', 'none');
                $('.psw').css('display','none')
            });
            $('#psw').click(function(){
                $('.psw').css('display', 'block');
                $('.add').css('display', 'none');
                $('.person').css('display','none')
            });
            $('#add').click(function(){
                $('.add').css('display', 'block');
                $('.psw').css('display', 'none');
                $('.person').css('display','none')
            });
            function updatepsw(){
            	var psw1 = $('#psw1').val();
            	var psw2 = $('#psw2').val();
            	if (psw1 == "" || psw2 == ""){
            		alert('请填写完整！');
            		return false;
            	}
            	if (psw1 != psw2){
            		alert('两次密码输入不一致！');
            		return false;
            	}
            	return true;
            }
        </script>
    </body>
</html>