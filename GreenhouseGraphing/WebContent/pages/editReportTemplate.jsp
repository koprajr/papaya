<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<head>
    <style type="text/css">
        body {
            background-color: #D3CFB8;
        }

        .chart-configuration {
            float: left;
            border: 1px solid lightgrey;
            padding: 10px;
            margin: 10px;
            background-color: #EBEBEB;
            min-width: 220px;
        }
    </style>
</head>

<body>
<!--MAIN CONTENT AREA-->
<div class="container container-main">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-sm-12">

            <div class="page-header reportTempCreation">
                <h2>Edit Report Template</h2>
            </div>
            <!-- /.page-header-->

            <div class="row reportTempCreation2">
                <div class="col-sm-12">
    <form role="form" action="updateReportTemplate" class="reportTempCreation2Form" method="post">
        <div class="row">
            <div class="col-xs-4">
                <h4 class="borderBottom" style="margin-top:0px !important;">Report Template Name *</h4>
                <input type="hidden" name="oldTemplateName" value="${template.name}">
                <input class="form-control" type="text" name="templateName" value="${template.name}">
                <h4 class="borderBottom">Report Template Description</h4>
                <textarea class="form-control" name="templateDescription">${template.description}</textarea>
                <h4 class="borderBottom">Individual Graphs</h4>
                <s:if test="%{sensors.isEmpty()}">
                    <h5>There are no data sensors included in this report template!</h5>
                </s:if>
<s:else>

                <div class="sensorList">
                    <s:iterator value="sensors" var="sensor">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="sensorIds" value="${sensor.id}" checked> ${sensor.name}
                            </label>
                        </div>
                    </s:iterator>
                </div>
</s:else>
<h4 class="borderBottom">Manual Data</h4>
<s:if test="%{manualData.isEmpty()}">
    <h5>There are no manual data included in this report template!</h5>
</s:if>
<s:else>

                <div class="sensorList">
                    <s:iterator value="manualData" var="data">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="manualDataIds" value="${data.id}" checked> ${data.name}
                            </label>
                        </div>
                    </s:iterator>
                </div>
</s:else>
            </div>
            <div id="chart-configuration-area" class="col-xs-8">
                <h4 class="borderBottom" style="margin-top:0px;">Grouped Charts </h4>

                <button id="chart-configuration-add" class="btn btn-default" type="button">Add Chart Configuration
                </button>
                <hr>

                <s:iterator value="template.chartConfigurations" var="cc" status="status">
                    <div class="chart-configuration">
                        <div class="form-group">
                            <label>Chart Name</label>
                            <input class="form-control" type="text" name="configurationNames" value="${cc.name}">
                        </div>
                        <div class="form-group">
                            <label>Type of Chart</label>
                            <select class="form-control" name="configurationTypes">
                                <s:if test="#cc.chartType == 'Line'">
                                    <option value="Line" selected>Line</option>
                                    <option value="Bar">Bar</option>
                                    <option value="Pie">Pie</option>
                                </s:if>
                                <s:elseif test="#cc.chartType == 'Bar'">
                                    <option value="Line">Line</option>
                                    <option value="Bar" selected>Bar</option>
                                    <option value="Pie">Pie</option>
                                </s:elseif>
                                <s:elseif test="#cc.chartType == 'Pie'">
                                    <option value="Line">Line</option>
                                    <option value="Bar">Bar</option>
                                    <option value="Pie" selected>Pie</option>
                                </s:elseif>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>X- Label</label>
                            <input class="form-control" type="text" name="configurationXLabels" value="${cc.xLabel}">
                        </div>
                        <div class="form-group">
                            <label>Y- Label</label>
                            <input class="form-control" type="text" name="configurationYLabels" value="${cc.yLabel}">
                        </div>
                            <%--
                                    TODO: HOW DO I ITERATE OVER THE "SENSORS" AND "MANUALDATAPOINTS" LISTS TWICE"??
                                    SEE ISSUE HERE:  http://stackoverflow.com/questions/6111248/iterate-twice-on-values
                            --%>
                        <label>Include selected sensors:</label>

                        <div class="sensorList">
                            <s:iterator value="template.sensors" var="sensor">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"
                                               name="chartSensorIds[<s:property value="%{#status.index}" />]"
                                               value="${sensor.id}" checked> ${sensor.name}
                                    </label>
                                </div>
                            </s:iterator>
                        </div>
                        <label>Include selected manual data:</label>

                        <div class="sensorList">
                            <s:iterator value="template.manualData" var="data">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"
                                               name="chartManualDataIds[<s:property value="%{#status.index}" />]"
                                               value="${data.id}" checked> ${data.name}
                                    </label>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <br><br><span style="font-size: 11px; text-align: center; display:block;">Fields marked with an * are required</span>
                <br>
                <button type="submit" class="btn btn-block btn-primaryGreen">Update Report Template</button>
            </div>
        </div>
    </form>
                </div>
            </div>
        </div>
        <!-- /.col-xs-12 .col-sm-12-->
    </div>
    <!-- /.row .row-offcanvas .row-offcanvas-right-->
</div>

<!-- LOAD JAVASCRIPT HERE SO THAT VIEW LOADS FASTER -->

<script type="text/javascript">
    // - GLOBAL VARIABLES
    var generatedChartCount = ${template.chartConfigurations.size()};
    // - LOGIC TO ADD A CHART CONFIGURATION
    $('#chart-configuration-add').on('click', (function () {
        $('#chart-configuration-area').append(
                '<div class="chart-configuration"> \
                    <div class="form-group"> \
                        <label>Chart Name</label> \
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
                        <label>X- Label</label> \
                        <input class="form-control" type="text" name="configurationXLabels"> \
                    </div> \
                    <div class="form-group"> \
                        <label>Y- Label</label> \
                        <input class="form-control" type="text" name="configurationYLabels"> \
                    </div> \
                    <label>Include selected sensors:</label> \
                    <div class="sensorList"> \
                        <s:iterator value="sensors" var="sensor"> \
                        <div class="checkbox"> \
                            <label> \
                                <input type="checkbox" name="chartSensorIds[' + generatedChartCount + ']" value="${sensor.id}"> ${sensor.name} \
                            </label> \
                        </div> \
                        </s:iterator> \
                    </div> \
                    <div class="sensorList"> \
                        <s:iterator value="manualData" var="data"> \
                        <div class="checkbox"> \
                            <label> \
                                <input type="checkbox" name="chartManualDataIds[' + generatedChartCount + ']" value="${data.id}"> ${data.name} \
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
