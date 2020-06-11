<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>登录</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>

    <style>
        .div{ margin:0 auto; width:400px; height:100%; }
    </style>
    <script>
        function submit1() {
            let username = $("#id_username").val();
            let password = $("#id_password").val();

            if(username.length === 0)
            {
                alert("用户名不能为空")
            }
            if(password.length === 0)
            {
                alert("密码不能为空")
            }

            $.ajax({
                type: "POST",
                url: "/main/login",
                data: $("#form1").serialize(),
                success: function (data) {
                    console.log(data);

                    if(data === 1)
                    {
                        window.location.replace("/main/index")
                    }
                    else
                    {
                        alert("账号或密码错误")
                    }
                },
                error: function () {
                    alert("登录失败,账号或密码错误")
                }
            })
        }
    </script>
    <script>
        $(document).ready(function () {
            if(${b} == 1)
            {
                alert("登录过期，请重新登录");
            }
        })
    </script>
</head>
<body>
<div class="container" style="width: 100%">
    <h1 class="text-center logo my-4">
        <a href="">态势语教学</a>
    </h1>

    <div class="div" >
        <div class="col-12">
            <div class="card">
                <div class="card-body" >
                    <h3 class="card-title">登录</h3>
                    <form id="form1">
                        <div class="form-group">
                            <label for="id_username">用户名:</label>
                            <input type="text" name="username" placeholder="请输入用户名" autofocus="" class="form-control " id="id_username">
                        </div>
                        <div class="form-group">
                            <label for="id_password">密码:</label>
                            <input type="password" name="password" placeholder="请输入密码" class="form-control " id="id_password">
                        </div>
                        <button onclick="submit1()" class="btn btn-primary btn-block" id="submit" type="button">登录</button>
                    </form>
                </div>
                <div class="card-footer text-muted text-center">
                    新用户? <a href="/main/signupstu">学生注册</a> or <a href="/main/signuptea">教师注册</a>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>