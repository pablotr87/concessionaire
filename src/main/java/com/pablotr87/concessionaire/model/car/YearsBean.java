package com.pablotr87.concessionaire.model.car;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * @author pablotr87
 */
public class YearsBean {

    private String id;

    private int year;

    @DBRef
    private List<StatusBean> states;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<StatusBean> getStates() {
        return states;
    }

    public void setStates(List<StatusBean> states) {
        this.states = states;
    }
}
