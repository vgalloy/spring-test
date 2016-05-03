package com.vgalloy.springtest.boot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vgalloy.springtest.boot.api.service.Service;

/**
 * Created by Vincent Galloy on 03/05/16.
 */
@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getPromotionRequestTypes() {
        return "Hello World";
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String getServiceName() {
        return service.getName();
    }
}
