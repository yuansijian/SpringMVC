<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>作业管理</title>
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
                          <div class="card-toolbar clearfix">
                              <form class="well form-search" method="POST" action="">
                              年级：
                              <input type="text" name="user_login" style="width: 100px;"  placeholder="">
                              &nbsp;&nbsp;
                              班级：
                              <input type="text" name="store_id" style="width: 100px;"  placeholder="">
                              &nbsp;&nbsp;

                              作业时间：
                              <input type="text" name="user_nicename" style="width: 150px;" placeholder="">
                              &nbsp;&nbsp;
                              作业题目：
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
                                          <th>作业标题</th>
                                          <th>学生姓名</th>
                                          <th>作业链接</th>
                                          <th>状态</th>
                                          <th>操作</th>
                                      </tr>
                                      </thead>
                                      <tbody>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="1"><span></span>
                                              </label>
                                          </td>
                                          <td>1</td>
                                          <td>《倚天屠龙记》</td>
                                          <td>金庸</td>
                                          <td>36</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="2"><span></span>
                                              </label>
                                          </td>
                                          <td>2</td>
                                          <td>《书剑恩仇录》</td>
                                          <td>金庸</td>
                                          <td>44</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="3"><span></span>
                                              </label>
                                          </td>
                                          <td>3</td>
                                          <td>《湘行散记》</td>
                                          <td>沈从文</td>
                                          <td>39</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="4"><span></span>
                                              </label>
                                          </td>
                                          <td>4</td>
                                          <td>《诗三百：思无邪》</td>
                                          <td>安意如</td>
                                          <td>36</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="5"><span></span>
                                              </label>
                                          </td>
                                          <td>5</td>
                                          <td>《打开心内的窗》</td>
                                          <td>林清玄</td>
                                          <td>32</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="6"><span></span>
                                              </label>
                                          </td>
                                          <td>6</td>
                                          <td>楔子 一阕词来 南国清秋魂梦绕 十年人散 绣房红烛剑光寒</td>
                                          <td>梁羽生</td>
                                          <td>42</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="7"><span></span>
                                              </label>
                                          </td>
                                          <td>7</td>
                                          <td>《彷徨》</td>
                                          <td>鲁迅</td>
                                          <td>40</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="8"><span></span>
                                              </label>
                                          </td>
                                          <td>8</td>
                                          <td>《莫泊桑短篇小说集》</td>
                                          <td>莫泊桑</td>
                                          <td>36</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="9"><span></span>
                                              </label>
                                          </td>
                                          <td>9</td>
                                          <td>第一回 赈民饥包公奉旨　图谋害庞相施计</td>
                                          <td>李雨堂</td>
                                          <td>35</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="10"><span></span>
                                              </label>
                                          </td>
                                          <td>10</td>
                                          <td>第一回 于按察山东赴任　邹其仁赴路登程</td>
                                          <td>佚名</td>
                                          <td>37</td>
                                          <td><font class="text-success">正常</font></td>
                                          <td>
                                              <div class="btn-group">
                                                  <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
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