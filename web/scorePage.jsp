<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/2
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
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
        .container-fluid>.row{
            height: 100%;
        }
        .btn_content{
            margin-top: 50px;
        }


    </style>
    <script>
        function goMainPage() {
            //goMainPage admId
            window.location.href = "goMainPage?admId=${admId}"
        }
    </script>
</head>
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
                            成绩查询界面 <span class="sr-only">(current)</span>
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
                        <div class="panel panel-default">
                            <div class="panel-heading">学生各科成绩</div>
                            <table class="table">
                                <tr>
                                    <th>#</th>
                                    <th>科目</th>
                                    <th>成绩</th>
                                </tr>
                                <c:forEach items="${arr}" var="item" varStatus="status">
                                    <tr>
                                        <td>${status.index+1}</td>
                                        <td> ${item.getA()}</td>
                                        <td>${item.getB()}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="btn_content">
                            <button class="btn btn-success"  onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;
                        </div>
                    </div>
                </div>
            </div>
    </main>
</div>
</div>
<body>
</body>
</html>
