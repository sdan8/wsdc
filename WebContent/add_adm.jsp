<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            #body {
                width: 75%;
                height: 300px;
                margin: 0 auto;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            #body h2{
                margin-left: 242px;
            }
            #body .div{
                width: 60%;
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
        <div id="body">
            <h2>添加管理员</h2>
            <form method="post" action="AddAdminServlet" name="form">
                <div class="div"><span>用户ID：</span>
                    <input type="text" name="user_id" />
                    <input type="submit" name="" value="添加"/>
                </div>
            </form>

        </div>
    </body>
</html>