$(document).ready(function() {
	generateSensorCharts();
	generateManualCharts();
	
});

function generateManualCharts(){
	var charttables = $(".manualChart");

	charttables.each(function(chart) {
		var manualName = $(".manualDataName", this).text();

		var labels = $(".ts", this).map(function(i, el) {
			return $(el).text();
		});

		var values = $(".value", this).map(function(i, el) {
			return parseFloat($(el).text());
		});
		
		$("#manualData").append('<div class="moreCharts"></div><hr />');
		
		$('.moreCharts:last').highcharts({
			chart : {
				type : 'column',
				zoomType : 'xy'
			},
			title : {
				text : manualName
			},
			xAxis : {
			 categories : labels
			},
			yAxis : {
				title : {
					text : 'Units'
				}
			},
			series : [ {
				name : manualName,
				data : values
			} ]
		});
	});
}

function generateSensorCharts(){
	var charttables = $(".sensorChart");

	charttables.each(function(chart) {

		var sensorName = $(".sensorName", this).text();

		var labels = $(".ts", this).map(function(i, el) {
			return $(el).text();
		});

		var values = $(".value", this).map(function(i, el) {
			return parseFloat($(el).text());
		});

		$("#sensors").append('<div class="moreCharts"></div><hr />');
		
		$('.moreCharts:last').highcharts({
			chart : {
				type : 'line',
				zoomType : 'xy'
			},
			title : {
				text : sensorName
			},
			xAxis : {
//			 categories : labels
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
}
