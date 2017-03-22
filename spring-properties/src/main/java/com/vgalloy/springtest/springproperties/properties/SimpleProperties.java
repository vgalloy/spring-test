package com.vgalloy.springtest.springproperties.properties;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent Galloy on 19/03/17.
 *
 * @author Vincent Galloy
 */
@Component
//@PropertySource("application-test.properties")
@ConfigurationProperties(prefix = "simple")
public class SimpleProperties {

    private String username;

    @PostConstruct
    private void init() {
        System.out.println("SimpleProperties : " + username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
