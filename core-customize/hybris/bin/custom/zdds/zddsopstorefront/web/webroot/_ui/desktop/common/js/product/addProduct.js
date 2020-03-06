var table;
var form;
var layer;
var layedit;
var laydate;

var addProductManage = {
    inital:function () {
        layui.use(['form', 'layedit', 'laydate','table','form'], function(){
            form = layui.form;
            layer = layui.layer;
            layedit = layui.layedit;
            laydate = layui.laydate;
            table = layui.table;

            //自定义验证规则
            form.verify({
                category: function(value){
                    if(value.length <= 0){
                        return '请选择类别';
                    }
                }
            });

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


            //监听提交
            form.on('submit(submit)', function(data){
                console.log(JSON.stringify(data.field));
                addProductManage.handleData("submit");
                return false;
            });
        });
    },
    saveProduct:function () {
        addProductManage.handleData("save");
    },
    handleData:function (obj) {
        var title = "";
        if(obj == "submit"){
            title = "提交数据";
        }else if(obj == "save"){
            title = "保存数据";
        }
        var data = {
            "name":$.trim($('input[name="name"]').val()),
        };
        $.ajax({
            url : webroot +"/product/save-submit-product",
            type : 'POST',
            data : JSON.stringify(data),
            contentType : 'application/json;charset=UTF-8',
            success : function(data) {
                if("S" == data.status){
                    layer.msg(title+"成功", {icon: 6,time: 2000});
                    return false;
                }else {
                    layer.msg(title+"失败", {icon: 5,time: 2000});
                    return false;
                }
            },
            error : function() {
                layer.msg("请您稍后重试....", {icon: 5,time: 2000});
                return false;
            }
        });
    }
}

$(document).ready(function () {
    addProductManage.inital();
});