<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>学生信息 - 后台管理系统</title>
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
              <div class="card-header"><h4>学生信息</h4></div>
              <div class="card-body">
                  <div class="card-toolbar clearfix">
                      <form class="well form-search" method="POST" action="">
                          姓名：
                          <input type="text" name="stuname" style="width: 100px;"  placeholder="">
                          &nbsp;&nbsp;
                          班级：
                          <input type="text" name="stuclass" style="width: 100px;"  placeholder="">
                          &nbsp;&nbsp;

                          注册时间：
                          <input type="text" name="registeredStartTime" style="width: 150px;" placeholder="">
                          &nbsp;&nbsp;
                          注册时间：
                          <input type="text" name="registeredEndTime" style="width: 150px;" placeholder="">
                          <input type="submit" class="btn btn-primary" value="搜索" />
                          <a class="btn btn-danger" href="/user/studentInformation?pageNum=1&pageSize=1">返回</a>
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
                                  <th>姓名</th>
                                  <th>用户名</th>
                                  <th>年级</th>
                                  <th>班级</th>
                                  <th>电话号码</th>
                                  <th>邮箱</th>
                                  <th>登录次数</th>
                                  <th>性别</th>
                                  <th>登录时间</th>
                                  <th>下线时间</th>
                                  <th>注册时间</th>
                                  <th>状态</th>
                                  <th>操作</th>
                              </tr>
                              </thead>
                              <tbody>
                                      <#list studentList.list as student>
                                      <tr>
                                          <td>
                                              <label class="lyear-checkbox checkbox-primary">
                                                  <input type="checkbox" name="ids[]" value="1"><span></span>
                                              </label>
                                          </td>
                                          <td >${student.id}</td>
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
                                                  <a class="btn btn-xs btn-default" href="/user/editStudentInfo/${student.id}" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                  <a class="btn btn-xs btn-default" href="/user/deleteStudent/${student.id}" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                                              </div>
                                          </td>
                                      </tr>
                                      </#list>
                              </tbody>
                          </table>
                      </div>
                      <nav>
                          <ul class="pagination pagination-circle">
                          <#--返回第一页-->
                                          <#if studentList.isFirstPage>
                                            <li class="disabled">
                                                <a href="#!">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          <#else>
                                            <li>
                                                <a href="/user/studentInformation?pageNum=${studentList.firstPage}&pageSize=1">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          </#if>

                                        <#if (studentList.pages == 0)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (studentList.pages==1)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (studentList.pages==2)>
                                            <li class="active"><a href="/user/studentInformation?pageNum=1&pageSize=1">1</a></li>
                                            <li><a href="/user/studentInformation?pageNum=2&pageSize=1">2</a></li>
                                        <#elseif (studentList.pages == 3)>
                                            <li class="active"><a href="/user/studentInformation?pageNum=1&pageSize=1">1</a></li>
                                            <li><a href="#!"></a></li>
                                            <li><a href="/user/studentInformation?pageNum=2&pageSize=1">2</a></li>
                                            <li><a href="/user/studentInformation?pageNum=3&pageSize=1">3</a></li>
                                        <#else>
                                            <#if studentList.isFirstPage>
                                                <li class="active"><a href="/user/studentInformation?pageNum=1&pageSize=1">1</a></li>
                                                <li><a href="/user/studentInformation?pageNum=2&pageSize=1">2</a></li>
                                                <li><a href="/user/studentInformation?pageNum=3&pageSize=1">3</a></li>
                                            <#else>
                                                <#if studentList.hasPreviousPage>
                                                    <li><a href="/user/studentInformation?pageNum=${studentList.prePage}&pageSize=1">${studentList.prePage}</a></li>
                                                <#else>
                                                    <li><a href="#!">${studentList.pageNum}</a></li>
                                                </#if>
                                                <li class="active"><a href="/user/studentInformation?pageNum=2&pageSize=1">${studentList.pageNum}</a></li>
                                                <#if studentList.hasNextPage>
                                                    <li><a href="/user/studentInformation?pageNum=${studentList.nextPage}&pageSize=1">${studentList.nextPage}</a></li>
                                                <#else>
                                                <#--<li><a href="/user/studentInformation?pageNum=${studentList.prePage}&pageSize=1">${studentList.prePage - 1}</a></li>-->
                                                <#--<li><a href="/user/studentInformation?pageNum=${studentList.prePage}&pageSize=1">${studentList.prePage}</a></li>-->
                                                <#--<li><a href="#!">${studentList.pageNum}</a></li>-->
                                                </#if>
                                            </#if>
                                        </#if>

                          <#--去到最后一页-->
                                          <#if studentList.isLastPage>
                                                <li class="disabled">
                                                    <a href="#!">
                                                        <span><i class="mdi mdi-chevron-right"></i></span>
                                                    </a>
                                                </li>
                                          <#else>
                                                <li>
                                                    <a href="/user/studentInformation?pageNum=${studentList.lastPage}&pageSize=1">
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