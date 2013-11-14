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

		<label>Max Values:<s:textfield name="max" /></label>

		<s:submit cssClass="btn btn-primary" />

	</s:form>

	<s:if test="%{selectedSensors != null}">
		You selected:<br />
		<s:iterator value="selectedSensors" var="n">
			Sensor Id: ${n} <br />
		</s:iterator>
	</s:if>

	<hr />

	<h2>${sensor.name}</h2>

	<div class="row">
		<div class="col-md-3">
			<table class="table table-condensed">
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
			<canvas id="myChart" width="900" height=600></canvas>
		</div>

	</div>

</div>
