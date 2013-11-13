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
        <h1>Create Report Template</h1>
        <hr>
        <form role="form" action="saveReportTemplate" method="post">
            <div class="row">
                <div class="col-xs-4">
                    <h4>Individual Graphs</h4>
                    <s:iterator value="sensors" var="sensor">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="sensorList[]" value="${sensor.name}"> ${sensor.name}
                        </label>
                    </div>
                    </s:iterator>
                    <hr>
                    <h4>Calculated Total Values to Display</h4>
                    <s:iterator value="equations" var="equation">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="equationList[]" value="${equation.name}"> ${equation.name}
                        </label>
                    </div>
                    </s:iterator>
                    <hr>
                    <h4>Manual Data</h4>
                    <s:iterator value="manualData" var="data">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="manualDataList[]" value="${data.name}"> ${data.name}
                        </label>
                    </div>
                    </s:iterator>
                </div>
                <div id="chart-configuration-area" class="col-xs-8">
                    <h4 style="display: inline;">Consolidated Graphs</h4>
                    <button id="chart-configuration-add" class="btn btn-default" type="button">Add Chart Configuration</button>
                    <hr>
                    <div class="chart-configuration">
                        <div class="form-group">
                            <label for="">Chart Name</label>
                            <input class="form-control" type="text">
                        </div>
                        <div class="form-group">
                            <label for="">Type of Chart</label>
                            <select class="form-control">
                                <option>Line</option>
                                <option>Bar</option>
                                <option>Pie</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="">X- Label</label>
                            <input class="form-control" type="text">
                        </div>
                        <div class="form-group">
                            <label for="">Y- Label</label>
                            <input class="form-control" type="text">
                        </div>
                        <label>Include selected data:</label>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="[]" value="null"> Check me out
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="[]" value="null"> Check me out
                            </label>
                        </div>
                    </div>
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
        // - LOGIC TO ADD A CHART CONFIGURATION
        $('#chart-configuration-add').on('click', (function() {
            $('#chart-configuration-area').append(
                '<div class="chart-configuration"> \
                    <div class="form-group"> \
                        <label for="">Chart Name</label> \
                        <input class="form-control" type="text"> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">Type of Chart</label> \
                        <select class="form-control"> \
                            <option>Line</option> \
                            <option>Bar</option> \
                            <option>Pie</option> \
                        </select> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">X- Label</label> \
                        <input class="form-control" type="text"> \
                    </div> \
                    <div class="form-group"> \
                        <label for="">Y- Label</label> \
                        <input class="form-control" type="text"> \
                    </div> \
                        <label>Include selected data:</label> \
                    <div class="checkbox"> \
                        <label> \
                            <input type="checkbox" name="[]" value="null"> Check me out \
                        </label> \
                    </div> \
                    <div class="checkbox"> \
                        <label> \
                            <input type="checkbox" name="[]" value="null"> Check me out \
                        </label> \
                    </div> \
                </div>'
            );
        }));
    </script>
</body>
