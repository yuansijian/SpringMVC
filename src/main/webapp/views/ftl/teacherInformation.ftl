<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>教师信息 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/statics/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script>
        function deleteTea(id, vname)
        {
            if(confirm("是否删除"+vname+"这个教师"))
            {

                //   通过ajax请求springmvc
                $.ajax({
                    type:"POST",
                    url:"/user/deleteTeacher/" + id,
                    success:function (data) {
                        if(data === 1)
                        {
                            alert("删除成功");
                            location.reload();
                        }
                        else
                        {
                            alert("删除失败");
                        }
                    }
                })
            }
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
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade active in" id="teacher">
                                    <div class="card-toolbar clearfix">
                                        <form class="well form-search" method="POST" action="/user/teacherInformation">
                                            姓名：
                                            <input type="text" name="teaname" style="width: 100px;"  placeholder="">
                                            &nbsp;&nbsp;
                                        <#--班级：-->
                                        <#--<input type="text" name="store_id" style="width: 100px;"  placeholder="">-->
                                        <#--&nbsp;&nbsp;-->

                                            注册时间：
                                            <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text" style="width: 150px;" id="registeredStartTime" name="registeredStartTime" placeholder="从">
                                            &nbsp;&nbsp;===>
                                            <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text"  style="width: 150px;" id="registeredEndTime" name="registeredEndTime" placeholder="至">
                                            <input type="submit" class="btn btn-primary" value="搜索" />
                                            <a class="btn btn-danger" href="/user/teacherInformation">清空</a>
                                        </form>
                                    <#--<div class="toolbar-btn-action">-->
                                    <#--<a class="btn btn-primary m-r-5" href="#!"><i class="mdi mdi-plus"></i> 新增</a>-->
                                    <#--<a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>-->
                                    <#--<a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>-->
                                    <#--<a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>-->
                                    <#--</div>-->
                                    </div>
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
                                                    <th>姓名</th>
                                                    <th>用户名</th>
                                                    <th>教学年级班级</th>
                                                    <#--<th>教学班级</th>-->
                                                    <#--<th>电话号码</th>-->
                                                    <th>邮箱</th>
                                                    <th>登录次数</th>
                                                    <th>性别</th>
                                                    <th>登录时间</th>
                                                    <th>下线时间</th>
                                                    <th>注册时间</th>
                                                    <th>状态</th>
                                                    <th>操作</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                  <#list teacherList.list as teacher>
                                                  <tr>
                                                      <td>
                                                          <label class="lyear-checkbox checkbox-primary">
                                                              <input type="checkbox" name="ids[]" value="1"><span></span>
                                                          </label>
                                                      </td>
                                                      <td >${teacher.id}</td>
                                                      <td>${teacher.teaname}</td>
                                                      <td>${teacher.username}</td>
                                                      <td>${teacher.grade}</td>
                                                      <#--<td>${teacher.classes}</td>-->
                                                      <#--<td>${teacher.stuphone}</td>-->
                                                      <#--<td>${teacher.stumail}</td>-->
                                                      <td>${teacher.teamail}</td>
                                                      <td>${teacher.loginnumber}</td>
                                                      <td>
                                                          <#if teacher.sex == 1>
                                                              男
                                                          <#else>
                                                                女
                                                          </#if>
                                                      </td>
                                                      <td>${teacher.logintime}</td>
                                                      <td>${teacher.endtime}</td>
                                                      <td>${teacher.registeredtime}</td>
                                                      <td><font class="text-success">正常</font></td>
                                                      <td>
                                                          <div class="btn-group">
                                                              <a class="btn btn-xs btn-default" href="/user/editTeacherInfo/${teacher.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                              <a class="btn btn-xs btn-default" onclick="deleteTea(${teacher.id}, '${teacher.username}')" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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
                                                <#if teacherList.isFirstPage>
                                                    <li class="disabled">
                                                        <a href="#!">
                                                            <span><i class="mdi mdi-chevron-left"></i></span>
                                                        </a>
                                                    </li>
                                                <#else>
                                                    <li>
                                                        <a href="/user/teacherInformation?pageNum=${teacherList.firstPage}&pageSize=10">
                                                            <span><i class="mdi mdi-chevron-left"></i></span>
                                                        </a>
                                                    </li>
                                                </#if>

                                            <#if (teacherList.pages == 0)>
                                                <li class="active disabled" ><a href="#!">1</a></li>
                                            <#elseif (teacherList.pages==1)>
                                                    <li class="active disabled" ><a href="#!">1</a></li>
                                            <#elseif (teacherList.pages==2)>
                                                    <li class="active"><a href="/user/teacherInformation?pageNum=1&pageSize=10">1</a></li>
                                                    <li><a href="/user/teacherInformation?pageNum=2&pageSize=10">2</a></li>
                                            <#elseif (teacherList.pages == 3)>
                                                    <li class="active"><a href="/user/teacherInformation?pageNum=1&pageSize=10">1</a></li>
                                                    <li><a href="#!"></a></li>
                                                    <li><a href="/user/teacherInformation?pageNum=2&pageSize=10">2</a></li>
                                                    <li><a href="/user/teacherInformation?pageNum=3&pageSize=10">3</a></li>
                                            <#else>
                                                <#if teacherList.isFirstPage>
                                                        <li class="active"><a href="/user/teacherInformation?pageNum=1&pageSize=10">1</a></li>
                                                        <li><a href="/user/teacherInformation?pageNum=2&pageSize=10">2</a></li>
                                                        <li><a href="/user/teacherInformation?pageNum=3&pageSize=10">3</a></li>
                                                <#else>
                                                    <#if teacherList.hasPreviousPage>
                                                            <li><a href="/user/teacherInformation?pageNum=${teacherList.prePage}&pageSize=10">${teacherList.prePage}</a></li>
                                                    <#else>
                                                            <li><a href="#!">${teacherList.pageNum}</a></li>
                                                    </#if>
                                                        <li class="active"><a href="/user/teacherInformation?pageNum=2&pageSize=10">${teacherList.pageNum}</a></li>
                                                    <#if teacherList.hasNextPage>
                                                            <li><a href="/user/teacherInformation?pageNum=${teacherList.nextPage}&pageSize=10">${teacherList.nextPage}</a></li>
                                                    <#else>
                                                    <#--<li><a href="/user/teacherInformation?pageNum=${teacher.prePage}&pageSize=10">${teacher.prePage - 1}</a></li>-->
                                                    <#--<li><a href="/user/teacherInformation?pageNum=${teacher.prePage}&pageSize=10">${teacher.prePage}</a></li>-->
                                                    <#--<li><a href="#!">${teacher.pageNum}</a></li>-->
                                                    </#if>
                                                </#if>
                                            </#if>

                                            <#--去到最后一页-->
                                            <#if teacherList.isLastPage>
                                                <li class="disabled">
                                                    <a href="#!">
                                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                                    </a>
                                                </li>
                                            <#else>
                                                <li>
                                                    <a href="/user/teacherInformation?pageNum=${teacherList.lastPage}&pageSize=10">
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