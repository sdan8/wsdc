<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body{
                width: 75%;
                margin: 0 auto;
                margin-top: 30px;
            }
            #body h2{
                text-align: center;
            }
            #body table{
                width: 60%;
                margin: 0 auto;
            }
            #body table tr th{
                width: 100px;
                height: 30px;
                background-color: #808080;
            }
            #body table tr td{
                width: 100px;
                height: 30px;
                text-align: center;
                font-size: 15px;
                background-color: #dcdcdc;
            }


            #body .div{
                width:  70%;
                /*margin-left: 20px;*/
                margin: 0 auto;
                margin-top: 30px;
                /*border-bottom: 2px solid #dcdcdc;*/
            }
            #body .div span{
                font-weight: bolder;
            }
            #body .div input[type="text"]{
                width: 100px;
                height: 30px;
            }

            #body .div input[type="submit"]{
                width: 50px;
                height: 30px;
                margin-left: 20px;
            }
            #body .null{
                width: 70%;
                height: 10px;
                margin: 0 auto;
                margin-top: 30px;

            }
        </style>
    </head>
    <body>
    	<jsp:useBean id="menuBean" class="vo.Menu"></jsp:useBean>
	    <div id="body">
	        <h2>删除菜品</h2>
	
	        <table>
	            <tr>
	                <th>菜品ID</th>
	                <th>菜名</th>
	                <th>单价</th>
	                <th>简介</th>
	            </tr>
	            <jsp:getProperty property="showUpdateList" name="menuBean"/>
	        </table>
	        <form method="post" action="DeleteMenuServlet" name="form" onsubmit="return confirm('确定要删除吗？')">
	            <div class="div"><span>菜品ID：</span>
	                <input type="text" name="food_id" />
	                <input type="submit" value="删除"/></div>
	        </form>
	        <div class="null"><hr/></div>
	        <form method="post" action="UpdateMenuServlet" name="form">
	            <div class="div"><span>菜品ID：</span>
	                <input type="text" name="foodId" />
	                <span>单价：</span>
	                <input type="text" name="price" />
	                <span>元/份</span>
	                <input type="submit" value="更改"/></div>
	        </form>
	    </div>

    </body>
</html>