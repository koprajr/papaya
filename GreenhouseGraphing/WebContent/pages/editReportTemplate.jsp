<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
    <style type="text/css">
        .chart-configuration {
            float:         left;
            border:        1px solid lightgrey;
            padding:       15px;
            margin:        1px;
        }
    </style>
</head>

<body>
<div class="container">
    <h1>Edit Report Template</h1>
    <hr>
    <form role="form" action="updateReportTemplate" method="post">
        <div class="row">
            <div class="col-xs-4">
                <h4>Report Template Name</h4>
                <input class="form-control" type="text" name="template.name" value="${template.name}">
                <h4>Report Template Description</h4>
                <textarea class="form-control" name="template.description">${template.description}</textarea>
                <hr>
                <h4>Individual Sensors</h4>
                <div class="sensorList">
                    <s:iterator value="sensors" var="sensor">
                    <div class="checkbox">
                        <label>
                            <s:if test="#sensor.id in {22, 24, 26}">
                            <input type="checkbox" name="sensorIds" value="${sensor.id}" checked> ${sensor.name}
                            </s:if>
                            <s:else>
                            <input type="checkbox" name="sensorIds" value="${sensor.id}"> ${sensor.name}
                            </s:else>
                        </label>
                    </div>
                    </s:iterator>
                </div>
            </div>
            <div id="chart-configuration-area" class="col-xs-8">
                <h4 style="display: inline; padding-top: 5px;">Grouped Charts </h4>
                <button id="chart-configuration-add" class="btn btn-default" type="button">Add Chart Configuration</button>
                <hr>
                <s:iterator value="template.chartConfigurations" var="cc">
                    <div class="chart-configuration">
                        <div class="form-group">
                            <label>Chart Name</label>
                            <input class="form-control" type="text" name="${cc.name}" value="${cc.name}">
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
                            <input class="form-control" type="text" name="${cc.xLabel}" value="${cc.xLabel}">
                        </div>
                        <div class="form-group">
                            <label>Y- Label</label>
                            <input class="form-control" type="text" name="${cc.yLabel}" value="${cc.yLabel}">
                        </div>
                        <label>Include selected sensors:</label>
                        <div class="sensorList">
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
        <div class="row">
            <hr>
            <div class="col-xs-4 col-xs-offset-4">
                <button type="submit" class="btn btn-success btn-block">Save Report Template</button>
            </div>
        </div>
    </form>
</div>

<!-- LOAD JAVASCRIPT HERE SO THAT VIEW LOADS FASTER -->

<script type="text/javascript">
    // - GLOBAL VARIABLES
    var generatedChartCount = 0;
    // - LOGIC TO ADD A CHART CONFIGURATION
    $('#chart-configuration-add').on('click', (function() {
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
                </div> \
            </div>'
        );
        generatedChartCount += 1;
    }));
</script>
</body>