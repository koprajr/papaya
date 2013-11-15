package actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import dao.MangoDAO;
import models.PointValue;
import models.Sensor;
import models.SensorValueSelect;

public class SensorSelectAction implements Comparator<Sensor> {

	private List<Sensor> sensors;
	private List<Integer> selectedSensors;
	private List<PointValue> values;

	private Sensor sensor;
	
	private String start;
	private String end;
	
	private int max = 70;
	
	public String execute() {
		MangoDAO dao = new MangoDAO();
		sensors = dao.getSensors();

		// sort sensor list
		Collections.sort(sensors, this);

		if (selectedSensors != null) {
			
			System.err.println("Start: " + start);
			System.err.println("End: " + end);
			
			System.err.println("start: " + timeStampToEpochTime(start));
			System.err.println("end: " + timeStampToEpochTime(end));
			
			// if there are some selected sensors, display their ids
			for (Integer i : selectedSensors) {
				System.err.println("Sensor Id: " + i);
				
				sensor = dao.getSensor(i);

				List<PointValue> dataPoints = dao.getPointValues(new SensorValueSelect(i, timeStampToEpochTime(start), timeStampToEpochTime(end)));

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

	private long timeStampToEpochTime(String timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			Date date = sdf.parse(timestamp);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
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
