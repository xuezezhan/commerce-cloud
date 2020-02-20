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
    <c:choose>
        <c:when test="${action == 'insert'}">
            <script src="${commonResourcePath}/js/account/insertaccount.js" charset="utf-8"></script>
        </c:when>
        <c:otherwise>
            <script src="${commonResourcePath}/js/account/updateaccount.js" charset="utf-8"></script>
        </c:otherwise>
    </c:choose>
</head>
<input hidden="hidden" id="mid" value="${mid}"/>
<input type="hidden" name="action" id="action" value="${action}">
<body>
<div class="layui-layout layui-layout-admin layui-form">
    <div class="layui-collapse">
        <div class="layui-colla-item">
            <h2 class="layui-colla-title" id="categoryTitle">
                基础信息
            </h2>
            <div class="layui-colla-content layui-show">
                    <div class="layui-form-item">
                        <div class="layui-col-xs3">
                            <label class="layui-form-label">子账号ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="uid" id="uid"  placeholder="系统自动生成" autocomplete="off" class="layui-input" value="${param.uid}" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-col-xs3">
                            <label class="layui-form-label">子账号名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="name" id="name" required  lay-verify="required" placeholder="请输入子账号名称" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-col-xs3">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-block">
                                <c:choose>
                                    <c:when test="${action == 'insert'}">
                                        <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="password" name="password" id="password" required placeholder="请输入密码" autocomplete="off" class="layui-input">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-col-xs3">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-block">
                                <c:choose>
                                    <c:when test="${action == 'insert'}">
                                        <input type="password" name="passwordConfirm" required lay-verify="required" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="password" name="passwordConfirm" required placeholder="请输入确认密码" autocomplete="off" class="layui-input">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>


    <div class="layui-bg-gray" style="position:fixed; bottom:-3px;width:100%;padding:5px">
        <div class="layui-col-xs-offset9 layui-col-xs4">
            <a class="layui-btn layui-btn-normal" style="width:30%" lay-submit lay-filter="accountData">保存</a>
            <a class="layui-btn layui-btn-warm" onclick='closeAccountTab()' style="width:30%">取消</a>
        </div>
    </div>
    </div>
</div>
</body>




</html>