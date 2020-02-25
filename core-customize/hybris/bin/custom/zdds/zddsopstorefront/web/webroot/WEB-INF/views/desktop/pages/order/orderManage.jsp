<%@ page trimDirectiveWhitespaces="true" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>供应商系统</title>
    <template:layUIHeader/>
    <script src="${commonResourcePath}/layui/formSelects-v4.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${commonResourcePath}/layui/css/formSelects-v4.css" media="all" />
    <script src="${commonResourcePath}/js/select.js" charset="utf-8"></script>
    <script src="${commonResourcePath}/js/order/orderManager.js" charset="utf-8"></script>
</head>
<body>
    <form class="layui-form" action="" style="margin-top: 15px;">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户账号</label>
                <div class="layui-input-inline">
                    <input type="tel" name="name" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入客户账号">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">订单编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="orderCode" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入订单编号">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">发货状态</label>
                <div class="layui-input-inline">
                    <select id="status" name="status" lay-verify="required" lay-search="">
                        <option value="">全部</option>
                        <option value="1">1</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">收货人名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="realName" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入收货人名称">
                </div>
            </div>
        </div>

        <div class="layui-form">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">下单时间</label>
                    <div class="layui-input-inline">
                        <input readonly="readonly" type="text" class="layui-input" id="creationTime" placeholder="请选择下单时间范围">
                    </div>
                </div>
                <div class="layui-inline" style="margin-left: 40px;">
                    <button type="button" class="layui-btn" onclick="orderManage.queryData()">搜索</button>
                </div>
                <div class="layui-inline">
                    <button type="reset" class="layui-btn layui-btn-normal">重置</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
