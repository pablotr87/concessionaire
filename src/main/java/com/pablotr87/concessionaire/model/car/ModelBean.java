package com.pablotr87.concessionaire.model.car;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * @author pablotr87
 */
public class ModelBean {

    private String id;

    private String name;

    @DBRef
    private List<YearsBean> years;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<YearsBean> getYears() {
        return years;
    }

    public void setYears(List<YearsBean> years) {
        this.years = years;
    }
}
