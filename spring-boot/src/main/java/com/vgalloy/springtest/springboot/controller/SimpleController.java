package com.vgalloy.springtest.springboot.controller;

import com.vgalloy.springtest.springboot.model.SimpleModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
@RestController
public final class SimpleController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return "Hello World";
    }

    @RequestMapping(value = "simple", method = RequestMethod.GET)
    public SimpleModel simple() {
        return new SimpleModel(1L, "Vincent");
    }
}
