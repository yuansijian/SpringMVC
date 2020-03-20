<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>留言</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Defend">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
    <script>
        //新增评论
        function save1(name, id) {
            let content = $("#message").val();

            $.ajax({
                type: "POST",
                url: "/main/addMessage",
                data: $("#form1").serialize(),
                success: function (data) {
                    if(data === 0)
                    {
                        alert("新增失败")
                    }
                    else
                    {

                        let html = "\t\t\t\t\t\t<div class=\"col-12\">\n" +
                                "                                                    <div class=\"card\" id=\"card\">\n" +
                                "                                                        <div class=\"card-header bg-brown\">\n" +
                                "                                                            <h4>\n" +
                                "                                                                <img src=\"/statics/studentHeader/${student.imageurl}\" alt=\"\" style=\"width: 30px; height: 30px\">\n" +
                                "                                                                ${student.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small style=\"color: white\"></small>\n" +
                                "                                                            </h4>\n" +
                                "                                                            <ul class=\"card-actions\">\n" +
                                "                                                                <li>\n" +
                                "                                                                    <button type=\"button\">\n" +
                                "                                                                        <i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                                "                                                                            <a id=\"replay\" style=\"background: white\" ></a></i></button>\n" +
                                "                                                                </li>\n" +
                                "                                                            </ul>\n" +
                                "                                                        </div>\n" +
                                "                                                        <div class=\"card-body\">\n" +
                                "                                                            <p id=\"content9\">"+content+"</p><br>\n" +
                                "\n" +
                                "                                                            <div id=\"download9\">\n" +
                                "                                                            </div>\n" +
                                "                                                        </div>\n" +
                                "                                                    </div>\n" +
                                "                                                </div>"
                        $("#messagebody").prepend(html);

                    }
                }
            })
        }
        //回复主楼框
        function reply(id, username)
        {
            // $("#content"+id).append("<div class=\"form-group\">\n" +
            //         "                    <label class=\"col-xs-12\" for=\"example-textarea-input\">回复</label>\n" +
            //         "                    <div class=\"col-xs-12\">\n" +
            //         "                      <textarea class=\"form-control\" id=\"example-textarea-input\" name=\"example-textarea-input\" rows=\"6\" placeholder=\"内容..\"></textarea>\n" +
            //         "                      <input class='btn btn-primary' type='button' onclick='save2("+id+")' value='发布'>&nbsp;&nbsp;&nbsp;&nbsp;<input id='cancel' class='btn btn-danger' type='button' onclick='cancelR("+id+")' value='取消回复'>\n" +
            //         "                    </div>\n" +
            //         "                  </div>");

            let a = "<form id="+id+" action=\"\" method=\"post\">\n" +
                    "                        <div class=\"form-group\">\n" +
                    "                            <label class=\"col-12\" for=\"textarea-input\">回复"+username+"</label>\n" +
                    "                            <div class=\"col-12\">\n" +
                    "                                <textarea class=\"form-control\" id=\"textarea-input\" name=\"content\" rows=\"6\" placeholder=\"回复"+username+"..\"></textarea>\n" +
                    "                                <input type='hidden' name='parentname' value='"+username+"'><input type='hidden' name='parentid' value='"+id+"'> " +
                    "<input class='btn btn-primary' type='button' onclick='save2("+id+")' value='发布'>&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-danger' type='button' onclick='cancelR("+id+")' value='取消回复'>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </form>";
            $("#content"+id).append(a)
        }
        //主楼下的回复框
        function reply1(id, pid, username) {
            let a = "<form id=re"+id+" action=\"\" method=\"post\">\n" +
                    "                        <div class=\"form-group\">\n" +
                    "                            <label class=\"col-12\" for=\"textarea-input\">回复"+username+"</label>\n" +
                    "                            <div class=\"col-12\">\n" +
                    "                                <textarea class=\"form-control\" id=res"+id+" name=\"content\" rows=\"6\" placeholder=\"回复"+username+"..\"></textarea>\n" +
                    "                                <input type='hidden' name='parentname' value='"+username+"'><input type='hidden' name='parentid' value='"+pid+"'> " +
                    "<input class='btn btn-primary' type='button' onclick='save2("+id+","+pid+", \" "+username+" \")\' value='发布'>&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-danger' type='button' onclick='cancelR1("+id+")' value='取消回复'>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </form>";
            $("#reply"+id).append(a)
        }
        //主楼回复保存
        function save3(id, pid, username) {

        }
        //异步回复
        function reply2(id, pid, username) {
            id = id + 1;
            let a = "<form id=re"+id+" action=\"\" method=\"post\">\n" +
                    "                        <div class=\"form-group\">\n" +
                    "                            <label class=\"col-12\" for=\"textarea-input\">回复"+username+"</label>\n" +
                    "                            <div class=\"col-12\">\n" +
                    "                                <textarea class=\"form-control\" id=res"+id+" name=\"content\" rows=\"6\" placeholder=\"回复"+username+"..\"></textarea>\n" +
                    "                                <input type='hidden' name='parentname' value='"+username+"'><input type='hidden' name='parentid' value='"+pid+"'> " +
                    "<input class='btn btn-primary' type='button' onclick='save2("+id+","+pid+", \" "+username+" \")\' value='发布'>&nbsp;&nbsp;&nbsp;&nbsp;<input class='btn btn-danger' type='button' onclick='cancelR1("+id+")' value='取消回复'>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </form>";
            id = id - 1;
            $("#temp"+id).append(a)
        }
        //主楼回复取消
        function cancelR(id) {
            let a =document.getElementById(id);
            a.remove();
        }
        //主楼下的回复取消
        function cancelR1(id) {
            let a =document.getElementById("re"+id);
            a.remove();
        }
        //主楼下的回复保存
        function save2(id, pid, parentname) {
            $.ajax({
                type: "POST",
                url: "/main/addReply",
                data: $("#re"+id).serialize(),
                success: function (data) {
                    if(data === 1)
                    {
                        let text = $("#res"+id).val();

                        let html = "<div class=\"col-12\">\n" +
                                "                                                                        <div class=\"card\">\n" +
                                "                                                                            <ul class=\"card-actions\">\n" +
                                "                                                                                <li>\n" +
                                "                                                                                    <button type=\"button\"><i class=\"mdi mdi-arrow-up-bold-circle\">顶(0)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                                "    <a id=\"replay\" style=\"background: white\" onclick=\"reply2("+id+", "+pid+",\' "+ parentname +" \')\">回复</a></i></button>\n" +
                                "                                                                                </li>\n" +
                                "                                                                            </ul>\n" +
                                "                                                                            <div class=\"card-body\" style=\"background: #c0c0c0;\">\n" +
                                "                                                                                <p id=\"temp"+id+"\">\n" +
                                "                                                                                    <label style=\"background: white\">${student.username}</label>回复<label style=\"background: white\">"+parentname+"</label><br>\n" +
                                "                                                                                    "+text+"<br>\n" +
                                "                                                                                    ${student.logintime}\n" +
                                "                                                                                </p>\n" +
                                "                                                                            </div>\n" +
                                "                                                                        </div>\n" +
                                "                                                                    </div>";

                                $("#download"+pid).append(html);
                                cancelR1(id);
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
                            <li > <a href="/main/index">图文教学</a> </li>
                            <li><a href="#!">视频教学</a> </li>
                            <li><a href="/main/practice">练习中心</a></li>
                            <li><a href="/main/resource">资源中心</a> </li>
                            <li class="active"> <a href="">留言</a></li>
                            <li><a href="">作业中心</a> </li>
                            <li><a href="/main/information">个人中心</a> </li>
                        </ul>

                        <div class="tab-pane active">
                            <div class="col-sm-push-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>新增留言</h4>
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
                                        <form id="form1" >
                                            <textarea id="message" name="message" class="col-sm-push-12" style=" width: 100%">
                                            </textarea>
                                            <button onclick="save1('${student.username}', ${student.id})" class="btn btn-primary">新增留言</button>
                                        </form>
                                        <div id="messagebody">
                                            <#list pageInfo.list as list>
                                                <div class="col-12">
                                                    <div class="card" id="card">
                                                        <div class="card-header bg-brown">
                                                            <h4>
                                                                <img src="/statics/studentHeader/${list.commenturl}" alt="${list.username}" style="width: 30px; height: 30px">
                                                                ${list.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small style="color: white">${list.commenttime}</small>
                                                            </h4>
                                                            <ul class="card-actions">
                                                                <li>
                                                                    <button type="button">
                                                                        <i  class="mdi mdi-arrow-up-bold-circle">顶(${list.up})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                            <a id="replay" style="background: white" onclick="reply(${list.id}, '${list.username}')" >回复</a></i></button>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                        <div class="card-body" >
                                                            <p id="content${list.id}">${list.comment}</p><br>
                                                        <#--<p>-->
                                                        <#--${list.commenttime}-->
                                                        <#--</p>-->

                                                            <div id="download${list.id}">
                                                            <#list reply as re>
                                                                <#if re.parentid == list.id>
                                                                    <div class="col-12">
                                                                        <div class="card">
                                                                            <ul class="card-actions">
                                                                                <li>
                                                                                    <button type="button"><i class="mdi mdi-arrow-up-bold-circle">顶(${re.up})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="replay" style="background: white" onclick="reply1(${re.id}, ${list.id}, '${re.username}')" >回复</a></i></button>
                                                                                </li>
                                                                            </ul>
                                                                            <div class="card-body" style="background: #c0c0c0;">
                                                                                <p id="reply${re.id}">
                                                                                    <label style="background: white">${re.username}</label>回复<label style="background: white">${re.parentname}</label><br>
                                                                                    ${re.content}<br>
                                                                                    ${re.creatTime}
                                                                                </p>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </#if>
                                                            </#list>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            <#--<div id="" class="card mb-4">-->
                                            <#--<div class="card-body p-3">-->
                                            <#--<div class="row">-->
                                            <#--<div class="col-2">-->
                                            <#--<small></small>-->
                                            <#--</div>-->
                                            <#--<div class="col-10">-->
                                            <#--<div class="row mb-3">-->
                                            <#--<div class="col-6 text-left">-->
                                            <#--<img src="/statics/headerPicture/1.jpg" alt="${list.username}" style="width: 30px; height: 30px">-->
                                            <#--<strong class="text-muted">${list.username}</strong>-->
                                            <#--&nbsp;<small>${list.commenttime}</small>-->

                                            <#--</div>-->

                                            <#--</div>-->
                                            <#--${list.comment}-->
                                            <#---->
                                            <#--</div>-->
                                            <#--<div class="col-10 text-right">-->
                                            <#--<div class="mb-4">-->
                                            <#--<a href="" class="btn btn-primary" role="button">Reply</a>-->
                                            <#--</div>-->
                                            <#--</div>-->
                                            <#--</div>-->
                                            <#--</div>-->
                                            <#--</div>-->
                                            </#list>
                                        </div>


                                    </div>
                                    <nav>
                                        <ul class="pagination pagination-circle">
                                        <#--返回上一页-->
                                        <#if pageInfo.isFirstPage>
                                            <li class="disabled">
                                                <span style="background: brown"><i class="mdi mdi-chevron-left"></i></span>
                                            </li>
                                        <#elseif pageInfo.hasPreviousPage>
                                            <li>
                                                <a style="background: brown" id="goPage1" href="/main/message?pageNum=${pageInfo.prePage}&id=0">
                                                    <span ><i class="mdi mdi-chevron-left"></i></span>
                                                </a>
                                            </li>
                                        </#if>
                                        <#--下一页-->
                                        <#if pageInfo.isLastPage>
                                            <li class="disabled">
                                                <span style="background: brown"><i class="mdi mdi-chevron-right"></i></span>
                                            </li>
                                        <#elseif pageInfo.hasNextPage>
                                            <li>
                                                <a style="background: brown" id="goPage" href="/main/message?pageNum=${pageInfo.nextPage}">
                                                    <span ><i class="mdi mdi-chevron-right"></i></span>
                                                </a>
                                            </li>
                                        </#if>
                                        </ul>
                                    </nav>
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