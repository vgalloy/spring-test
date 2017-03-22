package com.vgalloy.springtest.initialization.failingcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Vincent Galloy on 22/03/17.
 *
 * @author Vincent Galloy
 */
@Component("bean2")
public class Bean2 {

    public static ApplicationContext applicationContext;

    public Bean2() {
        System.out.println("Bean2 :: Constructor");
    }

    public static ApplicationContext applicationContext() {
        return applicationContext;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        Bean2.applicationContext = applicationContext;
    }
}
