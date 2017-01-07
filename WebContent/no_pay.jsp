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
                height: 400px;
                margin: 0 auto;
                margin-top: 30px;
            }
            #body h2{
                text-align: center;
            }
            #body .table{
                width: 80%;
                margin: 0 auto;
                text-align: center;
                margin-top: 30px;
                /*background-color: #dcdcdc;*/
            }
            #body .table .td{
                font-weight: bolder;
                width: 80px;
                height: 40px;
                line-height: 30px;
                background-color: #808080;
            }
            #body .table .td1{
                height: 28px;
                font-size: 15px;
                background-color: #dcdcdc;
            }
            /*#body .table .td1 a{*/
                /*text-decoration: none;*/
                /*color: #104E8B;*/
            /*}*/

            #body .span{
                width: 30%;
                /*float: left;*/
                margin: 0 auto;
                text-align: center;
                margin-top: 30px;
                font-weight: bolder;
                /*margin-bottom: 20px;*/
            }

            #body .button{
                width: 15%;
                margin: 0 auto;
                /*margin-bottom: 150px;*/
                margin-top: 30px;
            }
            #body .button input[type="submit"]{
                width: 100px;
                height: 30px;
                border: none;
                background-color: #ff4500;
                font-size: 15px;
                color: #f5f5f5;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
    	<jsp:useBean id="user" class="vo.Person" scope="session"></jsp:useBean>    	
    	<jsp:useBean id="ordersBean" class="vo.Orders" scope="page"></jsp:useBean>
    	<jsp:setProperty property="user" name="ordersBean" value="${user}"/>
        <div id="body">
            <h2>未消费清单：</h2>
            <table class="table">
                <tr class="tr">
                    <td class="td"><span class="text">编号</span></td>
                    <td class="td"><span class="text">菜名</span></td>
                    <td class="td"><span class="text">数量</span></td>
                    <td class="td"><span class="text">单价</span></td>
                    <td class="td"><span class="text">总价</span></td>
                    <td class="td"><span class="text">备注</span></td>
                    <!--<td class="td"><span class="text">操作</span></td>-->
                </tr>
                <jsp:getProperty property="showNoPayList" name="ordersBean"/>
            </table>
            <!--<div class="span" id="span"><span class="num">总数量：</span><span>3</span></div>-->
            <div class="span"><span>总价：</span><span class="pri"><jsp:getProperty property="totalPrice" name="ordersBean"/></span></div>
            <form method="post" name="form" action="OrdersPayServlet"><div class="button"><input type="submit" value="结算"/></div></form>
        </div>
    </body>
</html>