<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container">
	<h2>Sensor Select</h2>

	<s:form action="sensorSelect">
		<div class="sensorList">
			<s:iterator value="sensorIds" var="n">
				<input type="checkbox" name="selectedSensors" value="${n.id}" /> ${n.name} <br />
			</s:iterator>
		</div>

		<s:submit cssClass="btn btn-primary" />
	</s:form>
	
	<s:if test="%{selectedSensors != null}">
		You selected:<br/>
		<s:iterator value="selectedSensors" var="n">
			${n} <br />
		</s:iterator>
	</s:if>

</div>
