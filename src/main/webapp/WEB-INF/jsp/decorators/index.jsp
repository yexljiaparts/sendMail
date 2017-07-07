<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title><sitemesh:title/></title>
    <base href="<%=basePath%>">
    <link href="static/css/bootstrap/bootstrap-combined.min.css" rel="stylesheet">
    <link href="static/css/dataTable/jquery.dataTables.css" rel="stylesheet">
    <link href="static/css/jstree/style.min.css" rel="stylesheet">
    <%----%>
   <%-- <link href="/Content/metronic/simple-line-icons/simple-line-icons.min.css" rel="stylesheet"/>--%>
    <link href="static/assets/css/google-font.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/themes/light.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="static/assets/css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <link href="static/assets/css/custom.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/menu.css" rel="stylesheet" type="text/css"/>
    <style type='text/css'>
        body {
            background-color: #CCC;
        }
        #content {
            background-color: #FFF;
            border-radius: 5px;
        }
        #content .main {
            padding: 35px;
        }
        #content .sidebar {
            padding: 10px;
        }
        #content p {
            line-height: 30px;
        }
      /*  .nav{
            float:left
        }*/
        #myTab ul{
            list-style-type:none;
            margin:0;
            padding:0;
            overflow:hidden;
        }
        #myTab ul li{
            display:inline;
        }
     /*   #myTab ul li a{
            background-color:#dddddd; ;
        }*/

  /*      #myTab ul li a:link,a:visited
        {
            font-weight:bold;
            color:#FFFFFF;
            background-color:#98bf21;
            text-align:center;
            padding:6px;
            text-decoration:none;
            text-transform:uppercase;
        }*/

        #myTab ul li > a:hover,a:active
        {
            background-color:#7A991A;
        }



        #myTab ul li .active
        {
            border: 2px solid #D4D4D4;
            background-color: #b92c28;
        }
    </style>
    <sitemesh:head/>
</head>
<body>
<div class='container'>
    <h1>邮件发送系统</h1>
    <div class='navbar navbar-inverse'>
     <%--   <div class='navbar-inner nav-collapse' style="height: auto;">--%>
        <div id="myTab" >
            <ul >
               <%-- <li class="list-item" url="/home"><a href="/home">Home</a></li>--%>
                   <li onclick="pageManager(0)" ><a class="active"  href="/home">Home</a></li>
                   <li onclick="pageManager(1)"><a href="/pageone">Page One</a></li>
                <%--   <li><a href="contact.asp">Contact</a></li>--%>
                 <%--  <a href="/home"><li onclick="pageManager(0)"  >Home</li></a>
                   <a href="/pageone"><li onclick="pageManager(1)">Page One</li></a>--%>
                   <li  onclick="pageManager(2)"><a href="/index">Page two</a></li>

<%--                <li class="list-item"><a href="/pageone">Page One</a></li>--%>
             <%--   <li id="page2" class="dropdown">
                    <a href="#" id="myTabDrop1" class="dropdown-toggle"
                       data-toggle="dropdown">Java
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                        <li><a href="#jmeter" tabindex="-1" data-toggle="tab">jmeter</a></li>
                        <li><a href="#ejb" tabindex="-1" data-toggle="tab">ejb</a></li>
                    </ul>
                </li>--%>
            </ul>
        </div>
<%--        </div>--%>
    </div>
    <div id='content' class='row-fluid'>
        <div class='span12 main'>
            <sitemesh:body/>
        </div>

    </div>
</div>

</body>

<content tag="pagePlugins">
    <script type="text/javascript" src="static/lib/jquery-1.10.2.js"></script>
    <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="static/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/lib/jquery.dataTables.js"></script>
    <script type="text/javascript" src="static/lib/DT_bootstrap.js"></script>



</content>

    <script src="static/js/dataTable/homeTable.js"></script>
<%--
    <script>window.$q=[];window.$=window.jQuery=function(a){window.$q.push(a);};</script>
--%>

    <script type="text/javascript">
    /*    $(function () {
            $('#myTab a:last').tab('show');
        })*/
        var dataTables1;
        var dataTables2;
   /*     jQuery(document).ready(function () {*/
            dataTables1 = initTable();
            dataTables2= initTable2();

    /*    });*/

    $(function(){
        $(".nav li").click(function () {
            var herfUrl=$(this).attr("url");
            window.location=herfUrl;
        });
        var navFlag=$(".nav-flag").val();
        if(!isNullOrEmpty(navFlag)){
            navFlag=parseInt(navFlag);
            var navItem=$($(".nav li")[navFlag]);
        /*    navItem.removeClass("list-item")*/
            navItem.addClass("active");
        }
    });

    function isNullOrEmpty(obj){
        if(obj==null||obj==""||obj==undefined){
            return true;
        }else{
            return false;
        }
    }



        </script>
    <sitemesh:getProperty property="page.pageScripts"/>

</html>
