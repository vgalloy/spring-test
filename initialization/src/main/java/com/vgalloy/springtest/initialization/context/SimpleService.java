package com.vgalloy.springtest.initialization.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 01/02/17.
 */
@Service
@Lazy
public class SimpleService {

    private SimpleComponent simpleComponent;

    @Autowired
    public SimpleService(SimpleComponent simpleComponent) {
        System.out.println("Constructor::SimpleService");
        this.simpleComponent = simpleComponent;
    }
}
