<%@ page trimDirectiveWhitespaces="true" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>中台系统</title>
    <template:layUIHeader/>
    <script src="${commonResourcePath}/js/account/updateauthority.js" charset="utf-8"></script>
</head>
<input hidden="hidden" id="mid" value="${mid}"/>
<body>
<div class="layui-layout layui-layout-admin layui-form">
    <div class="layui-collapse">
        <div class="layui-colla-item">
            <div class="layui-colla-content layui-show">
                    <div class="layui-form-item">
                        <div class="layui-col-xs3">
                            <label class="layui-form-label">子账号ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="uid" id="uid"  placeholder="系统自动生成" autocomplete="off" class="layui-input" value="${param.uid}" readonly="readonly">
                            </div>
                        </div>

                        <div class="layui-col-xs3">
                            <label class="layui-form-label">子账号名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="name" id="name" required  lay-verify="required" placeholder="请输入子账号名称" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <div class="layui-collapse">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title">
                修改权限
            </h2>
            <div class="layui-colla-content layui-show">
                <div id="layui-xtree-demo1" style="padding-bottom:50px;">
                </div>

            </div>
        </div>
    </div>

    <div class="layui-bg-gray" style="position:fixed; bottom:-3px;width:100%;padding:5px">
        <div class="layui-col-xs-offset9 layui-col-xs4">
            <a class="layui-btn layui-btn-normal" style="width:30%" lay-submit lay-filter="authorityData">保存</a>
            <a class="layui-btn layui-btn-warm" onclick='closeAccountTab()' style="width:30%">取消</a>
        </div>
    </div>
    </div>
    <input type="hidden" name="action" id="action" value="${action}">
</div>
</body>




</html>