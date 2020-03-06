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
    <script src="${commonResourcePath}/js/select.js" charset="utf-8"></script>
    <script src="${commonResourcePath}/js/consignment/consignmentDetail.js" charset="utf-8"></script>
</head>
<input type="hidden" id="pk" value="${param.pk}">
<body>
    <div class="layui-tab-content" style="padding: 2px;height:95%"></div>
</body>
</html>
