package models;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/7/13
 * Time: 2:30 PM
 * Represents an actual point value for manual data. Similar to the pointValues table for sensors.
 *
 */
public class ManualDataPointValue {
    int id;
    int manualDataPointId; // The type of manual data.
    int userId; // The user who inserted this data point value.
    Double pointValue; // The actual value. eg "5" pounds.
    BigInteger ts;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManualDataPointId() {
        return manualDataPointId;
    }

    public void setManualDataPointId(int manualDataPointId) {
        this.manualDataPointId = manualDataPointId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getPointValue() {
        return pointValue;
    }

    public void setPointValue(Double pointValue) {
        this.pointValue = pointValue;
    }

    public BigInteger getTs() {
        return ts;
    }

    public void setTs(BigInteger ts) {
        this.ts = ts;
    }

    public void setTs(Long ts) {
        setTs(BigInteger.valueOf(ts));
    }


}
