package models;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/7/13
 * Time: 2:30 PM
 * Represents an actual point value for manual data. Similar to the pointValues table for sensors.
 */
public class ManualDataPointValue {
    int id;
    int manualDataPointId; // The type of manual data.
    int userId; // The user who inserted this data point value.
    Double pointValue; // The actual value. eg "5" pounds.
    BigInteger ts;


}
