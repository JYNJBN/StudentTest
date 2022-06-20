<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/7
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    .navbar-nav{
        width: 300px;
        float: left !important;
        display: block !important;
    }
    .nav-item{
        padding-left: 20px;
        float: left !important;
    }
    .input-group-addon {
        padding: 6px 12px;
        font-size: 14px;
        font-weight: 400;
        line-height: 1;
        color: #555;
        text-align: center;
        background-color: #eee;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .input-group{
        margin-top: 30px;
        max-width: 400px;
    }
    .btn_content{
        margin-top: 50px;
    }
    .badge{
        font-size: 100%;
    }

    #a{
        margin-top: 100px;
    }
    .container-fluid>.row{
        height: 100%;
    }
</style>
<script>
    function goMainPage() {
        //goMainPage admId
        window.location.href = "goMainPage?admId=${admId}"
    }
    function createStu() {
        /*
        * 我们去访问服务器要拿的参数
        * 1.灵魂：就是管理员的id 1  admId:
        * 2.处理对象： 学生  stuId:
        * 3.成绩：a b c d  4
        *
        * */
        let a=document.getElementById("a1").value;
        let b=document.getElementById("a2").value;
        window.location.href = "createStu?admId=${admId}&a="+a+"&b="+b;
    }
</script>


<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <div class="col-md-3 col-lg-2 mr-0 px-3" ></div>
    <!--<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">-->
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link">当前用户：<span class="badge" th:text="${user.getU_name()}">${user.getU_name()}</span></a>
        </li>
        <li class="nav-item text-nowrap">
            <a class="nav-link" th:href="">退出</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active menua"  th:href="@{/user}" target="mainFrame">
                            <span data-feather="home"></span>

                            添加学生界面 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- 中间主体内容部分 -->
        <main class="main col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container">

                <div class="row">
                    <div class="col-md-12">
                        <div id ="a">
                            <%--
                                admId  stuId
                            --%>
                            <div class="page-header">
                                <h3>学生信息录入:</h3>
                            </div>
                            <div id = "b">
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">姓名</span>
                                    <input type="text" class="form-control" placeholder="请输入姓名" id="a1" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon2">学生电话</span>
                                    <input type="text" class="form-control" placeholder="请输入学生电话" id="a2" aria-describedby="basic-addon1">
                                </div>
                            </div>
                            <div class="btn_content">
                                <button class="btn btn-success"  onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;
                                <button class="btn btn-primary" onclick="createStu()">确认添加</button>
                            </div>
                        </div>

                    </div>
                    </div>
                </div>
        </main>
    </div>
</div>
</body>
</html>
