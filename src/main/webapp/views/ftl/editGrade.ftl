<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>教师中心-编辑年级</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/jquery-3.3.1.min.js"></script>
    <script>
        function update1() {
            $.ajax({
                type: "POST",
                url: "/teacher/updateG",
                data: $("#form1").serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        alert("更新成功");
                        location.reload();
                    }
                    else
                    {
                        alert("更新失败")
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <#include "layout/sidebar.ftl">
        <!--End 左侧导航-->

        <!--头部信息-->
        <header class="lyear-layout-header">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <#include "layout/header1.ftl">

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${administrator.imageurl}" alt="笔下光年" />
                                <span>${administrator.username} <span class="caret"></span></span>
                                <!--切换主题配色-->
                            </a>
                            <#include "layout/header2.ftl">
                        </li>
                        <#include "layout/header3.ftl">
                        <!--切换主题配色-->
                    </ul>

                </div>
            </nav>

        </header>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <a href="javascript:history.go(-1);"><h4 style="color: #0FB25F">返回</h4></a>
                            </div>
                            <div class="card-body">
                                <form id="form1" class="site-form">

                                    <div class="form-group">
                                        <label for="grade">年级</label>
                                        <input type="text" class="form-control" name="grade" id="grade" required="required" value="${grade.grade}">
                                    </div>
                                    <div class="form-group">
                                        <label for="description">描述</label>
                                        <input type="text" class="form-control" name="description" id="description" required="required" value="${grade.description}">
                                    </div>
                                    <div class="form-group">
                                        <label for="teacher">负责老师</label>
                                        <input type="text" class="form-control" name="teacher" id="teacher" required="required" value="${grade.teacher}">
                                    </div>
                                    <input type="hidden" name="id" value="${grade.id}">
                                    <button onclick="update1()" type="button" class="btn btn-primary">更新</button>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>

        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
</body>
</html>