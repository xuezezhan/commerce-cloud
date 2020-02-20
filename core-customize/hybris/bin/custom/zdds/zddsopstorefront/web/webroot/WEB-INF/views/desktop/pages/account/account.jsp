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
    <script src="${commonResourcePath}/js/select.js" charset="utf-8"></script>
    <script src="${commonResourcePath}/js/account/account.js" charset="utf-8"></script>
</head>
<input hidden="hidden" id="mid" value="${mid}"/>
<body>
    <div class="layui-row" style="margin: 10px 0px;">
        <div class="layui-col-sm3">
            <label class="layui-form-label">账号ID</label>
            <div class="layui-input-inline">
                <input type="text" id="uid" placeholder="账号名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-col-sm3">
            <label class="layui-form-label">账号名</label>
            <div class="layui-input-inline">
                <input type="text" id="name" placeholder="账号名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-col-sm3">
            <label class="layui-form-label">账号状态</label>
            <div class="layui-input-block layui-form" lay-filter="status">
                <select required lay-verify="required" class="layui-input"
                        id="status" lay-search="" name="status">
                    <option value="">全部</option>
                    <option value="0">使用中</option>
                    <option value="1">已停用</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-row" id="buttons">
        <%--<div class="layui-col-sm1">--%>
            <%--<button class="layui-btn layui-btn-normal" onclick="queryAccount()" style="width: 90%;">--%>
                <%--<i class="layui-icon">&#xe615;</i>搜索--%>
            <%--</button>--%>
        <%--</div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="newAccount()" style="width: 90%;">新建</button></div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="updateAccount()" style="width: 90%;">修改</button></div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="updateAuthority()" style="width: 90%;">设置权限</button></div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="activateAccount()" style="width: 90%;">启/停账户</button></div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="updateAccountGroup()" style="width: 90%;">分配权限组</button></div>--%>
    </div>
    <table id="account" class="layui-table" style="width:100%;height: 100%" lay-size="sm"></table>
</body>
</html>

<script type="text/javascript">
    var buttons = ${buttonJSON};
    if(buttons){
        for(var p = 0; p < buttons.length; p++){
            var button = $(' <div class="layui-col-sm1"><button class="layui-btn" onclick="'+buttons[p].file+'()" style="width: 90%;">'+buttons[p].name+'</button></div>');
            $("#buttons").append(button);
        }
    }
</script>

