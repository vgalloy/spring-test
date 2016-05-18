package com.vgalloy.springtest.boot.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vgalloy.springtest.boot.api.service.Service;
/**
 * Created by Vincent Galloy on 02/05/16.
 */
@SpringBootApplication
public class MainConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Service service = context.getBean(Service.class);
        System.out.println(service.getName());
        //        SpringApplication.run(MainConfiguration.class, args);
    }
}
