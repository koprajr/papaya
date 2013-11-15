$(document).ready(function() {

	$(".datepicker").datetimepicker();
	
	var ctx = document.getElementById("myChart").getContext("2d");

	var options = {
		animation : false,
	};

	var labels = $(".ts").map(function(i, el) {
		return $(el).text();
	});

	var values = $(".value").map(function(i, el) {
		return $(el).text();
	});

	var data = {
		labels : labels,
		datasets : [ {
			fillColor : "rgba(220, 0, 0, 0.5)",
			data : values
		} ]
	};

	var myNewChart = new Chart(ctx).Line(data, options);

});