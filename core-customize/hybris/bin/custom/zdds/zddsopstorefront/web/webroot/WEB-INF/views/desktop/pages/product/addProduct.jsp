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
    <script src="${commonResourcePath}/js/product/addProduct.js" charset="utf-8"></script>
</head>
<style>
    .required{
        color: red;
    }
    .layui-form-label {
        width: 6em;
    }
    .layui-textarea {
        width: 30%;
        height: 10em;
    }
</style>
<body>
    <form class="layui-form" action="" lay-filter="example">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>基本信息</legend>
        </fieldset>

        <div class="layui-form-item">
            <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>商品分类</label>
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

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">商品编码</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="code" autocomplete="off" class="layui-input" placeholder="自动生成">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>商品名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" autocomplete="off" class="layui-input" placeholder="请输入商品名称">
                </div>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>商品参数</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>产品品牌</label>
                <div class="layui-input-inline">
                    <select name="modules" lay-search="">
                        <option value="">请选择品牌</option>
                        <option value="1">layer</option>
                        <option value="2">form</option>
                        <option value="3">layim</option>
                        <option value="4">element</option>
                        <option value="5">laytpl</option>
                        <option value="6">upload</option>
                        <option value="7">laydate</option>
                        <option value="8">laypage</option>
                        <option value="9">flow</option>
                        <option value="10">util</option>
                        <option value="11">code</option>
                        <option value="12">tree</option>
                        <option value="13">layedit</option>
                        <option value="14">nav</option>
                        <option value="15">tab</option>
                        <option value="16">table</option>
                        <option value="17">select</option>
                        <option value="18">checkbox</option>
                        <option value="19">switch</option>
                        <option value="20">radio</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>产品型号</label>
                <div class="layui-input-inline">
                    <select name="modules" lay-search="">
                        <option value="">请选择型号</option>
                        <option value="1">layer</option>
                        <option value="2">form</option>
                        <option value="3">layim</option>
                        <option value="4">element</option>
                        <option value="5">laytpl</option>
                        <option value="6">upload</option>
                        <option value="7">laydate</option>
                        <option value="8">laypage</option>
                        <option value="9">flow</option>
                        <option value="10">util</option>
                        <option value="11">code</option>
                        <option value="12">tree</option>
                        <option value="13">layedit</option>
                        <option value="14">nav</option>
                        <option value="15">tab</option>
                        <option value="16">table</option>
                        <option value="17">select</option>
                        <option value="18">checkbox</option>
                        <option value="19">switch</option>
                        <option value="20">radio</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>产品型号</label>
                <div class="layui-input-inline">
                    <select name="modules" lay-search="">
                        <option value="">请选择型号</option>
                        <option value="1">layer</option>
                        <option value="2">form</option>
                        <option value="3">layim</option>
                        <option value="4">element</option>
                        <option value="5">laytpl</option>
                        <option value="6">upload</option>
                        <option value="7">laydate</option>
                        <option value="8">laypage</option>
                        <option value="9">flow</option>
                        <option value="10">util</option>
                        <option value="11">code</option>
                        <option value="12">tree</option>
                        <option value="13">layedit</option>
                        <option value="14">nav</option>
                        <option value="15">tab</option>
                        <option value="16">table</option>
                        <option value="17">select</option>
                        <option value="18">checkbox</option>
                        <option value="19">switch</option>
                        <option value="20">radio</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">商品编码</label>
                <div class="layui-input-inline">
                    <input type="text" readonly name="code" autocomplete="off" class="layui-input" placeholder="自动生成">
                </div>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>库存规格</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>建议零售价</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" autocomplete="off" class="layui-input" placeholder="请输入建议零售价">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>成本价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" autocomplete="off" class="layui-input" placeholder="请输入成本价格">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label"><i class="required">*&nbsp;&nbsp;</i>商品库存</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" autocomplete="off" class="layui-input" placeholder="请输入商品库存">
                </div>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>详细描述</legend>
        </fieldset>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品描述</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入商品描述" class="layui-textarea" name="desc"></textarea>
            </div>
        </div>

        <div class="layui-form-item" style="text-align: center;margin: 2em auto;">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="submit">提交</button>
                <button type="button" class="layui-btn layui-btn-primary" onclick="addProductManage.saveProduct()">保存</button>
            </div>
        </div>
    </form>
</body>
</html>