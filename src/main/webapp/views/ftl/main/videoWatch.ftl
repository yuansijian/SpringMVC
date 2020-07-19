<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
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

                        <div class="tab-pane active">
                            <div class="col-sm-push-12">
                                <div class="card">
                                    <div class="card-header">
                                        <a href="javascript:history.go(-1)"><h4>返回</h4></a>
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
                                    <div class="card-body">
                                        <video width="780" height="585" controls>
                                            <source src="/statics/video/${video.vname}" type="video/mp4">
                                            <source src="movie.ogg" type="video/ogg">
                                        </video>
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