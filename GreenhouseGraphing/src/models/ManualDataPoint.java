package models;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class ManualDataPoint {
    private Long id;
    private String name;

    public ManualDataPoint(Long id, String name) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ManualDataPoint) {
            ManualDataPoint other = (ManualDataPoint) obj;
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.getId(), other.getId());
            eb.append(this.getName(), other.getId());
            return eb.build();
        }
        return false;
    }
}
