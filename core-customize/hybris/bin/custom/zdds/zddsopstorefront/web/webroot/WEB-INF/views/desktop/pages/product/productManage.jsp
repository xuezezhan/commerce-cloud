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
    <script src="${commonResourcePath}/js/product/productManager.js" charset="utf-8"></script>
</head>
<style>
    .layui-form-label {
        width: 6em;
    }
</style>
<body>
    <form class="layui-form" action="" style="margin-top: 15px;">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-inline">
                    <input type="tel" name="name" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入商品名称">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">商品编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入商品编号">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">商品分类</label>
                <div class="layui-input-inline">
                    <select name="quiz1" lay-search="" lay-verify="category">
                        <option value="">请选择一级分类</option>
                        <c:forEach items="${oneLevels}" var="level">
                            <option value="${level.code}">${level.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="quiz2" lay-search="" lay-verify="category">
                        <option value="">请选择二级分类</option>
                        <c:forEach items="${twoLevels}" var="level">
                            <option value="${level.code}">${level.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="quiz3" lay-search="" lay-verify="category">
                        <option value="">请选择三级分类</option>
                        <c:forEach items="${threeLevels}" var="level">
                            <option value="${level.code}">${level.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">商品状态</label>
                <div class="layui-input-inline">
                    <input id="tempApprovalStatus" name="approvalStatus" type="hidden"/>
                    <select id="approvalStatus" lay-verify="required" lay-search="">
                        <option value="">全部</option>
                        <option value="approved">已上架</option>
                        <option value="check">已下架</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">商品审核状态</label>
                <div class="layui-input-inline">
                    <input id="tempCheckStatus" name="checkStatus" type="hidden"/>
                    <select id="checkStatus" lay-verify="required" lay-search="">
                        <option value="">全部</option>
                        <option value="PENDINGREVIEW">待审核</option>
                        <option value="APPROVED">审核已通过</option>
                        <option value="UNAPPROVED">审核未通过</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline" style="margin-left: 40px;">
                <button type="button" class="layui-btn" onclick="consignmentManage.queryData()">搜索</button>
            </div>
            <div class="layui-inline">
                <button type="reset" class="layui-btn layui-btn-normal" onclick="consignmentManage.resetData()">重置</button>
            </div>
            <%--<div class="layui-inline">--%>
                <%--<button type="button" class="layui-btn">--%>
                    <%--<i class="layui-icon">&#xe654;</i>添加商品--%>
                <%--</button>--%>
            <%--</div>--%>
        </div>
    </form>
    <table id="table_data" class="layui-table" style="width:100%;height: 100%" lay-size="sm" lay-filter="table_ope"></table>

    <script type="text/html" id="operationBar">
        <a class="layui-btn layui-btn-xs" lay-event="edit" onclick="consignmentManage.toDetail()">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="approvel" onclick="consignmentManage.toDetail()">上下架</a>
    </script>
</body>
</html>
