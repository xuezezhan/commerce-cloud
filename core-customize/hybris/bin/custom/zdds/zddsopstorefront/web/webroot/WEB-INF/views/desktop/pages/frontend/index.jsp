<%@ page trimDirectiveWhitespaces="true" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop" %>
<!DOCTYPE html>

<html  lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>供应商系统</title>
    <template:layUIHeader/>
    <script src="${commonResourcePath}/js/frontend/index.js"></script>
    <style>
        .layui-tab-content div{
            height:100%
        }
        .layui-layout-admin .layui-header{
            background-color: #296465;
        }
        .layui-layout-admin .layui-logo {
            width: 380px;
            line-height: 60px;
            text-align: center;
            color: white;
            font-weight: bolder;
            font-style: normal;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">国网浙江综合能源电商平台供应商系统</div>
        <ul class="layui-nav layui-layout-right">
            <div class="layui-nav-item">
                <c:if test="${not empty logo}">
                    <img src="${logo}" class="layui-nav-img">
                </c:if>
                ${user.name}
            </div>
            <li class="layui-nav-item"><a style="cursor: pointer;">修改密码</a></li>
            <li class="layui-nav-item"><a id="logout" style="cursor: pointer;">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll" id="menuList">
        </div>
    </div>

    <div class="layui-body" style="overflow: hidden">
        <div class="layui-tab" style="margin:0px;height:100%" id="frontContent" lay-filter="frontContent">
            <ul class="layui-tab-title">
                <li class="layui-this">首页</li>
            </ul>
            <div class="layui-tab-content" style="padding: 2px;height:95%">
                <div class="layui-tab-item layui-show"></div>
            </div>
        </div>
    </div>

    <div class="layui-footer layui-bg-black" style="text-align: right">
        <span>&copy; 国网浙江综合能源有限公司</span>
    </div>
</div>
</body>
</html>



<script type="text/javascript">
    var menu = ${menuJSON};
    var menuList = $('<ul class="layui-nav layui-nav-tree"  lay-filter="test"></ul>');
    if(menu){
        for(var p = 0; p < menu.length; p++){
            var li = $('<li class="layui-nav-item"></li>');
            var a = $('<a href="javascript:;">'+menu[p].name+'</a>');
            if(menu[p].file){
                $(a).data("target", "${encodedContextPath}/pageJump?pageTarget="+menu[p].file);
                li.append(a);
                menuList.append(li);
                continue;
            }
            li.append(a);
            var dl = $('<dl class="layui-nav-child"></dl>');
            var child = menu[p].child;
            for(var i = 0; i < child.length; i++){
                var dd = $('<dd></dd>')
                var a = $('<a href="javascript:;">'+child[i].name+'</a>');
                if(child[i].file){
                    $(a).data("target", "${encodedContextPath}/pageJump?pageTarget="+child[i].file+"&mid="+child[i].uid);
                }
                dd.append(a);
                dl.append(dd);
            }
            li.append(dl);
            menuList.append(li);
        }
    }
    $("#menuList").append(menuList);
    //退出
    layui.use(['layer'], function(){
        $('#logout').click(function () {
            layer.confirm('确定要退出登录吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                location.href='${encodedContextPath}/logout';
            });
        })
    })
</script>


