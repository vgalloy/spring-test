package com.vgalloy.springtest.initialization;

import com.vgalloy.springtest.initialization.context.SimpleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@Configuration
@ComponentScan("com.vgalloy.springtest.initialization.context.")
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main2.class);
        System.out.println("get Service");
        SimpleService simpleService = applicationContext.getBean(SimpleService.class);
    }
}
