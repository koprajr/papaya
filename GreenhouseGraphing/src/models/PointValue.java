package models;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PointValue {

	private int dataPointId;
	private double pointValue;
	private BigInteger ts;
	
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
	public BigInteger getTs() {
		return ts;
	}
	public void setTs(BigInteger ts) {
		this.ts = ts;
	}
	public String getTimeStamp(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy - kk:mm:ss");
		return sdf.format(new Date(ts.longValue()));
	}
	
}
