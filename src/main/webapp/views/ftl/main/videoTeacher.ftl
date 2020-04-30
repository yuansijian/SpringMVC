<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>视频教学</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">

        <div class="container-fluid">

            <div class="row">

                <div class="col-lg-12">
                    <div class="card">
                        <ul class="nav nav-tabs page-tabs">
                            <li > <a href="/main/index">图文教学</a> </li>
                            <li class="active"><a href="#!">视频教学</a> </li>
                            <li><a href="/main/practice">练习中心</a></li>
                            <li><a href="/main/resource">资源中心</a> </li>
                            <li> <a href="/main/message">留言</a></li>
                            <li><a href="/main/homework">作业中心</a> </li>
                            <li><a href="/main/information">个人中心</a> </li>
                        </ul>

                        <div class="tab-pane active">
                            <div class="col-sm-push-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>视频教学</h4>
                                    <#--<ul class="card-actions">-->
                                    <#--<li>-->
                                    <#--<button type="button" data-toggle="tooltip" title="撤消"><i class="mdi mdi-undo"></i></button>-->
                                    <#--</li>-->
                                    <#--<li>-->
                                    <#--<button type="button" data-toggle="tooltip" title="重做"><i class="mdi mdi-redo"></i></button>-->
                                    <#--</li>-->
                                    <#--<li>-->
                                    <#--<button type="button" data-toggle="tooltip" title="修改"><i class="mdi mdi-pencil"></i></button>-->
                                    <#--</li>-->
                                    <#--<li class="dropdown">-->
                                    <#--<button type="button" data-toggle="dropdown">更多 <span class="caret"></span></button>-->
                                    <#--<ul class="dropdown-menu dropdown-menu-right">-->
                                    <#--<li> <a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">3</span> 通知</a> </li>-->
                                    <#--<li> <a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">1</span> 消息</a> </li>-->
                                    <#--<li class="divider"></li>-->
                                    <#--<li> <a tabindex="-1" href="javascript:void(0)">更新个人信息</a> </li>-->
                                    <#--</ul>-->
                                    <#--</li>-->
                                    <#--</ul>-->
                                        <!-- .card-actions -->
                                    </div>
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-toolbar clearfix">
                                                <form class="well form-search" method="POST" action="/main/videoTeacher">
                                                    视频名称：
                                                    <input type="text" name="vname" style="width: 100px;"  placeholder="">
                                                    &nbsp;&nbsp;

                                                    &nbsp;&nbsp;
                                                    <input type="submit" class="btn btn-primary" value="搜索" />
                                                    <a class="btn btn-danger" href="/main/videoTeacher">返回</a>
                                                </form>
                                            </div>
                                            <div class="card-body">

                                                <div class="table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>编号</th>
                                                            <th>文件名</th>
                                                            <th>文件描述</th>
                                                            <th>文件大小</th>
                                                            <th>上传作者</th>
                                                            <th>状态</th>
                                                            <th>操作</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                                              <#list pageInfo.list as uploadfile>
                                                                              <tr>
                                                                                  <td >${uploadfile.id}</td>
                                                                                  <td>${uploadfile.vname}</td>
                                                                                  <td>${uploadfile.description}</td>
                                                                                  <td>${uploadfile.vsizes}Kb</td>
                                                                                  <td>${uploadfile.author}</td>
                                                                                  <td><font class="text-success">正常</font></td>
                                                                                  <td>
                                                                                      <div class="btn-group">
                                                                                          <a class="btn btn-xs btn-default" href="/main/videoWatch/${uploadfile.id}" title="观看" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                                                                                          <a class="btn btn-xs btn-default" href="/statics/video/${uploadfile.vname}" download="${uploadfile.vname}" title="下载" data-toggle="tooltip"><i class="mdi mdi-arrow-down-bold"></i></a>
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
                                          <#if pageInfo.isFirstPage>
                                            <li class="disabled">
                                                <a href="#!">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          <#else>
                                            <li>
                                                <a href="/community/videoTeacher?pageNum=${pageInfo.firstPage}&pageSize=10">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                          </#if>

                                        <#if (pageInfo.pages == 0)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (pageInfo.pages==1)>
                                            <li class="active disabled" ><a href="#!">1</a></li>
                                        <#elseif (pageInfo.pages==2)>
                                            <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="/community/videoTeacher?pageNum=2&pageSize=10">2</a></li>
                                        <#elseif (pageInfo.pages == 3)>
                                            <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=10">1</a></li>
                                            <li><a href="#!"></a></li>
                                            <li><a href="/community/videoTeacher?pageNum=2&pageSize=10">2</a></li>
                                            <li><a href="/community/videoTeacher?pageNum=3&pageSize=10">3</a></li>
                                        <#else>
                                            <#if pageInfo.isFirstPage>
                                                <li class="active"><a href="/community/videoTeacher?pageNum=1&pageSize=10">1</a></li>
                                                <li><a href="/community/videoTeacher?pageNum=2&pageSize=10">2</a></li>
                                                <li><a href="/community/videoTeacher?pageNum=3&pageSize=10">3</a></li>
                                            <#else>
                                                <#if pageInfo.hasPreviousPage>
                                                    <li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a></li>
                                                <#else>
                                                    <li><a href="#!">${pageInfo.pageNum}</a></li>
                                                </#if>
                                                <li class="active"><a href="/community/videoTeacher?pageNum=2&pageSize=10">${pageInfo.pageNum}</a></li>
                                                <#if pageInfo.hasNextPage>
                                                    <li><a href="/community/videoTeacher?pageNum=${pageInfo.nextPage}&pageSize=10">${pageInfo.nextPage}</a></li>
                                                <#else>
                                                <#--<li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage - 1}</a></li>-->
                                                <#--<li><a href="/community/videoTeacher?pageNum=${pageInfo.prePage}&pageSize=10">${pageInfo.prePage}</a></li>-->
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
                                                    <a href="/community/videoTeacher?pageNum=${pageInfo.lastPage}&pageSize=10">
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
                    </div>
                </div>

            </div>

        </div>

    </div>
</div>

<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/statics/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/statics/js/main.min.js"></script>
</body>
</html>