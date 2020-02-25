var orderManage = {
    inital:function () {
        layui.use(['form', 'layedit', 'laydate'], function(){
            var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;
            //日期范围
            laydate.render({
                elem: '#creationTime'
                ,range: true
            });
        });
    },
    queryData:function () {
    }
}

$(document).ready(function () {
    orderManage.inital();
});