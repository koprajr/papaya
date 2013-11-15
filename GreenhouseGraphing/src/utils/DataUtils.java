package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.PointValue;

public class DataUtils {

	/**
	 *  Adds in missing point values to a list to deal with the "record only on change"
	 *  methodology of Mango.
	 *  
	 *  The basic idea is to find the smallest time gap between points in the given list
	 *  and assume that is the time interval at which this data is measured.
	 *  
	 *  Then, loop through the list of values and check the time difference between each
	 *  value and the one next to it. If this difference is bigger than the determined
	 *  interval, insert filler values to make up the gap
	 *  
	 * @param values - List in need of interpolation
	 * @return - original list interpolated and sorted by time
	 */
	public static List<PointValue> interpolateMissingValues(List<PointValue> values){
		if (values.size() < 2){
			return values;
		}
		
		long smallDif = smallestTimeDifferenceInSeconds(values);	// interval at which this data seems to be measured
		
		List<PointValue> newValues = new ArrayList<PointValue>();
		
		for (int i = 1; i < values.size(); i++) {
			newValues.add(values.get(i - 1));	//add the original data point
			long diff = Math.abs(values.get(i).getTs() - values.get(i - 1).getTs()) / 1000;
			if (diff > smallDif) {	// if there's more than one interval of time between values, fill in that space
				int fillCount = (int) Math.floor(diff / smallDif) - 1;	// how many values to fill the gap
				for (int j = 0; j < fillCount; j++) {
					PointValue filler = new PointValue();
					filler.setDataPointId(values.get(i - 1).getDataPointId());
					filler.setPointValue(values.get(i - 1).getPointValue());
					filler.setTs(values.get(i - 1).getTs() + ((j+1) * smallDif * 1000));
					newValues.add(filler);	// add points to the end of the list, will be sorted by time later
				}
			}
		}
		newValues.add(values.get(values.size()-1));	//add the last item in the array since it isn't done in the loop
		
		Collections.sort(newValues, new PointValueComparator()); //sort points chronologically
		
		return newValues;
	}
	
	/**
	 * Calculates the smallest time gap in a list of PointValues.
	 * 
	 * @param values - List of values to check
	 * @return - smallest found time difference between points in the list
	 */
	public static long smallestTimeDifferenceInSeconds(List<PointValue> values) {
		Collections.sort(values, new PointValueComparator());	// list must be sorted or the gaps will not be accurate
		
		if (values.size() < 2){
			return 0;
		}
		
		long difference = Math.abs(values.get(1).getTs() - values.get(0).getTs());
		for (int i = 2; i < values.size(); i++) {
			long temp = Math.abs(values.get(i).getTs() - values.get(i - 1).getTs());
			if (temp < difference){
				difference = temp;
			}
		}
		return difference / 1000;
	}
	
}
