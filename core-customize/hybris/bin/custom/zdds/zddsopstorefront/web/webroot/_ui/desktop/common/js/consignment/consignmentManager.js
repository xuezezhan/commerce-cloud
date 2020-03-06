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
                {field: 'pk', title: 'pk',hide:true},
                {align:'left',title: '序号',type:'numbers',width:100,minWidth:10}
                ,{field:'code', title: '订单编号',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.code)) {
                        return " ";
                    }else {
                        return d.orderData.code;
                    }
                }}
                ,{field:'code', title: '发货单编号'}
                ,{field:'statusName', title: '发货状态'}
                ,{field:'creationTime', title: '下单时间',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.creationTime)) {
                        return " ";
                    }else {
                        return d.orderData.creationTime;
                    }
                }}
                ,{field:'name', title: '客户账号',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.name)) {
                        return " ";
                    }else {
                        return d.orderData.name;
                    }
                }}
                ,{field:'realName', title: '收货人名称',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.realName)) {
                        return " ";
                    }else {
                        return d.orderData.realName;
                    }
                }}
                ,{field:'phone', title: '收货人手机',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.phone)) {
                        return " ";
                    }else {
                        return d.orderData.phone;
                    }
                }}
                ,{field:'remark', title: '买家备注',templet: function(d){
                    if($.isEmptyObject(d.orderData)||$.isEmptyObject(d.orderData.remark)) {
                        return " ";
                    }else {
                        return d.orderData.remark;
                    }
                }}
                ,{align:'left',fixed: 'right',title: '操作',toolbar: '#operationBar'}
            ]]
        });
    },
    toDetail:function(){
        //监听工具条
        table.on('tool(table_ope)', function(obj){
            var pk = obj.data.pk;
            var layEvent = obj.event;

            if(layEvent === 'detail'){
                layer.open({
                    title:"发货单详情",
                    type: 2,
                    content: "?pageTarget=pages/consignment/consignmentDetail&pk="+pk,
                    area:["100%","100%"],
                    resize:false,
                    cancel:function(index, layero){
                    },
                    success: function(layero, index){
                    }
                });
            }
        });


    },
    queryData:function () {
        consignmentManage.tableRender();
    },
    resetData:function () {
        $('#creationTime').data('startTime','');
        $('#creationTime').data('endTime','');
        $("#status").val("");
    }
}

$(document).ready(function () {
    consignmentManage.inital();
});