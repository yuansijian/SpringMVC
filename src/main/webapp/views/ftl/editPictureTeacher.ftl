<#--noinspection ALL-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <link rel="stylesheet" href="/statics/assets/css/font-awesome.min.css"/>

    <link href="/statics/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="/statics/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/statics/css/font-awesome.min.css"/>

    <link rel="stylesheet" href="/statics/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/statics/css/style.css">

    <script src="/statics/js/jquery.min.js"></script>

    <script src="/statics/assets/layer/layer.js" type="text/javascript"></script>
    <title>编辑图文教学 - 后台管理系统</title>
    <link rel="icon" href="/statics/favicon.ico" type="image/ico">
    <meta name="author" content="Yuan Sijian">
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="/statics/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/statics/css/style.min.css" rel="stylesheet">

    <script>
        function save1() {
            let formData = new FormData($("#edit-pic")[0]);

            $.ajax({
                type: "POST",
                url: "/community/updatePictureTeacher",
                data: formData,
                contentType: false,
                processData: false,

                success: function (data) {
                    console.log(data);
                    console.log(222);
                    if (data === 1) {
                        alert("更新成功");
                        location.reload();
                    }
                    else if (data === 202) {
                        alert("文件大于200M")
                    }
                    else if (data === 303) {
                        alert("文件格式不对")
                    }
                    else {
                        alert("上传失败,刷新或重命名试试")
                    }
                }
            })
        }
    </script>

</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
    <#--<#include "layout/sidebar.ftl">-->
        <!--End 左侧导航-->

        <!--头部信息-->
        <div class="card">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <a href="javascript:history.go(-1)"><h4 style="color: #0FB25F">返回</h4></a>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${administrator.imageurl}"
                                     alt="笔下光年"/>
                                <span>${administrator.username} <span class="caret"></span></span>
                                <!--切换主题配色-->
                            </a>
                            <#include "layout/header2.ftl">
                        </li>
                        <#include "layout/header3.ftl">
                        <!--切换主题配色-->
                    </ul>

                </div>
            </nav>

        </div>
        <!--End 头部信息-->

        <div class="card">
            <div class="card-header"><h4>编辑图文</h4></div>
            <div class="card-body">
                <form id="edit-pic" enctype="multipart/form-data" action="" method="post">
                    <ul class='carouselbox'>
                        <div class="col-xs-12">
                            <input class="form-control" type="text" name="pname" value="${pictureTeacher.pname}">
                            <input class="form-control" type="text" name="description" value="${pictureTeacher.world}">
                            <input type="hidden" name="id" value="${id}">
                        </div>

                    </ul>
                    <div class='preview_footer'>
                        <input type="button" value='添加' id="carouselplus" class="preview_btn">&nbsp;
                        <input type="button" onclick="save1()" value='保存' id="carouselsubmit" class="preview_btn">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
    let length =${length}
    <#assign i = 1>
                <#list pictures as picture>


                    $('ul.carouselbox').append(`<li>
                                <div class="carselhead">第<span>`+${i}+`</span>张：</div>
                                <div class='carselconborder'>
                                    <input type="file" name="image" accept="image/png, image/jpeg, image/gif, image/jpg"
                                           class="carselcon"/>
                                    <p class="carselplus" style="display: none;">+</p>
                                    <p style="display: none;">点击上传图片</p>
                                    <input type="hidden" name="iname" value="${picture}" class="tt">
                                    <img src="/statics/pictureTeacher/${picture}" alt="" class="previewimg">
                                </div>
                                <div class="previewimgbtn">
                                    <div class="carselcheck carselpreview">预览</div>
                                    <div id="dele" class="carselcheck carseldelete">删除</div>
                                </div>
                            </li>`)
                    ;
                    <#assign i = i + 1>
                </#list>

    })
</script>
<script>
    //JavaScript代码区域
    $(function () {
        $("ul").on("change", ".carselcon", togglePic); //图片替换

        function togglePic() {
            console.log(this.files[0]);
            var srcs = getObjectURL(this.files[0]);   //获取路径
            $(this).siblings('p').hide();//隐藏+号，文字
            $(this).siblings('img').attr("src", srcs);//展示图片
            $(this).siblings('.tt').remove();

        }

        $("ul").on("click", ".carselpreview", function () { //图片预览
            var imgdiv = $(this).parent('.previewimgbtn').siblings('.carselconborder').children('.previewimg');
            console.log(imgdiv.attr('src'));
            if (imgdiv.attr('src')) {
                //页面层-
                let picHtml = `<img src="` + imgdiv.attr("src") + `" alt="" style="width: 700px;height: 500px" >`;
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: ['700px', '500px'],
                    skin: 'layui-layer-nobg', //没有背景色
                    shadeClose: true,
                    content: picHtml
                });
            } else {
                layer.msg('您还未上传图片，无法预览', {icon: 5});
            }
            //icon= 0-叹号；1-对号；2-×号；3-问号；4-锁号；5-哭脸；6-笑脸
        });
        $("ul").on("click", ".carseldelete", function () { //图片删除
            console.log($(this).text());
            console.log($(this).parent('.previewimgbtn').parent('li'));
            $(this).parent('.previewimgbtn').parent('li').css("display", "none")
            $(this).parent('.previewimgbtn').parent('li').children().remove();
        });

        $('#carouselplus').on('click', function () {  //添加一个轮播图框
            console.log($('.carselhead>span'));
            var numarr = $('.carselhead>span');
            console.log(numarr.length);
            var index;
            if (!$('.carselhead>span').text()) {
                index = 1;
            } else {
                index = Number($(numarr[numarr.length - 1]).text()) + 1;
            }
            var imgHtml = `<li>
            <div class="carselhead">第<span>` + index + `</span>张：</div>
            <div class='carselconborder'>
                <input type="file" name="image" accept="image/png, image/jpeg, image/gif, image/jpg"
                       class="carselcon"/>
                <p class="carselplus">+</p>
                <p>点击上传图片</p>
                <img src="" alt="" class="previewimg">
            </div>
            <div class="previewimgbtn">
                <div class="carselcheck carselpreview">预览</div>
                <div class="carselcheck carseldelete">删除</div>
            </div>
        </li>`;
            $('ul.carouselbox').append(imgHtml);
        })
        $('#carouselsubmit').on('click', function () { //提交数据
            var imgarr = $('.carouselbox').find('.previewimg');
            imgarr.each(function (i, v) {
//                console.log(i,$(v).attr('src'));
                if (!$(v).attr('src')) {
                    layer.msg('您还有未上传图片框', {icon: 5});
                    return false;
                }
            })
        })

    })


    function getObjectURL(file) {  //获取上传的URL
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file)
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file)
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file)
        }
        return url;
    };


</script>
</body>
</html>