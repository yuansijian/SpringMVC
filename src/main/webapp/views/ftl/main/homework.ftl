<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>资源中心</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
    <script>
        function save3(id) {
            let formData = new FormData($("#upload-file" + id)[0]);
            $.ajax({
                type: "POST",
                url: "/main/saveHomework/" + id,
                data: formData,
                contentType: false,
                processData: false,

                success: function (data) {
                    console.log(data);
                    console.log(222);
                    if (data === 1) {
                        alert("上传成功");
                        location.reload();
                    }
                    else if (data === 202) {
                        alert("文件大于200M")
                    }
                    else if (data === 303) {
                        alert("文件格式不对")
                    }
                    else {
                        alert("上传失败,刷新或重命名试试")
                    }
                }
            })
        }
    </script>
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">

        <div class="container-fluid">

            <div class="row">

                <div class="col-lg-12">
                    <div class="card">
                        <ul class="nav nav-tabs page-tabs">
                            <li><a href="/main/index">图文教学</a></li>
                            <li><a href="/main/videoTeacher">视频教学</a></li>
                            <li><a href="/main/practice">练习中心</a></li>
                            <li><a href="/main/resource">资源中心</a></li>
                            <li><a href="/main/message">留言</a></li>
                            <li class="active"><a href="">作业中心</a></li>
                            <li><a href="/main/information">个人中心</a></li>
                        </ul>
                        <div class="tab-pane active">
                            <h5>作业布置</h5>
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>作业名称</th>
                                    <th>作者</th>
                                    <th>开始时间</th>
                                    <th>截止时间</th>
                                    <th>上传</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list pageInfo.list as list>
                                        <tr>
                                            <th scope="row">${list.id}</th>
                                            <td data-toggle="tooltip" data-placement="left"
                                                title="${list.description}">${list.title}</td>
                                            <td>${list.author}</td>
                                            <td>${list.starttime}</td>
                                            <td>${list.endtime}</td>
                                            <td>
                                                <form id="upload-file${list.id}" enctype="multipart/form-data">
                                                    <input type="file" id="file" name="file" value="">
                                                    <input type="hidden" name="title" value="${list.title}">
                                                    <a href="#" onclick="save3(${list.id})">提交</a>
                                                </form>

                                            </td>
                                        </tr>
                                    </#list>
                                <#--<tr>-->
                                <#--<th scope="row">1</th>-->
                                <#--<td>康复的家庭</td>-->
                                <#--<td>大江健三郎</td>-->
                                <#--<td>散文随笔</td>-->
                                <#--</tr>-->
                                <#--<tr>-->
                                <#--<th scope="row">2</th>-->
                                <#--<td>名侦探的规条</td>-->
                                <#--<td>东野圭吾</td>-->
                                <#--<td>悬疑小说</td>-->
                                <#--</tr>-->
                                <#--<tr>-->
                                <#--<th scope="row">3</th>-->
                                <#--<td>天才相师</td>-->
                                <#--<td>打眼</td>-->
                                <#--<td>都市小说</td>-->
                                <#--</tr>-->
                                </tbody>
                            </table>
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