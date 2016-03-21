package com.vgalloy.springtest.initialization.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public class SimpleBean implements InitializingBean {

    @Autowired
    private String value;

    public SimpleBean() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct");
    }

    public void myInit() {
        System.out.println("myInit");
    }

    public void myDestroy() {
        System.out.println("myDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public String getValue() {
        return value;
    }

    @Autowired
    public void setValue(String value) {
        System.out.println("setValue " + value);
        this.value = "method";
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "value='" + value + '\'' +
                '}';
    }
}
