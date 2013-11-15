package utils;

import java.util.Comparator;

import models.PointValue;

public class PointValueComparator implements Comparator<PointValue>{

	@Override
	public int compare(PointValue o1, PointValue o2) {
		return (int) (o1.getTs() - o2.getTs());
	}

}
