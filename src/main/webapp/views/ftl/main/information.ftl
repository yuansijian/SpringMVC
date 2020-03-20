<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>个人信息</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Defend">
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
    <script>
        function out() {
            if(confirm("确定退出吗"))
            {
                $.ajax({
                    type: "POST",
                    url: "/main/logout",
                    success:function (data) {
                        if(data === 1)
                        {
                            window.location.replace("http://localhost:8080/");
                        }
                    }
                })
            }
        }
        function see() {
            // $(this).addClass("actives").siblings().removeClass("actives");
            let html = "<iframe  frameborder=\"0\" scrolling=\"yes\" style=\"width: 800px; height: 500px\" src=\" /main/news/${student.username} \" id=\"aa\"></iframe>\n";
            $("#look").remove();
            let html1 = "<button   class=\"btn btn-primary\" type=\"button\" onclick='closePage()'>关闭消息</button>\n";
            $("#ifpage").append(html1);
            $("#ifpage").append(html);
        }
        function closePage () { window.location.reload() }
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
                            <li> <a href="/main/index">图文教学</a> </li>
                            <li><a href="#!">视频教学</a> </li>
                            <li><a href="/main/practice">练习中心</a></li>
                            <li><a href="/main/resource">资源中心</a> </li>
                            <li> <a href="/main/message">留言</a></li>
                            <li><a href="/main/homework">作业中心</a> </li>
                            <li class="active"><a href="">个人中心</a> </li>
                        </ul>
                        <div class="tab-pane active">
                            <div class="card-body">
                                <form method="post" action="/main/changePhoto" enctype="multipart/form-data">
                                    <div class="edit-avatar">

                                        <input type="hidden" class="form-control" name="id" id="id" value="${student.id}" >
                                        <div>
                                            <input type="file" name="imageURL">
                                            <img src="/statics/studentHeader/${student.getImageurl()}"  alt="..." class="img-avatar">
                                        </div>
                                        <div class="avatar-divider"></div>
                                        <div class="edit-avatar-content" id="ifpage">
                                            <button class="btn btn-default" type="submit">修改头像</button>
                                            <button class="btn btn-danger" onclick="out()">退出</button>
                                            <p class="m-0">选择一张你喜欢的图片，裁剪后会自动生成264x264大小，上传图片大小不能超过2M。</p>
                                            <button id="look"  class="btn btn-primary" type="button" onclick="see()">
                                                查看消息 <span class="badge">4</span>
                                            </button>
                                        </div>
                                    </div>
                                    <hr>
                                </form>
                                <form method="post" action="/main/updateProfile" class="site-form">
                                    <input name="id" type="hidden" value="${student.id}">
                                    <div class="form-group">
                                        <label for="nickname">用户名</label>
                                        <input type="text" class="form-control" name="username" id="username" value="${student.username}">
                                    </div>
                                    <div class="form-group">
                                        <label for="stunumber">学号</label>
                                        <input type="text" class="form-control" name="stunumber" id="stunumber" value="${student.stunumber}">
                                    </div>
                                    <div class="form-group">
                                        <label for="grade">年级班级</label>
                                        <input type="text" class="form-control" name="grade" id="grade" value="${student.grade}" disabled>
                                    </div>
                                    <div class="form-group">
                                        <label for="stumail">邮箱</label>
                                        <input type="email" class="form-control" name="stumail" id="stumail" aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址" value="${student.stumail}">
                                        <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="stuphone">电话号码</label>
                                        <input type="text" class="form-control" name="stuphone" id="stuphone" aria-describedby="phoneHelp" placeholder="请输入正确的电话号码" value="${student.stuphone}">
                                        <small id="phoneHelp" class="form-text text-muted">请保证您填写的电话号码是正确的。</small>
                                    </div>
                                    <button type="submit" class="btn btn-primary">保存</button>
                                </form>



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