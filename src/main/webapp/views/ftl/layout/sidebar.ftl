<!--左侧导航-->
<aside class="lyear-layout-sidebar">
<!-- logo -->
<div id="logo" class="sidebar-header">
    <a href="/index"><img src="/statics/images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a>
</div>
<div class="lyear-layout-sidebar-scroll">

    <nav class="sidebar-main">
        <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="/index"><i class="mdi mdi-home"></i> 后台首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
                <a href="javascript:void(0)"><i class="mdi mdi-palette"></i> 教师中心</a>
                <ul class="nav nav-subnav">
                    <#--<w:hyperlink w:anchor="/views/ftl/manageStudent.ftl">按钮</w:hyperlink>-->
                    <li> <a href="/teacher/manageStudent?pageNum=1&pageSize=1">学生管理</a> </li>
                    <li> <a href="/teacher/manageHomework">作业管理</a> </li>
                    <li> <a href="#!">其他</a> </li>
                </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
                <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 用户分析</a>
                <ul class="nav nav-subnav">
                    <li> <a href="/user/newStudent?pageNum=1&pageSize=1">新加入的用户</a> </li>
                    <#--<li><a href="/user/newTeacher?pageNum=1&pageSize=1">新加入的教师</a></li>-->
                    <#--<li> <a href="/user/activity">活跃度</a> </li>-->
                    <li> <a href="/user/studentInformation?pageNum=1&pageSize=1">学生信息</a> </li>
                    <li> <a href="/user/teacherInformation?pageNum=1&pageSize=1">教师信息</a> </li>
                </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
                <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 社区管理</a>
                <ul class="nav nav-subnav">
                    <li class="nav-item nav-item-has-subnav">
                        <a href="#!">内容维护</a>
                        <ul class="nav nav-subnav">
                            <li class="nav-item nav-item-has-subnav">
                                <a href="#!">学习部分</a>
                                <ul class="nav nav-subnav">
                                    <li> <a href="/community/videoTeacher">视频教学</a> </li>
                                    <li> <a href="/community/pictureTeacher">图文教学</a> </li>
                                    <li> <a href="/community/wordTeacher">文字教学</a> </li>
                                </ul>
                            </li>
                            <li class="nav-item nav-item-has-subnav">
                                <a href="#!">练习部分</a>
                                <ul class="nav nav-subnav">
                                    <li> <a href="/community/shortAnswerDatabase">简答题库</a> </li>
                                    <li> <a href="/community/chooseDatabase.ftl">选择题库</a> </li>
                                </ul>
                            </li>
                            <li class="nav-item nav-item-has-subnav">
                                <a href="/community/uploadFile">上传文件</a>
                            </li>
                        </ul>
                    </li>
                    <#--<li> <a href="/community/manageUser.ftl">用户管理</a></li>-->
                    <#--<li> <a href="/community/registrationMaintenance.ftl">注册维护</a> </li>-->
                    <#--<li> <a href="/community/authorityControl">设置权限</a></li>-->
                </ul>
            </li>
            <li class="nav-item">
                <a href="/community/baseConfig"><i class="mdi mdi-wrench"></i>系统</a>
            </li>
            <#--<li class="nav-item nav-item-has-subnav">-->
                <#--<a href="javascript:void(0)"><i class="mdi mdi-menu"></i> 多级菜单</a>-->
                <#--<ul class="nav nav-subnav">-->
                    <#--<li class="nav-item nav-item-has-subnav">-->
                        <#--<a href="#!">一级菜单</a>-->
                        <#--<ul class="nav nav-subnav">-->
                            <#--<li class="nav-item nav-item-has-subnav">-->
                                <#--<a href="#!">二级菜单</a>-->
                                <#--<ul class="nav nav-subnav">-->
                                    <#--<li> <a href="#!">三级菜单</a> </li>-->
                                    <#--<li> <a href="#!">三级菜单</a> </li>-->
                                <#--</ul>-->
                            <#--</li>-->
                        <#--</ul>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</li>-->
        </ul>
    </nav>

    <div class="sidebar-footer">
        <p class="copyright">©2020 - 2020, content by Defend. All Rights Reserved.</p>
    </div>
</div>
</aside>
<!--End 左侧导航-->