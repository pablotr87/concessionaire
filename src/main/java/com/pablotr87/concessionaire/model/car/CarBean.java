package com.pablotr87.concessionaire.model.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Bean that represents a car.
 * @author pablotr87
 */
@Document(collection = "cars")
public class CarBean {
    @Id
    private String id;

    @DBRef
    private List<MakesBean> makes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MakesBean> getMakes() {
        return makes;
    }

    public void setMakes(List<MakesBean> makes) {
        this.makes = makes;
    }
}