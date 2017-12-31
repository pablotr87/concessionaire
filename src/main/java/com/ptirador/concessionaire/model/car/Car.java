package com.ptirador.concessionaire.model.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "{error.mandatoryField}")
    private String make;

    /**
     * Model name.
     */
    @NotBlank(message = "{error.mandatoryField}")
    private String model;

    /**
     * Model year.
     */
    @Min(value = 1860, message = "{error.year.greaterThan}")
    @NotNull(message = "{error.mandatoryField}")
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
