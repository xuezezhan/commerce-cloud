SelectUtils = {
    init:function(id, functionName, url, queryparam, emptyText, text, code, filter){
        var param = new Object();
        param.id = id;
        param.functionName = functionName;
        param.filter = filter;
        param.url = url;
        param.param = queryparam;
        param.text = text;
        param.code = code;
        param.emptyText = emptyText;
        if (param.functionName) {
            param.onSelect;
        }
        if (!param.filter) {
            param.filter = id;
        }
        this.loadUrl(param);
        return param;
    },
    /**加载远程数据
     *
     * @param param 对象
     */
    loadUrl : function(param){
        $.ajax({
            url: param.url,
            method: "get",
            data: param.param,
            async: false,
            success: function (data) {
                $("#" + param.id).empty();
                $("#" + param.id + "+div:first dl:first").empty();
                $("#" + param.id + "+div:first>div:first input").val("");
                var codeStr = param.code ? param.code : "code";
                var valueStr = param.text ? param.text : "value";
                var selectData;
                if (data.constructor == Array) {
                    selectData = data;
                    $("#" + param.id).append("<option value='' class=''>"+param.emptyText+"</option>");
                } else if (data.constructor == Object) {
                    selectData = data.data;
                    $("#" + param.id).append("<option value='' class=''>"+param.emptyText+"</option>");
                } else {
                    $("#" + param.id).append("<option value='' class=''>"+param.emptyText+"</option>");
                }
                for (var p in selectData) {
                    var row = selectData[p];
                    $("#" + param.id).append("<option value='" + row[codeStr] + "'>" + row[valueStr] + "</option>");
                    $("#" + param.id + "+div:first dl:first").append("<dd lay-value='" + row[codeStr] + "'>" + row[valueStr] + "</dd>")
                }
            }
        })
        form.render('select',param.filter);
        if (param.functionName) {
            this.onSelect(param);
        }
    },
    /**
     * 绑定选择点击方法
     * @param param 对象
     */
    onSelect : function(param){
        var dds = $("#" + param.id + "+div:first>dl:first dd");
        for (var i = 0; i < dds.length; i++) {
            var dd = $(dds[i]);
            dd.attr("onclick", param.functionName + "('" + dd.attr('lay-value') + "','" + dd.html() + "')");
        }
    },
    /**加载本地数据
     *
     * @param param 对象
     */
    loadData:function (param,data) {
        $("#" + param.id).empty();
        $("#" + param.id + "+div:first dl:first").empty();
        $("#" + param.id + "+div:first>div:first input").val("");
        for (var p in data) {
            var row = data[p];
            $("#" + param.id).append("<option value='" + row.value + "'>" + row.code + "</option>");
            $("#" + param.id + "+div:first dl:first").append("<dd lay-value='" + row.value + "' class>" + row.code + "</dd>")
        }
        form.render('select', param.filter);
        if (param.functionName) {
            this.onSelect(param);
        }
    },
    getCode:function (id) {
        var select = $("#" + id + " option:selected");
        return select.val();
    },
    getText:function (id) {
        var select = $("#" + id + " option:selected");
        return select.text();
    },
    clear:function (id) {
        $("#" + id).empty();
        $("#" + id + "+div:first dl:first").empty();
        $("#" + id + "+div:first>div:first input").val("");
    },
    setCode:function(id,code){
        $('#' + id).val(code);
        var index = undefined;
        var select = $("#" + id + " option");
        if(code){
            for(var i = 0 ; i<select.length;i++){
                if(code == $(select[i]).val()){
                    index = i;
                    break;
                }
            }

        }else{
            index = 0;
        }
        var dlSelected = $("#"+id+"+div:first>dl:first>dd.layui-this");
        if(dlSelected.length == 1){
            $("#"+id+"+div:first>dl:first>dd.layui-this").attr("class","");
        }
        var dls = $("#"+id+"+div:first>dl:first>dd");
        $(dls[index]).attr("class","layui-this");
        $("#"+id+"+div:first>div:first input").val($(dls[index]).text());
    }

}

var webroot="/zddsopstorefront";