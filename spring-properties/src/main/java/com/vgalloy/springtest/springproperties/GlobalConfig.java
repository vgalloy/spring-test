package com.vgalloy.springtest.springproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Vincent Galloy on 19/03/17.
 *
 * @author Vincent Galloy
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class GlobalConfig {

    public static void main(String[] args) {
        SpringApplication.run(GlobalConfig.class, args);
    }
}
