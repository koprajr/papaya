<%@ taglib prefix="s" uri="/struts-tags"%>

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
		<div id="manualData">manual data stuff goes here...</div>

		<h3>Charts</h3>
		<div id="charts">complex charts go here...</div>

	</s:if>

	<div id="sensorInfo">
		<!-- this is hidden -->
		<s:if test="%{sensors != null}">
			not null
			<s:iterator value="sensors" var="sensor">
				<div class="charttable">
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