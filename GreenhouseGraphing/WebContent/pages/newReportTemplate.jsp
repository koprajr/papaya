<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
    <style type="text/css">
        body {
            background-color: #D3CFB8;
        }
        .chart-configuration {
            float:            left;
            border:           1px solid lightgrey;
            padding:          10px;
            margin:           10px;
            background-color: #EBEBEB;
            min-width:        220px;
        }
    </style>
</head>

<body>
    <!--MAIN CONTENT AREA-->
    <div class="container container-main">
        <div class="row row-offcanvas row-offcanvas-right">
            <div class="col-sm-12">
    
                <div class="page-header reportTempCreation">
                    <h2>Create New Report Template</h2>
                </div><!-- /.page-header-->
    
                <div class="row reportTempCreation2">
                    <div class="col-sm-12">
                        <form role="form" action="saveReportTemplate" class="reportTempCreation2Form" method="post" placeholder="">
                            <div class="row">
                                <div class="col-sm-4">
                                    <h4 class="borderBottom" style="margin-top:0px !important;">Report Template Name</h4>
                                    <input class="form-control" type="text" name="bean.name" value="${bean.name}">
                                    <h4 class="borderBottom">Individual Graphs</h4>
                                    <div class="sensorList">
                                        <s:iterator value="sensors" var="sensor">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" name="sensorIds" value="${sensor.id}"> ${sensor.name}
                                                </label>
                                            </div>
                                        </s:iterator>
                                    </div>
                                    <h4 class="borderBottom">Calculated Total Values to Display</h4>
                                    <s:iterator value="equations" var="equation">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="equations" value="${equation.name}"> ${equation.name}
                                            </label>
                                        </div>
                                    </s:iterator>
                                    <h4 class="borderBottom">Manual Data</h4>
                                    <s:iterator value="manualData" var="md">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" name="manualIds" value="${md}"> ${md}
                                            </label>
                                        </div>
                                    </s:iterator>
                                </div>
                                <div id="chart-configuration-area" class="col-sm-8">
                                    <h4 class="borderBottom" style="margin-top:0px;">Grouped Charts </h4>
                                    <button id="chart-configuration-add" class="btn btn-default chart-configuration-add" type="button">Add Chart Configuration</button><br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4 col-sm-offset-4">
                                    <br><button type="submit" class="btn btn-block btn-primaryGreen">Save Report Template
                                        <span class="glyphicon glyphicon-arrow-right"></span></button><br>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div><!-- /.col-xs-12 .col-sm-12-->
        </div><!-- /.row .row-offcanvas .row-offcanvas-right-->
    </div><!--/.container .container-main-->

    <!-- LOAD JAVASCRIPT HERE SO THAT VIEW LOADS FASTER -->
    <script type="text/javascript">
        // - GLOBAL VARIABLES
        var generatedChartCount = 0;
        // - LOGIC TO ADD A CHART CONFIGURATION
        $('#chart-configuration-add').on('click', (function() {
            $('#chart-configuration-area').append(
                '<div class="chart-configuration"> \
                    <div class="form-group"> \
                        <label for="">Chart Name</label> \
                        <input class="form-control" type="text" name="configurationNames"> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">Type of Chart</label> \
                        <select class="form-control" name="configurationTypes"> \
                            <option value="Line">Line</option> \
                            <option value="Bar">Bar</option> \
                            <option value="Pie">Pie</option> \
                        </select> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">X- Label</label> \
                        <input class="form-control" type="text" name="configurationXLabels"> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">Y- Label</label> \
                        <input class="form-control" type="text" name="configurationYLabels"> \
                    </div> \
                    <label>Include selected sensors:</label> \
                    <div class="sensorList"> \
                        <s:iterator value="sensors" var="chartSensor"> \
                        <div class="checkbox"> \
                            <label> \
                                <input type="checkbox" name="chartSensorIds[' + generatedChartCount + ']" value="${chartSensor.id}"> ${chartSensor.name} \
                            </label> \
                        </div> \
                        </s:iterator> \
                    </div> \
                </div>'
            );
            generatedChartCount += 1;
        }));
    </script>
</body>
