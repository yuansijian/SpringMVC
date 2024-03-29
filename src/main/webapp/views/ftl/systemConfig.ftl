<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>系统信息 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script>
        function A() {
            alert("清除成功");
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
                            <ul class="nav nav-tabs page-tabs">
                                <li><a href="/community/baseConfig">基本</a></li>
                                <li class="active"><a href="#!">系统</a></li>
                                <li><a href="/community/uploadConfig">上传</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active">

                                    <form action="#!" method="post" name="edit-form" class="edit-form">
                                        <div class="form-group">
                                            <label for="config_group">配置分组</label>
                                            <textarea class="form-control" id="config_group" rows="5"
                                                      name="config_group" placeholder="请输入配置分组">
base:基本
system:${system}
develop:开发
upload:上传
</textarea>
                                        </div>
                                    <#--<div class="form-group">-->
                                    <#--<label for="form_item_type">配置类型</label>-->
                                    <#--<textarea class="form-control" id="form_item_type" rows="5" name="form_item_type" placeholder="请输入配置类型" >text:单行文本-->
                                    <#--textarea:多行文本-->
                                    <#--checkbox:复选框-->
                                    <#--radio:单选按钮-->
                                    <#--switch:开关-->
                                    <#--array:数组-->
                                    <#--select:下拉框-->
                                    <#--image:单张图片-->
                                    <#--ueditor:UEditor 编辑器-->
                                    <#--tags:标签-->
                                    <#--</textarea>-->
                                    <#--</div>-->
                                        <div class="form-group">
                                            <label for="wipe_cache_type">清除缓存类型</label>
                                            <div class="controls-box">
                                                <label class="lyear-checkbox checkbox-inline checkbox-primary">
                                                    <input type="checkbox" name="wipe_cache_type[]"
                                                           checked><span>应用缓存</span>
                                                </label>
                                                <label class="lyear-checkbox checkbox-inline checkbox-primary">
                                                    <input type="checkbox" name="wipe_cache_type[]"><span>应用日志</span>
                                                </label>
                                                <label class="lyear-checkbox checkbox-inline checkbox-primary">
                                                    <input type="checkbox" name="wipe_cache_type[]"><span>模板缓存</span>
                                                </label>
                                            </div>
                                            <small class="help-block">清除缓存时，要删除的缓存类型</small>
                                        </div>
                                    <#--<div class="form-group">-->
                                    <#--<label for="develop_mode">开发模式</label>-->
                                    <#--<div class="controls-box">-->
                                    <#--<label class="lyear-radio radio-inline radio-primary">-->
                                    <#--<input type="radio" name="develop_mode" value="0" checked><span>关闭</span>-->
                                    <#--</label>-->
                                    <#--<label class="lyear-radio radio-inline radio-primary">-->
                                    <#--<input type="radio" name="develop_mode" value="1"><span>开启</span>-->
                                    <#--</label>-->
                                    <#--</div>-->
                                    <#--</div>-->
                                    <#--<div class="form-group">-->
                                    <#--<label for="app_trace">显示页面Trace</label>-->
                                    <#--<div class="controls-box">-->
                                    <#--<label class="lyear-radio radio-inline radio-primary">-->
                                    <#--<input type="radio" name="app_trace" value="0" checked><span>否</span>-->
                                    <#--</label>-->
                                    <#--<label class="lyear-radio radio-inline radio-primary">-->
                                    <#--<input type="radio" name="app_trace" value="1"><span>是</span>-->
                                    <#--</label>-->
                                    <#--</div>-->
                                    <#--</div>-->
                                        <div class="form-group">
                                            <button type="button" onclick="A()" class="btn btn-primary m-r-5">确 定
                                            </button>
                                            <button type="button" class="btn btn-default"
                                                    onclick="javascript:history.back(-1);return false;">返 回
                                            </button>
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