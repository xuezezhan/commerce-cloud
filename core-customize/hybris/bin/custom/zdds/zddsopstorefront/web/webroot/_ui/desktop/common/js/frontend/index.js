layui.use('element', function(){
    // var element = layui.element;

    // element.on('tab(frontContent)', function(data){
    //     console.log(data);
    // });
});
$(function(){
    $('ul li a').click(function(obj){
        var path=  $(this).data("target");
        if(path != undefined && path != ""){
            // $('#targetFrame').attr("src", path);
            var title = $(this).text();
            tabAdd(title,path)
        }else{
            if($(obj.target).parent()[0].localName=="dd"){
                layer.msg('菜单路径不存在');
            }
        }
    });

    $("#frontContent>ul>li>i").on("click",function(){
        element.tabDelete("frontContent", $(this).parent().attr("lay-id"));
    })
    // $("#frontContent>ul>li:first").text("首页");
})

function tabAdd(title,url){
    var element = layui.element;
    var tabli = $("#frontContent>ul>li");
    var newTabIndex = $("#frontContent>ul>li:last").attr("lay-id")?(parseInt($("#frontContent>ul>li:last").attr("lay-id"))+1):1;

    for(var i = 0 ; i<tabli.length; i++){
        if($(tabli[i]).text().replace("ဆ","") == title){
            element.tabChange("frontContent", $(tabli[i]).attr("lay-id"));
            $("#frontContent>ul>li>i").on("click",function(){
                element.tabDelete("frontContent", $(this).parent().attr("lay-id"));
            })
            return false;
        }
    }

    element.tabAdd('frontContent', {
        title: title+'<i class="layui-icon layui-unselect layui-tab-close">ဆ</i>'
        ,content: '<iframe id="targetFrame" src="'+url+'" style="border:0px;padding:0px;width:100%;height:100%"></iframe>', //支持传入html
        id:newTabIndex,
    });
    element.tabChange("frontContent", newTabIndex);
    $("#frontContent>ul>li>i").on("click",function(){
        element.tabDelete("frontContent", $(this).parent().attr("lay-id"));
    })
}

function closeTab(obj) {
    $(obj).parent().remove();
    $("#iframe2").parent().remove();
    $($("#frontContent>ul>li")[0]).addClass("layui-this");
    $($("#frontContent>div>div")[0]).addClass("layui-show");
}
function openDetail(orderCode) {
    alert(orderCode);
}


