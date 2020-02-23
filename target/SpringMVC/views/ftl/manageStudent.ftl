<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>按钮 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="/statics/favicon.ico" type="image/ico">
<meta name="keywords" content="Defend的后台管理">
<meta name="author" content="YSJ">
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
              <div class="card-header"><h4>学生信息</h4></div>
                <form method="get" action="/teacher/manageStudent">
                    <div class="row m-b-10">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <span class="input-group-btn">
                                  <button class="btn btn-cyan" type="submit" >搜索</button>
                                </span>
                                <input name="keyword" type="text" class="form-control" placeholder="请输入关键词...">
                            </div>
                        </div>
                </form><a href="/teacher/manageStudent"><button class="btn btn-success">返回</button></a> <br/>

              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-hover table-bordered table-striped table-vcenter" style="word-wrap: break-word">
                    <thead>
                      <tr>
                        <th class="w-5">编号</th>
                        <th class="w-5">姓名</th>
                        <th class="w-5">学号</th>
                        <th class="w-5">年级</th>
                        <th class="w-5">班级</th>
                        <th class="w-5">性别</th>
                        <th class="w-5">电话号码</th>
                        <th class="w-5">邮箱</th>
                      </tr>
                    </thead>
                    <tbody>
                        <#assign count=0>
                        <#list studentList as stu>
                            <tr>
                                <#assign count = count + 1>
                                <td>${count}</td>
                                <td>${stu.stuname}</td>
                                <td>${stu.stunumber}</td>
                                <td>${stu.grade}</td>
                                <td>${stu.class1}</td>
                                <td>${stu.sex}</td>
                                <td>${stu.stuphone}</td>
                                <td>${stu.stumail}</td>
                            </tr>
                        </#list>
                    </tbody>
                    <#--<tbody>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-default btn-w-md" type="button">默认按钮</button></td>-->
                        <#--<td><code>btn btn-default</code></td>-->
                        <#--<td><button class="btn btn-primary btn-w-md" type="button">主要颜色按钮</button></td>-->
                        <#--<td><code>btn btn-primary</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-success btn-w-md" type="button">绿色按钮</button></td>-->
                        <#--<td><code>btn btn-success</code></td>-->
                        <#--<td><button class="btn btn-info btn-w-md" type="button">一般信息按钮</button></td>-->
                        <#--<td><code>btn btn-info</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-warning btn-w-md" type="button">橙色按钮</button></td>-->
                        <#--<td><code>btn btn-warning</code></td>-->
                        <#--<td><button class="btn btn-danger btn-w-md" type="button">红色按钮</button></td>-->
                        <#--<td><code>btn btn-danger</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-secondary btn-w-md" type="button">次要颜色按钮</button></td>-->
                        <#--<td><code>btn btn-secondary</code></td>-->
                        <#--<td><button class="btn btn-dark btn-w-md" type="button">黑色按钮</button></td>-->
                        <#--<td><code>btn btn-dark</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-purple btn-w-md" type="button">紫色按钮</button></td>-->
                        <#--<td><code>btn btn-purple</code></td>-->
                        <#--<td><button class="btn btn-pink btn-w-md" type="button">粉红色按钮</button></td>-->
                        <#--<td><code>btn btn-pink</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-cyan btn-w-md" type="button">青色按钮</button></td>-->
                        <#--<td><code>btn btn-cyan</code></td>-->
                        <#--<td><button class="btn btn-yellow btn-w-md" type="button">黄色按钮</button></td>-->
                        <#--<td><code>btn btn-yellow</code></td>-->
                      <#--</tr>-->
                      <#--<tr>-->
                        <#--<td><button class="btn btn-brown btn-w-md" type="button">棕色按钮</button></td>-->
                        <#--<td><code>btn btn-brown</code></td>-->
                        <#--<td><button class="btn btn-link" type="button">链接形式</button></td>-->
                        <#--<td><code>btn btn-link</code></td>-->
                      <#--</tr>-->
                    <#--</tbody>-->
                  </table>
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