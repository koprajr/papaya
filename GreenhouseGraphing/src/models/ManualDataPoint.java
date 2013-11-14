package models;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/7/13
 * Time: 2:29 PM
 * A manual data point. Similar to the dataPoints table for sensors in the database.
 * Represents a type of manual data. eg. "Pounds of lettuce added to digestor."
 */
public class ManualDataPoint {

    int id;
    String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
