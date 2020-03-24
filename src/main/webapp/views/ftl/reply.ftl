<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>留言回复</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="description" content="态势语后台管理系统">
    <meta name="author" content="Defend">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script>
        function save2() {
            $.ajax({
                type: "POST",
                url: "/community/addReply",
                data: $("#reply").serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        alert("回复成功");
                    }
                    else
                    {
                        alert("回复失败");
                    }
                }

            })
        }
    </script>
</head>

<body>
<div id="answer1">
    <form id="reply" action="" method="post">
        <div class="form-group">
            <div class="col-12">
                <textarea class="form-control" id="res" name="content" rows="6" placeholder="回复..."></textarea>
                <input type="hidden" name="parentid" value="${parentid}">
                <input type="hidden" name="parentname" value="${parentname}">
                <input class='btn btn-primary' type='button' onclick='save2()' value='发布'>&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
</body>
</html>