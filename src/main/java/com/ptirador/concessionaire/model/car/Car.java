package com.ptirador.concessionaire.model.car;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;

/**
 * Bean that represents a car.
 *
 * @author ptirador
 */
@Document(collection = "cars")
public class Car {

    /**
     * Car identifier.
     */
    @Id
    private String id;

    /**
     * Make name.
     */
    @NotEmpty(message = "error.mandatoryField")
    private String make;

    /**
     * Model name.
     */
    @NotEmpty(message = "error.mandatoryField")
    private String model;

    /**
     * Model year.
     */
    @NotEmpty(message = "error.mandatoryField")
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
