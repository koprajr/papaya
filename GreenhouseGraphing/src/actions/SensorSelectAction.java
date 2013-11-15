package actions;

import dao.MangoDAO;
import models.Sensor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SensorSelectAction implements Comparator<Sensor>{

	private List<Sensor> sensors;
	private List<Integer> selectedSensors;
	
	public String execute(){
		MangoDAO dao = new MangoDAO();
		sensors = dao.getSensors();
		
		//sort sensor list
		Collections.sort(sensors, this);
		
		if (selectedSensors != null){
			// if there are some selected sensors, display their ids
			for (Integer i : selectedSensors){
				System.err.println(i);
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
	
}
