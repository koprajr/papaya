package actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.MangoDAO;
import models.PointValue;
import models.Sensor;

public class SensorSelectAction implements Comparator<Sensor> {

	private List<Sensor> sensors;
	private List<Integer> selectedSensors;
	private List<PointValue> values;

	private Sensor sensor;
	
	private int max;
	
	public String execute() {
		MangoDAO dao = new MangoDAO();
		sensors = dao.getSensors();

		// sort sensor list
		Collections.sort(sensors, this);

		if (selectedSensors != null) {
			// if there are some selected sensors, display their ids
			for (Integer i : selectedSensors) {
				System.err.println("Sensor Id: " + i);
				
				sensor = dao.getSensor(i);

				List<PointValue> dataPoints = dao.getPointValues(i);

				System.err.println("Total data points: " + dataPoints.size());
				
				try{
					values = dataPoints.subList(0, max);
				} catch (Exception e){
					System.err.println();
					values = dataPoints;
				}

				System.err.println("Showing first: " + values.size());
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

	@Override
	public int compare(Sensor o1, Sensor o2) {
		return o1.getName().compareTo(o2.getName());
	}

	public List<PointValue> getValues() {
		return values;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
