package models;

/**
 *  This is a model representation of the 'dataPoints' database table from
 *  Mango's embedded Apache Derby database.
 */
public class Sensor {
    private Long id;
    private String name;

    public Sensor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
