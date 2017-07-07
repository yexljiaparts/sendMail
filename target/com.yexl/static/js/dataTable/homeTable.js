/**
 * Created by Administrator on 2017/2/18.
 */
function initTable() {
    var dataTable = $('#sample_1').dataTable({
        "bServerSide": true, //是否启动服务器端数据导入
        "aLengthMenu": [
            [10, 20, 50],
            [10, 20, 50]
        ], //更改显示记录数选项
        "iDisplayLength": 10, //默认显示的记录数
        "sPaginationType": "bootstrap", //详细分页组，可以支持直接跳转到某页
        "aaSorting": [
            [0, "asc"]
        ], //默认的排序方式，第2列，升序排列
        "bFilter": false, //是否启动过滤、搜索功能
        "bDestroy": true,
        "bLengthChange": false,
        "oLanguage": { //国际化配置
            "sProcessing": "正在获取数据，请稍后...",
            "sLengthMenu": "显示 _MENU_ 条",
            "sZeroRecords": "该区域没有绑定组织",
            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "记录数为0",
            "sInfoFiltered": "(全部记录数 _MAX_ 条)",
            "sInfoPostFix": "",
            "sSearch": "搜索",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "最后一页"
            }
        },
        "aoColumns": [
      /*      console.dir(data),*/
            {"mData": "id", "sTitle": "组织标识", "sClass": "center", "bSortable": false},
         //   {"mData": "jobNum", "sTitle": "组织名称", "sClass": "center", "bSortable": false},
            {"mData": "money", "sTitle": "联系人", "sClass": "center", "bSortable": false},
            {
                "mData": null,
                "sTitle": "部门",
                "sClass": "center",
                "bSortable": false,
                "fnRender": function (obj) {
             /*       var delButton = "";
                    if(1==1){
                        delButton = "<button type=\"button\" class=\"btn btn-xs red\" onclick=\"delRoleUser(" + obj.aData.userId + ");\">删除</button>";
                    }*/
             console.dir(obj);

                    return 1;
                   /* return obj.aData.department.name;*/
                }
            },            /*
            {"mData": "phone", "sTitle": "联系电话", "sClass": "center", "bSortable": false},
*/
            {"mData": "sort", "sTitle": "地址", "sClass": "center", "bSortable": false}
 /*           {
                "mData": null,
                "sTitle": "操作",
                "sClass": "center",
                "bSortable": false,
                "fnRender": function (obj) {
                    var delButton =""
                 /!*   if(permTag != null && permTag != "") {
                        delButton = "<shiro:hasPermission name=\"delAreaOrg\"><button type=\"button\" class=\"btn btn-xs red\" onclick=\"delAreaOrg('" + obj.aData.orgCode + "');\">取消分配</button></shiro:hasPermission>";
                    }*!/
                    return delButton;
                }
            }*/
        ],
        "sAjaxSource": "/data/getData"
    });
/*    alert(dataTable);*/
    return dataTable;
}

function initTable2() {
    var dataTable = $('#sample_2').dataTable({
        "bServerSide": true, //是否启动服务器端数据导入
        "aLengthMenu": [
            [10, 20, 50],
            [10, 20, 50]
        ], //更改显示记录数选项
        "iDisplayLength": 5, //默认显示的记录数
        "sPaginationType": "bootstrap", //详细分页组，可以支持直接跳转到某页
        "aaSorting": [
            [0, "asc"]
        ], //默认的排序方式，第2列，升序排列
        "bFilter": false, //是否启动过滤、搜索功能
        "bSort": true, //排序功能
        "bDestroy": true,
        "bLengthChange": false,
        "oLanguage": { //国际化配置
            "sProcessing": "正在获取数据，请稍后...",
            "sLengthMenu": "显示 _MENU_ 条",
            "sZeroRecords": "该区域没有绑定组织",
            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "记录数为0",
            "sInfoFiltered": "(全部记录数 _MAX_ 条)",
            "sInfoPostFix": "",
            "sSearch": "搜索",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "最后一页"
            }
        },
        "aoColumns": [
            /*      console.dir(data),*/
            {"mData": "id", "sTitle": "组织标识", "sClass": "center", "bSortable": true},
         //   {"mData": "jobNum", "sTitle": "组织名称", "sClass": "center", "bSortable": false},
     {"mData": "name", "sTitle": "姓名", "sClass": "center", "bSortable": false},
            {"mData": "sex", "sTitle": "性别", "sClass": "center", "bSortable": false},
            {
                "mData": null,
                "sTitle": "部门",
                "sClass": "center",
                "bSortable": false,
                "fnRender": function (_obj) {
                    /*       var delButton = "";
                     if(1==1){
                     delButton = "<button type=\"button\" class=\"btn btn-xs red\" onclick=\"delRoleUser(" + obj.aData.userId + ");\">删除</button>";
                     }*/

                    return _obj.aData.department.name;
                    /* return obj.aData.department.name;*/
                }
            },
             {"mData": "phone", "sTitle": "联系电话", "sClass": "center", "bSortable": false},
           {"mData": "mail", "sTitle": "邮箱", "sClass": "center", "bSortable": false}
            /*           {
             "mData": null,
             "sTitle": "操作",
             "sClass": "center",
             "bSortable": false,
             "fnRender": function (obj) {
             var delButton =""
             /!*   if(permTag != null && permTag != "") {
             delButton = "<shiro:hasPermission name=\"delAreaOrg\"><button type=\"button\" class=\"btn btn-xs red\" onclick=\"delAreaOrg('" + obj.aData.orgCode + "');\">取消分配</button></shiro:hasPermission>";
             }*!/
             return delButton;
             }
             }*/
        ],
        "sAjaxSource": "/employees/getEmployees"
    });
    /*    alert(dataTable);*/
    return dataTable;
}