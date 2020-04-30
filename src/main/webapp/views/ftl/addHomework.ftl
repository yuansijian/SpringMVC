<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>新增作业 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/statics/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>

    <script>
        function save1() {
            $.ajax({
                type: "POST",
                url: "/teacher/homeworkAchieve",
                data: $("#form1").serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        alert("添加成功");
                    }
                    else
                    {
                        alert("添加失败")
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
        <#include "layout/header.ftl">
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
                                <hr>
                                <form id="form1" method="post" action="" class="site-form">
                                    <div class="form-group">
                                        <label for="title">作业标题</label>
                                        <input type="text" class="form-control" name="title" id="title" />
                                    </div>
                                    <div class="form-group">
                                        <label for="description">作业内容</label>
                                        <input type="text" class="form-control" name="description" id="description" >
                                    </div>
                                    <div class="form-group">
                                        <label class="col-12" id="class-input">年级</label>
                                        <div class="col-12">
                                            <select class="form-control" id="select" name="updatetime" size="1">
                                            <#--<option value="0">全部</option>-->
                                            <#list gradeList as cl>
                                                <script>
                                                    $("#select").append("<option value=\"${cl.grade}\">${cl.grade}</option>\n")
                                                </script>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="starttime">开始时间</label>
                                        <input class="form-control js-datepicker" data-date-format="yyyy-mm-dd" type="text" id="starttime" name="starttime" placeholder="从">
                                    </div>
                                    <div class="form-group">
                                        <label for="endtime">结束时间</label>
                                        <input class="form-control js-datepicker" data-date-format="yyyy-mm-dd" type="text" id="endtime" name="endtime" placeholder="至">
                                    </div>
                                    <button onclick="save1()" type="button" class="btn btn-primary">保存</button>
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

<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
<!--日期选择插件-->
<script src="/statics/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="/statics/js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<#--<script type="text/javascript" src="/statics/js/main.min.js"></script>-->
</body>
</html>