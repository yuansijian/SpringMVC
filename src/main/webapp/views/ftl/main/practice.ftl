<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>练习中心</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>

    <script>
        function change1(id) {
            let value = "value" + id;
            console.log(value);
            let address = $("#" + value).attr("data-src");
            address = address + id;
            // $(this).addClass("actives").siblings().removeClass("actives");
            $("#" + value).addClass("actives").siblings().removeClass("actives");
            $("iframe").attr("src", address);
        }

        function nex() {
            let id = $("ul .actives").val();
            console.log(id);
            console.log(${pageInfo.pageNum*25-25+1});
            if (id === ${pageInfo.pageNum*25}) {
                $("#goPage span").click();
                return;
            }
            id = id + 1;
            change1(id);
        }

        function pre() {
            let id = $("ul .actives").val();
            id = id - 1;
            let href = "/main/practice&pageNum=${pageInfo.prePage}&id=" + id;
            console.log(href);
            console.log(id);
            console.log(${pageInfo.pageNum*25}-24);
            if (id === ${pageInfo.pageNum*25}-25) {
                $("#goPage1").attr("href", href);
                $("#goPage1 span").click();
                return;
            }
            change1(id);
        }


    </script>
    <script>
        $(document).ready(function () {
            console.log(${ids});
            if (${ids} !==
            0
        )
            {
                let id = ${ids}
                        $("#value" + id).addClass("actives");
                <#assign ids=0>

            }
        else
            {
                let id = ${pageInfo.pageNum*25-25+1}
                        $("#value" + id).addClass("actives");
                <#assign ids=0>

            }

        })
    </script>
    <style>
        .main_left {
            width: 150px;
            height: 100%;
            float: left;
            background: #c0c0c0;
            cursor: pointer;
        }

        .actives {
            color: #ffffff;
            background: #c81623;
        }

        .main_right {
            width: 100%;
            height: 630px;
        }

        .page {
            height: 100px;
        }
    </style>
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
                            <li class="active"><a href="#!">练习中心</a></li>
                            <li><a href="/main/resource">资源中心</a></li>
                            <li><a href="/main/message">留言</a></li>
                            <li><a href="/main/homework">作业中心</a></li>
                            <li><a href="/main/information">个人中心</a></li>
                        </ul>
                        <div class="tab-pane active">
                            <!-- 左侧导航 -->
                            <div class="main_left">
                                <ul id="menu" class="nav nav-pills nav-stacked">
                                    <#assign id=0>
                                    <#list pageInfo.list as li>
                                    <#--onclick="change1(${li.id})"-->

                                        <li onclick="change1(${li.id})" value="${li.id}" data-src="/main/practiceText/"
                                            id="value${li.id}">${li.title}</li>
                                    </#list>
                                </ul>

                                <nav>
                                    <ul class="pagination pagination-circle">
                                    <#--返回上一页-->
                                        <#if pageInfo.isFirstPage>
                                            <li class="disabled">
                                                <a href="#!">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                        <#elseif pageInfo.hasPreviousPage>
                                            <li>
                                                <a id="goPage1" href="/main/practice&pageNum=${pageInfo.prePage}&id=0">
                                                    <span><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                        </#if>
                                    <#--下一页-->
                                        <#if pageInfo.isLastPage>
                                            <li class="disabled">
                                                <span><i class="mdi mdi-chevron-right"></i></span>
                                            </li>
                                        <#elseif pageInfo.hasNextPage>
                                            <li>
                                                <a id="goPage" href="/main/practice?pageNum=${pageInfo.nextPage}">
                                                    <span><i class="mdi mdi-chevron-right"></i></span>
                                                </a>
                                            </li>
                                        </#if>
                                    </ul>
                                </nav>
                            </div>
                            <!-- 右侧内容 -->
                            <div class="main_right">
                                <#assign x = pageInfo.pageNum*25-25+4>
                                <input hidden value="${pageInfo.pageNum}">
                                <iframe frameborder="0" scrolling="yes" style="width: 1325px; height: 100%"
                                        src="/main/practiceText/${x}" id="aa"></iframe>
                            </div>
                            <nav class="page">
                                <ul class="pager">
                                <#--返回上一页-->
                                    <li>
                                        <a id="pre" onclick="pre()" href="#!">
                                            上一条
                                        </a>
                                    </li>
                                <#--<#if (pageInfo.isFirstPage) && {pageInfo}>-->
                                <#--<li class="disabled">-->
                                <#--<a  href="#">上一条</a>-->
                                <#--</li>-->
                                <#--<#else>-->
                                <#--<li >-->
                                <#--<a id="pre" onclick="pre()" href="/main/index?pageNum=${pageInfo.prePage}">-->
                                <#--上一条-->
                                <#--</a>-->
                                <#--</li>-->
                                <#--</#if>-->
                                <#--下一页-->
                                    <li>
                                        <a id="nex" onclick="nex()" href="#!">
                                            下一条
                                        </a>
                                    </li>
                                <#--<#if pageInfo.isLastPage>-->
                                <#--<li class="disabled">-->
                                <#--<a  href="#">下一条</a>-->
                                <#--</li>-->
                                <#--<#else>-->
                                <#--<li>-->
                                <#--<a id="nex" onclick="nex()" href="#!">-->
                                <#--下一条-->
                                <#--</a>-->
                                <#--</li>-->
                                <#--</#if>-->
                                <#--<li><a  href="#">上一条</a></li>-->
                                <#--<li><a  href="">下一条</a></li>-->
                                </ul>
                            </nav>
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