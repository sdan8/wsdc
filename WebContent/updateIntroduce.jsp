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
            #body #div{
                margin-left: 200px;
            }
            #body #div #text{
                width: 250px;
                height: 100px;
            }
            #body .div input[type="submit"]{
                display: block;
                width: 50px;
                height: 30px;
                margin-left: 80px;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <div id="body">
            <h2>修改商家信息</h2>
            <form method="post" action="UpdateIntroduceServlet" name="form">
                <div class="div"><span>商家介绍：</span></div>
                <div class="div" id="div">
                    <textarea id="text" name="introduce"></textarea>
                    <input type="submit" value="修改"/>
                </div>
            </form>
        </div>
    </body>
</html>