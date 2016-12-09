package com.pablotr87.concessionaire.model.car;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * @author pablotr87
 */
public class MakesBean {

    private String id;

    private String name;

    @DBRef
    private List<ModelBean> models;

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

    public List<ModelBean> getModels() {
        return models;
    }

    public void setModels(List<ModelBean> models) {
        this.models = models;
    }
}
