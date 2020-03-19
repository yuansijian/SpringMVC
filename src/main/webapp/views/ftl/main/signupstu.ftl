<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>注册</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Defend">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
    <script>
        function save() {
            $.ajax({
                type:"POST",
                url:"/main/saveStudent",
                data:$("#info").serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        alert("注册成功");
                    }
                    else
                    {
                        alert("注册失败");
                    }
                }
            })
        }
    </script>
</head>
<body>
<div class="card-body">
    <form  class="site-form" id="info">
        <div class="form-group">
            <label for="nickname">用户名</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="text" class="form-control" name="password" id="password" required>
        </div>
        <div class="form-group">
            <label for="stuname">学生姓名</label>
            <input type="text" class="form-control" name="stuname" id="stuname" required>
        </div>
        <div class="form-group">
            <label for="stunumber">学号</label>
            <input type="text" class="form-control" name="stunumber" id="stunumber" value="" required>
        </div>
        <div class="form-group">
            <label class="col-12" id="class-input">年级</label>
            <div class="col-12">
                <select class="form-control" id="select" name="grade" size="1  ">
                    <#--<option value="0">全部</option>-->
                        <#list gradeList as cl>
                            <script>
                                $("#select").append("<option value=\"${cl.grade}\">${cl.grade}</option>\n")
                            </script>
                        </#list>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" class="form-control" name="stumail" id="stumail" aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址" required>
            <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>
        </div>
        <div class="form-group">
            <label for="phone">电话号码</label>
            <input type="text" class="form-control" name="stuphone" id="stuphone" aria-describedby="phoneHelp" placeholder="请输入正确的邮箱地址" required>
            <small id="phoneHelp" class="form-text text-muted">请保证您填写的电话号码是正确的。</small>
        </div>
        <div class="form-group">
            <label class="sex" >性别</label>
            <select class="form-control" id="select" name="sex" size="1  ">
                <option value="0">女</option>
                <option  value="1">男</option>
            </select>
        </div>
        <button onclick="save()" type="button" class="btn btn-primary">保存</button>
    </form>

</div>
</body>
</html>