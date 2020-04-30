<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>用户管理 - 后台管理系统</title>
<link rel="icon" href="/statics/favicon.ico" type="image/ico">
<meta name="author" content="Yuan Sijian">
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
                          <div class="card-header"><h4>学生信息</h4></div>
                          <div class="card-body">
                              <div class="card-toolbar clearfix">
                                  <form class="well form-search" method="POST" action="">
                                      姓名：
                                      <input type="text" name="user_login" style="width: 100px;"  placeholder="">
                                      &nbsp;&nbsp;
                                  <#--班级：-->
                                  <#--<input type="text" name="store_id" style="width: 100px;"  placeholder="">-->
                                  <#--&nbsp;&nbsp;-->

                                      注册时间：
                                      <input type="text" name="user_nicename" style="width: 150px;" placeholder="">
                                      &nbsp;&nbsp;
                                      注册时间：
                                      <input type="text" name="user_nicename" style="width: 150px;" placeholder="">
                                      <input type="submit" class="btn btn-primary" value="搜索" />
                                      <a class="btn btn-danger" href="">清空</a>
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
                                              <th>学生姓名</th>
                                              <th>用户名</th>
                                              <th>年级</th>
                                              <th>班级</th>
                                              <th>电话号码</th>
                                              <th>邮箱</th>
                                              <th>登录次数</th>
                                              <th>性别</th>
                                              <th>最近登录时间</th>
                                              <th>最近下线时间</th>
                                              <th>注册时间</th>
                                              <th>状态</th>
                                              <th>操作</th>
                                          </tr>
                                          </thead>
                                          <tbody>
                                      <#list studentList as student>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="1"><span></span>
                                              </label>
                                          </td>
                                          <td>${student.id}</td>
                                          <td>${student.stuname}</td>
                                          <td>${student.username}</td>
                                          <td>${student.grade}</td>
                                          <td>${student.class1}</td>
                                          <td>${student.stuphone}</td>
                                          <td>${student.stumail}</td>
                                          <td>${student.loginnumber}</td>
                                          <td>${student.sex}</td>
                                          <td>${student.logintime}</td>
                                          <td>${student.endtime}</td>
                                          <td>${student.registeredtime}</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      </#list>
                                          </tbody>
                                      </table>
                                  </div>
                                  <ul class="pagination">
                                      <li class="disabled"><span>«</span></li>
                                      <li class="active"><span>1</span></li>
                                      <li><a href="#1">2</a></li>
                                      <li><a href="#1">3</a></li>
                                      <li><a href="#1">4</a></li>
                                      <li><a href="#1">5</a></li>
                                      <li><a href="#1">6</a></li>
                                      <li><a href="#1">7</a></li>
                                      <li><a href="#1">8</a></li>
                                      <li class="disabled"><span>...</span></li>
                                      <li><a href="#!">14452</a></li>
                                      <li><a href="#!">14453</a></li>
                                      <li><a href="#!">»</a></li>
                                  </ul>

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