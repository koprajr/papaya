package models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;


/**
 * A class that represents a type of manual data.
 * Corresponds to the manualDataPoint table.
 */
public class ManualDataPoint {
    private Integer id;
    private String name; // eg. "Pounds of lettuce added to the greenhouse"
    private List<ManualDataPointValue> values;

    public ManualDataPoint() {
    }

    public ManualDataPoint(String name) {
        this.name = name;
    }

    public ManualDataPoint(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ManualDataPoint) {
            ManualDataPoint other = (ManualDataPoint) obj;
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.getId(), other.getId());
//            eb.append(this.getTitle(), other.getId());
            return eb.build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).build();
    }

    public List<ManualDataPointValue> getValues() {
        return values;
    }

    public void setValues(List<ManualDataPointValue> values) {
        this.values = values;
    }
}