<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>教师中心-其他</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/jquery-3.3.1.min.js"></script>
    <script>
        function change2(id, val) {
            let content = document.getElementById("state").innerText;
            $.ajax({
                type: "POST",
                url: "/teacher/updateGrade",
                data: "id="+id+"&val="+val,
                success: function (data) {
                    if(data === 1)
                    {
                        alert("状态已改变");
                        if(content === "已启用")
                        {
                            $("#state").text("未启用");
                        }
                        if(content === "未启用")
                        {
                            $("#state").text("已启用");
                        }
                    }
                    else
                    {
                        alert("服务器出错")
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
        <#if administrator.authority == 2>
            <#include "layout/sidebar1.ftl">
        <#else>
            <#include "layout/sidebar.ftl">
        </#if>
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
                            <div class="card-header"><h4>班级信息</h4></div>
                            <div class="card-toolbar clearfix">
                                <form class="well form-search form-horizontal" method="POST" action="/teacher/other">
                                    <div class="container">
                                        <div class="form-group">
                                            <label class="col-xs-2" id="name-input">关键词</label>
                                            <div class="col-xs-2">
                                                <input class="form-control input-sm " type="text" id="input-small" name="keyword" placeholder="请输入关键词">
                                            </div>
                                            <input type="submit" class="btn btn-primary" value="搜索" />
                                            <a class="btn btn-danger" href="/teacher/other">返回</a>
                                            <a class="btn btn-brown" href="/teacher/addGrade">新增年级</a>
                                        </div>
                                    </div>
                                </form>
                            <#--<div class="toolbar-btn-action">-->
                            <#--<a class="btn btn-primary m-r-5" href="/teacher/other?pageNum=1&pageSize=1"><i class="mdi mdi-plus"></i>返回</a>-->
                            <#--<a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>-->
                            <#--<a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>-->
                            <#--<a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>-->
                            <#--</div>-->
                            </div>

                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-hover table-bordered table-striped table-vcenter" style="word-wrap: break-word">
                                        <thead>
                                        <tr>
                                            <th class="w-5">编号</th>
                                            <th class="w-5">年级</th>
                                            <th class="w-5">描述</th>
                                            <th class="w-5">负责老师</th>
                                            <th class="w-5">状态</th>
                                            <th class="w-5">编辑</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                            <#--<#assign count=0>-->
                                            <#list pageInfo.list as list>
                                                <tr>
                                                    <#--<#assign count = count + 1>-->
                                                    <td>${list.id}</td>
                                                    <td>${list.grade}</td>
                                                    <td>${list.description}</td>
                                                    <td>${list.teacher}</td>
                                                    <td><a id="state" href="#" onclick="change2(${list.id}, ${list.isDelete})" >
                                                        <#if list.isDelete == 0>
                                                            已启用
                                                        <#else>
                                                            未启用
                                                        </#if>
                                                    </a>
                                                    </td>
                                                    <td>
                                                        <a  class="btn btn-xs btn-default" href="/teacher/editGrade/${list.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                    </td>
                                                </tr>
                                            </#list>
                                        </tbody>
                                    </table>
                                <#--<a href="/teacher/other?pageNum=2&pageSize=1">下一页</a>-->
                                    <nav>
                                        <ul class="pagination pagination-circle">
                                        <#--返回第一页-->
                            <#if pageInfo.isFirstPage>
                                <li class="disabled">
                                    <a href="#!">
                                        <span><i class="mdi mdi-chevron-left"></i></span>
                                    </a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/teacher/other?pageNum=${pageInfo.firstPage}&pageSize=10">
                                        <span><i class="mdi mdi-chevron-left"></i></span>
                                    </a>
                                </li>
                            </#if>

                            <#if (pageInfo.pages == 0)>
                                <li class="active disabled" ><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==1)>
                                <li class="active disabled" ><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==2)>
                                <li class="active"><a href="/teacher/other?pageNum=1&pageSize=10">1</a></li>
                                <li><a href="/teacher/other?pageNum=2&pageSize=10">2</a></li>
                            <#elseif (pageInfo.pages == 3)>
                                <li class="active"><a href="/teacher/other?pageNum=1&pageSize=10">1</a></li>
                                <li><a href="#!"></a></li>
                                <li><a href="/teacher/other?pageNum=2&pageSize=10">2</a></li>
                                <li><a href="/teacher/other?pageNum=3&pageSize=10">3</a></li>
                            <#else>
                                <#if pageInfo.isFirstPage>
                                    <li class="active"><a href="/teacher/other?pageNum=1&pageSize=10">1</a></li>
                                    <li><a href="/teacher/other?pageNum=2&pageSize=10">2</a></li>
                                    <li><a href="/teacher/other?pageNum=3&pageSize=10">3</a></li>
                                <#else>
                                    <#if pageInfo.hasPreviousPage>
                                        <li><a href="/teacher/other?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a></li>
                                    <#else>
                                        <li><a href="#!">${pageInfo.pageNum}</a></li>
                                    </#if>
                                    <li class="active"><a href="/teacher/other?pageNum=2&pageSize=10">${pageInfo.pageNum}</a></li>
                                    <#if pageInfo.hasNextPage>
                                        <li><a href="/teacher/other?pageNum=${pageInfo.nextPage}&pageSize=10">${pageInfo.nextPage}</a></li>
                                    <#else>
                                    <#--<li><a href="/teacher/other?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage - 1}</a></li>-->
                                    <#--<li><a href="/teacher/other?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a></li>-->
                                    <#--<li><a href="#!">${pageInfo.pageNum}</a></li>-->
                                    </#if>
                                </#if>
                            </#if>

                                        <#--去到最后一页-->
                            <#if pageInfo.isLastPage>
                                <li class="disabled">
                                    <a href="#!">
                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                    </a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/teacher/other?pageNum=${pageInfo.lastPage}&pageSize=10">
                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                    </a>
                                </li>
                            </#if>

                                        </ul>
                                    </nav>
                                </div>
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