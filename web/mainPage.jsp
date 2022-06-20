<%--
  Created by IntelliJ IDEA.
  @author:  	马志勇
  				许昌学院
  				计科2班
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/index.css" >
    <style>
        .footer {
            width: 100%;
            height: 30px;
            line-height: 30px;
            margin-top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            /*position: absolute;*/
            z-index: 10;
            background-color: #343a40;
        }
        .footer a{
            font-family:  Georgia, "Times New Roman", Times, serif;;
            color: #fff;
        }

        .navbar-nav{
            width: 300px;
            float: left !important;
            display: block !important;
        }
        .nav-item{
            padding-left: 20px;
            float: left !important;
        }

        .menua{
            font-size: 1.2em;
        }

        .menua:hover{
            background: #fff;
        }

        .container {
            padding: 20px;
        }

        .search {
            padding-bottom: 20px;
            border-bottom: 1.5px solid #ddd;
        }

        #add {
            margin-right: 5em;
        }

        #search {
            margin-left: 0.5em;
        }

        .pagination {
            display: flex;
            padding-left: 0;
            margin: 20px 0;
            border-radius: 4px;
        }

        .pagination>li:last-child>a, .pagination>li:last-child>span {
            border-top-right-radius: 4px;
            border-bottom-right-radius: 4px;
        }

        .pagination>li:first-child>a, .pagination>li:first-child>span {
            margin-left: 0;
            border-top-left-radius: 4px;
            border-bottom-left-radius: 4px;
        }

        .pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover, .pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover {
            z-index: 3;
            color: #fff;
            cursor: default;
            background-color: #337ab7;
            border-color: #337ab7;
        }

        .pagination>li>a, .pagination>li>span {
            position: relative;
            float: left;
            padding: 6px 12px;
            margin-left: -1px;
            line-height: 1.42857143;
            color: #337ab7;
            text-decoration: none;
            background-color: #fff;
            border: 1px solid #ddd;
            cursor: pointer;
        }
        .badge{
            font-size: 100%;
        }

        .body {
            font-size: 16px;
        }

    </style>

    <script>
        function search() {
            //要搜索的信息就拿回来了
            let v = document.getElementById("fileId").value;
            /*
            * v id  名字
            *
            * */
            window.location.href = "mainServlet?v="+v+"&id=${user.getU_id()}";

        }

        function goShow(v) {
            window.location.href = "show?v="+v+"&admId=${user.getU_id()}";
        }

        function del(v,name) {
            let isdel = confirm("是否删除"+name+"同学？");
            if(isdel){
                window.location.href = "del?v="+v+"&id=${user.getU_id()}";
            }else{
                return;
            }
        }

        function createUser() {
             window.location.href = "createPage?admId=${user.getU_id()}";
        }

        function upDate(v) {
            /*
            * v:学生的id
            *
            * 我们先跳到服务器里  从服务器里在跳到修改界面
            * 1.学生的id
            * 2.管理员的id
            *
            * */
            window.location.href = "upTo?stuId="+v+"&admId=${user.getU_id()}";
        }
        function logOut() {
            window.location.href = "./login.jsp";
        }


    </script>

</head>
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
            <a class="nav-link" th:href=""  onclick="logOut()">退出</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="sidebar-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active menua" th:href="@{/user}" target="mainFrame">
                            <span data-feather="home"></span>
                            用户管理 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- 中间主体内容部分 -->
        <main class="main col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container">
                <input type="text" id="ctx" hidden="hidden" th:value="">
                <div class="search">
                    <div class="input-group col-md-8">
                        <button onclick="createUser()" class="btn btn-success" type="button" id="add">
                            添加
                        </button>
                        <input class="form-control" type="text" id="fileId" placeholder="请输入姓名">
                        <span class="input-group-btn">
					<button class="btn btn-primary" type="button" onclick="search()" id="search">查询
					</button>
			</span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="portlet">
                            <div class="category-list">
                                <table class="table table-striped table-hover" id="dataTable">
                                    <thead>
                                    <tr>
                                        <td>学生id</td>
                                        <td>学生名字</td>
                                        <td>学生电话</td>
                                        <td>查看成绩</td>
                                        <td>操作</td>
                                    </tr>
                                    <c:forEach items="${arr}" var="item">
                                        <tr>
                                            <td>${item.getU_id()}</td>
                                            <td>${item.getU_name()}</td>
                                            <td>${item.getU_phone()}</td>
                                            <td><button class="btn btn-success" type="button" onclick="goShow(${item.getU_id()})">查看成绩</button></td>
                                            <td><button class="btn btn-primary" type="button" onclick="upDate(${item.getU_id()})">修改</button>
                                                <button class="btn btn-danger" type="button" onclick="del(${item.getU_id()},'${item.getU_name()}')">删除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8" align="center" style="position: fixed; bottom: 20%;">
                        <!-- 分页控件，标签必须是<ul> -->
                        <ul id="pageButton" class="pagination-centered"></ul>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>

