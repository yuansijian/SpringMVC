<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>文件上传 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <!--日期选择插件-->
    <link rel="stylesheet" href="/statics/js/bootstrap-datepicker/bootstrap-datepicker3.min.css">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script>
        function save1() {
            let formData = new FormData($("#upload-file")[0]);

            $.ajax({
                type: "POST",
                url: "/community/uploadFileAchieve",
                data: formData,
                contentType: false,
                processData: false,

                success: function (data) {
                    console.log(data);
                    console.log(222);
                    if (data === 1) {
                        alert("上传成功");
                        location.reload();
                    }
                    else if (data === 202) {
                        alert("文件大于200M")
                    }
                    else if (data === 303) {
                        alert("文件格式不对")
                    }
                    else {
                        alert("上传失败,刷新或重命名试试")
                    }
                }
            })
        }

        function deleteFile(id, fname) {
            if (confirm("确定删除" + fname + "这个文件吗")) {
                $.ajax({
                    type: "POST",
                    url: "/community/deleteFile/" + id,
                    success: function (data) {
                        if (data === 1) {
                            alert(fname + "删除成功");
                            location.reload();
                        }
                        else {
                            alert(fname + "删除失败");
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
                        <#--<div class="card-header"><iframe src="/community/videoTeacher"></iframe></div>-->
                            <div class="card-body">
                                <form id="upload-file" class="form-horizontal" action="" method="post"
                                      enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label class="col-xs-12" for="example-file-multiple-input">文件上传</label>
                                        <div class="col-xs-12">
                                            <input class="form-control" type="file" id="file" name="file" multiple>
                                            <input class="form-control" type="text" name="description"
                                                   placeholder="文件描述">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <button class="btn btn-primary" type="button" onclick="save1()">提交</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="card-toolbar clearfix">
                                    <form class="well form-search" method="POST" action="">
                                        文件名：
                                        <input type="text" name="fileName" style="width: 100px;" placeholder="">
                                        &nbsp;&nbsp;

                                        上传时间：
                                        <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text"
                                               style="width: 150px;" id="startTime" name="startTime" placeholder="从">
                                        &nbsp;&nbsp;===>
                                        <input class="js-datepicker" data-date-format="yyyy-mm-dd" type="text"
                                               style="width: 150px;" id="endTime" name="endTime" placeholder="至">
                                        <input type="submit" class="btn btn-primary" value="搜索"/>
                                        <a class="btn btn-danger" href="/community/uploadFile">返回</a>
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
                                      <#list uploadfileList.list as uploadfile>
                                      <tr>
                                          <td>${uploadfile.id}</td>
                                          <td>${uploadfile.filename}</td>
                                          <td>${uploadfile.uploadtime}</td>
                                          <td>${uploadfile.description}</td>
                                          <td>${uploadfile.filesize}Kb</td>
                                          <td>${uploadfile.author}</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default"
                                                     onclick="deleteFile(${uploadfile.id}, '${uploadfile.filename}')"
                                                     title="删除" data-toggle="tooltip"><i
                                                          class="mdi mdi-window-close"></i></a>
                                                  <a class="btn btn-xs btn-default"
                                                     href="/statics/uploadFile/${uploadfile.filename}"
                                                     download="${uploadfile.filename}" title="下载" data-toggle="tooltip"><i
                                                          class="mdi mdi-content-save"></i></a>

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
                                          <#if uploadfileList.isFirstPage>
                                            <li class="disabled">
                                                <a href="#!">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          <#else>
                                            <li>
                                                <a href="/community/uploadFile?pageNum=${uploadfileList.firstPage}&pageSize=10">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          </#if>

                                        <#if (uploadfileList.pages == 0)>
                                            <li class="active disabled"><a href="#!">1</a></li>
                                        <#elseif (uploadfileList.pages==1)>
                                            <li class="active disabled"><a href="#!">1</a></li>
                                        <#elseif (uploadfileList.pages==2)>
                                            <li class="active"><a
                                                    href="/community/uploadFile?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="/community/uploadFile?pageNum=2&pageSize=10">2</a></li>
                                        <#elseif (uploadfileList.pages == 3)>
                                            <li class="active"><a
                                                    href="/community/uploadFile?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="#!"></a></li>
                                            <li><a href="/community/uploadFile?pageNum=2&pageSize=10">2</a></li>
                                            <li><a href="/community/uploadFile?pageNum=3&pageSize=10">3</a></li>
                                        <#else>
                                            <#if uploadfileList.isFirstPage>
                                                <li class="active"><a
                                                        href="/community/uploadFile?pageNum=1&pageSize=10">1</a></li>
                                                <li><a href="/community/uploadFile?pageNum=2&pageSize=10">2</a></li>
                                                <li><a href="/community/uploadFile?pageNum=3&pageSize=10">3</a></li>
                                            <#else>
                                                <#if uploadfileList.hasPreviousPage>
                                                    <li>
                                                        <a href="/community/uploadFile?pageNum=${uploadfileList.prePage}&pageSize=10">${uploadfileList.prePage}</a>
                                                    </li>
                                                <#else>
                                                    <li><a href="#!">${uploadfileList.pageNum}</a></li>
                                                </#if>
                                                <li class="active"><a
                                                        href="/community/uploadFile?pageNum=2&pageSize=10">${uploadfileList.pageNum}</a>
                                                </li>
                                                <#if uploadfileList.hasNextPage>
                                                    <li>
                                                        <a href="/community/uploadFile?pageNum=${uploadfileList.nextPage}&pageSize=10">${uploadfileList.nextPage}</a>
                                                    </li>
                                                <#else>
                                                <#--<li><a href="/community/uploadFile?pageNum=${uploadfileList.prePage}&pageSize=10">${uploadfileList.prePage - 1}</a></li>-->
                                                <#--<li><a href="/community/uploadFile?pageNum=${uploadfileList.prePage}&pageSize=10">${uploadfileList.prePage}</a></li>-->
                                                <#--<li><a href="#!">${uploadfileList.pageNum}</a></li>-->
                                                </#if>
                                            </#if>
                                        </#if>

                                        <#--去到最后一页-->
                                          <#if uploadfileList.isLastPage>
                                                <li class="disabled">
                                                    <a href="#!">
                                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                                    </a>
                                                </li>
                                          <#else>
                                                <li>
                                                    <a href="/community/uploadFile?pageNum=${uploadfileList.lastPage}&pageSize=10">
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