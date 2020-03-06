<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>开关 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="/statics/favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
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
      <#include "layout/header.ftl">
      <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-xs-12 col-sm-6">
            <div class="card">
              <div class="card-header"><h4>默认开关样式</h4></div>
              <div class="card-body">
                <p>添加 <code>.switch-*</code> 以更改开关的外观：<code>.switch-success</code> <code>.switch-pink</code>...</p>
                <div class="example-box">
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">默认</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Primary（主色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-primary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Success（成功）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-success">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Secondary（灰色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-secondary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Info（一般信息）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-info">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Warning（警告）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-warning">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Danger（危险）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-danger">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Dark（黑色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-dark">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Purple（紫色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-purple">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Pink（粉红色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-pink">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Cyan（青色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-cyan">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Yellow（黄色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-yellow">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Brown（棕色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-brown">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                </div>
                <!-- end example-box -->
              </div>
            </div>
          </div>
          <div class="col-xs-12 col-sm-6">
            <div class="card">
              <div class="card-header"><h4>纯色风格开关</h4></div>
              <div class="card-body">
                <div class="example-box">
                  <p>给开关添加 <code>.switch-solid</code>。</p>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">默认</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Primary（主色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-primary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Success（成功）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-success">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Secondary（灰色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-secondary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Info（一般信息）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-info">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Warning（警告）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-warning">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Danger（危险）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-danger">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Dark（黑色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-dark">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Purple（紫色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-purple">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Pink（粉红色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-pink">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Cyan（青色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-cyan">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Yellow（黄色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-yellow">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Brown（棕色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-solid switch-brown">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                </div>
                <!-- end example-box -->
              </div>
            </div>
          </div>
        </div>
        
        <div class="row">
          <div class="col-xs-12 col-sm-6">
            <div class="card">
              <div class="card-header"><h4>浅色背景开关样式</h4></div>
              <div class="card-body">
                <p>添加 <code>.switch-light</code> 以改变背景颜色。</p>
                <div class="example-box">
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">默认</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Primary（主色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-primary switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Success（成功）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-success switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Secondary（灰色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-secondary switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Info（一般信息）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-info switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Warning（警告）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-warning switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Danger（危险）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-danger switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Dark（黑色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-dark switch-light">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Purple（紫色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light switch-purple">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Pink（粉红色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light switch-pink">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Cyan（青色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light switch-cyan">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Yellow（黄色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light switch-yellow">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Brown（棕色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-light switch-brown">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                </div>
                <!-- end example-box -->
              </div>
            </div>
          </div>
          <div class="col-xs-12 col-sm-6">
            <div class="card">
              <div class="card-header"><h4>边框风格开关</h4></div>
              <div class="card-body">
                <div class="example-box">
                  <p>给开关添加 <code>.switch-outline</code>。</p>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">默认</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Primary（主色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-primary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Success（成功）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-success">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Secondary（灰色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-secondary">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Info（一般信息）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-info">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Warning（警告）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-warning">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Danger（危险）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-danger">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row m-b-10">
                    <div class="col-xs-6">Dark（黑色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-dark">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Purple（紫色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-purple">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Pink（粉红色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-pink">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Cyan（青色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-cyan">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Yellow（黄色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-yellow">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-xs-6">Brown（棕色）</div>
                    <div class="col-xs-6">
                      <label class="lyear-switch switch-outline switch-brown">
                        <input type="checkbox" checked="">
                        <span></span>
                      </label>
                    </div>
                  </div>
                </div>
                <!-- end example-box -->
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