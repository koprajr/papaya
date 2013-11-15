package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import utils.TimeUtils;

public class PointValue {

	private int dataPointId;
	private double pointValue;
	private long ts;
	
	public int getDataPointId() {
		return dataPointId;
	}
	public void setDataPointId(int dataPointId) {
		this.dataPointId = dataPointId;
	}
	public double getPointValue() {
		return pointValue;
	}
	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getTimeStamp(){
		return TimeUtils.epochTimeToTimeStamp(ts);
	}
	
}
