<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
    <style type="text/css">
        body {
            background-color: #D3CFB8;
        }
        .container-breadcrumb {
            margin-bottom: 0px;
        }
    </style>
</head>

<!--BREADCRUBS-->
<div class="container-breadcrumb">
    <div class="container">
        <ol class="breadcrumb "> <!--add class "hide" to get rid of breadcrumbs-->
            <li><a href="#">Home</a></li>
            <li class="active">Create Report Template</li>
        </ol>
    </div><!-- /.container-->
</div><!-- /.container-breadcrumb-->

<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <form role="form" action="saveReportTemplate" class="reportTempCreation1Form" method="post" placeholder="">
        <div class="col-sm-8">
            <div class="page-header reportTempCreation">
                <h2>Create New Report Template</h2>
            </div><!-- /.page-header-->

            <!-- ---------------------------------------------------------------------------------------- -->
            <div id="overall_breadcrumbNav" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li class="active">Top Level</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="greenhouse_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li class="active">Greenhouse</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="greenhouseWater_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li><a onclick="goTo_greenhouse();">Greenhouse</a></li>
                                <li class="active">Water System</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="greenhouseLight_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li><a onclick="goTo_greenhouse();">Greenhouse</a></li>
                                <li class="active">Lighting System</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="greenhouseTemp_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li><a onclick="goTo_greenhouse();">Greenhouse</a></li>
                                <li class="active">Temperature System</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="greenhouseElec_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li><a onclick="goTo_greenhouse();">Greenhouse</a></li>
                                <li class="active">Electricity System</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <div id="digester_breadcrumbNav" style="display:none;" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="container-breadcrumb2">
                        <div class="container" style="width:100%;">
                            <ol class="breadcrumb"> <!--add class "hide" to get rid of breadcrumbs-->
                                <li><a onclick="goTo_topLevel();">Top Level</a></li>
                                <li class="active">Digester</li>
                            </ol>
                        </div><!-- /.container-->
                    </div><!-- /.container-breadcrumb-->
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->
            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- MAIN IMAGE -->
            <div id="overall_Image" class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG">
                        <!--TOP LEVEL SYSTEM GRAPHIC-->
                        <map name="MainPicMap">
                            <area onclick="goTo_greenhouse();" shape="polygon" coords="34, 240, 35, 193, 124, 161, 154, 162, 235, 194, 235, 243, 34, 243"> <!--Greenhouse-->
                            <area href="#" shape="polygon" coords="262, 171, 282, 109, 277, 89, 305, 75, 393, 75, 427, 98, 427, 175, 262, 177"> <!--Energy Cabin-->
                            <area onclick="goTo_digester();" shape="polygon" coords="308, 306, 360, 292, 389, 292, 424, 310, 425, 414, 363, 426, 307, 411"> <!--Digester-->
                            <area href="#" shape="rect" coords="217, 6, 382, 33"> <!--Overall System-->
                        </map>
                        <img class="mainSystemNavImage img-responsive hidden-md hidden-sm hidden-xs" style="width:720px;" src="img/mainNavImage.jpg" usemap="#MainPicMap"/>

                        <div class="row visible-md visible-sm visible-xs">
                            <div class="col-md-4 col-md-offset-4">
                                <button onclick="goTo_greenhouse();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Greenhouse</button>
                                <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Energy Cabin</button>
                                <button onclick="goTo_digester();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Digester</button>
                                <button type="button" class="btn btn-lg btn-primaryGreen btn-block">Overall System</button>
                                <br>
                            </div><!-- /.col-md-4 .col-md-offset-4-->
                        </div><!-- /.row .visible-xs-->
                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- GREENHOUSE IMAGE -->
            <div id="greenhouse_Image" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG">
                        <!--GREENHOUSE GRAPHIC-->
                        <map name="greenhouseMap">
                            <area onclick="goTo_greenhouseWater();" shape="rect" coords="26, 59, 141, 97"> <!-- Water System Room 1 -->
                            <area onclick="goTo_greenhouseLight();" shape="rect" coords="26, 102, 141, 140"> <!-- Lighting System Room 1 -->
                            <area onclick="goTo_greenhouseTemp();" shape="rect" coords="25, 145, 139, 179"> <!-- Temperature Control Room 1 -->
                            <area onclick="goTo_greenhouseElec();" shape="rect" coords="24, 184, 140, 220"> <!-- Electricity Room 1 -->
                            <area onclick="goTo_greenhouseWater();" shape="rect" coords="213, 61, 324, 96"> <!-- Water System Room 2 -->
                            <area onclick="goTo_greenhouseLight();" shape="rect" coords="213, 103, 324, 139"> <!-- Lighting System Room 2 -->
                            <area onclick="goTo_greenhouseTemp();" shape="rect" coords="213, 144, 324, 180"> <!-- Temperature Control Room 2 -->
                            <area onclick="goTo_greenhouseWater();" shape="rect" coords="395, 60, 507, 95"> <!-- Water System Room 3 -->
                            <area onclick="goTo_greenhouseLight();" shape="rect" coords="395, 102, 508, 140"> <!-- Lighting System Room 3 -->
                            <area onclick="goTo_greenhouseTemp();" shape="rect" coords="395, 144, 508, 179"> <!-- Temperature Control Room 3 -->
                            <area onclick="goTo_greenhouseElec();" shape="rect" coords="396, 185, 507, 221"> <!-- Electricity Room 3 -->
                            <area onclick="goTo_greenhouseElec();" shape="rect" coords="432, 331, 541, 367"> <!-- Electricity Total -->
                        </map>

                        <img class="mainSystemNavImage img-responsive hidden-md hidden-sm hidden-xs" style="width:581px"src="img/greenhouse.png" usemap="#greenhouseMap"/>

                        <div class="row visible-md visible-sm visible-xs">
                            <div class="col-md-4 col-md-offset-4">
                                <button onclick="goTo_greenhouseWater();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Water System</button>
                                <button onclick="goTo_greenhouseLight();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Lighting System</button>
                                <button onclick="goTo_greenhouseTemp();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Temperature Control</button>
                                <button onclick="goTo_greenhouseElec();" type="button" class="btn btn-lg btn-primaryGreen btn-block">Electricity</button>
                                <br>
                            </div><!-- /.col-md-4 .col-md-offset-4-->
                        </div><!-- /.row .visible-xs-->
                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- GREENHOUSE WATER LIST -->
            <div id="greenhouseWater_List" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG" style="padding: 20px;">

                        <s:iterator value="sensors" var="sensor">
                            <div class="reportEntry">
                                <h4>${sensor.name}
                                    <div class="reportButtons">
                                        <a onclick="check('${sensor.id}', '${sensor.id}_input');" type="button" class="btn btn-primaryGreen reportList" data-toggle="modal" data-target="#myModal">Add to template
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </a>
                                    </div>
                                </h4>
                            </div><!-- /.reportEntry-->
                        </s:iterator>

                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- GREENHOUSE LIGHTING LIST -->
            <div id="greenhouseLight_List" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG" style="padding: 20px;">

                        <s:iterator value="" var="">
                            <div class="reportEntry">
                                <h4>Name of some Manual Data Point
                                    <div class="reportButtons">
                                        <a onclick="check('test', 'test_input');" type="button" class="btn btn-primaryGreen reportList" data-toggle="modal" data-target="#myModal">Add to template
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </a>
                                    </div>
                                </h4>
                            </div><!-- /.reportEntry-->
                        </s:iterator>

                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- GREENHOUSE TEMPERATURE LIST -->
            <div id="greenhouseTemp_List" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG" style="padding: 20px;">

                        <s:iterator value="" var="">
                            <div class="reportEntry">
                                <h4>Name of some Manual Data Point
                                    <div class="reportButtons">
                                        <a onclick="check('test', 'test_input');" type="button" class="btn btn-primaryGreen reportList" data-toggle="modal" data-target="#myModal">Add to template
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </a>
                                    </div>
                                </h4>
                            </div><!-- /.reportEntry-->
                        </s:iterator>

                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- GREENHOUSE ELECTRICITY LIST -->
            <div id="greenhouseElec_List" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG" style="padding: 20px;">

                        <s:iterator value="" var="">
                            <div class="reportEntry">
                                <h4>Name of some Manual Data Point
                                    <div class="reportButtons">
                                        <a onclick="check('test', 'test_input');" type="button" class="btn btn-primaryGreen reportList" data-toggle="modal" data-target="#myModal">Add to template
                                            <span class="glyphicon glyphicon-plus"></span>
                                        </a>
                                    </div>
                                </h4>
                            </div><!-- /.reportEntry-->
                        </s:iterator>

                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!-- Digester IMAGE -->
            <div id="digester_Image" class="row" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="whiteBG">
                        <a href="#"><img class="mainSystemNavImage img-responsive" style="width:581px"src="img/digester.png"/></a>
                    </div>
                </div><!-- /.col-xs-12 .col-sm-12-->
            </div><!-- /.row .row-offcanvas .row-offcanvas-right-->

            <!-- ---------------------------------------------------------------------------------------- -->

            <!--MANUAL ENTER DATA-->
            <div id="manualData" class="row manualEnterData" style="display:none;">
                <div class="col-xs-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Manually Data Entered</h3>
                        </div><!-- /.panel-heading-->
                        <div class="panel-body">

                            <s:iterator value="manualDataTypes" var="md">
                                <div class="reportEntry">
                                    <h4>${md}
                                        <div class="reportButtons">
                                            <a onclick="check('${md}', '${md}_input');" type="button" class="btn btn-primaryGreen reportList">Add to template
                                                <span class="glyphicon glyphicon-plus"></span>
                                            </a>
                                        </div>
                                    </h4>
                                </div><!-- /.reportEntry-->
                            </s:iterator>

                        </div><!-- /.panel .panel-default-->
                    </div><!-- /.panel .panel-default-->
                </div><!-- /.col-md-8 .col-md-offset-1-->
            </div><!-- /.row .manualEnterData-->

            </div><!-- /.col-xs-8 .col-sm-8-->

            <div id="chart-configuration-area" class="col-sm-4 reportTempCreation2" style="border-top:0px;">
                <h4 class="borderBottom" style="margin-top:20px !important;">Report Template Name</h4>
                <input class="form-control" type="text" name="template.name" autofocus>

                <h4 class="borderBottom">Sensor / Data List <small> to include in the report</small></h4>
                <div class="senorListnoHeight">
                    <s:iterator value="sensors" var="sensor">
                        <div id="${sensor.id}" class="checkbox" style="display:none;">
                            <label> <input id="${sensor.id}_input" type="checkbox" name="sensorIds" value="${sensor.id}"> ${sensor.name}</label>
                            <span onclick="uncheck('${sensor.id}', '${sensor.id}_input');" class="glyphicon glyphicon-remove"></span>
                        </div>
                    </s:iterator>
                    <s:iterator value="manualDataTypes" var="md">
                        <div id="${md}" class="checkbox" style="display:none;">
                            <label> <input id="${md}_input" type="checkbox" name="manualIds" value="${md}"> ${md}</label>
                            <span onclick="uncheck('${md}', '${md}_input');" class="glyphicon glyphicon-remove"></span>
                        </div>
                    </s:iterator>
                </div>

                <br><button type="submit" style="margin-top:25px;" class="btn btn-block btn-primaryGreen">Save Report Template
                <span class="glyphicon glyphicon-arrow-right"></span></button><br>
            </div>
        </form>
    </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
