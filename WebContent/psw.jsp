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
                text-align: center;
            }

            #body  table{
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
            #body  table input{
                border-style: none;
                background-color: gainsboro;
                text-align: center;
            }
            #body table .text{
                width: 300px;
                font-family: "微软雅黑";
                font-weight: bolder;
            }
            #body  table .content{
                width: 200px;
            }
            #body  .input{
                width: 50%;
                margin: 0 auto;
                margin-top: 20px;
            }
            #body  input[type="submit"]{
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
        <div id="body">
            <h2>修改密码</h2>
            <div class="psw">
                <form method="post" action="UserUpdateServlet?info=updatepsw" name="form" onsubmit="return updatepsw()">
                    <table>
                        <tr>
                            <td class="text">原密码：</td>
                            <td class="content"><input type="password" name="psw"/></td>
                        </tr>
                        <tr>
                            <td class="text">新密码：</td>
                            <td class="content"><input type="password" name="psw1"/></td>
                        </tr>
                        <tr>
                            <td class="text">确认密码：</td>
                            <td class="content"><input type="password" name="psw2"/></td>
                        </tr>
                    </table>
                    <div class="input"><input type="submit" value="修改密码"/></div>
                </form>

            </div>
        </div>

	<script src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
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