<#macro layout>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>首页 - 光年(Light Year Admin)后台管理系统模板</title>
    <link rel="icon" href="/static/favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="Yuan Sijian">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/static/css/style.min.css" rel="stylesheet">
</head>
<body>
<div style="width: 700px; text-align:center; font-size:30px;">
	    <#include "header.ftl">

	    <#include "sidebar.ftl">

<#-- 在这里嵌入main content -->
	    <#nested>

	    <#include "footer.ftl">
</div>

</body>
</html>
</#macro>