<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>上传设置 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Defend">
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
                            <ul class="nav nav-tabs page-tabs">
                                <li> <a href="/community/baseConfig">基本</a> </li>
                                <li> <a href="/community/systemConfig">系统</a> </li>
                                <li class="active"> <a href="#!">上传</a> </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active">

                                    <form action="/community/uploadUpdate" method="post" name="edit-form" class="edit-form">
                                        <div class="form-group">
                                            <label for="upload_file_ext">文件上传限制</label>
                                            <input class="js-tags-input form-control" type="text" id="type1" name="type1" value="${uploadconfig.type1}" >
                                            <small class="help-block">多个后缀用逗号隔开，不填写则不限制类型</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_image_size">图片上传大小限制</label>
                                            <input class="form-control" type="text" id="image" name="image" value="${uploadconfig.image}" placeholder="请输入图片上传大小限制" >
                                            <small class="help-block">0为不限制大小，单位：kb</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_image_ext">允许上传的图片后缀</label>
                                            <input class="js-tags-input form-control" type="text" id="imageconfig" name="imageconfig" value="${uploadconfig.imageconfig}" >
                                            <small class="help-block">多个后缀用逗号隔开，不填写则不限制类型</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_file_size">文件上传大小限制</label>
                                            <input class="form-control" type="text" id="limit1" name="limit1" value="${uploadconfig.limit1}" placeholder="请输入文件上传大小限制" >
                                            <small class="help-block">0为不限制大小，单位：kb</small>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary m-r-5">确 定</button>
                                            <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                                        </div>
                                    </form>


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