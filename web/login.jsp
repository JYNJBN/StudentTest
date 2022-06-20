<%--
  Created by IntelliJ IDEA.
  User: MECHREVO
  Date: 2022/6/12
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/login.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">


</head>
<body>
<div id="login-box">
    <h1>密码登陆</h1>
    <div class="form">
        <div class="item">
            <i class="fa fa-user-circle-o" aria-hidden="true" style="font-size:24px"></i>
            <input id="u_id" type="text" placeholder="Username">
        </div>
        <div class="item">
            <i class="fa fa fa-unlock-alt" style="font-size:24px"></i>
            <input id="u_pwd" type="password" placeholder="Password">
        </div>
    </div>
    <button id="bt">Login</button>
    <div id="error" >${error}</div>
    <script src="js/md5.js"></script>
    <script>
        let bt=document.getElementById("bt");
        bt.onclick=function (){
            // 获取id是否为空
            let id_str=document.getElementById("u_id").value;
            if(id_str == null || id_str == ""){
                document.getElementById("error").innerHTML="账号不能为空";
                return;
            }
            let pwd_str=document.getElementById("u_pwd").value;
            if(pwd_str == null || pwd_str == ""){
                document.getElementById("error").innerHTML="密码不能为空";
                return;
            }
            //重定向到loginServlet 开始访问服务器 访问的参数使用？连接

            window.location.href = "login?u_id="+id_str+"&u_pwd="+hex_md5(pwd_str);

        }
    </script>
</div>
</body>

</html>
