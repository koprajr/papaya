package models;

/**
 *  This is a model representation of the 'dataPoints' database table from
 *  Mango's embedded Apache Derby database.
 */
public class Sensor {

    private int id;
    private String name;


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
