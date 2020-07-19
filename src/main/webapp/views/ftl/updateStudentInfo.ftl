<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>学生信息 - 后台管理系统模板</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
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
                                <img class="img-avatar img-avatar-48 m-r-10" src="${administrator.imageurl}"
                                     alt="笔下光年"/>
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
                            <div class="card-body">
                                <hr>
                                <form method="post" action="/user/updateStudentInfo/" class="site-form">
                                    <div class="form-group">
                                        <label for="stuname">学生姓名</label>
                                        <input type="text" class="form-control" name="stuname" id="stuname"
                                               value="${student.stuname}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="username">用户名</label>
                                        <input type="text" class="form-control" name="username" id="username"
                                               value="${student.username}">
                                    </div>
                                    <div class="form-group">
                                        <label for="stumail">邮箱</label>
                                        <input type="email" class="form-control" name="stumail" id="stumail"
                                               aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址"
                                               value="${student.stumail}">
                                        <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="stunumber">学号</label>
                                        <input type="text" class="form-control" name="stunumber" id="stunumber"
                                               value="${student.stunumber}">
                                    </div>
                                    <div class="form-group">
                                        <label for="class1">班级</label>
                                        <input type="text" class="form-control" name="class1" id="class1"
                                               value="${student.class1}">
                                    </div>
                                    <div class="form-group">
                                        <label for="sex">性别</label>
                                        <input type="text" class="form-control" name="sex" id="sex"
                                               value="${student.sex}">
                                    </div>
                                <#--<input type="hidden" class="form-control" name="password" id="password" value="${student.password}">-->
                                <#--<input type="hidden" class="form-control" name="lastname" id="lastname" value="${student.lastname}">-->
                                <#--<input type="hidden" class="form-control" name="registeredtime" id="registeredtime" value="${student.registeredtime}">-->
                                <#--<input type="hidden" class="form-control" name="loginnumber" id="loginnumber" value="${student.loginnumber}">-->
                                <#--<input type="hidden" class="form-control" name="deleteTime" id="deleteTime" value="${student.deleteTime}">-->
                                <#--<input type="hidden" class="form-control" name="endtime" id="endtime" value="${student.endtime}">-->
                                <#--<input type="hidden" class="form-control" name="isDelete" id="isDelete" value="${student.isDelete}">-->
                                <#--<input type="hidden" class="form-control" name="updatetime" id="updatetime" value="${student.updatetime}">-->
                                <#--<input type="hidden" class="form-control" name="updatepasswordtime" id="updatepasswordtime" value="${student.updatepasswordtime}">-->
                                <#--<input type="hidden" class="form-control" name="sex" id="sex" value="${student.sex}">-->
                                    <button type="submit" class="btn btn-primary">保存</button>
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