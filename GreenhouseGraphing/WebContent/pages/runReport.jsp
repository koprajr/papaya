<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<script type="text/javascript" src="js/runReport.js"></script>
</head>

<div class="container">
	<h2>Run Report: ${reportName}</h2>

	<s:form action="runReport" method="get" cssClass="form-inline">
		<s:hidden name="reportName" />

		<s:textfield name="start" placeholder="Start" cssClass="datepicker" />
		<s:textfield name="end" placeholder="End" cssClass="datepicker" />

		<s:submit cssClass="btn btn-primary" value="Submit" />

	</s:form>

	<!-- results -->
	<s:if test="%{template != null}">
		<hr />

		<strong>Name: </strong> ${template.name} <br />
		<strong>Description:</strong> ${template.description} <br />

		<hr />

		<h3>Sensors</h3>
		<div id="sensors"></div>

		<h3>Manual Data</h3>
		<div id="manualData"></div>

		<h3>Charts</h3>
		<div id="charts"></div>

	</s:if>
	
	<div id="chartInfo">
		<s:if test="%{charts != null}">
			
			<c:forEach items="${charts}" var="chart">
				<h2 class="chartTitle">${chart.name}</h2>
				<c:forEach items="${chart.sensors}" var="sensor">
					<div class="chartSensor" name="${sensor.name}">
						<c:forEach items="${sensor.values}" var="val">
							${val.pointValue}, 
						</c:forEach>
					</div>

				</c:forEach>
			</c:forEach>
			
		</s:if>
	</div>

	<div id="manualDataInfo">
		<s:if test="%{manualData != null}">
			not null
			<s:iterator value="manualData" var="man">
				<div class="manualChart">
					<h2 class="manualDataName">${man.name}</h2>
					<div class="col-md-3">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Value</th>
									<th>Timestamp</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${man.values}" var="n">
									<tr>
										<td class="value">${n.pointValue}</td>
										<td class="ts">${n.prettyTs}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</div>
			</s:iterator>
		</s:if>
	</div>

	<div id="sensorInfo">
		<!-- this is hidden -->
		<s:if test="%{sensors != null}">
			not null
			<s:iterator value="sensors" var="sensor">
				<div class="sensorChart">
					<h2 class="sensorName">${sensor.name}</h2>
					<div class="col-md-3">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Value</th>
									<th>Timestamp</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#sensor.values" var="n">
									<tr>
										<td class="value">${n.pointValue}</td>
										<td class="ts">${n.timeStamp}</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>

					</div>

				</div>
			</s:iterator>
		</s:if>
	</div>

</div>