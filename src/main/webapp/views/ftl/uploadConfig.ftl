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
                            <ul class="nav nav-tabs page-tabs">
                                <li> <a href="/community/baseConfig">基本</a> </li>
                                <li> <a href="/community/systemConfig">系统</a> </li>
                                <li class="active"> <a href="#!">上传</a> </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active">

                                    <form action="#!" method="post" name="edit-form" class="edit-form">
                                        <div class="form-group">
                                            <label for="upload_file_ext">图片上传大小限制</label>
                                            <input class="js-tags-input form-control" type="text" id="upload_file_ext" name="upload_file_ext" value="doc,docx,xls,xlsx,ppt,pptx,pdf,wps,txt,rar,zip,gz,bz2,7z" >
                                            <small class="help-block">多个后缀用逗号隔开，不填写则不限制类型</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_image_size">图片上传大小限制</label>
                                            <input class="form-control" type="text" id="upload_image_size" name="upload_image_size" value="0" placeholder="请输入图片上传大小限制" >
                                            <small class="help-block">0为不限制大小，单位：kb</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_image_ext">允许上传的图片后缀</label>
                                            <input class="js-tags-input form-control" type="text" id="upload_image_ext" name="upload_image_ext" value="gif,jpg,jpeg,bmp,png" >
                                            <small class="help-block">多个后缀用逗号隔开，不填写则不限制类型</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="upload_file_size">文件上传大小限制</label>
                                            <input class="form-control" type="text" id="upload_file_size" name="upload_file_size" value="0" placeholder="请输入文件上传大小限制" >
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