<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>步骤 - 光年(Light Year Admin)后台管理系统模板</title>
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
        <div class="alert alert-info" role="alert">
          实际应用中，给a标签加上 <code>data-toggle="tab"</code> ，可查看<a href="lyear_pages_guide.html">表单向导</a>。
        </div>
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-header"><h4>步骤</h4></div>
              <div class="card-body">
                
                <ul class="nav-step step-dots">
                  <li class="nav-step-item active">
                    <span>步骤一</span>
                    <a class="active" href="#"></a>
                  </li>
      
                  <li class="nav-step-item">
                    <span>步骤三</span>
                    <a href="#"></a>
                  </li>
      
                  <li class="nav-step-item">
                    <span>步骤四</span>
                    <a href="#"></a>
                  </li>
      
                  <li class="nav-step-item">
                    <span>步骤五</span>
                    <a href="#"></a>
                  </li>
                </ul>
                
                <ul class="nav-step step-dots">
                  <li class="nav-step-item complete">
                    <span>步骤一</span>
                    <a class="active" href="#"></a>
                  </li>
      
                  <li class="nav-step-item active">
                    <span>步骤三</span>
                    <a href="#"></a>
                  </li>
      
                  <li class="nav-step-item">
                    <span>步骤四</span>
                    <a href="#"></a>
                  </li>
      
                  <li class="nav-step-item">
                    <span>步骤五</span>
                    <a href="#"></a>
                  </li>
                </ul>
                
                <ul class="nav-step step-anchor">
                  <li class="nav-step-item active">
                    <a href="#step-1">
                      <h6>步骤一</h6>
                      <p class="m-0">步骤一说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item">
                    <a href="#step-2">
                      <h6>步骤二</h6>
                      <p class="m-0">步骤二说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item">
                    <a href="#step-3">
                      <h6>步骤三</h6>
                      <p class="m-0">步骤三说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item">
                    <a href="#step-4">
                      <h6>步骤四</h6>
                      <p class="m-0">步骤四说明</p>
                    </a>
                  </li>
                </ul>
                
                <ul class="nav-step step-anchor">
                  <li class="nav-step-item complete">
                    <a href="#step-1">
                      <h6>步骤一</h6>
                      <p class="m-0">步骤一说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item active">
                    <a href="#step-2">
                      <h6>步骤二</h6>
                      <p class="m-0">步骤二说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item">
                    <a href="#step-3">
                      <h6>步骤三</h6>
                      <p class="m-0">步骤三说明</p>
                    </a>
                  </li>
                  <li class="nav-step-item">
                    <a href="#step-4">
                      <h6>步骤四</h6>
                      <p class="m-0">步骤四说明</p>
                    </a>
                  </li>
                </ul>
                
              </div>
            </div>
          </div>
        </div>
        <!-- .row --> 
        
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