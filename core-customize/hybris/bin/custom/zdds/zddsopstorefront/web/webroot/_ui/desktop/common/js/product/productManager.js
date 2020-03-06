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
                var id = data.elem.id;
                var value = data.value;
                if(id == 'approvalStatus'){
                    $("#tempApprovalStatus").val(value);
                }else if(id == 'checkStatus'){
                    $("#tempCheckStatus").val(value);
                }
            });
            productManage.tableRender();
        });
    },
    tableRender:function () {
        var name = $('input[name="name"]').val();
        var code = $('input[name="code"]').val();
        // var status = $("#status").val();

        var approvalStatus = $("#tempApprovalStatus").val();
        var checkStatus = $("#tempCheckStatus").val();

        table.render({
            elem: '#table_data'
            ,url: webroot+'/product/productInfo'
            ,height:"full-190"
            ,cellMinWidth: 80
            ,page: true
            ,limits: [10, 20, 30]
            ,limit: 10 //每页默认显示的数量
            ,where:{name:name,code:code,approvalStatus:approvalStatus,checkStatus:checkStatus}
            ,cols: [[
                {field: 'pk', title: 'pk',hide:true},
                {align:'left',title: '序号',type:'numbers',width:100,minWidth:10}
                ,{field:'code', title: '商品编号'}
                ,{field:'name', title: '商品名称'}
                ,{field:'name', title: '商品品类'}
                ,{field:'approvalStatusName', title: '商品状态'}
                ,{field:'checkStatusName', title: '商品审核状态'}
                ,{field:'formattedValue', title: '建议零售价格',templet: function(d){
                        return d.recommedndPrice.formattedValue;
                    }}
                ,{field:'stockLevel', title: '库存'}
                ,{field:'creationTime', title: '商品创建时间'}
                ,{field:'onlineDate', title: '商品上架时间'}
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
        productManage.tableRender();
    },
    resetData:function () {
        $("#tempApprovalStatus").val("");
        $("#tempCheckStatus").val("");
    }
}

$(document).ready(function () {
    productManage.inital();
});