/**
 * Created by Administrator on 2017/4/19.
 */
//以指定的Json数据，初始化JStree控件
//treeName为树div名称，url为数据源地址，checkbox为是否显示复选框，loadedfunction为加载完毕的回调函数
function bindJsTree(treeName, url, checkbox,contextmenu, loadedfunction) {
    var control = $('#' + treeName)
    control.data('jstree', false);//清空数据，必须

/*    control.bind(
        "deselect_node.jstree", function (evt, data) {
            if (onDeselect)onDeselect(data);
        }
    );
    control.bind(
        "select_node.jstree", function (evt, data) {
            if (onSelect)onSelect(data);
        }
    );*/

    var isCheck = checkbox|| false; //设置checkbox默认值为false
    var isContextmenu = contextmenu|| false; //设置checkbox默认值为false
    if(isCheck) {
        //复选框树的初始化
        $.getJSON(url, function (data) {
            control.jstree({
                'plugins' : [ "checkbox" ], //出现选择框
                'checkbox': { cascade: "", three_state: false }, //不级联
                'core': {
                    'data': data,
                    "themes": {
                        "responsive": false
                    }
                }
            }).bind('loaded.jstree', loadedfunction);
        });
    }
    else {
        if(isContextmenu){
            //加入contextmenu树列表的初始化
            $.getJSON(url, function (data) {
                control.jstree({
                    'plugins' : [  "themes", "html_data","contextmenu", "dnd",
                        "state", "types", "wholerow"],
                    'core': {
                        "animation" : 0,
                        "check_callback" : true,
                        'data': data,
                        "themes": {
                            "responsive": false,
                            "stripes" : true
                        }
                    },
                    'types' : {
                        "default" : {
                            "icon" :true
                            /*    "icon" : "fa fa-folder icon-warning icon-lg",
                             "valid_children" : ["default","text"]*/
                        }/*,
                         "text" : {
                         "icon" : "fa fa-file icon-info icon-lg",
                         "valid_children" : []
                         }*/
                    }/*,"contextmenu":{
                        "items": {
                        /!*    "ccp": null*!/
                        }
                    }*/
                    /*,
                    "contextmenu":{
                        "items": {
                            "新增" : {
                                "separator_before"	: false,
                                "separator_after"	: true,
                                "_disabled"			: false, //(this.check("create_node", data.reference, {}, "last")),
                                "label"				: "新增",
                                "action"			: function (data) {
                                    addNode(data);

                                }
                            },
                            "编辑" : {
                                "separator_before"	: false,
                                "separator_after"	: false,
                                "_disabled"			: false, //(this.check("rename_node", data.reference, this.get_parent(data.reference), "")),
                                "label"				: "编辑",
                                "action"			: function (data) {
                                    editNode(data);
                                }
                            },
                            "刷新权限点" : {
                                "separator_before"	: false,
                                "separator_after"	: false,
                                "_disabled"			: false, //(this.check("rename_node", data.reference, this.get_parent(data.reference), "")),
                                "label"				: "刷新权限点",
                                "action"			: function (data) {
                                    refreshPermission(data);
                                }
                            }
                    }
                    }*/
                }).bind('loaded.jstree', loadedfunction);
            });
        }else{
            //普通树列表的初始化
            $.getJSON(url, function (data) {
                control.jstree({
                    'plugins' : [ "state", "types", "wholerow" ],
                    'core': {
                        'data': data,
                        "themes": {
                            "responsive": false,
                            "stripes" : true
                        }
                    },
                    'types' : {
                        "default" : {
                            "icon" :true
                            /*    "icon" : "fa fa-folder icon-warning icon-lg",
                             "valid_children" : ["default","text"]*/
                        }/*,
                         "text" : {
                         "icon" : "fa fa-file icon-info icon-lg",
                         "valid_children" : []
                         }*/
                    }
                }).bind('loaded.jstree', loadedfunction);
            });

        }
    }
}