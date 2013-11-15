package actions;

import java.util.Comparator;

import models.Sensor;

public class SensorComparator implements Comparator<Sensor>{

	@Override
	public int compare(Sensor o1, Sensor o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
