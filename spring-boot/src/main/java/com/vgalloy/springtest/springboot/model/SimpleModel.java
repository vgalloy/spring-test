package com.vgalloy.springtest.springboot.model;

import java.io.Serializable;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
public final class SimpleModel implements Serializable {

    private final Long id;
    private final String name;

    public SimpleModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
