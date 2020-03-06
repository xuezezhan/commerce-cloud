<%@ page trimDirectiveWhitespaces="true" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    .icon-title{
        position: relative;
        left: 10%;
        margin: 1em auto;
    }
    .icon-title-margin{
        margin-top: 4em;
    }
    .table-common{
        position:relative;
        left: 10%;
        width: 80%;
    }
</style>

<div class="icon-title">
    <i class="layui-icon layui-icon-flag" style="font-size: 30px; color: #1E9FFF;"></i>
    <span>基本信息</span>
</div>
<table class="layui-table table-common" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th style="width: 10em;">下单时间</th>
        <th>订单编号</th>
        <th>发货单编号</th>
        <th>客户账号</th>
        <th>发货状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${opConsignmentData.orderData.creationTime}</td>
        <td>${opConsignmentData.orderData.code}</td>
        <td>${opConsignmentData.code}</td>
        <td>${opConsignmentData.orderData.name}</td>
        <td>${opConsignmentData.statusName}</td>
    </tr>
    </tbody>

    <thead>
    <tr>
        <th>收货人</th>
        <th>收货人联系方式</th>
        <th>收货地址</th>
        <th>买家备注</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${opConsignmentData.orderData.realName}</td>
        <td>${opConsignmentData.orderData.phone}</td>
        <td>
            ${fn:escapeXml(opConsignmentData.orderData.address.region.name)}&nbsp;
            ${fn:escapeXml(opConsignmentData.orderData.address.city.name)}&nbsp;
            ${fn:escapeXml(opConsignmentData.orderData.address.cityDistrict.name)}&nbsp;
            ${fn:escapeXml(opConsignmentData.orderData.address.streetName)}
        </td>
        <td>${opConsignmentData.orderData.remark}</td>
        <td></td>
    </tr>
    </tbody>
</table>


<div class="icon-title icon-title-margin">
    <i class="layui-icon layui-icon-flag" style="font-size: 30px; color: #1E9FFF;"></i>
    <span>物流信息</span>
    <span style="position: relative;left: 63em;"><button type="button" class="layui-btn layui-btn-sm layui-btn-danger">订单发货</button></span>
</div>
<table class="layui-table table-common" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>物流公司</th>
        <th>物流单号</th>
        <th>配送商品</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${opConsignmentData.deliveryInfoes}" var="deliveryInfo">
        <tr>
            <td rowspan="${fn:length(deliveryInfo.products)}">${deliveryInfo.carrierName}</td>
            <td rowspan="${fn:length(deliveryInfo.products)}">${deliveryInfo.logisticsNumber}</td>
            <c:choose>
                <c:when test="${fn:length(deliveryInfo.products) > 0}">
                    <c:forEach items="${deliveryInfo.products}" var="product" begin="0" end="0">
                        <td>${product.name}</td>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <td></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <c:choose>
            <c:when test="${fn:length(deliveryInfo.products) > 1}">
                <tr>
                    <c:forEach items="${deliveryInfo.products}" var="product" begin="1">
                        <td>${product.name}</td>
                    </c:forEach>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>
    </tbody>
</table>


<div class="icon-title icon-title-margin">
    <i class="layui-icon layui-icon-flag" style="font-size: 30px; color: #1E9FFF;"></i>
    <span>商品信息</span>
</div>
<table class="layui-table table-common" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>价格/型号</th>
        <th>数量</th>
        <th>库存</th>
        <th>小计</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${opConsignmentData.orderData.entries}" var="entry">
        <tr>
            <td><img width="80px" height="80px" src="${entry.product.normalMedia}"></td>
            <td>${entry.product.name}</td>
            <td>
                <div>价格：${entry.product.salesPrice.formattedValue}</div>
                <div>型号：${entry.product.model}</div>
            </td>
            <td>${entry.quantity}</td>
            <td>${entry.product.stockLevel}</td>
            <td>${entry.subSalesPrice.formattedValue}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="text-align: right;">
            合计：${opConsignmentData.orderData.totalSalesPrice.formattedValue}
        </td>
    </tr>
    </tbody>
</table>


<div class="icon-title icon-title-margin">
    <i class="layui-icon layui-icon-flag" style="font-size: 30px; color: #1E9FFF;"></i>
    <span>费用信息</span>
</div>
<table class="layui-table table-common" lay-size="lg">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>商品合计</th>
        <th>运费</th>
        <th>运费</th>
        <th>活动优惠</th>
        <th>活动优惠</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
</table>