<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>教师中心-学生管理</title>
<link rel="icon" href="/statics/favicon.ico" type="image/ico">
<meta name="keywords" content="Defend的后台管理">
<meta name="author" content="YSJ">
<link href="/statics/css/bootstrap.min.css" rel="stylesheet">
<link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
<link href="/statics/css/style.min.css" rel="stylesheet">
<script type="text/javascript" src="/statics/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(function () {
        $(".pagination li").click(function () {
            $(".pagination li").removeClass("active");
            $(this).addClass('active');
        })
    });
</script>
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
              <div class="card-header"><h4>学生信息</h4></div>
                <div class="card-toolbar clearfix">
                    <form class="well form-search form-horizontal" method="POST" action="/teacher/manageStudent">
                        <div class="container">
                            <div class="form-group">
                                <label class="col-xs-2" id="name-input">姓名</label>
                                <div class="col-xs-2">
                                    <input class="form-control input-sm " type="text" id="input-small" name="stuname" placeholder="请输入姓名">
                                </div>
                                <label class="col-xs-2" id="class-input">班级</label>
                                <div class="col-xs-2">
                                    <select class="form-control" id="select" name="stuclass" size="1  ">
                                        <option value="0">全部</option>
                                        <option value="1">1班</option>
                                        <option value="2">2班</option>
                                        <option value="6">6班</option>
                                    </select>
                                </div>
                                <input type="submit" class="btn btn-primary" value="搜索" />
                                <a class="btn btn-danger" href="/teacher/manageStudent?pageNum=1&pageSize=1">返回</a>
                            </div>
                            <div class="form-group">

                            </div>
                        </div>
                    </form>
                <#--<div class="toolbar-btn-action">-->
                <#--<a class="btn btn-primary m-r-5" href="/teacher/manageStudent?pageNum=1&pageSize=1"><i class="mdi mdi-plus"></i>返回</a>-->
                <#--<a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>-->
                <#--<a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>-->
                <#--<a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>-->
                <#--</div>-->
                </div>

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
                        <th class="w-5">状态</th>
                      </tr>
                    </thead>
                    <tbody>

                        <#assign count=0>
                        <#list pageInfo.list as stu>
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
                                <td><font class="text-success">正常</font></td>
                            </tr>
                        </#list>
                    </tbody>
                  </table>
                    <#--<a href="/teacher/manageStudent?pageNum=2&pageSize=1">下一页</a>-->
                    <nav>
                        <ul class="pagination pagination-circle">
                            <#--返回第一页-->
                            <#if pageInfo.isFirstPage>
                                <li class="disabled">
                                    <a href="#!">
                                        <span><i class="mdi mdi-chevron-left"></i></span>
                                    </a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/teacher/manageStudent?pageNum=${pageInfo.firstPage}&pageSize=1">
                                        <span><i class="mdi mdi-chevron-left"></i></span>
                                    </a>
                                </li>
                            </#if>

                            <#if (pageInfo.pages == 0)>
                                <li class="active disabled" ><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==1)>
                                <li class="active disabled" ><a href="#!">1</a></li>
                            <#elseif (pageInfo.pages==2)>
                                <li class="active"><a href="/teacher/manageStudent?pageNum=1&pageSize=1">1</a></li>
                                <li><a href="/teacher/manageStudent?pageNum=2&pageSize=1">2</a></li>
                            <#elseif (pageInfo.pages == 3)>
                                <li class="active"><a href="/teacher/manageStudent?pageNum=1&pageSize=1">1</a></li>
                                <li><a href="#!"></a></li>
                                <li><a href="/teacher/manageStudent?pageNum=2&pageSize=1">2</a></li>
                                <li><a href="/teacher/manageStudent?pageNum=3&pageSize=1">3</a></li>
                            <#else>
                                <#if pageInfo.isFirstPage>
                                    <li class="active"><a href="/teacher/manageStudent?pageNum=1&pageSize=1">1</a></li>
                                    <li><a href="/teacher/manageStudent?pageNum=2&pageSize=1">2</a></li>
                                    <li><a href="/teacher/manageStudent?pageNum=3&pageSize=1">3</a></li>
                                <#else>
                                    <#if pageInfo.hasPreviousPage>
                                        <li><a href="/teacher/manageStudent?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage}</a></li>
                                    <#else>
                                        <li><a href="#!">${pageInfo.pageNum}</a></li>
                                    </#if>
                                    <li class="active"><a href="/teacher/manageStudent?pageNum=2&pageSize=1">${pageInfo.pageNum}</a></li>
                                    <#if pageInfo.hasNextPage>
                                        <li><a href="/teacher/manageStudent?pageNum=${pageInfo.nextPage}&pageSize=1">${pageInfo.nextPage}</a></li>
                                    <#else>
                                        <#--<li><a href="/teacher/manageStudent?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage - 1}</a></li>-->
                                        <#--<li><a href="/teacher/manageStudent?pageNum=${pageInfo.prePage}&pageSize=1">${pageInfo.prePage}</a></li>-->
                                        <#--<li><a href="#!">${pageInfo.pageNum}</a></li>-->
                                    </#if>
                                </#if>
                            </#if>

                            <#--去到最后一页-->
                            <#if pageInfo.isLastPage>
                                <li class="disabled">
                                    <a href="#!">
                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                    </a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/teacher/manageStudent?pageNum=${pageInfo.lastPage}&pageSize=1">
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
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
</body>
</html>