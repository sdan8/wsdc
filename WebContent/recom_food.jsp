<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        </style>
    </head>
    <body>
    	<jsp:useBean id="menuBean" class="vo.Menu"></jsp:useBean>
        <div id="body">
            <div id="body_top">
                <h2>推荐菜品</h2>
                <table>
                    <tr>
                        <th>菜品ID</th>
                        <th>菜名</th>
                        <th>单价</th>
                        <th>详细信息</th>
                        <th>操作</th>
                    </tr>
                    <jsp:getProperty property="showMenuTopUpdate" name="menuBean"/>
                </table>
            </div>
            <div id="body_bottom">
                <h2>全部菜品</h2>
                <table>
                    <tr>
                        <th>菜品ID</th>
                        <th>菜名</th>
                        <th>单价</th>
                        <th>详细信息</th>
                        <th>操作</th>
                    </tr>
                    <jsp:getProperty property="showMenuUpdate" name="menuBean"/>
                </table>
            </div>
        </div>
    </body>
</html>