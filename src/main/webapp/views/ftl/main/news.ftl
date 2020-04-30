<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>留言</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="description" content="态势语后台管理系统">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">
    <script>
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
                                "                                                                                    <button type=\"button\"><i class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                                "    <a id=\"replay\" style=\"background: white\" onclick=\"reply2("+id+", "+pid+",\' "+ parentname +" \')\"></a></i></button>\n" +
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

                        $("#answer1").prepend(html);
                        cancelR1(id);
                    }
                }

            })
        }
        function cancelR1(id) {
            let a =document.getElementById("re"+id);
            a.remove();
        }
    </script>
</head>

<body>
<div id="answer1">
    <#list news as re>
        <div class="col-12">
            <div class="card">
                <ul class="card-actions">
                    <li>
                        <button type="button"><i class="mdi mdi-arrow-up-bold-circle">顶(${re.up})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="replay" style="background: #b4c2cc" onclick="reply1(${re.id}, ${re.parentid}, '${re.username}')">回复</a></i></button>
                    </li>
                </ul>
                <div class="card-body" style="background: #c0c0c0;">
                    <p id="reply${re.id}">
                        <label style="background: white">${re.username}</label>回复<label style="background: white" >${re.parentname}</label><br>
                        ${re.content}<br>
                        ${re.creatTime}
                    </p>
                </div>
            </div>
        </div>
    </#list>
</div>
<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
</body>
</html>