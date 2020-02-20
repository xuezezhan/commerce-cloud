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
    <script src="${commonResourcePath}/js/account/group.js" charset="utf-8"></script>
</head>
<input hidden="hidden" id="mid" value="${mid}"/>
<body>

    <div class="layui-row" id="buttons">
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="newMenuGroup()" style="width: 90%;">新建</button></div>--%>
        <%--<div class="layui-col-sm1"><button class="layui-btn" onclick="updateMenuGroup()" style="width: 90%;">修改</button></div>--%>
    </div>

    <table id="group" class="layui-table" style="width:100%;height: 100%" lay-size="sm">
    </table>
</body>
</html>


<script type="text/javascript">
    var buttons = ${buttonJSON};
    console.log('----buttons----'+buttons);
    if(buttons){
        for(var p = 0; p < buttons.length; p++){
            var button = $(' <div class="layui-col-sm1"><button class="layui-btn" onclick="'+buttons[p].file+'()" style="width: 90%;">'+buttons[p].name+'</button></div>');
            $("#buttons").append(button);
        }
    }
</script>