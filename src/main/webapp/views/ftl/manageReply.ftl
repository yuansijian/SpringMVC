<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>留言 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/statics/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
    <link href="/statics/css/style.min.css" rel="stylesheet">

    <script>
        function delethw(id) {
            if (confirm("确定删除这个留言吗")) {
                $.ajax({
                    type: "POST",
                    url: "/community/deleteReply/" + id,
                    success: function (data) {
                        if (data === 1) {
                            alert("留言删除成功");
                            location.reload();
                        }
                        else {
                            alert("留言删除失败");
                        }
                    }
                })
            }
        }

        function reply2(id, name) {
            let src = "/community/reply/" + id + "/" + name;
            // $(this).addClass("actives").siblings().removeClass("actives");
            let html = "<iframe  frameborder=\"0\" scrolling=\"yes\" style=\"width: 800px; height: 200px\" src=\"" + src + "\" id=\"aa\"></iframe>\n";
            $("#reply" + id).remove();
            let html1 = "<a id=\"reply" + id + "\"   class=\"btn btn-xs btn-default\" onclick=\"closePage()\" href=\"#!\" title=\"取消回复\" data-toggle=\"tooltip\"><i class=\"mdi mdi-comment-processing-outline\"></i></a>\n";
            $("#ifpage" + id).append(html1);
            $("#ifpage" + id).append(html);

        }

        function closePage() {
            window.location.reload()
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
                            <ul id="myTabs" class="nav nav-tabs" role="tablist">
                                <li class="dropdown">
                                    <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"
                                       aria-controls="myTabDrop1-contents" aria-expanded="false">选择<span
                                            class="caret"></span></a>
                                    <ul class="dropdown-menu" id="myTabDrop1-contents">
                                        <li><a href="/community/manageMessage">留言</a></li>
                                        <li><a href="#comment" id="student-tab" data-toggle="tab">回复的留言</a></li>
                                    </ul>
                                </li>
                            </ul>
                        <#--<div class="card-toolbar clearfix">-->
                        <#--<form class="well form-search" method="POST" action="/community/manageMessage">-->
                        <#--&lt;#&ndash;姓名：&ndash;&gt;-->
                        <#--&lt;#&ndash;<input type="text" name="stuname" style="width: 100px;"  placeholder="输入数字">&ndash;&gt;-->
                        <#--&lt;#&ndash;&nbsp;&nbsp;&ndash;&gt;-->
                        <#--作业标题：-->
                        <#--<input type="text" name="homeworkname" style="width: 100px;"  placeholder="">-->
                        <#--&nbsp;&nbsp;-->
                        <#--&lt;#&ndash;日期选择:&ndash;&gt;-->
                        <#--&lt;#&ndash;<div class="input-daterange input-group">&ndash;&gt;-->
                        <#--&lt;#&ndash;<input class="form-control js-datepicker" data-date-format="yyyy-mm-dd" type="text" id="startTime" name="startTime" placeholder="从">&ndash;&gt;-->
                        <#--&lt;#&ndash;<span class="input-group-addon"><i class="mdi mdi-chevron-right"></i></span>&ndash;&gt;-->
                        <#--&lt;#&ndash;<input class="form-control js-datepicker" data-date-format="yyyy-mm-dd" type="text" id="endTime" name="endTime" placeholder="至">&ndash;&gt;-->
                        <#--&lt;#&ndash;</div>&ndash;&gt;-->

                        <#--作业时间：-->
                        <#--<input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text" style="width: 150px;" id="startTime" name="startTime" placeholder="从">-->
                        <#--&nbsp;&nbsp;===>-->
                        <#--<input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text"  style="width: 150px;" id="endTime" name="endTime" placeholder="至">-->
                        <#--<input type="submit" class="btn btn-primary" value="搜索" />-->
                        <#--<a class="btn btn-danger" href="/community/manageMessage">返回</a>-->
                        <#--<a class="btn btn-success" href="/teacher/addHomework">新增作业</a>-->
                        <#--</form>-->

                        <#--</div>-->
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade active in" id="comment">
                                    <div class="card-body">

                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                <tr>
                                                    <th>
                                                        <label class="lyear-checkbox checkbox-primary">
                                                            <input type="checkbox" id="check-all"><span></span>
                                                        </label>
                                                    </th>
                                                    <th>编号</th>
                                                    <th>用户名</th>
                                                    <th>回复留言</th>
                                                    <th>回复的人</th>
                                                    <th>留言时间</th>
                                                    <th>操作</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                            <#assign count=0>
                                            <#list pageInfo.list as hw>
                                                <tr>
                                                    <#assign count = count + 1>
                                                    <td>
                                                        <label class="lyear-checkbox checkbox-primary">
                                                            <input type="checkbox" name="ids[]" value="1"><span></span>
                                                        </label>
                                                    </td>
                                                    <td>${count}</td>
                                                    <td>${hw.username}</td>
                                                    <td>${hw.content}</td>
                                                    <td>${hw.parentname}</td>
                                                    <td>${hw.creatTime}</td>
                                                    <td>
                                                        <div class="btn-group" id="ifpage${hw.id}">
                                                        <#--<a  class="btn btn-xs btn-default" href="/teacher/editHomework/${hw.id}" title="回复" data-toggle="tooltip"><i class="mdi mdi-comment-processing-outline"></i></a>-->
                                                        <#--<a class="btn btn-xs btn-default" href="/teacher/checkHomework/${hw.id}/${hw.updatetime}" title="查看作业情况" data-toggle="tooltip"><i class="mdi mdi-account"></i></a>-->
                                                            <a id="delete" onclick="delethw(${hw.id})"
                                                               class="btn btn-xs btn-default" title="删除"
                                                               data-toggle="tooltip"><i
                                                                    class="mdi mdi-window-close"></i></a>
                                                            <a id="reply${hw.id}" class="btn btn-xs btn-default"
                                                               onclick="reply2(${hw.id}, '${hw.parentname}')" href="#!"
                                                               title="回复" data-toggle="tooltip"><i
                                                                    class="mdi mdi-comment-processing-outline"></i></a>

                                                        </div>
                                                    </td>
                                                </tr>
                                            </#list>

                                                </tbody>
                                            </table>
                                        </div>
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
                                    <a href="/community/manageReply?pageNum=${pageInfo.firstPage}&pageSize=10">
                                        <span><i class="mdi mdi-chevron-left"></i></span>
                                    </a>
                                </li>
                            </#if>

                            <#if (pageInfo.pages == 0)>
                                <li class="active disabled"><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==1)>
                                <li class="active disabled"><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==2)>
                                <li class="active"><a href="/community/manageReply?pageNum=1&pageSize=10">1</a></li>
                                <li><a href="/community/manageReply?pageNum=2&pageSize=10">2</a></li>
                            <#elseif (pageInfo.pages == 3)>
                                <li class="active"><a href="/community/manageReply?pageNum=1&pageSize=10">1</a></li>
                                <li><a href="#!"></a></li>
                                <li><a href="/community/manageReply?pageNum=2&pageSize=10">2</a></li>
                                <li><a href="/community/manageReply?pageNum=3&pageSize=10">3</a></li>
                            <#else>
                                <#if pageInfo.isFirstPage>
                                    <li class="active"><a href="/community/manageReply?pageNum=1&pageSize=10">1</a></li>
                                    <li><a href="/community/manageReply?pageNum=2&pageSize=10">2</a></li>
                                    <li><a href="/community/manageReply?pageNum=3&pageSize=10">3</a></li>
                                <#else>
                                    <#if pageInfo.hasPreviousPage>
                                        <li>
                                            <a href="/community/manageReply?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a>
                                        </li>
                                    <#else>
                                        <li><a href="#!">${pageInfo.pageNum}</a></li>
                                    </#if>
                                    <li class="active"><a
                                            href="/community/manageReply?pageNum=2&pageSize=10">${pageInfo.pageNum}</a>
                                    </li>
                                    <#if pageInfo.hasNextPage>
                                        <li>
                                            <a href="/community/manageReply?pageNum=${pageInfo.nextPage}&pageSize=10">${pageInfo.nextPage}</a>
                                        </li>
                                    <#else>
                                    <#--<li><a href="/community/manageReply?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage - 1}</a></li>-->
                                    <#--<li><a href="/community/manageReply?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a></li>-->
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
                                    <a href="/community/manageReply?pageNum=${pageInfo.lastPage}&pageSize=10">
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

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
<!--日期选择插件-->
<script src="/statics/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="/statics/js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<#--<script type="text/javascript" src="/statics/js/main.min.js"></script>-->

</body>
</html>