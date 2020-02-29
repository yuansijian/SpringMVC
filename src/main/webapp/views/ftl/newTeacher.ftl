<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>表单 - 光年(Light Year Admin)后台管理系统模板</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
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
      <#include "layout/header.ftl">
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
                                        <li><a href="#teacher" id="teacher-tab" data-toggle="tab">教师</a></li>
                                        <li><a href="/user/newStudent?pageNum=1&pageSize=1">学生</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade active in" id="teacher">
                                    <div class="card-toolbar clearfix">
                                        <form class="well form-search" method="POST" action="/user/newTeacher">
                                            姓名：
                                            <input type="text" name="teaname" style="width: 100px;"  placeholder="">
                                            &nbsp;&nbsp;
                                        <#--班级：-->
                                        <#--<input type="text" name="store_id" style="width: 100px;"  placeholder="">-->
                                        <#--&nbsp;&nbsp;-->

                                            注册时间：
                                            <input type="text" name="registeredStartTime" style="width: 150px;" placeholder="">
                                            &nbsp;&nbsp;
                                            注册时间：
                                            <input type="text" name="registeredEndTime" style="width: 150px;" placeholder="">
                                            <input type="submit" class="btn btn-primary" value="搜索" />
                                            <a class="btn btn-danger" href="/user/newTeacher?pageNUm=1&pageSize=1">清空</a>
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
                                                    <th>教师姓名</th>
                                                    <th>用户名</th>
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
                                                      <td>${teacher.id}</td>
                                                      <td>${teacher.teaname}</td>
                                                      <td>${teacher.username}</td>
                                                      <td>${teacher.registeredtime}</td>
                                                      <td><font class="text-success">正常</font></td>
                                                      <td>
                                                          <div class="btn-group">
                                                              <a class="btn btn-xs btn-default" href="/user/editTeacherInfo/${teacher.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                              <a class="btn btn-xs btn-default" href="/user/deleteTeacher/${teacher.id}" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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
                                                        <a href="/user/newTeacher?pageNum=${teacherList.firstPage}&pageSize=1">
                                                            <span><i class="mdi mdi-chevron-left"></i></span>
                                                        </a>
                                                    </li>
                                                </#if>

                                            <#if (teacherList.pages == 0)>
                                                <li class="active disabled" ><a href="#!">1</a></li>
                                            <#elseif (teacherList.pages==1)>
                                                    <li class="active disabled" ><a href="#!">1</a></li>
                                            <#elseif (teacherList.pages==2)>
                                                    <li class="active"><a href="/user/newTeacher?pageNum=1&pageSize=1">1</a></li>
                                                    <li><a href="/user/newTeacher?pageNum=2&pageSize=1">2</a></li>
                                            <#elseif (teacherList.pages == 3)>
                                                    <li class="active"><a href="/user/newTeacher?pageNum=1&pageSize=1">1</a></li>
                                                    <li><a href="#!"></a></li>
                                                    <li><a href="/user/newTeacher?pageNum=2&pageSize=1">2</a></li>
                                                    <li><a href="/user/newTeacher?pageNum=3&pageSize=1">3</a></li>
                                            <#else>
                                                <#if teacherList.isFirstPage>
                                                        <li class="active"><a href="/user/newTeacher?pageNum=1&pageSize=1">1</a></li>
                                                        <li><a href="/user/newTeacher?pageNum=2&pageSize=1">2</a></li>
                                                        <li><a href="/user/newTeacher?pageNum=3&pageSize=1">3</a></li>
                                                <#else>
                                                    <#if teacherList.hasPreviousPage>
                                                            <li><a href="/user/newTeacher?pageNum=${teacherList.prePage}&pageSize=1">${teacherList.prePage}</a></li>
                                                    <#else>
                                                            <li><a href="#!">${teacherList.pageNum}</a></li>
                                                    </#if>
                                                        <li class="active"><a href="/user/newTeacher?pageNum=2&pageSize=1">${teacherList.pageNum}</a></li>
                                                    <#if teacherList.hasNextPage>
                                                            <li><a href="/user/newTeacher?pageNum=${teacherList.nextPage}&pageSize=1">${teacherList.nextPage}</a></li>
                                                    <#else>
                                                    <#--<li><a href="/user/newTeacher?pageNum=${teacher.prePage}&pageSize=1">${teacher.prePage - 1}</a></li>-->
                                                    <#--<li><a href="/user/newTeacher?pageNum=${teacher.prePage}&pageSize=1">${teacher.prePage}</a></li>-->
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
                                                    <a href="/user/newTeacher?pageNum=${teacherList.lastPage}&pageSize=1">
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
</body>
</html>