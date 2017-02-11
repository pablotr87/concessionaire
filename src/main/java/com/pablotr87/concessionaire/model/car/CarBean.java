package com.pablotr87.concessionaire.model.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Bean that represents a car.
 *
 * @author pablotr87
 */
@Document(collection = "cars")
public class CarBean {

    /**
     * Car identifier.
     */
    @Id
    private String id;

    /**
     * Make name.
     */
    private String make;

    /**
     * Model name.
     */
    private String model;

    /**
     * Model year.
     */
    private Integer year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}