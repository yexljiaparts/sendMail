<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/16
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageOne</title>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />--%>
<link rel="stylesheet" href="static/css/jstree/style.min.css"/>
</head>
<body>
<%--<div class='span12 main'>--%>
<div class='span3 main'>
    <div id="tree_1" class="tree-demo"></div>
</div>
<div class='span9 main'>
<input class="nav-flag" type="hidden" value="1" />
    <div class="tab-pane fade in active" id="pageOne">
        <p>测试</p>
        <table class="table table-striped table-bordered table-hover" id="sample_2"></table>
    </div>
    </div>
</body>
<content tag="pageScripts">
<script src="static/js/tree/baseJsTree.js"></script>
<script src="static/lib/jstree.min.js"></script>
    <%--<script src="static/lib/jstree.js"></script>--%>
    <script src="static/assets/scripts/core/app.js"></script>
    <script type="text/javascript" src="http://malsup.github.io/min/jquery.blockUI.min.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function () {
      bindJsTree("tree_1","/department/createDepTreeNode",false,true);
        $('#tree_1').on("select_node.jstree", function (e, data) {
//        var id = data.node.id;
            refresh_table(data);
        });
        //绑定树形结构创建节点事件
        $('#tree_1').on("create_node.jstree", function (e, data) {
//        var id = data.node.id;
            create_node(data);
        });
        //绑定树形结构重命名节点事件
        $('#tree_1').on("rename_node.jstree", function (e, data) {
//        var id = data.node.id;
            setTimeout(rename_node(data),100);

        });

        //绑定树形结构重命名节点事件
        $('#tree_1').on("hh.jstree", function (e, data) {
//        var id = data.node.id;
            setTimeout(rename_node(data),100);

        });
        //绑定树形结构删除节点事件
        $('#tree_1').on("delete_node.jstree", function (e, data) {
//        var id = data.node.id;
            delete_node(data);

        });
    });

    //树控件的变化事件处理



    //绑定树形结构点击事件
    function refresh_table(data){
        // console.dir(data);
        var _id =data.node.id;
        var  id=_id.split("_")[2];
        var pageContent = $('#sample_2');
        App.blockUI({target: pageContent, iconOnly: true});
        var oSettings = $('#sample_2').dataTable().fnSettings();
        var url = "employees/getEmployees?id=" +id;
        oSettings.sAjaxSource = url;
        $('#sample_2').dataTable().fnDraw(oSettings);
        App.unblockUI(pageContent);
    }
    //创建节点
    function create_node(data) {
        var _id =data.node.parent;
        var  id=_id.split("_")[2];
            $.post(
                    "department/operationDep",
                    {
                        "operation" : "create_node",
                        "id" : id,
                        "title" : data.node.text
                    });
        }


//修改节点名字
    function rename_node(data) {
        var _id =data.node.id;
        var  id=_id.split("_")[2];
        $.post(
                "department/operationDep",
                {
                    "operation" : "rename_node",
                    "id" : id,
                    "title":data.text

                });
    }

    //删除节点名字
    function delete_node(data) {
/*        alert(3);
        console.dir(data);*/
        var _id =data.node.id;
        var  id=_id.split("_")[2];
        $.ajax({
            url: "employees/booleanEmp",
            type: "POST",
            dataType:"json",
            data: {
                id:id
            },
            success: function (response) {
                if(response!=1&&response!=2){
                    $.post(
                            "department/operationDep",
                            {
                                "operation" : "delete_node",
                                "id" : id
                            });
                }else{
                    //刷新Jstree防止未删除页面仍显示删除
                    var tree = jQuery.jstree.reference("#tree_1");
                    tree.refresh();
                    if(response==1){
                        alert("无法删除总部门！");
                    }else if(response==2){
                        alert("此部门包含员工,无法删除！");
                    }
                    return ;
                }

            },
                error:function(response){
                    alert("删除失败");
        }
    });

    }
/*    function  onSelect() {
        "select_node.jstree", function (evt, data) {
            if (refresh_table)refresh_table(data);
        }
    }*/



/*   console.dir($(".vakata-context-separator").children().children()); ;*/

    </script>
    </content>
</html>
