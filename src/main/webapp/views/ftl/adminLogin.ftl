<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>登录 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <style>
        .lyear-wrapper {
            position: relative;
        }
        .lyear-login {
            display: flex !important;
            min-height: 100vh;
            align-items: center !important;
            justify-content: center !important;
        }
        .login-center {
            background: #fff;
            min-width: 38.25rem;
            padding: 2.14286em 3.57143em;
            border-radius: 5px;
            margin: 2.85714em 0;
        }
        .login-header {
            margin-bottom: 1.5rem !important;
        }
        .login-center .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
        }
        .login-center .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }
        .login-center .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
    </style>
    <script>
        function login() {
            let username = $("#username").val();
            let password = $("#password").val();

            if(username.length === 0)
            {
                alert("用户民不能为空");
                
                return;
            }
            if(password.length === 0)
            {
                alert("密码不能为空");
                return;
            }
            
            $.ajax({
                type: "POST",
                url: "/redirect",
                data: $("#form1").serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        window.location.replace("/index")
                    }
                    else
                    {
                        alert("账号或密码错误");
                    }
                },
                error: function () {
                    alert("账号或密码错误1");
                }
            })
            
        }
    </script>
</head>

<body>
<div class="row lyear-wrapper">
    <div class="lyear-login">
        <div class="login-center">
            <div class="login-header text-center">
                <a > <img alt="light year admin" src="/statics/images/下载.png"> </a>
            </div>
            <form id="form1">
                <label for="id_username">用户名:</label>
                <div class="form-group has-feedback feedback-left">
                    <input type="text" placeholder="请输入您的用户名" class="form-control" name="username" id="username" required="required"/>
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <label for="id_username">密码:</label>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password" required="required"/>
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <#--<div class="form-group has-feedback feedback-left row">-->
                    <#--<div class="col-xs-7">-->
                        <#--<input type="text" name="captcha" class="form-control" placeholder="验证码">-->
                        <#--<span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>-->
                    <#--</div>-->
                    <#--<div class="col-xs-5">-->
                        <#--<img src="/statics/images/captcha.png" class="pull-right" id="captcha" style="cursor: pointer;" onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">-->
                    <#--</div>-->
                <#--</div>-->
                <div class="form-group">
                    <button class="btn btn-block btn-primary" type="button" onclick="login()">立即登录</button>
                </div>
            </form>
            <hr>
            <footer class="col-sm-12 text-center">
                <p class="m-b-0">Copyright © 2019 <a href="https://yuansijian.github.io/">Yuan Sijian</a>. All right reserved</p>
            </footer>
        </div>
    </div>
</div>
<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script type="text/javascript">;</script>
</body>
</html>