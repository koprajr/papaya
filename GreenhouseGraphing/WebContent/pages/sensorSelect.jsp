<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container">
	<h2>Sensor Select</h2>

	<s:form action="sensorSelect">
		<div class="sensorList">
			<s:iterator value="sensors" var="n">
				<input type="checkbox" name="selectedSensors" value="${n.id}" /> ${n.name} <br />
			</s:iterator>
		</div>

		<s:submit cssClass="btn btn-primary" />
	</s:form>

</div>
