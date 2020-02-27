var table;
var form;
var layer;
var layedit;
var laydate;

var consignmentManage = {
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
            consignmentManage.tableRender();
        });
    },
    tableRender:function () {
        var name = $('input[name="name"]').val();
        var orderCode = $('input[name="orderCode"]').val();
        var status = $("#status").val();
        var realName = $('input[name="realName"]').val();
        var startTime = $('#creationTime').data('startTime');
        var endTime = $('#creationTime').data('endTime');

        table.render({
            elem: '#table_data'
            ,url: webroot+'/consignment/consignmentInfo'
            ,height:"full-190"
            ,cellMinWidth: 80
            ,page: true
            ,limits: [10, 20, 30]
            ,limit: 10 //每页默认显示的数量
            ,where:{name:name,orderCode:orderCode,status:status,realName:realName,startTime:startTime,endTime:endTime}
            ,cols: [[
                {align:'left',title: '序号',type:'numbers',width:100,minWidth:10}
                ,{field:'orderCode', title: '订单编号'}
                ,{field:'code', title: '发货单编号'}
                ,{field:'statusName', title: '发货状态'}
                ,{field:'creationTime', title: '下单时间'}
                ,{field:'name', title: '客户账号'}
                ,{field:'realName', title: '收货人名称'}
                ,{field:'phone', title: '收货人手机'}
                ,{field:'remark', title: '买家备注'}
                ,{align:'left',fixed: 'right',title: '操作'}
            ]]
        });
    },
    queryData:function () {
        consignmentManage.tableRender();
    }
}

$(document).ready(function () {
    consignmentManage.inital();
});