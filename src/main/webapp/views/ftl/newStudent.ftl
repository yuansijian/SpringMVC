<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>新学生 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/statics/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
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
                          <ul id="myTabs" class="nav nav-tabs" role="tablist">
                              <li class="dropdown">
                                  <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents" aria-expanded="false">选择<span class="caret"></span></a>
                                  <ul class="dropdown-menu" id="myTabDrop1-contents">
                                      <li><a href="#student" id="student-tab" data-toggle="tab">学生</a></li>
                                      <li><a href="/user/newTeacher?pageNum=1&pageSize=10">教师</a></li>
                                  </ul>
                              </li>
                          </ul>
                          <div id="myTabContent" class="tab-content">
                              <div class="tab-pane fade active in" id="student">
                                  <div class="card-toolbar clearfix">
                                      <form class="well form-search" method="get" action="/user/newStudent">
                                          姓名：
                                          <input type="text" name="stuname" style="width: 100px;"  placeholder="">
                                          &nbsp;&nbsp;
                                          班级：
                                          <input type="text" name="stuclass" style="width: 100px;"  placeholder="">
                                          &nbsp;&nbsp;

                                          注册时间：
                                          <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text" style="width: 150px;" id="registeredStartTime" name="registeredStartTime" placeholder="从">
                                          &nbsp;&nbsp;===>
                                          <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text"  style="width: 150px;" id="registeredEndTime" name="registeredEndTime" placeholder="至">
                                          <input type="submit" class="btn btn-primary" value="搜索" />
                                          <a class="btn btn-danger" href="/user/newStudent">返回</a>
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
                                                  <th>学生姓名</th>
                                                  <th>用户名</th>
                                                  <th>注册时间</th>
                                                  <th>状态</th>
                                                  <th>操作</th>
                                              </tr>
                                              </thead>
                                              <tbody>
                                      <#list studentList.list as student>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="check-all" value="1"><span></span>
                                              </label>
                                          </td>
                                          <td>${student.id}</td>
                                          <td>${student.stuname}</td>
                                          <td>${student.username}</td>
                                          <td>${student.registeredtime}</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="/user/editStudentInfo/${student.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="/user/deleteStudent/${student.id}" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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
                                          <#if studentList.isFirstPage>
                                            <li class="disabled">
                                                <a href="#!">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                        <#else>
                                            <li>
                                                <a href="/user/newStudent?pageNum=${studentList.firstPage}&pageSize=10">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                        </#if>

                                        <#if (studentList.pages == 0)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (studentList.pages==1)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (studentList.pages==2)>
                                            <li class="active"><a href="/user/newStudent?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="/user/newStudent?pageNum=2&pageSize=10">2</a></li>
                                        <#elseif (studentList.pages == 3)>
                                            <li class="active"><a href="/user/newStudent?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="#!"></a></li>
                                            <li><a href="/user/newStudent?pageNum=2&pageSize=10">2</a></li>
                                            <li><a href="/user/newStudent?pageNum=3&pageSize=10">3</a></li>
                                        <#else>
                                            <#if studentList.isFirstPage>
                                                <li class="active"><a href="/user/newStudent?pageNum=1&pageSize=10">1</a></li>
                                                <li><a href="/user/newStudent?pageNum=2&pageSize=10">2</a></li>
                                                <li><a href="/user/newStudent?pageNum=3&pageSize=10">3</a></li>
                                            <#else>
                                                <#if studentList.hasPreviousPage>
                                                    <li><a href="/user/newStudent?pageNum=${studentList.prePage}&pageSize=10">${studentList.prePage}</a></li>
                                                <#else>
                                                    <li><a href="#!">${studentList.pageNum}</a></li>
                                                </#if>
                                                <li class="active"><a href="/user/newStudent?pageNum=2&pageSize=10">${studentList.pageNum}</a></li>
                                                <#if studentList.hasNextPage>
                                                    <li><a href="/user/newStudent?pageNum=${studentList.nextPage}&pageSize=10">${studentList.nextPage}</a></li>
                                                <#else>
                                                <#--<li><a href="/user/newStudent?pageNum=${studentList.prePage}&pageSize=10">${studentList.prePage - 1}</a></li>-->
                                                <#--<li><a href="/user/newStudent?pageNum=${studentList.prePage}&pageSize=10">${studentList.prePage}</a></li>-->
                                                <#--<li><a href="#!">${studentList.pageNum}</a></li>-->
                                                </#if>
                                            </#if>
                                        </#if>

                                          <#--去到最后一页-->
                                          <#if studentList.isLastPage>
                                                <li class="disabled">
                                                    <a href="#!">
                                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                                    </a>
                                                </li>
                                          <#else>
                                                <li>
                                                    <a href="/user/newStudent?pageNum=${studentList.lastPage}&pageSize=10">
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