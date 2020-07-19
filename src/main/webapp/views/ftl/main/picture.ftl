<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>图文教学</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="description" content="态势语后台管理系统">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #fff;
        }

        .error-page {
            height: 100%;
            position: fixed;
            width: 100%;
        }

        .error-body {
            padding-top: 5%;
        }

        .error-body h1 {
            font-size: 210px;
            font-weight: 700;
            text-shadow: 4px 4px 0 #f5f6fa, 6px 6px 0 #33cabb;
            line-height: 210px;
            color: #33cabb;
        }

        .error-body h4 {
            margin: 30px 0px;
        }
    </style>

</head>

<body>
<section class="error-page">
    <div class="error-box">
        <div class="error-body text-center" id="content1" style="height: 100%">
        <#--<img src="/statics/pictureTeacher/2.jpg" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/4.jpg" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/3.png" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/fig5.png" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/fig5.png" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/fig5.png" style="height: 400px; width: 300px">-->
        <#--<img src="/statics/pictureTeacher/fig5.png" style="height: 400px; width: 300px">-->

        </div>

        <textarea
                style="border:0;border-radius:5px;background-color:rgba(241,241,241,.98);width: 100%;height: 120px;padding: 10px;resize: none;">${pictureTeacher.world}</textarea>
    <#--<nav class="page">-->
    <#--<ul class="pager">-->
    <#--&lt;#&ndash;返回上一页&ndash;&gt;-->
    <#--<#if pageInfo.isFirstPage>-->
    <#--<li class="disabled">-->
    <#--<a  href="#">上一条</a>-->
    <#--</li>-->
    <#--<#elseif pageInfo.hasPreviousPage>-->
    <#--<li>-->
    <#--<a href="/main/index?pageNum=${pageInfo.prePage}">-->
    <#--上一条-->
    <#--</a>-->
    <#--</li>-->
    <#--</#if>-->
    <#--&lt;#&ndash;下一页&ndash;&gt;-->
    <#--<#if pageInfo.isLastPage>-->
    <#--<li class="disabled">-->
    <#--<a  href="#">下一条</a>-->
    <#--</li>-->
    <#--<#elseif pageInfo.hasNextPage>-->
    <#--<li>-->
    <#--<a href="/main/index?pageNum=${pageInfo.nextPage}">-->
    <#--下一条-->
    <#--</a>-->
    <#--</li>-->
    <#--</#if>-->
    <#--&lt;#&ndash;<li><a  href="#">上一条</a></li>&ndash;&gt;-->
    <#--&lt;#&ndash;<li><a  href="">下一条</a></li>&ndash;&gt;-->
    <#--</ul>-->
    <#--</nav>-->

    </div>
</section>
<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
            <#list pictures as picture>
                $("#content1").append("<img src=\"/statics/pictureTeacher/${picture}\" style=\"height: 400px; width: 300px\">\n");
            </#list>
    })
</script>
</body>
</html>