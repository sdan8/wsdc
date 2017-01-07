<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body {
                width: 75%;
                height: 300px;
                /*height: 500px;*/
                /*background-color: aqua;*/
                /*float: right;*/
                margin: 0 auto;
                margin-top: 50px;
                margin-bottom: 120px;
                /*border-left: 3px solid gray;*/
                /*border-top: 3px solid gray;*/
                /*border-bottom: 3px solid gray;*/
            }
            #body h2{
                text-align: center;
            }

            #body   table{
                margin: 0 auto;
                margin-top: 30px;
            }
            #body  table tr{
                /*width: 400px;*/
                height: 50px;
                background-color: gainsboro;
                line-height: 50px;
                text-align: center;
            }
            #body   table input{
                border-style: none;
                background-color: gainsboro;
                text-align: center;
            }
            #body  table .text{
                width: 300px;
                font-family: "微软雅黑";
                font-weight: bolder;
            }
            #body  table .content{
                width: 200px;
            }
            #body .input{
                width: 50%;
                margin: 0 auto;
                margin-top: 20px;
            }
            #body input[type="submit"]{
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
		<jsp:useBean id="user" class="vo.Person" scope="session"></jsp:useBean>
        <div id="body">
            <h2>修改个人信息</h2>
            <div class="person">
                <form action="UserUpdateServlet?info=updateinfo" method="post" name="form">
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
        </div>

    </body>
</html>