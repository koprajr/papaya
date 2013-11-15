<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<script type="text/javascript" src="js/sensors.js"></script>
</head>

<div class="container">
	<h2>Sensor Select</h2>

	<s:form action="sensorSelect" method="get">
		<div class="sensorList">
			<s:iterator value="sensors" var="n">
				<input type="checkbox" name="selectedSensors" value="${n.id}" /> ${n.name} <br />
			</s:iterator>
		</div>

		<div>
			<s:textfield name="start" placeholder="Start" cssClass="datepicker" />
			<s:textfield name="end" placeholder="End" cssClass="datepicker" />
		</div>

		<s:submit cssClass="btn btn-primary" />

	</s:form>

	<s:if test="%{selectedSensors != null}">
		<hr />
		<div class="row">
			<h2 id="sensorName">${sensor.name}</h2>
			<div class="col-md-3">
				<table class="table table-condensed" id="datatable">
					<thead>
						<tr>
							<th>Value</th>
							<th>Timestamp</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="values" var="n">
							<tr>
								<td class="value">${n.pointValue}</td>
								<td class="ts">${n.timeStamp}</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>

			</div>

			<div class="col-md-9">
				<div id="container" style="width: 100%; height: 400px;"></div>
				<canvas id="myChart" width="900px" height="500px"></canvas>
			</div>

		</div>
	</s:if>

</div>