</div><!--/.container .container-main-->

<script type="text/javascript">
    function showHideDiv(div_id, showOrHide) {
        if (showOrHide == 0){
            //document.getElementById( div_id ).style.visibility="visible";
            document.getElementById( div_id ).style.display="inherit";
        }
        else {
            //document.getElementById( div_id ).style.visibility="hidden";
            document.getElementById( div_id ).style.display="none";
        }
    }
    function check(div_id, input_id){
        document.getElementById(input_id).checked=true;
        document.getElementById(div_id).style.display="list-item";
    }
    function uncheck(div_id, input_id){
        document.getElementById(input_id).checked=false;
        document.getElementById(div_id).style.display="none";
    }
    function goTo_topLevel() {
        showHideDiv('overall_Image', 0);
        showHideDiv('overall_breadcrumbNav', 0);

        showHideDiv('greenhouse_Image', 1);
        showHideDiv('greenhouse_breadcrumbNav', 1);

        showHideDiv('digester_Image', 1);
        showHideDiv('digester_breadcrumbNav', 1);

        showHideDiv('greenhouseWater_breadcrumbNav', 1);
        showHideDiv('greenhouseLight_breadcrumbNav', 1);
        showHideDiv('greenhouseTemp_breadcrumbNav', 1);
        showHideDiv('greenhouseElec_breadcrumbNav', 1);
        showHideDiv('greenhouseWater_List', 1);
        showHideDiv('greenhouseLight_List', 1);
        showHideDiv('greenhouseTemp_List', 1);
        showHideDiv('greenhouseElec_List', 1);

        showHideDiv('manualData', 1);
    }
    function goTo_greenhouse() {
        showHideDiv('overall_Image', 1);
        showHideDiv('overall_breadcrumbNav', 1);

        showHideDiv('greenhouseWater_breadcrumbNav', 1);
        showHideDiv('greenhouseLight_breadcrumbNav', 1);
        showHideDiv('greenhouseTemp_breadcrumbNav', 1);
        showHideDiv('greenhouseElec_breadcrumbNav', 1);
        showHideDiv('greenhouseWater_List', 1);
        showHideDiv('greenhouseLight_List', 1);
        showHideDiv('greenhouseTemp_List', 1);
        showHideDiv('greenhouseElec_List', 1);

        showHideDiv('greenhouse_Image', 0);
        showHideDiv('greenhouse_breadcrumbNav', 0);
        showHideDiv('manualData', 0);
    }

    function goTo_greenhouseWater() {
        showHideDiv('greenhouse_Image', 1);
        showHideDiv('greenhouse_breadcrumbNav', 1);

        showHideDiv('greenhouseWater_breadcrumbNav', 0);
        showHideDiv('greenhouseWater_List', 0);
    }

    function goTo_greenhouseLight() {
        showHideDiv('greenhouse_Image', 1);
        showHideDiv('greenhouse_breadcrumbNav', 1);

        showHideDiv('greenhouseLight_breadcrumbNav', 0);
        showHideDiv('greenhouseLight_List', 0);
    }

    function goTo_greenhouseTemp() {
        showHideDiv('greenhouse_Image', 1);
        showHideDiv('greenhouse_breadcrumbNav', 1);

        showHideDiv('greenhouseTemp_breadcrumbNav', 0);
        showHideDiv('greenhouseTemp_List', 0);
    }

    function goTo_greenhouseElec() {
        showHideDiv('greenhouse_Image', 1);
        showHideDiv('greenhouse_breadcrumbNav', 1);

        showHideDiv('greenhouseElec_breadcrumbNav', 0);
        showHideDiv('greenhouseElec_List', 0);
    }

    function goTo_digester() {
        showHideDiv('overall_Image', 1);
        showHideDiv('overall_breadcrumbNav', 1);

        //showHideDiv('digesterList_breadcrumbNav', 1);
        //showHideDiv('digesterList_List', 1);

        showHideDiv('digester_Image', 0);
        showHideDiv('digester_breadcrumbNav', 0);
        showHideDiv('manualData', 0);
    }

</script>
