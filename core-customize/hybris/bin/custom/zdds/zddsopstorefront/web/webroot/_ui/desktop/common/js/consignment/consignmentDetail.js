var layer;

var consignmentDetail = {
    inital:function () {
        layui.use(['form', 'layedit', 'laydate','table','form'], function(){
            layer = layui.layer;
        });
        consignmentDetail.reloadData();
    },
    reloadData:function () {
        $.ajax({
            url: webroot + '/consignment/consignmentDetail',
            type: 'post',
            data: {pk: $("#pk").val()},
            success: function (result) {
                $(".layui-tab-content").html(result);
            },
            error: function () {
                layer.alert('连接失败，请稍后再试...', {icon: 2});
            }
        });
    }
}

$(document).ready(function () {
    consignmentDetail.inital();
});
