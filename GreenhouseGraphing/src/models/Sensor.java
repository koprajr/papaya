package models;

import java.util.List;

public class Sensor {

	private Integer id;
	private byte[] data;
	private List<PointValue> values;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public String getName() {
		String orig = new String(data);
		String newData = orig.replaceAll("[^A-Za-z0-9 ]", "-");
		String name = newData.substring(newData.indexOf("----xp") + 15);
		name = name.substring(0, name.indexOf("---"));
		return name;
	}
	public List<PointValue> getValues() {
		return values;
	}
	public void setValues(List<PointValue> values) {
		this.values = values;
	}
	
}