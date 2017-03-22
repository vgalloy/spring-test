package com.vgalloy.springtest.initialization.failingcontext;

import org.springframework.stereotype.Component;

/**
 * Created by Vincent Galloy on 22/03/17.
 *
 * @author Vincent Galloy
 */
@Component
// @DependsOn("bean2")
public class Bean1 {

    public Bean1() {
        System.out.println("Bean1 :: Constructor");
        if (Bean2.applicationContext == null) {
            throw new IllegalStateException();
        }
    }
}
