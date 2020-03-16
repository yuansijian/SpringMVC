<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>个人信息</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Defend">
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
                            <li> <a href="/main/index">图文教学</a> </li>
                            <li><a href="#!">视频教学</a> </li>
                            <li><a href="/main/resource">资源中心</a> </li>
                            <li> <a href="/main/message">留言</a></li>
                            <li><a href="/main/homework">作业中心</a> </li>
                            <li class="active"><a href="">个人中心</a> </li>
                        </ul>
                        <div class="tab-pane active">
                            <div class="card-body">
                                <form method="post" action="/user/changePhoto" enctype="multipart/form-data">
                                    <div class="edit-avatar">

                                        <input type="hidden" class="form-control" name="id" id="id"  >
                                        <div>
                                            <input type="file" name="imageURL">
                                            <img  alt="..." class="img-avatar">
                                        </div>
                                        <div class="avatar-divider"></div>
                                        <div class="edit-avatar-content">
                                            <button class="btn btn-default" type="submit">修改头像</button>
                                            <p class="m-0">选择一张你喜欢的图片，裁剪后会自动生成264x264大小，上传图片大小不能超过2M。</p>
                                        </div>
                                    </div>
                                    <hr>
                                </form>

                                <form method="post" action="/user/updateProfile" class="site-form">

                                    <div class="form-group">
                                        <label for="nickname">用户名</label>
                                        <input type="text" class="form-control" name="username" id="username">
                                    </div>
                                    <div class="form-group">
                                        <label for="stunumber">学号</label>
                                        <input type="text" class="form-control" name="stunumber" id="stunumber" value="">
                                    </div>
                                    <div class="form-group">
                                        <label for="grade">年级</label>
                                        <input type="text" class="form-control" name="grade" id="grade" >
                                    </div>
                                    <div class="form-group">
                                        <label for="class1">班级</label>
                                        <input type="text" class="form-control" name="class1" id="class1">
                                    </div>

                                    <div class="form-group">
                                        <label for="email">邮箱</label>
                                        <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址" >
                                        <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">电话号码</label>
                                        <input type="text" class="form-control" name="phone" id="phone" aria-describedby="phoneHelp" placeholder="请输入正确的邮箱地址">
                                        <small id="phoneHelp" class="form-text text-muted">请保证您填写的电话号码是正确的。</small>
                                    </div>
                                    <div class="form-group">
                                        <label class="sex" >性别</label>
                                        <select class="form-control" id="select" name="sex" size="1  ">
                                            <option value="0">女</option>
                                            <option  value="1">男</option>

                                        </select>
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