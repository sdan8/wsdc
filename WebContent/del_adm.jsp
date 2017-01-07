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
                /*margin-left: 242px;*/
                /*margin: 0 auto;*/
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
                width: 60%;
                /*margin-left: 20px;*/
                margin: 0 auto;
                margin-top: 30px;

            }
            #body .div span{
                font-weight: bolder;
            }
            #body .div input[type="text"]{
                width: 150px;
                height: 30px;
            }

            #body .div input[type="submit"]{
                width: 50px;
                height: 30px;
                margin-left: 20px;
            }
        </style>
    </head>
    <body>
		<jsp:useBean id="adminBean" class="vo.Person"></jsp:useBean>
        <div id="body">
            <h2>删除管理员</h2>
            <table>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>真实姓名</th>
                    <th>性别</th>
                    <th>E-mail</th>
                </tr>
                <jsp:getProperty property="showAdminList" name="adminBean"/>
            </table>
            <form method="post" action="RemoveAdminServlet" name="form">
                <div class="div"><span>用户ID：</span>
                    <input type="text" name="user_id" />
                    <input type="submit" value="删除"/></div>
            </form>
        </div>

    </body>
</html>