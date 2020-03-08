<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>视频教学 - 后台管理系统</title>
<link rel="icon" href="/statics/favicon.ico" type="image/ico">
<meta name="author" content="Defend">
<link href="/statics/css/bootstrap.min.css" rel="stylesheet">
<link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
<!--标签插件-->
<link rel="stylesheet" href="/statics/js/jquery-tags-input/jquery.tagsinput.min.css">
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
                            <div class="card-body">
                                <form class="form-horizontal" action="/community/videoTeacherAchieve" method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label class="col-xs-12" for="example-file-multiple-input">文件上传</label>
                                        <div class="col-xs-12">
                                            <input class="form-control" type="file" id="file" name="file" multiple>
                                            <input class="form-control" type="text" name="description" placeholder="文件描述">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <button class="btn btn-primary" type="submit">提交</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="card-toolbar clearfix">
                                    <form class="well form-search" method="POST" action="/community/videoTeacher">
                                        文件名：
                                        <input type="text" name="vname" style="width: 100px;"  placeholder="">
                                        &nbsp;&nbsp;

                                        上传时间：
                                        <input type="text" name="startTime" style="width: 150px;" placeholder="">
                                        &nbsp;&nbsp;
                                        上传时间：
                                        <input type="text" name="endTime" style="width: 150px;" placeholder="">
                                        <input type="submit" class="btn btn-primary" value="搜索" />
                                        <a class="btn btn-danger" href="/community/videoTeacher?pageNum=1&pageSize=1">返回</a>
                                    </form>
                                </div>
                                <div class="card-body">

                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>文件名</th>
                                                <th>上传时间</th>
                                                <th>文件描述</th>
                                                <th>文件大小</th>
                                                <th>上传作者</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                      <#list pageInfo.list as uploadfile>
                                      <tr>
                                          <td >${uploadfile.id}</td>
                                          <td>${uploadfile.vname}</td>
                                          <td>${uploadfile.uploadtime}</td>
                                          <td>${uploadfile.description}</td>
                                          <td>${uploadfile.vsizes}Kb</td>
                                          <td>${uploadfile.author}</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="/community/videoPreview/${uploadfile.id}" title="预览" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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
                                                <a href="/community/videoTeacher?pageNum=${pageInfo.firstPage}&pageSize=1">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          </#if>

                                        <#if (pageInfo.pages == 0)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (pageInfo.pages==1)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (pageInfo.pages==2)>
                                            <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=1">1</a></li>
                                            <li><a href="/community/videoTeacher?pageNum=2&pageSize=1">2</a></li>
                                        <#elseif (pageInfo.pages == 3)>
                                            <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=1">1</a></li>
                                            <li><a href="#!"></a></li>
                                            <li><a href="/community/videoTeacher?pageNum=2&pageSize=1">2</a></li>
                                            <li><a href="/community/videoTeacher?pageNum=3&pageSize=1">3</a></li>
                                        <#else>
                                          <#if pageInfo.isFirstPage>
                                                <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=1">1</a></li>
                                                <li><a href="/community/videoTeacher?pageNum=2&pageSize=1">2</a></li>
                                                <li><a href="/community/videoTeacher?pageNum=3&pageSize=1">3</a></li>
                                          <#else>
                                            <#if pageInfo.hasPreviousPage>
                                                    <li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage}</a></li>
                                            <#else>
                                                    <li><a href="#!">${pageInfo.pageNum}</a></li>
                                            </#if>
                                                <li class="active"><a href="/community/videoTeacher?pageNum=2&pageSize=1">${pageInfo.pageNum}</a></li>
                                            <#if pageInfo.hasNextPage>
                                                    <li><a href="/community/videoTeacher?pageNum=${pageInfo.nextPage}&pageSize=1">${pageInfo.nextPage}</a></li>
                                            <#else>
                                            <#--<li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage - 1}</a></li>-->
                                            <#--<li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage}</a></li>-->
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
                                                    <a href="/community/videoTeacher?pageNum=${pageInfo.lastPage}&pageSize=1">
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
<!--标签插件-->
<script src="/statics/js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
</body>
</html>