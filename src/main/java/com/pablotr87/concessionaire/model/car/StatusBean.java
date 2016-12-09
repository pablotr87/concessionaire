package com.pablotr87.concessionaire.model.car;

/**
 * @author pablotr87
 */
public enum StatusBean {
    USED("car.makes.models.years.status.used"),
    NEW("car.makes.models.years.status.new");

    /**
     * key in message-bundle
     */
    private String name;

    /**
     *
     * @param name
     */
    StatusBean(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
