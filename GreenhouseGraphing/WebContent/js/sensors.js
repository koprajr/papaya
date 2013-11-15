$(document).ready(function() {

	$(".datepicker").datetimepicker();

	var sensorName = $("#sensorName").text();
	
	var labels = $(".ts").map(function(i, el) {
		return $(el).text();
	});

	var values = $(".value").map(function(i, el) {
		return parseFloat($(el).text());
	});

	$('#container').highcharts({
		chart : {
			type : 'line'
		},
		title : {
			text : "Chart"
		},
		xAxis : {
//			categories : labels
		},
		yAxis : {
			title : {
				text : 'Units'
			}
		},
		series : [ {
			name : sensorName,
			data : values
		} ]
	});

});