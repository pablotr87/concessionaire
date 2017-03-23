package com.ptirador.concessionaire.model;

import java.io.Serializable;

/**
 * Simple JavaBean, used by beans that need the properties defined inside it.
 *
 * @author ptirador
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
