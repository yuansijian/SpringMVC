<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>基本设置 - 后台管理系统</title>
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
        <header class="lyear-layout-header">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <#include "layout/header1.ftl">

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="/statics/images/users/avatar.jpg" alt="笔下光年" />
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
                                <li class="active"> <a href="#!">基本</a> </li>
                                <#--<li> <a href="lyear-config-system.html">系统</a> </li>-->
                                <#--<li> <a href="lyear-config-upload.html">上传</a> </li>-->
                                <li> <a href="/community/systemConfig">系统</a> </li>
                                <li> <a href="/community/uploadConfig">上传</a> </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active">

                                    <form action="#!" method="post" name="edit-form" class="edit-form">
                                        <#--<div class="form-group">-->
                                            <#--<label for="web_site_title">网站标题</label>-->
                                            <#--<input class="form-control" type="text" id="web_site_title" name="web_site_title" value="光年后台管理系统HTML模板" placeholder="请输入站点标题" >-->
                                            <#--<small class="help-block">调用方式：<code>config('web_site_title')</code></small>-->
                                        <#--</div>-->
                                        <div class="form-group">
                                            <label for="web_site_logo">LOGO图片</label>
                                            <div class="input-group">
                                                <input type="text" class="form-control" name="web_site_logo" id="web_site_logo" value="${logoPicturePath.pictureurl}" />
                                                <div class="input-group-btn"><button class="btn btn-default" type="button">上传图片</button></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="web_site_keywords">站点关键词</label>
                                            <input class="form-control" type="text" id="web_site_keywords" name="web_site_keywords" value="后台系统" placeholder="请输入站点关键词" >
                                            <small class="help-block">网站搜索引擎关键字</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="web_site_description">站点描述</label>
                                            <textarea class="form-control" id="web_site_description" rows="5" name="web_site_description" placeholder="请输入站点描述" >态势语后台管理系统</textarea>
                                            <small class="help-block">网站描述，有利于搜索引擎抓取相关信息</small>
                                        </div>
                                        <div class="form-group">
                                            <label for="web_site_copyright">版权信息</label>
                                            <input class="form-control" type="text" id="web_site_copyright" name="web_site_copyright" value="©2020 - 2020, content by Defend. All Rights Reserved." placeholder="请输入版权信息" >
                                            <small class="help-block"></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="web_site_icp">备案信息</label>
                                            <input class="form-control" type="text" id="web_site_icp" name="web_site_icp" value="" placeholder="请输入备案信息" >
                                            <small class="help-block"></small>
                                        </div>
                                        <div class="form-group">
                                            <label class="btn-block" for="web_site_status">站点开关</label>
                                            <label class="lyear-switch switch-solid switch-primary">
                                                <input type="checkbox" checked="">
                                                <span></span>
                                            </label>
                                            <small class="help-block">站点关闭后将不能访问，后台可正常登录</small>
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