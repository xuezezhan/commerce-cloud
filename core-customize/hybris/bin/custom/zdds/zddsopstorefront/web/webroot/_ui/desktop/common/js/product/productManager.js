var table;
var form;
var layer;
var layedit;
var laydate;

var productManage = {
    inital:function () {
        layui.use(['form', 'layedit', 'laydate','table','form'], function(){
            form = layui.form;
            layer = layui.layer;
            layedit = layui.layedit;
            laydate = layui.laydate;
            table = layui.table;

            //日期范围
            laydate.render({
                elem: '#creationTime'
                ,range: true
                ,done: function(value, date, endDate){
                    $('#creationTime').data('startTime',$.trim(value.split(" - ")[0]));
                    $('#creationTime').data('endTime',$.trim(value.split(" - ")[1]));
                }
            });

            form.on('select', function(data){
                console.log(data.elem.id); //得到select原始DOM对象
                console.log(data.value); //得到被选中的值]
                $("#status").val(data.value);
                console.log(data.othis); //得到美化后的DOM对象
            });
        });
    },
}

$(document).ready(function () {
    productManage.inital();
});