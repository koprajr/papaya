package actions;

import java.util.Collections;
import java.util.List;

import utils.DataUtils;
import utils.TimeUtils;
import dao.MangoDAO;
import models.PointValue;
import models.Sensor;
import models.SensorValueSelect;

public class SensorSelectAction {

	private List<Sensor> sensors;
	private List<Integer> selectedSensors;
	private List<PointValue> values;

	private Sensor sensor;
	
	private String start;
	private String end;
	
	private int max = 50000;
	
	public String execute() {
		MangoDAO dao = new MangoDAO();
		sensors = dao.getSensors();
		
		// sort sensor list
		Collections.sort(sensors, new SensorComparator());

		if (selectedSensors != null) {
			// if there are some selected sensors, display their ids
			for (Integer i : selectedSensors) {
				System.err.println("Sensor Id: " + i);
				
				sensor = dao.getSensor(i);
				
				List<PointValue> dataPoints = dao.getPointValues(new SensorValueSelect(i, TimeUtils.timeStampToEpochTime(start), TimeUtils.timeStampToEpochTime(end)));

				System.err.println("Total data points: " + dataPoints.size());
				
				try {
					values = dataPoints.subList(0, max);
				} catch (Exception e){
					values = dataPoints;
				}
				
				values = DataUtils.interpolateMissingValues(values);
			}
		}

		return "success";
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}

	public List<Integer> getSelectedSensors() {
		return selectedSensors;
	}

	public void setSelectedSensors(List<Integer> selectedSensors) {
		this.selectedSensors = selectedSensors;
	}

	public List<PointValue> getValues() {
		return values;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
