package models;

/**
 * Created with IntelliJ IDEA.
 * User: Jeff
 * Date: 11/12/13
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManualData {
    private int id;
    private double value;
    private int typeId;
    private int userId;
    private long timeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
